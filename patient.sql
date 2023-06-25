SELECT * FROM hospital.patient;


select id,illness from patient
order by illness asc;
-- we use IN 
SELECT DISTINCT a.department_name, concat(p.name, " ", p.surname) as 'Patient Info'
FROM appointment a
JOIN patient p ON p.id = a.patient_id
WHERE p.name = 'Frank' AND p.surname = 'Delphino'
AND p.illness IN ('Lupus', 'Alzheimer');
 
update patient
set illness='Schizophrenia'
where name='Doğukan';

drop table patient;-- We rebuilt the table to auto inc the ids

delete from patient;


update patient
set surname='Simon'
where name='Harry';



INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Harry', 'Styles', '1997-08-07', 'Male', 'Aortic Stenosis', '2023-12-22', '2024-01-01');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Emma', 'Watson', '1990-04-15', 'Female', 'Heart Rhythm Disorders', '2023-11-18', '2023-12-05');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Michael', 'Johnson', '1985-06-30', 'Male', 'Myocardial infarction', '2023-10-10', '2023-10-25');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Sophia', 'Miller', '1982-12-12', 'Female', 'Diabetes', '2023-09-03', '2023-09-20');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Oliver', 'Smith', '1988-09-25', 'Male', 'Obesity', '2023-08-15', '2023-08-30');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Isabella', 'Taylor', '1995-03-08', 'Female', 'Cataracts', '2023-07-12', '2023-07-25');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Noah', 'Brown', '1992-11-18', 'Male', 'Eye Pressure (Glaucoma)', '2023-06-20', '2023-06-30');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Mia', 'Anderson', '1999-07-04', 'Female', 'Glomerulonephritis', '2023-05-15', '2023-06-05');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('James', 'Wilson', '1975-02-10', 'Male', 'Nephritis Hypertension', '2023-04-25', '2023-05-05');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Emma', 'Thompson', '1980-06-22', 'Female', 'Alzheimer', '2023-03-15', '2023-04-01');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Daniel', 'Roberts', '1979-09-08', 'Male', 'Brain tumors', '2023-02-10', '2023-03-01');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Emily', 'Davis', '1985-12-29', 'Female', 'Epilepsy', '2023-01-05', '2023-01-15');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Olivia', 'Wilson', '1990-07-15', 'Female', 'Pregnancy', '2022-12-10', '2023-02-20');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('William', 'Johnson', '1984-05-03', 'Male', 'Premature labor', '2022-11-15', '2022-11-30');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Sophia', 'Brown', '1993-09-12', 'Female', 'Osteoarthritis', '2022-10-20', '2022-11-10');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Benjamin', 'Davis', '1987-04-28', 'Male', 'Scoliosis', '2022-09-15', '2022-09-30');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Liam', 'Clark', '1992-03-18', 'Male', 'Anxiety disorders', '2022-08-10', '2022-08-20');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Ava', 'Anderson', '1988-11-02', 'Female', 'Eating disorders', '2022-07-15', '2022-08-01');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Noah', 'Harris', '1995-06-25', 'Male', 'Obsessive-compulsive disorder', '2022-06-20', '2022-07-05');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Mia', 'Thompson', '1998-09-09', 'Female', 'Schizophrenia', '2022-05-15', '2022-06-01');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Emma', 'Wilson', '1991-02-12', 'Female', 'Asthma', '2022-04-10', '2022-04-20');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('James', 'Jackson', '1985-08-28', 'Male', 'Flu', '2022-03-15', '2022-03-31');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Avery', 'Green', '1996-12-07', 'Female', 'Tuberculosis', '2022-02-20', '2022-03-10');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Ethan', 'Lee', '1999-07-23', 'Male', 'Gout', '2022-01-15', '2022-02-01');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Oliver', 'Martin', '1993-05-02', 'Male', 'Lupus', '2022-12-10', '2022-12-20');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Sophia', 'Anderson', '1990-09-18', 'Female', 'Rheumatoid Arthritis', '2022-11-15', '2022-11-30');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Frank', 'Delphino', '1988-09-12', 'Male', 'Alzheimer', '2023-04-19', '2023-07-03');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Ethan', 'Lee', '1999-07-23', 'Male', 'Aortic Stenosis', '2022-05-17', '2022-05-27');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Oliver', 'Martin', '1993-05-02', 'Male', 'Obesity', '2022-07-10', '2022-07-25');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Sophia', 'Anderson', '1990-09-18', 'Female', ' Diabetes', '2023-08-05', '2023-08-22');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Frank', 'Delphino', '1988-09-12', 'Male', 'Lupus', '2023-07-19', '2023-07-29');
