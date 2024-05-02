CREATE TABLE notification (
                              id SERIAL PRIMARY KEY,
                              client_id BIGINT NOT NULL,
                              message TEXT NOT NULL,
                              notification_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                              status VARCHAR(255) NOT NULL,
                              title VARCHAR(255)
);
