SELECT * FROM hospital.works;

-- Hospital-Doctor relationship was created.
CREATE TABLE works (
  doctor_id INT,
  hospital_name VARCHAR(100),
  FOREIGN KEY (doctor_id) REFERENCES doctor(id)
);

-- Physician values working in our hospital have been added to the system.
INSERT INTO works (doctor_id, hospital_name)
VALUES 
(1, 'GSDM Hospital'),
(2, 'GSDM Hospital'),
(3, 'GSDM Hospital'),
(4, 'GSDM Hospital'),
(5, 'GSDM Hospital'),
(6, 'GSDM Hospital'),
(7, 'GSDM Hospital'),
(8, 'GSDM Hospital'),
(9, 'GSDM Hospital'),
(10, 'GSDM Hospital'),
(11, 'GSDM Hospital'),
(12, 'GSDM Hospital'),
(13, 'GSDM Hospital'),
(14, 'GSDM Hospital'),
(15, 'GSDM Hospital'),
(16, 'GSDM Hospital');

