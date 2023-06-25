SELECT * FROM hospital.appointment;


-- WE USED DROP OBJ.
DROP TABLE IF EXISTS appointment; -- We already created the appointment table, but we created it again using ternary relationship

CREATE TABLE appointment (
  appointment_id INT AUTO_INCREMENT PRIMARY KEY,
  doctor_id INT,
  patient_id INT,
  disease_name varchar(50),
  department_name VARCHAR(200),
  appointment_date DATE,
  FOREIGN KEY (doctor_id) REFERENCES doctor(id),
  FOREIGN KEY (patient_id) REFERENCES patient(id),
  FOREIGN KEY (disease_name) REFERENCES disease(name)
);


INSERT INTO appointment (doctor_id,patient_id,disease_name, department_name, appointment_date)
VALUES (1,50,'Aortic Stenosis','Cardiology','2023-12-22'),
(1, 51, 'Heart Rhythm Disorders', 'Cardiology', '2023-11-18'),
(1, 52, 'Myocardial infarction', 'Cardiology', '2023-10-10'),
(14, 53, 'Diabetes', 'Endocrinology', '2023-09-03'),
(14, 54, 'Obesity', 'Endocrinology', '2023-08-15'),
(6, 55, 'Cataracts', 'Eye Diseases', '2023-07-12'),
(6, 56, 'Eye Pressure (Glaucoma)', 'Eye Diseases', '2023-06-20'),
 (5, 57, 'Glomerulonephritis', 'Nephrology', '2023-05-15'),
 (12, 58, 'Nephritis Hypertension', 'Nephrology', '2023-04-25'),
 (3, 59, 'Alzheimer', 'Neurology', '2023-03-15'),
 (3, 60, 'Brain tumors', 'Neurology', '2023-02-10'),
 (3, 61, 'Epilepsy', 'Neurology', '2023-01-05'),
 (2, 62, 'Pregnancy', 'Obstetrician', '2022-12-10'),
 (9, 63, 'Premature labor', 'Obstetrician', '2022-11-15'),
  (8, 64, 'Osteoarthritis', 'Orthopedics', '2022-10-20'),
  (8, 65, 'Scoliosis', 'Orthopedics', '2022-09-15'),
(15, 66, 'Eating disorders', 'Psychiatry', '2022-07-15'),
(16, 67, 'Anxiety disorders', 'Psychiatry', '2022-08-10'),
(16, 68, 'Schizophrenia', 'Psychiatry', '2022-05-15'),
(15, 69, 'Obsessive-compulsive disorder', 'Psychiatry', '2022-06-20'),
(7, 70, 'Gout', 'Rheumatology', '2022-01-15'),
 (10, 71, 'Lupus', 'Rheumatology', '2022-12-10'),
 (7, 72, 'Rheumatoid Arthritis', 'Rheumatology', '2022-11-15'),
 (13, 73, 'Asthma', 'Pulmonology', '2022-04-10'),
 (13, 74, 'Flu', 'Pulmonology', '2022-03-15'),
 (13, 75, 'Tuberculosis', 'Pulmonology', '2022-02-20'),
 (3, 76, 'Alzheimer', 'Neurology', '2023-04-19'),
(1, 77, 'Aortic Stenosis', 'Cardiology', '2022-05-17'),
 (14, 78, 'Obesity', 'Endocrinology', '2022-07-10'),
 (14, 79, 'Diabetes', 'Endocrinology', '2023-08-05'),
 (7, 80, 'Lupus', 'Rheumatology', '2023-07-19');
 
