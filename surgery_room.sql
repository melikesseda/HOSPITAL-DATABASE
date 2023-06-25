SELECT * FROM hospital.surgery_room;


update surgery_room
set floor=0
where Department='Psychiatry';

update surgery_room
set capacity=5
where SurgeryRoomNo=7;

-- WE USED SUM
SELECT SUM(capacity) AS TOTAL_CAPACITY
FROM surgery_room;

