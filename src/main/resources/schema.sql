CREATE DATABASE IF NOT EXISTS `vibe_tracker`;
USE `vibe_tracker`;

DROP TABLE IF EXISTS `vibe`;
DROP TABLE IF EXISTS `rating`;
DROP TABLE IF EXISTS `person`;

--
-- Table structure for table `user`
--

CREATE TABLE `person` (
    `id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(50) NOT NULL,
    `password` varchar(255) NOT NULL,
    `firstname` varchar(50) NOT NULL,
    `lastname` varchar(50) NOT NULL,
    `nickname` varchar(50) DEFAULT NULL,
    `email` varchar(100) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username_unique` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `panorama`
--

CREATE TABLE `rating` (
    `id` int NOT NULL AUTO_INCREMENT,
    `overview` text NOT NULL,
    `rating_order` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `vibe`
--

CREATE TABLE `vibe` (
    `id` int NOT NULL AUTO_INCREMENT,
    `date` datetime DEFAULT NULL,
    `rating_id` int NOT NULL,
    `user_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_user_idx` (`user_id`),
    KEY `fk_rating_idx` (`rating_id`),
    CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `person` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_rating` FOREIGN KEY (`rating_id`) REFERENCES `rating` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Insert sample data
--

INSERT INTO `person` (`username`, `password`, `firstname`, `lastname`, `nickname`, `email`)
VALUES ('johndoe', 'password123', 'John', 'Doe', 'JD', 'john.doe@example.com');

INSERT INTO `rating` (`overview`, `rating_order`) VALUES
    ('Great', 1),
    ('Good', 2),
    ('Meh', 3),
    ('Bad', 4),
    ('Ugly', 5);
