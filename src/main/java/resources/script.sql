CREATE DATABASE `pao`;


CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `autorId` int default null,
  KEY `autorId` (`autorId`),
        CONSTRAINT `book_ibfk_1` FOREIGN KEY (`autorId`) REFERENCES `Autor` (`id`) ON DELETE CASCADE,
 `publishingHouseId`  int default null,
  KEY `publishingHouseId` (`publishingHouseId`),
        CONSTRAINT `book_ibfk_2` FOREIGN KEY (`publishingHouseId`) REFERENCES `PublishingHouse` (`id`) ON DELETE CASCADE,
  `number` int DEFAULT NULL,
  `isbn` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `PublishingHouse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Autor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
   `bookId` int default null,
    KEY `bookId` (`bookId`),
                 CONSTRAINT `autor_ibfk_1` FOREIGN KEY (`bookId`) REFERENCES `Book` (`id`) ON DELETE CASCADE,
  PRIMARY KEY (`id`)
);

CREATE TABLE `TypeOf` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
   `bookId` int default null,
   KEY `bookId` (`bookId`),
              CONSTRAINT `typeOf_ibfk_1` FOREIGN KEY (`bookId`) REFERENCES `Book` (`id`) ON DELETE CASCADE,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Genres` (
  `id` int NOT NULL AUTO_INCREMENT,
   `typeOfId` int default null,
  KEY `typeOfId` (`typeOfId`),
      CONSTRAINT `genres_ibfk_1` FOREIGN KEY (`typeOfId`) REFERENCES `TypeOf` (`id`) ON DELETE CASCADE,
  `name` varchar(30) DEFAULT NULL,
     `bookId` int default null,
   KEY `bookId` (`bookId`),
            CONSTRAINT `genres_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `Book` (`id`) ON DELETE CASCADE,
  PRIMARY KEY (`id`)
);
CREATE TABLE `Librarian` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
   `memberId` int default null,
  KEY `memberId` (`memberId`),
        CONSTRAINT `librarian_ibfk_1` FOREIGN KEY (`memberId`) REFERENCES `Member` (`id`) ON DELETE CASCADE,
  PRIMARY KEY (`id`)
);
CREATE TABLE `Member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
   `bookId` int default null,
 KEY `bookId` (`bookId`),
         CONSTRAINT `member_ibfk_1` FOREIGN KEY (`bookId`) REFERENCES `Book` (`id`) ON DELETE CASCADE,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Reader` (
  `id` int NOT NULL AUTO_INCREMENT,
  `memberId` int default null,
  KEY `memberId` (`memberId`),
      CONSTRAINT `reader_ibfk_1` FOREIGN KEY (`memberId`) REFERENCES `Member` (`id`) ON DELETE CASCADE,
  `name` varchar(30) DEFAULT NULL,
   `bookId` int default null,
   KEY `bookId` (`bookId`),
         CONSTRAINT `reader_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `Book` (`id`) ON DELETE CASCADE,
  PRIMARY KEY (`id`)
);
