CREATE SCHEMA `task_management` ;

CREATE TABLE `task_management`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

CREATE TABLE `task_management`.`plan` (
  `id_plan` INT NOT NULL AUTO_INCREMENT,
  `plan` VARCHAR(50) NOT NULL,
  `description` VARCHAR(100) NULL,
  `date_created` DATE NOT NULL,
  `due_date` DATE NOT NULL,
  `type` VARCHAR(50) NULL,
  `status` VARCHAR(50) NOT NULL,
  `id_user` INT NULL,
  PRIMARY KEY (`id_plan`),
  INDEX `fk_user_task_management_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_user_task_management`
    FOREIGN KEY (`id_user`)
    REFERENCES `task_management`.`user` (`id_user`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
