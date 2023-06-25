select * from surgery;

-- The surgery relation has been created.
CREATE TABLE surgery (
  operation_date DATE,
  OperationRoomNo INT,
  doctor_name varchar(50),
doctor_surname varchar(50),
  patient_name varchar(50),
   patient_surname varchar(50),
  FOREIGN KEY (doctor_name) REFERENCES doctor(name),
  FOREIGN KEY (doctor_surname) REFERENCES doctor(surname),
  FOREIGN KEY (patient_name) REFERENCES patient(name),
  FOREIGN KEY (patient_surname) REFERENCES patient(surname)
);


-- WE CREATED INDEX FOR THE DOCTOR AND PATIENT BECAUSE THERE IS FK RESTRICTION IN THE APPOINTMENT TABLE.
CREATE INDEX idx_doctor_name ON doctor (name);
CREATE INDEX idx_doctor_surname ON doctor (surname);
CREATE INDEX idx_patient_name ON patient (name);
CREATE INDEX idx_patient_surname ON patient (surname);


DELETE FROM SURGERY;
INSERT INTO surgery (operation_date, OperationRoomNo, doctor_name, doctor_surname, patient_name, patient_surname)
VALUES
('2023-12-26', 2, 'Anthony', 'Brown', 'Harry', 'Styles'),
('2023-11-29', 2, 'Anthony', 'Robins', 'Emma', 'Watson'),
('2023-10-17', 2, 'Anthony', 'Brown', 'Oliver', 'Smith'),
('2023-08-20', 7, 'Canan', 'Karatoy', 'Oliver', 'Smith'),
('2023-07-20', 9, 'Benjamin', 'Anderson', 'Isabella', 'Taylor'),
('2023-06-28', 9, 'Ava', 'Taylor', 'Noah', 'Brown'),
('2023-05-30', 3, 'Sophia', 'Mitchell', 'Mia', 'Anderson'),
('2023-05-01', 3, 'Alexander', 'Martinez', 'James', 'Wilson'),
('2023-02-11', 1, 'Amelia', 'Write', 'Daniel', 'Roberts'),
('2023-12-17', 10, 'Andrew', 'Khan', 'Olivia', 'Wilson'),
('2022-11-23', 10, 'Olivia', 'Davis', 'William', 'Johnson'),
('2022-10-31', 5, 'Noah', 'Thompson', 'Sophia', 'Brown'),
('2022-01-27', 4, 'Isabella', 'Wilson', 'Ethan', 'Lee'),
('2022-10-16', 4, 'Ethan', 'Johnson', 'Oliver', 'Martin'),
('2022-11-18', 4, 'Ethan', 'Johnson', 'Sophia', 'Anderson');
