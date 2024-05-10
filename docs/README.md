### Full Implementation Documentation

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL
      NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED",  "MAY", and
      "OPTIONAL" in this document are to be interpreted as described in
      [RFC 2119](https://datatracker.ietf.org/doc/html/rfc2119).

- All ID in classes __MUST__ be greater than 0, this is for displaying purpose in a human readability.

- All fields __MUST NOT__ be null or blank.

- We **SHOULD** be able to make copy of an object, display a class object's details in a pretty printing way.

- Two objects of a class are equal when its fields contents are the same.

#### Member.java
Member class based on Member table in the DB.

##### Rules:
- *Birth Date* **MUST** be in format *dd/MM/yyyy*.

- *Age* **MUST** be calculated automatically from birth date.

- *Email* **MUST** be verify for the bare minimum using regex or similar methods.

- *Passport* **MUST** have **9** characters.

- *AMCI Matricule* **MUST** have **8** digits.

- *Membership Status* **MUST** be **true**(yes) or **false**(no).

- We **SHOULD** be able to create copy object of this class.

- Two objects of this class are equal when its fields contents are the same.

#### Card.java
Stay Card class based on Card table in the DB.

##### Rules:
- *Id Member*, follows ID rule cited on top.<br> This will represent a foreign key in DB representation indicating the member posessing the card.

- *Id City* follows ID rule cited on top.<br> This will represent a foreign key in DB representation indicating the city that issued the card.

- *CIN* **MUST** have 8 digits and not be null and always uppercased.
- *Reason* is the reason of the stay in Morroco.

- *Obtention date*, issued card's date, it **MUST** be a date or stored as one and **MUST** follow the format _dd/MM/yyyy_.

- *Expiration date* **MUST** be a date or stored as one and **MUST** follow the format _dd/MM/yyyy_.

- *PIN* **MUST** have **4** digits, this is delivered along with the card and is part of Morocco's numerical identity [lear more here.](https://www.identitenumerique.ma/about.html) 

#### City.java
City Card class based on City table in the DB.

##### Rules:
- *Name*, name of the city: **MUST NOT** be null or blank.

- *Region*, region where the city is located: **MUST NOT** be null or blank.

- *Facs*, list of faculties within the city and **SHOULD** at least have one faculty, it **MAY** be null.
- *Reason* is the reason of the stay in Morroco.

- *Obtention date*, issued card's date, it **MUST** be a date or stored as one and **MUST** follow the format _dd/MM/yyyy_.

- *Exiration date* **MUST** be a date or stored as one and **MUST** follow the format _dd/MM/yyyy_.

- This object should be able to manage the list of faculties (add, update, delete, get a faculy and get all of them)  

#### Faculty.java
Faculty class based on faculty table in the DB.

##### Rules:
- *Abbr*, abbreviation of the faculty's initial: **MUST NOT** be null or blank.

- *Desc*, description of faculty's abbreviation. The full name: **MUST NOT** be null or blank.

- *Fields*, list of fields in the faculty **SHOULD** at least have one field, it **MAY** be null.

- This object should be able to manage the list of fields (add, update, delete, get a faculy and get all of them)  

#### Field.java
Field class based on Field table in the DB.

##### Rules:
- *Id Faculty*, follows ID rule cited on top.<br> This will represent a foreign key in DB representation indicating the field's Faculty.

- *Abbr*, abbreviation of the field's initial: **MUST NOT** be null or blank.

- *Name*, description of field's abbreviation. The full name: **MUST NOT** be null or blank.

- *Certificate*, diploma that will be issued at the end of the formation; **MUST NOT** be null nor blank.

- *Duration* of the formation, **SHOULD** at least be one year; **MUST NOT** be less or equal to 0






