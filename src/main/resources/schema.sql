CREATE TABLE Emploee (
      id varchar(36) NOT NULL,
      INN varchar(20) NOT NULL,
      first_name varchar(50),
      last_name varchar(50),
      department int,
      CONSTRAINT emploees_PK PRIMARY KEY (id)
);