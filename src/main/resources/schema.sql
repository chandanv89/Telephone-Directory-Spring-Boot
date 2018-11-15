-- REQUIRES MYSQL-SERVER-5.7.6 OR HIGHER

CREATE DATABASE IF NOT EXISTS TELEPHONE_DIRECTORY;

USE TELEPHONE_DIRECTORY;

CREATE USER IF NOT EXISTS 'DIRECTORY_APP'@'localhost' IDENTIFIED BY 'D!rect0ry';

CREATE TABLE IF NOT EXISTS `CONTACTS` (
    `id` VARCHAR(40) NOT NULL COMMENT 'System-generated GUID',
    `full_name` VARCHAR(65) NOT NULL COMMENT 'Contact\' s full name',
    `first_name` VARCHAR(30) NOT NULL COMMENT ' Contact\'s first name',
    `last_name` VARCHAR(30) NOT NULL COMMENT 'Contact\' s last name',
    `cre_dt` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT ' Created timestamp ',
    `upd_dt` TIMESTAMP DEFAULT NULL NULL COMMENT ' Updated timestamp ',
    `deleted` CHAR(1) DEFAULT 'N' NOT NULL COMMENT ' Indicates if the record has been deleted',
    PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

CREATE TABLE IF NOT EXISTS `C_NUMS` (
    `id` VARCHAR(40) NOT NULL COMMENT ' System-generated ID',
    `c_number` VARCHAR(20) DEFAULT NULL,
    `category` VARCHAR(100) DEFAULT NULL COMMENT ' Indicate the type of contact number ( work, personal, home, etc ) ',
    `is_primary` CHAR(1) NOT NULL DEFAULT 'N' COMMENT ' Indicate if this is the primary contact number.',
    `c_id` VARCHAR(40) NOT NULL COMMENT ' Refers to the CONTACTS.id column ',
    `cre_dt` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT ' Created timestamp ',
    `upd_dt` TIMESTAMP DEFAULT NULL NULL COMMENT ' Updated timestamp ',
    PRIMARY KEY (`id`),
    KEY `C_NUMS_CONTACTS_FK` (`c_id`),
    CONSTRAINT `C_NUMS_CONTACTS_FK` FOREIGN KEY (`c_id`)
        REFERENCES `CONTACTS` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

CREATE TABLE IF NOT EXISTS `EMAILS` (
    `id` VARCHAR(40) NOT NULL COMMENT ' System-generated ID',
    `email_id` VARCHAR(100) NOT NULL COMMENT ' Contact\'s email id',
    `category` VARCHAR(25) DEFAULT NULL COMMENT 'Indicate the type of email id (work, personal, home, etc)',
    `is_primary` CHAR(1) NOT NULL DEFAULT 'N' COMMENT 'Indicates if the mail id is primary',
    `c_id` VARCHAR(40) NOT NULL COMMENT 'Refers to the CONTACTS table',
    `cre_dt` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT 'Created timestamp',
    `upd_dt` TIMESTAMP DEFAULT NULL NULL COMMENT 'Updated timestamp',
    PRIMARY KEY (`id`),
    KEY `EMAILS_CONTACTS_FK` (`c_id`),
    CONSTRAINT `EMAILS_CONTACTS_FK` FOREIGN KEY (`c_id`)
        REFERENCES `CONTACTS` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

-- INITIAL, SAMPLE DATA
SELECT 
    *
FROM
    telephone_directory.CONTACTS;
set
	@r_count = found_rows() if @r_count = 0 then INSERT
		INTO
			telephone_directory.CONTACTS ( id,
			full_name,
			first_name,
			last_name,
			deleted,
			cre_dt,
			upd_dt )
		VALUES( '4d134c35-b797-11e8-bdb8-0071cc56c4c3',
		'Ted Mosby',
		'Mosby',
		'Ted',
		'N',
		'2018-09-15 14:13:50.000',
		NULL );
	INSERT
		INTO
			telephone_directory.CONTACTS ( id,
			full_name,
			first_name,
			last_name,
			deleted,
			cre_dt,
			upd_dt )
		VALUES( '88df9efb-b3c0-11e8-8cde-0071cc56c4c3',
		'Chandan Veerabhadrappa',
		'Chandan',
		'Veerabhadrappa',
		'N',
		'2018-09-15 14:13:50.000',
		NULL );
	INSERT
		INTO
			telephone_directory.CONTACTS ( id,
			full_name,
			first_name,
			last_name,
			deleted,
			cre_dt,
			upd_dt )
		VALUES( '97013221-b3c9-11e8-8cde-0071cc56c4c3',
		'Vidyashree G S',
		'Vidyashree',
		'G S',
		'2018-09-15 14:13:50.000',
		'N',
		NULL );
	INSERT
		INTO
			telephone_directory.CONTACTS ( id,
			full_name,
			first_name,
			last_name,
			deleted,
			cre_dt,
			upd_dt )
		VALUES( 'd240feee-b793-11e8-bdb8-0071cc56c4c3',
		'Veerabhadrappa',
		'Veerabhadrappa',
		'Tagadur',
		'2018-09-15 14:13:50.000',
		'N',
		NULL );
end if;
SELECT 
    *
FROM
    telephone_directory.C_NUMS;
set
@count = found_rows() if @count = 0 then INSERT
	INTO
		telephone_directory.C_NUMS ( id,
		c_number,
		category,
		is_primary,
		c_id,
		cre_dt,
		upd_dt )
	VALUES( '19d6f7f7-b3c3-11e8-8cde-0071cc56c4c3',
	'+918970151014',
	'MOBILE',
	0,
	'88df9efb-b3c0-11e8-8cde-0071cc56c4c3',
	'2018-09-15 14:39:58.000',
	NULL );
INSERT
	INTO
		telephone_directory.C_NUMS ( id,
		c_number,
		category,
		is_primary,
		c_id,
		cre_dt,
		upd_dt )
	VALUES( '9c99d984-b3c2-11e8-8cde-0071cc56c4c3',
	'+353899802537',
	'MOBILE',
	1,
	'88df9efb-b3c0-11e8-8cde-0071cc56c4c3',
	'2018-09-15 14:39:58.000',
	NULL );
INSERT
	INTO
		telephone_directory.C_NUMS ( id,
		c_number,
		category,
		is_primary,
		c_id,
		cre_dt,
		upd_dt )
	VALUES( 'aa454933-b3c9-11e8-8cde-0071cc56c4c3',
	'+91123456789',
	'MOBILE',
	0,
	'97013221-b3c9-11e8-8cde-0071cc56c4c3',
	'2018-09-15 14:39:58.000',
	NULL );
INSERT
	INTO
		telephone_directory.C_NUMS ( id,
		c_number,
		category,
		is_primary,
		c_id,
		cre_dt,
		upd_dt )
	VALUES( 'c8f67767-b3c9-11e8-8cde-0071cc56c4c3',
	'+353899777047',
	'MOBILE',
	1,
	'97013221-b3c9-11e8-8cde-0071cc56c4c3',
	'2018-09-15 14:39:58.000',
	NULL );
end if;
SELECT 
    *
FROM
    telephone_directory.EMAILS;
set
@count = found_rows() if @count = 0 then INSERT
INTO
	telephone_directory.EMAILS ( id,
	email_id,
	category,
	is_primary,
	c_id,
	cre_dt,
	upd_dt )
VALUES( '0ed878d0-b3c3-11e8-8cde-0071cc56c4c3',
'chandan_v@infosys.com',
'WORK',
0,
'88df9efb-b3c0-11e8-8cde-0071cc56c4c3',
'2018-09-15 14:38:16.000',
NULL );
INSERT
INTO
	telephone_directory.EMAILS ( id,
	email_id,
	category,
	is_primary,
	c_id,
	cre_dt,
	upd_dt )
VALUES( 'bc8ddb0b-b3c9-11e8-8cde-0071cc56c4c3',
'vidyashree3@gmail.com.com',
'PERSONAL',
0,
'97013221-b3c9-11e8-8cde-0071cc56c4c3',
'2018-09-15 14:38:16.000',
NULL );
INSERT
INTO
	telephone_directory.EMAILS ( id,
	email_id,
	category,
	is_primary,
	c_id,
	cre_dt,
	upd_dt )
VALUES( 'fe821183-b3c2-11e8-8cde-0071cc56c4c3',
'chanadnv89@gmail.com',
'PERSONAL',
1,
'88df9efb-b3c0-11e8-8cde-0071cc56c4c3',
'2018-09-15 14:38:16.000',
NULL );
end if;
