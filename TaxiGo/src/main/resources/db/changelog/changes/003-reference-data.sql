INSERT INTO drivers (last_name, first_name, status, availability_start, availability_end) VALUES
    ('John Doe', 'John', 'AVAILABLE', '2023-05-01 08:00:00', '2023-05-01 18:00:00'),
    ('Jane Smith', 'Jane', 'IN_PROGRESS', '2023-05-02 09:00:00', '2023-05-02 17:00:00'),
    ('Bob Johnson', 'Bob', 'UNAVAILABLE', '2023-05-03 10:00:00', '2023-05-03 20:00:00');

INSERT INTO vehicles (model, license_plate, mileage, status, type) VALUES
    ('Toyota Camry', 'ABC123', 50000, 'AVAILABLE', 'SEDAN'),
    ('Ford Transit', 'XYZ789', 75000, 'IN_PROGRESS', 'VAN'),
    ('Mercedes-Benz Sprinter', 'PQR456', 30000, 'UNAVAILABLE', 'MINIBUS');
    
    
INSERT INTO reservations (date_time, departure_address, arrival_address, price, status, distance_km, driver_id, vehicle_id,start_time_course,end_time_course) VALUES
    ('2023-05-01 10:00:00', 'New York Manhattan', 'New York Brownx', 50.00, 'CREATED', 385.2, 1, 1,8,9),
    ('2023-05-02 14:30:00', 'Los Angeles Hollywood', 'Los Angeles center', 35.00, 'CONFIRMED', 268.4, 2, 2,10,11),
    ('2023-05-03 18:15:00', 'Chicago', 'Chicago downcity', 45.00, 'COMPLETED', 385.2, 3, 3,12,13);
