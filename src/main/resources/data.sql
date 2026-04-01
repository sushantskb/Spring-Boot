INSERT INTO
    public.patient (birth_date, email, gender, name, blood_group)
VALUES
    (
        '1990-01-15',
        'patient1@example.com',
        'Male',
        'John Doe',
        'A_POSITIVE'
    ),
    (
        '1985-05-22',
        'patient2@example.com',
        'Female',
        'Jane Smith',
        'B_NEGATIVE'
    ),
    (
        '1978-11-30',
        'patient3@example.com',
        'Male',
        'Robert Johnson',
        'AB_POSITIVE'
    ),
    (
        '1992-08-10',
        'patient4@example.com',
        'Female',
        'Emily Brown',
        'O_NEGATIVE'
    ),
    (
        '1980-03-25',
        'patient5@example.com',
        'Male',
        'Michael Wilson',
        'A_NEGATIVE'
    );

INSERT INTO
    public.doctor (name, specialization, email, license_number)
VALUES
    (
        'Dr. Alice Green',
        'Cardiology',
        'alice.green@example.com',
        'MD12345'
    ),
    (
        'Dr. Bob White',
        'Neurology',
        'bob.white@example.com',
        'MD67890'
    ),
    (
        'Dr. Carol Black',
        'Pediatrics',
        'carol.black@example.com',
        'MD54321'
    );

INSERT INTO
    public.appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
    ('2024-07-01 10:00:00', 'Routine Checkup', 1, 1),
    ('2024-07-02 14:30:00', 'Headache', 2, 2),
    ('2024-07-03 09:00:00', 'Child Vaccination', 3, 3),
    ('2024-07-05 16:00:00', 'Follow-up Visit', 2, 5);