SELECT * FROM hospital.disease;

select count(NAME) from disease;

SELECT p.name, p.surname, d.type -- This SQL query combines the "patient" and "disease" tables to return the columns "name", "surname" and "type".
FROM patient p
JOIN disease d ON p.illness = d.disease_id;

-- This query will return the result set by combining the doctors' information, their specialties, the patients' information, and their disease. Results will be sorted by physician name, surname, branch, patient name, surname and disease columns, and a maximum of 1000 results will be returned. 
SELECT concat(d.name," " , d.surname) as 'DOCTOR INFO', d.branch, CONCAT(p.name," ", p.surname) AS 'PATIENT INFO',  p.illness
FROM doctor d
JOIN appointment a ON d.id = a.doctor_id
JOIN patient p ON a.patient_id = p.id
JOIN disease t ON p.illness = t.name
ORDER BY d.name, d.surname asc
LIMIT 1000;


SELECT p.name, p.surname, p.illness, a1.appointment_date AS 'FirstAppointmentDate', a2.appointment_date AS 'SecondAppointmentDate'
FROM patient p
JOIN appointment a1 ON p.id = a1.patient_id
JOIN appointment a2 ON p.id = a2.patient_id
JOIN disease d1 ON p.illness = d1.name
JOIN disease d2 ON p.illness = d2.name
WHERE d1.name <> d2.name -- The two diseases must be different from each other
  AND a1.appointment_date < a2.appointment_date -- First appointment date must be before second appointment date
  AND p.id IN (
    SELECT patient_id
    FROM appointment
    GROUP BY patient_id
    HAVING COUNT(DISTINCT illness) > 1 -- To find patients with appointments for more than one disease
  )
ORDER BY p.name, p.surname;


use hospital;
-- we use where, group by ,and ,join(2).Bu sorgu, verilen isim ve soyisime sahip hastaların randevu bilgilerini ve ilgili hastaların bölüm bilgilerini getirir. İç içe geçmiş bir sorgu kullanarak, isim ve soyisim filtresi uygulayarak eşleşen hastaların randevularını bulur ve bu randevulara ilişkin bölüm bilgileriyle birlikte sonuç kümesini döndürür.

SELECT a.department_name, CONCAT(p.name, ' ', p.surname) AS "Patient Info"
FROM appointment AS a
JOIN patient AS p ON a.patient_id = p.id
WHERE a.patient_id IN (
    SELECT patient_id
    FROM appointment
    WHERE name = 'Frank' AND surname = 'Delphino'
    GROUP BY patient_id
);



-- WE USED SELECT DISTINCT
select distinct type from disease;

-- WE USED COUNT
select count(type) from disease;
select count(name) from disease;

-- WE USED DELETE
delete from disease;

-- appointment ve treatment tablosundaki fk kısıtlamalarını kaldırdım.
ALTER TABLE appointment DROP FOREIGN KEY appointment_ibfk_3;
ALTER TABLE treatment DROP FOREIGN KEY treatment_ibfk_3;

ALTER TABLE disease DROP COLUMN disease_id;
ALTER TABLE disease ADD PRIMARY KEY (name);



INSERT INTO disease (treatment_period, name, type)
VALUES (17, 'Alzheimer', 'Neurology');

INSERT INTO disease (treatment_period, name, type)
VALUES (15, 'Scoliosis', 'Orthopedics');

INSERT INTO disease (treatment_period, name, type)
VALUES (17, 'Schizophrenia', 'Psychiatry');

INSERT INTO disease (treatment_period, name, type)
VALUES (15, 'Premature labor', 'Obstetrician');

INSERT INTO disease (treatment_period, name, type)
VALUES (15, 'Myocardial infarction', 'Cardiology');

INSERT INTO disease (treatment_period, name, type)
VALUES (17, 'Gout', 'Rheumatology');

INSERT INTO disease (treatment_period, name, type)
VALUES (21, 'Osteoarthritis', 'Orthopedics');

INSERT INTO disease (treatment_period, name, type)
VALUES (72, 'Pregnancy', 'Obstetrician');

INSERT INTO disease (treatment_period, name, type)
VALUES (21, 'Glomerulonephritis', 'Nephrology');

INSERT INTO disease (treatment_period, name, type)
VALUES (10, 'Nephritis Hypertension', 'Nephrology');

INSERT INTO disease (treatment_period, name, type)
VALUES (10, 'Anxiety disorders', 'Psychiatry');

INSERT INTO disease (treatment_period, name, type)
VALUES (16, 'Flu', 'Pulmonology');

INSERT INTO disease (treatment_period, name, type)
VALUES (15, 'Obsessive-compulsive disorder', 'Psychiatry');

INSERT INTO disease (treatment_period, name, type)
VALUES (10, 'Eye Pressure (Glaucoma)', 'Eye Diseases');

INSERT INTO disease (treatment_period, name, type)
VALUES (10, 'Epilepsy', 'Neurology');

INSERT INTO disease (treatment_period, name, type)
VALUES (15, 'Obesity', 'Endocrinology');

INSERT INTO disease (treatment_period, name, type)
VALUES (17, 'Eating disorders', 'Psychiatry');

INSERT INTO disease (treatment_period, name, type)
VALUES (13, 'Cataracts', 'Eye Diseases');

INSERT INTO disease (treatment_period, name, type)
VALUES (17, 'Diabetes', 'Endocrinology');

INSERT INTO disease (treatment_period, name, type)
VALUES (19, 'Brain tumors', 'Neurology');

INSERT INTO disease (treatment_period, name, type)
VALUES (10, 'Asthma', 'Pulmonology');

INSERT INTO disease (treatment_period, name, type)
VALUES (17, 'Heart Rhythm Disorders', 'Cardiology');

INSERT INTO disease (treatment_period, name, type)
VALUES (10, 'Lupus', 'Rheumatology');



INSERT INTO disease (treatment_period, name, type)
VALUES (18, 'Tuberculosis', 'Pulmonology');

INSERT INTO disease (treatment_period, name, type)
VALUES (10, 'Aortic Stenosis', 'Cardiology');

INSERT INTO disease (treatment_period, name, type)
VALUES (15, 'Rheumatoid Arthritis', 'Rheumatology');

select name,type,disease_id from disease
order by name asc ;

alter table disease
drop PRIMARY KEY;  -- IN THIS TABLE, THE NAME WAS INITIALLY DEFINED AS PK, BUT THE PK WAS REMOVED BECAUSE THERE MAY BE MANY PATIENTS WITH THE SAME DISEASE.

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Emma', 'Thompson', '1980-06-22', 'Female', 'Alzheimer', '2023-03-15', '2023-04-01');

INSERT INTO patient (name, surname, DateOfBirth, gender, illness, AppointmentDate, DischargeDate)
VALUES ('Frank', 'Delphino', '1988-09-12', 'Male', 'Alzheimer', '2023-04-19', '2023-07-03');

