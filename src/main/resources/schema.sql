CREATE DATABASE IF NOT EXISTS `vibe_tracker`;
USE `vibe_tracker`;

DROP TABLE IF EXISTS `vibe`;
DROP TABLE IF EXISTS `panorama`;
DROP TABLE IF EXISTS `user`;

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
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

CREATE TABLE `panorama` (
  `id` int NOT NULL AUTO_INCREMENT,
  `overview` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `vibe`
--

CREATE TABLE `vibe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `panoramic_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_idx` (`user_id`),
  KEY `fk_panorama_idx` (`panoramic_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_panorama` FOREIGN KEY (`panoramic_id`) REFERENCES `panorama` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Insert sample data
--

INSERT INTO `user` (`username`, `password`, `firstname`, `lastname`, `nickname`, `email`) 
VALUES ('johndoe', 'password123', 'John', 'Doe', 'JD', 'john.doe@example.com');

INSERT INTO `panorama` (`overview`) VALUES 
('Great'),
('Good'),
('Meh'),
('Bad'),
('Ugly');
