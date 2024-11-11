CREATE TABLE IF NOT EXISTS reservations (
    id SERIAL PRIMARY KEY,
    date_time TIMESTAMP NOT NULL,
    departure_address VARCHAR(255),
    arrival_address VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    distance_km DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS drivers (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL,
    availability_start TIMESTAMP NOT NULL,
    availability_end TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS vehicles (
    id SERIAL PRIMARY KEY,
    model VARCHAR(100) NOT NULL,
    license_plate VARCHAR(20) NOT NULL,
    mileage INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    type VARCHAR(20) NOT NULL
);