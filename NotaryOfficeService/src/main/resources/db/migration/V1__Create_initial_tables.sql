CREATE TABLE registry_office_situations (
                                            id VARCHAR(20) PRIMARY KEY,
                                            name VARCHAR(50) NOT NULL
);

CREATE TABLE registry_office_duties (
                                        id VARCHAR(20) PRIMARY KEY,
                                        name VARCHAR(50) NOT NULL,
                                        situation BOOLEAN DEFAULT TRUE NOT NULL
);

CREATE TABLE notary_offices (
                                id INT PRIMARY KEY,
                                name VARCHAR(150) NOT NULL,
                                note VARCHAR(250),
                                status VARCHAR(20) NOT NULL,
                                FOREIGN KEY (status) REFERENCES registry_office_situations(id)
);

CREATE TABLE notary_office_duties (
                                      notary_office_id INT,
                                      duty_id VARCHAR(20),
                                      PRIMARY KEY (notary_office_id, duty_id),
                                      FOREIGN KEY (notary_office_id) REFERENCES notary_offices(id),
                                      FOREIGN KEY (duty_id) REFERENCES registry_office_duties(id)
);
