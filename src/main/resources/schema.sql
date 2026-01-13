CREATE DATABASE IF NOT EXISTS `vibe_tracker`;
USE `vibe_tracker`;

DROP TABLE IF EXISTS `vibe`;
DROP TABLE IF EXISTS `rating`;
DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `day_health`;

--
-- Table structure for table `user`
--

CREATE TABLE `person` (
    `user_id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(50) NOT NULL,
    `password` varchar(255) NOT NULL,
    `firstname` varchar(50) NOT NULL,
    `lastname` varchar(50) NOT NULL,
    `nickname` varchar(50) DEFAULT NULL,
    `email` varchar(100) NOT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `username_unique` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `panorama`
--

CREATE TABLE `rating` (
    `rating_id` int NOT NULL AUTO_INCREMENT,
    `overview` text NOT NULL,
    `rating_order` int NOT NULL,
    PRIMARY KEY (`rating_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `vibe`
--

CREATE TABLE `vibe` (
    `vibe_id` int NOT NULL AUTO_INCREMENT,
    `date` datetime DEFAULT NULL,
    `rating_id` int NOT NULL,
    `user_id` int NOT NULL,
    PRIMARY KEY (`vibe_id`),
    KEY `fk_user_idx` (`user_id`),
    KEY `fk_rating_idx` (`rating_id`),
    CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `person` (`user_id`) ON DELETE CASCADE,
    CONSTRAINT `fk_rating` FOREIGN KEY (`rating_id`) REFERENCES `rating` (`rating_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `daily_health`
--

CREATE TABLE `day_health` (
    `health_entry_id` int NOT NULL AUTO_INCREMENT,
    `vibe_id` int NOT NULL,
    `mental_rating_id` int DEFAULT NULL,
    `physical_rating_id` int DEFAULT NULL,
    `mental_health_notes` text DEFAULT NULL,
    `physical_health_notes` text DEFAULT NULL,
    `wins` text DEFAULT NULL,
    `setbacks` text DEFAULT NULL,
    PRIMARY KEY (`health_entry_id`),
    KEY `fk_vibe_idx` (`vibe_id`),
    KEY `fk_mental_rating_idx` (`mental_rating_id`),
    KEY `fk_physical_rating_idx` (`physical_rating_id`),
    CONSTRAINT `fk_vibe` FOREIGN KEY (`vibe_id`) REFERENCES `vibe` (vibe_id) ON DELETE CASCADE,
    CONSTRAINT `fk_mental_rating` FOREIGN KEY (`mental_rating_id`) REFERENCES `rating` (rating_id) ON DELETE CASCADE,
    CONSTRAINT `fk_physical_rating` FOREIGN KEY (`physical_rating_id`) REFERENCES `rating` (rating_id) ON DELETE CASCADE
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
