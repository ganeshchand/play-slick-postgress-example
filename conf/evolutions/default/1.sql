CREATE TABLE USERS (
  ID  SERIAL NOT NULL , -- Use AutoIncrement for H2 database
  USERNAME varchar(255) NOT NULL PRIMARY KEY,
  PASSWORD varchar(255) NOT NULL,
  FULL_NAME VARCHAR(255) NOT NULL,
  EMAIL VARCHAR(255) ,
  GENDER VARCHAR(10) ,
  DOB DATE NOT NULL,
  JOINED_DATE DATE NOT NULL
);

INSERT INTO public.users
(id, username, password, full_name, email, gender, dob, joined_date)
VALUES (1,'Jane', 'password', 'Jane Smith', 'jane.smith@gmail.com', 'Female', '2017-07-26', '2017-07-29');