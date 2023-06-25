SELECT * FROM hospital.hospital;

SELECT * FROM hospital.hospital;

-- Update the number of doctors, the number of patients, etc.

update hospital 
set NumberOfDoctors=16
Where hospitalName= 'GSDM Hospital';

update hospital 
set NumberOfPatient=31
Where hospitalName= 'GSDM Hospital';

update hospital 
set department=13
Where hospitalName= 'GSDM Hospital';


-- these are our some queries

-- join(3) This query uses a triple JOIN structure. While the appointment and sick_treats tables are combined using two JOIN statements, the doctor table is combined with the third JOIN statement. In this way, the three tables are combined to obtain the relationship between the appointment and the sick_treats tables and the relevant doctor information in the doctor table.

SELECT a.patient_id, a.disease_name, s.medicine_name, d.id as doctor_id, d.branch as doctor_branch
FROM appointment AS a
JOIN sick_treats AS s ON a.patient_id = s.patient_id AND a.disease_name = s.disease_name
JOIN doctor AS d ON a.doctor_id = d.id
ORDER BY d.branch;

-- HAVING:
SELECT branch, AVG(salary) AS avg_salary
FROM doctor
GROUP BY branch
HAVING AVG(salary) > 20000;

-- EXISTS  checks if there are any appointments for each patient. The EXISTS condition evaluates to true if there is at least one matching record
SELECT p.name, p.surname
FROM patient p
WHERE EXISTS (
    SELECT 1
    FROM appointment a
    WHERE a.patient_id = p.id
    -- Check if patient has any appointments
);


-- IS NOT  NULL:
SELECT MedicationName
FROM medicine
WHERE StockStatus IS not NULL;

-- IN/NOT IN:
SELECT id,branch
FROM doctor
WHERE id IN (1, 3, 5) ;

-- BETWEEN AND:
SELECT concat(name,' ',surname) as "Doctor Info" , salary
FROM doctor
WHERE salary BETWEEN 70000 AND 150000;

-- MIN/MAX:
SELECT m.medicationName, m.stockStatus AS "Max Stock Status"
FROM medicine m
WHERE m.stockStatus = (
    SELECT MAX(stockStatus)
    FROM medicine
)
GROUP BY m.medicationName, m.stockStatus;



-- SOME:
SELECT concat(name,' ' ,surname) as "Doctor Info",id AS "Doctor Id", branch as 'Doctor Branch'
FROM doctor
WHERE branch= SOME (SELECT branch FROM doctor WHERE branch='Cardiology');

-- ALL:
select * from doctor
where salary > all(select avg(salary) from doctor 
group by branch);

-- UNIQUE:
SELECT DISTINCT branch
FROM doctor;

SELECT branch, COUNT(DISTINCT name)  as "Total Disease"
FROM doctor 
GROUP BY branch
HAVING COUNT(DISTINCT name) >= 1;

-- SUBQUERY IN THE FROM:
SELECT d.branch, COUNT(p.id) AS num_patients
FROM (	
    SELECT id, branch
    FROM doctor
    WHERE branch = 'Neurology'
) AS d
JOIN appointment AS a ON d.id = a.doctor_id
JOIN patient AS p ON a.patient_id = p.id
GROUP BY d.id, d.branch;



-- UNION/EXCEPT/INTERSECT:
SELECT a.patient_id, a.disease_name, d.id, d.name
FROM appointment AS a
JOIN doctor AS d ON a.doctor_id = d.id
UNION
SELECT NULL AS patient_id, NULL AS disease_name, d.id, d.name
FROM doctor AS d
WHERE d.id NOT IN (SELECT doctor_id FROM appointment);

-- doctor ids with no patients
SELECT id FROM doctor as doctorid
EXCEPT
SELECT doctor_id FROM appointment;


SELECT DISTINCT disease_name FROM appointment
INTERSECT
SELECT name FROM disease;




-- WE USE VIEW 
CREATE VIEW doctor_view AS
SELECT CONCAT(name, " " ,surname) as "DOCTORS INFO", ID, branch
FROM doctor;

SELECT * FROM doctor_view;

DROP VIEW doctor_view; -- WE HAVE RENAMED. THAT'S WHY WE USE DROP VIEW.

ALTER TABLE hospital
ADD COLUMN NumberOfDoctor INT,
ADD CONSTRAINT FK_hospital_doctor
FOREIGN KEY (tablo1_id)
REFERENCES Tablo1(id);


-- We gave 15% raise to doctors whose graduation_date was before '1990-01-01'
UPDATE doctor
SET salary = 
    CASE
        WHEN graduation_date < '1990-01-01' THEN salary * 1.15 
        ELSE salary
    END;
    
    SELECT * FROM doctor;
select name,surname,branch,id from doctor
order by branch;
drop table doctor;

delete from doctor;

-- Removed doctor_id fk from appointment table to add table a salary
ALTER TABLE appointment
DROP FOREIGN KEY appointment_ibfk_1;

-- We re-added the doctor_id fk in the appointment table
ALTER TABLE appointment
ADD CONSTRAINT appointment_ibfk_1
FOREIGN KEY (doctor_id) REFERENCES doctor (id);

-- We double-checked the table to verify that the constraint was successfully added.
SHOW CREATE TABLE appointment;

-- we used string operaions: LIKE
SELECT CONCAT( name, " ",surname) AS 'NAME SURNAME' ,branch
FROM doctor
WHERE branch LIKE 'Ne%';

ALTER TABLE doctor
ADD COLUMN salary DECIMAL(10,2);


delete from medicine
where MedicationName='PARANOX';  -- THIS DRUG USED AS PAIN RELIEF IN CHILDREN, HAS BEEN REVOCED BY THE MINISTRY OF HEALTH BY STOPPING ITS MANUFACTURING.



-- WE USED AVG 
select avg(StockStatus) as AVG_STOCK 
FROM medicine;

select count(StockStatus) from medicine;


delete  from appointment;

UPDATE appointment
SET department_name = 'Obstetrician'
WHERE appointment_id = 17;

