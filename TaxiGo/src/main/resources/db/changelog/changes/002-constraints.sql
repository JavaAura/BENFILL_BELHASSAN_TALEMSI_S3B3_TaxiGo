
ALTER TABLE reservations ADD COLUMN driver_id INTEGER;

ALTER TABLE reservations ADD COLUMN vehicle_id INTEGER;

ALTER TABLE reservations ADD CONSTRAINT fk_driver FOREIGN KEY (driver_id) REFERENCES drivers(id);

ALTER TABLE reservations ADD CONSTRAINT fk_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicles(id);

ALTER TABLE reservations ADD CONSTRAINT check_status CHECK (status IN ('CREATED', 'CONFIRMED', 'COMPLETED', 'CANCELLED'));