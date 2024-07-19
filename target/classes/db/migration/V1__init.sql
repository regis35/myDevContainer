CREATE TABLE if not exists users (
    id SERIAL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE INDEX if not exists idx_users_email ON users(email);

CREATE TABLE if not exists todos(
    id BIGINT NOT NULL,
    id_user BIGINT NOT NULL,
    title VARCHAR(250) NOT NULL,
    description TEXT,
    PRIMARY KEY (id),
    CONSTRAINT fk_users FOREIGN KEY (id_user) references users(id)
);

