### Full Implementation Documentation

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL
      NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED",  "MAY", and
      "OPTIONAL" in this document are to be interpreted as described in
      [RFC 2119](https://datatracker.ietf.org/doc/html/rfc2119).

- All ID in classes __MUST__ be greater than 0, this is for displaying purpose in a human readability.
- All fields __MUST NOT__ be null or blank.

- One **SHOULD** be able to make copy of an object, display a class object's details in a pretty printing way.
- Two objects of a class are equal when its fields contents are the same.
The classes below are located in the package **model**

#### Version Change, updates and Challenges
ArrayList has been used in this version over arrays, which has helped a lot when dealing with adding, retrieving, deleting but most importantly shifting and restructuring the table after each operation.

Roles are basically managed with inheritance which happened to quite tidious but feasible.

All crud operations have been implemented regarding the faced challenges.

The menu is not fully implemented as implementation was getting slow and a better approach on how to deal with Roles has been throughly thought and will be in the next release candidate.

The project will be refractored on a **THREE LAYER DESIGN** comprises of a **PRESENTATION**, **SERVICE** and a **REPOSITORY**.

Implementing such will be fun and most of the current code will be reused.


#### Member.java
Member class based on Member table in the DB.
##### Rules:
- *First Name and last bame* : **MUST NOT** be null or empty*.
- *Birth Date* : **MUST** be in format *dd/MM/yyyy*.
- *Age* : **MUST** be calculated automatically from birth date.
- *Email* : **MUST** be verify for the bare minimum using regex or similar methods.
- *Passport* : **MUST** have **9** characters.
- *AMCI Matricule* : **MUST** have **8** digits.
- *Membership Status* : **MUST** be **true**(yes) or **false**(no).
- One **SHOULD** be able to create copy object of this class.
- Two objects of this class are equal when its fields contents are the same.

#### Card.java
Stay Card class based on Card table in the DB.
##### Rules:
- *Id Member* : represent the person's card holder, follows ID rule cited on top.<br> This will represent a foreign key in DB representation indicating the member posessing the card.
- *Id City* : follows ID rule cited on top.<br> This will represent a foreign key in DB representation indicating the city that issued the card.
- *CIN* : **MUST** have 8 digits and not be null and always uppercased.
- *Reason* is the reason of the stay in Morroco.
- *Obtention date* : issued card's date, it **MUST** be a date or stored as one and **MUST** follow the format _dd/MM/yyyy_.
- *Expiration date* : **MUST** be a date or stored as one and **MUST** follow the format _dd/MM/yyyy_.
- *PIN* : **MUST** have **4** digits, this is delivered along with the card and is part of Morocco's [numerical identity](https://www.identitenumerique.ma/about.html) 

#### City.java
City class based on City table in the DB.

##### Rules:
- *Name* : name of the city: **MUST NOT** be null or blank.
- *Region* : region where the city is located: **MUST NOT** be null or blank.
- *Facs* : list of faculties within the city and **SHOULD** at least have one faculty, it **MAY** be null.
- *Reason* : is the reason of the stay in Morroco.
- This object should be able to manage the list of faculties (_add, update, delete, get a faculy and get all of them_ or whatever management service of yours)  

#### Faculty.java
Faculty class based on faculty table in the DB.

##### Rules:
- *Abbr* : abbreviation of the faculty's initial: **MUST NOT** be null or blank.
- *Desc* : description of faculty's abbreviation. The full name: **MUST NOT** be null or blank.
- *Fields* : list of fields in the faculty. A given Faculty **SHOULD** at least have one field, it **MAY** be null.
- This object should be able to manage the list of fields (_add, update, delete, get a faculy and get all of them_ and whatever management system on your own)  

#### Field.java
Field class based on Field table in the DB.

##### Rules:
- *Abbreviation* : of the field name's initial, **MUST NOT** be null or blank.
- *Name* : description of field's abbreviation. The full name: **MUST NOT** be null or blank.
- *Certificate* : diploma that will be issued at the end of the formation; **MUST NOT** be null nor blank.
- *Duration* : of the formation, **SHOULD** at least be one year; **MUST NOT** be less or equal to 0.
Within the package **model**, there's another package **manager** that handles all management _roles, permissions and operations_.

The first approach is as below:
<blockquote>I used inheritance in order to achieve role management as follow:<br>

- A **moderator**, is a member with a _session_ and a set of _permissions_ on members, he/she can add, remove, update a member in a given city but **MUST** not be able to manage cities or list all members of the app.
- An **admin**, on the other hand is a member and a moderator meaning he can manage cities on top of what a moderator does.
- A diagram class explaining this approach is to be found in <code>**_the docs/_**</code> folder.
- <cite>Note: this approach is simple but less clever and will surely replace by another.</cite></blockquote>

#### Acemanger.java

Interface that would define all the operations a give moderator can do; thus the moderator class **MUST** implements this interface.

Everything one can imagine about member management should be defined here.

#### *Permission.java*
An interface that set the contracts between Admin and moderator. This class must declare all core permissions amongst parties.

Has no corresponding entity in DB. 

#### Manager.java

Has no corresponding entity in DB. 
This class does represent the Moderator that will mod the app.
<cite>~~It might represent a role table or stuff like that! We'll figure that out.~~</cite>
This class implements *Permission* and extends *Member.java*. 
The manager or moderator is a member.

##### Rules:
- *Session Start* : **MUST NOT** be null or blank.<br>
It **SHOULD BE** on format _dd/MM/yyy at HH:mm:ss_ or whatever other format. 
- *Session End* : **MUST NOT** be null or blank.<br>
It **SHOULD BE** on format _dd/MM/yyy at HH:mm:ss_ or whatever other format. 
- *Members* : a list of the members that the moderator would manage; **MAY** be null.
- *Cards* : a list of the cards that the moderator would manage; **MAY** be null.

- *Role* : **MUST** be **ADMINISTRATOR** or **MODERATOR** following this: <blockquote>A moderator <b>MUST NOT</b> be able to manage cities. He can only manage a set of members in a given city which at 99% would be his city.  
</blockquote>

- *Cities* : a list of the cities that the administrator would manage; **MAY** be null.


#### SuperUser.java

Has no corresponding entity in DB. 
This class does represent the Admin that will mod the app.
<cite>~~It might represent a role table or stuff like that! We'll figure that out.~~</cite>
This object **MUST** inherit from **MODERATOR**, at the end an admin can do everything a moderator does and more.


##### Rules:

- *moderators* : a list of the moderators that the admin would manage; **MAY** be null.

#### Helpers.java

- Contains randoms functions utilized in the app such as (<code>validate email</code>, <code>validate date</code>, ...etc)
- Functions such as the mentionned above **SHOULD BE** added here.

#### FillTables.java

- Contains static function that fill the base tables as a preloaded data of the app.

#### Prompt.java

- Contains static functions that ask and validate user's input.

#### Class Diagram

- The folder <code>docs/images/</code> contains the class diagram images.

Here is the diagram class for this full implementation documentation.

![alt text](images/mod_admin_class_diagram.svg)






