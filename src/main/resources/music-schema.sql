DROP TABLE `music`;
CREATE TABLE `music` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `genre` VARCHAR(255),
    `country` VARCHAR(255),
    `artist` VARCHAR(255),
    `release_year` INTEGER
);