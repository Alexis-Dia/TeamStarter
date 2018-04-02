-- auto-generated definition
CREATE TABLE usersfull
(
  id                    INT AUTO_INCREMENT
    PRIMARY KEY,
  username              VARCHAR(255) NULL,
  email                 VARCHAR(255) NULL,
  password              VARCHAR(255) NULL,
  password_confirmation VARCHAR(255) NULL,
  timezone              VARCHAR(255) NULL,
  CONSTRAINT usersFull_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;
