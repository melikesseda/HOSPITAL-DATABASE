SELECT * FROM hospital.treatment;

DROP TABLE TREATMENT;
delete from treatment;
CREATE TABLE treatment (
  doctor_id INT,
  patient_id INT,
  disease_name varchar(50),
  FOREIGN KEY (doctor_id) REFERENCES doctor(id),
  FOREIGN KEY (patient_id) REFERENCES patient(id),
  FOREIGN KEY (disease_name) REFERENCES disease(name)
);

ALTER TABLE treatment DROP FOREIGN KEY treatment_ibfk_3;


-- we use not in(we got an error in fk restriction because we entered different names.)(diabets, anxiety disorder)
SELECT DISTINCT disease_name
FROM treatment
WHERE disease_name NOT IN (SELECT name FROM disease);

ALTER TABLE treatment 
ADD CONSTRAINT treatment_ibfk_3 FOREIGN KEY (disease_name) REFERENCES disease (name);


INSERT INTO treatment (doctor_id, patient_id, disease_name)
VALUES
(1, 50, 'Aortic Stenosis'),
(1, 51, 'Heart Rhythm Disorders'),
(4, 52, 'Myocardial infarction'),
(14, 53, 'Diabetes'),
(14, 54, 'Obesity'),
(6, 55, 'Cataracts'),
(11, 56, 'Eye Pressure (Glaucoma)'),
(5, 57, 'Glomerulonephritis'),
(12, 58, 'Nephritis Hypertension'),
(3, 59, 'Alzheimer'),
(3, 60, 'Brain tumors'),
(3, 61, 'Epilepsy'),
(2, 62, 'Pregnancy'),
(9, 63, 'Premature labor'),
(8, 64, 'Osteoarthritis'),
(8, 65, 'Scoliosis'),
(16, 66, 'Anxiety disorders'),
(15, 67, 'Eating disorders'),
(16, 68, 'Obsessive-compulsive disorder'),
(15, 69, 'Schizophrenia'),
(13, 70, 'Asthma'),
(13, 71, 'Flu'),
(13, 72, 'Tuberculosis'),
(10, 73, 'Gout'),
(7, 74, 'Lupus'),
(7, 75, 'Rheumatoid Arthritis'),
(3, 76, 'Alzheimer'),
(1, 77, 'Aortic Stenosis'),
(14, 78, 'Obesity'),
(14, 79, 'Diabetes'),
(10, 80, 'Lupus');




