    CREATE TABLE `restaurant`.`produkt` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `name` VARCHAR(45) NOT NULL,
      `category` VARCHAR(45) NOT NULL,
      `price` VARCHAR(45) NOT NULL,
      PRIMARY KEY (`id`));
    CREATE TABLE `restaurant`.`users` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `name` VARCHAR(45) NOT NULL,
      `surname` VARCHAR(45) NOT NULL,
      `email` VARCHAR(45) NOT NULL,
      `password` VARCHAR(45) NOT NULL,
      `role` VARCHAR(45) NOT NULL,
      PRIMARY KEY (`id`),
      UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

    CREATE TABLE `restaurant`.`cart` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `price` VARCHAR(45) NULL,
      `payment_method` VARCHAR(45) NULL,
      `id_user` INT NULL,
      PRIMARY KEY (`id`),
      INDEX `user_fk_idx` (`id_user` ASC) VISIBLE,
      CONSTRAINT `user_fk`
        FOREIGN KEY (`id_user`)
        REFERENCES `restaurant`.`users` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);

    CREATE TABLE `restaurant`.`cart_product` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `id_cart` INT NOT NULL,
      `id_product` INT NOT NULL,
      PRIMARY KEY (`id`),
      INDEX `cart_fk_idx` (`id_cart` ASC) VISIBLE,
      INDEX `product_fk_idx` (`id_product` ASC) VISIBLE,
      CONSTRAINT `cart_fk`
        FOREIGN KEY (`id_cart`)
        REFERENCES `restaurant`.`cart` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
      CONSTRAINT `product_fk`
        FOREIGN KEY (`id_product`)
        REFERENCES `restaurant`.`produkt` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);
    CREATE TABLE `restaurant`.`waiter` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `name` VARCHAR(45) NULL,
      `surname` VARCHAR(45) NULL,
      `feedback` VARCHAR(45) NULL,
      PRIMARY KEY (`id`));
    CREATE TABLE `restaurant`.`receipt` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `price` DOUBLE NULL,
      `id_waiter` INT NULL,
      PRIMARY KEY (`id`),
      INDEX `waiter_fk_idx` (`id_waiter` ASC) VISIBLE,
      CONSTRAINT `waiter_fk`
        FOREIGN KEY (`id_waiter`)
        REFERENCES `restaurant`.`waiter` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);
    CREATE TABLE `restaurant`.`receipt_product` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `id_product` INT NULL,
      `id_receipt` INT NULL,
      PRIMARY KEY (`id`),
      INDEX `product_fk_idx` (`id_product` ASC) VISIBLE,
      INDEX `fature_fk_idx` (`id_receipt` ASC) VISIBLE,
      CONSTRAINT `product_fk1`
        FOREIGN KEY (`id_product`)
        REFERENCES `restaurant`.`produkt` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
      CONSTRAINT `fature_fk`
        FOREIGN KEY (`id_receipt`)
        REFERENCES `restaurant`.`receipt` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);

