### Documentation

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL
      NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED",  "MAY", and
      "OPTIONAL" in this document are to be interpreted as described in
      [RFC 2119](https://datatracker.ietf.org/doc/html/rfc2119).

- All ID in classes __MUST__ be greater than 0, this is for displaying purpose in a human readability.

- All fields __MUST NOT__ be null or blank

#### Member.java
Member class based on User table in the DB

##### Rules:
- *Birth Date* **MUST** be in format *dd/MM/yyyy*

- *Age* **MUST** be calculated automatically from birth date.

- *Email* **MUST** be verify for the bare minimum using regex or similar methods.

- *Passport* **MUST** have **9** characters.

- *AMCI Matricule* **MUST** have **8** digits.

- *Membership Status* **MUST** be **true**(yes) or **false**(no).

- We **SHOULD** be able to create copy object of this class.

- Two objects of this class are equal when its fields contents are the same

- We **SHOULD** be able to to display class object's details in a pretty printing way.


