create database telephone_directory;
create user directory_app;
grant all on db_name.* to ‘db_user’@’localhost’ identified by ‘db_password’;

CREATE TABLE `CONTACTS` (
  `id` varchar(40) NOT NULL COMMENT 'System-generated GUID',
  `full_name` varchar(65) NOT NULL COMMENT 'Contact''s full name',
  `first_name` varchar(30) NOT NULL COMMENT 'Contact''s first name',
  `last_name` varchar(30) NOT NULL COMMENT 'Contact''s last name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `C_NUMS` (
  `id` varchar(40) NOT NULL COMMENT 'System-generated ID',
  `c_number` varchar(20) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL COMMENT 'Indicate the type of contact number (work, personal, home, etc)',
  `is_primary` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Indicate if this is the primary contact number.',
  `C_ID` varchar(40) NOT NULL COMMENT 'Refers to the CONTACTS.id column',
  PRIMARY KEY (`id`),
  KEY `C_NUMS_CONTACTS_FK` (`C_ID`),
  CONSTRAINT `C_NUMS_CONTACTS_FK` FOREIGN KEY (`C_ID`) REFERENCES `CONTACTS` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `EMAILS` (
  `id` varchar(40) NOT NULL COMMENT 'System-generated ID',
  `email_id` varchar(100) NOT NULL COMMENT 'Contact''s email id',
  `category` varchar(25) DEFAULT NULL COMMENT 'Indicate the type of email id (work, personal, home, etc)',
  `is_primary` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Indicates if the mail id is primary',
  `c_id` varchar(40) NOT NULL COMMENT 'Refers to the CONTACTS table',
  PRIMARY KEY (`id`),
  KEY `EMAILS_CONTACTS_FK` (`c_id`),
  CONSTRAINT `EMAILS_CONTACTS_FK` FOREIGN KEY (`c_id`) REFERENCES `CONTACTS` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

