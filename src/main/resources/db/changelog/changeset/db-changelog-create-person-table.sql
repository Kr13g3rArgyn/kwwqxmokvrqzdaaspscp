CREATE TABLE person (
id SERIAL PRIMARY KEY generated by default as identity ,
name VARCHAR(255),
birthYear INTEGER,
firstPhoneNum BIGINT,
secondPhoneNum BIGINT,
createdAt TIMESTAMP
);