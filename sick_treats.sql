SELECT * FROM hospital.sick_treats;

CREATE TABLE sick_treats (
  patient_id INT,
  disease_name VARCHAR(50),
  medicine_name VARCHAR(50),
  FOREIGN KEY (patient_id) REFERENCES patient(id),
  FOREIGN KEY (disease_name) REFERENCES disease(name),
  FOREIGN KEY (medicine_name) REFERENCES medicine(medicationName)
);

select patient_id , disease_name,medicine_name
from sick_treats
where medicine_name='VOLTAREN';


INSERT INTO sick_treats(patient_id,disease_name,medicine_name)
VALUES (64,'Osteoarthritis','VOLTAREN'),
(75,'Rheumatoid Arthritis','VOLTAREN'),
(73,'Gout','VOLTAREN'),
(77,'Aortic Stenosis','ASPIRIN'),
(51,'Heart Rhythm Disorders','ASPIRIN'),
(52,'Myocardial infarction','ASPIRIN'),
(75,'Rheumatoid Arthritis','ARVELES'),
(64,'Osteoarthritis','ARVELES'),
(58,'Nephritis Hypertension','BENICAR'),
(58,'Nephritis Hypertension','CAPTOPRIL'),
(75,'Rheumatoid Arthritis','ENBREL'),
(69,'Schizophrenia','GEODON'),
(66,'Anxiety disorders','PROZAC'),
(68,'Obsessive-compulsive disorder','PROZAC'),
(59,'Alzheimer','DONEPEZIL'),
(76,'Alzheimer','DONEPEZIL'),
(70,'Asthma','ALBUTEROL'),
(53,'Diabetes','METFORMIN'),
(60,'Brain tumors','TEMODAL'),
(62,'Pregnancy','OXYTOCIN'),
(63,'Premature labor','OXYTOCIN'),
(53,'Diabetes','EPIPEN'),
(61,'Epilepsy','KAPVAY'),
(58,'Nephritis Hypertension','DOPAMINE'),
(54,'Obesity','NEXIUM'),
(78,'Obesity','NEXIUM'),
(75,'Rheumatoid Arthritis','TORADOL'),
(64,'Osteoarthritis','TORADOL'),
(69,'Schizophrenia','ZOPICLONE');
