###############################################################
###############################################################
#####                                                     #####
#####                                                     #####
#####                 STOCK ACCOUNT                       #####
#####                 General Stock                       #####
#####                                                     #####
#####                                                     #####
#####                                                     #####
###############################################################
###############################################################
DROP DATABASE IF EXISTS stock_accounting;
CREATE DATABASE IF NOT EXISTS stock_accounting;
USE stock_accounting;


#######################
###   USER-ACTION   ###
#######################
SELECT 'USER_ACTION';
DROP TABLE IF EXISTS user_action;
CREATE TABLE IF NOT EXISTS user_action(
    user_action_id          INT(6)                  NOT NULL AUTO_INCREMENT,
    user_action_desc        VARCHAR(30)             NOT NULL UNIQUE,
    user_action_abbr        VARCHAR(10)             DEFAULT NULL UNIQUE,
    del                     ENUM('*')               DEFAULT NULL,
    PRIMARY KEY(user_action_id)
);
INSERT INTO user_action VALUES
    (1, 'Create', NULL, NULL),
    (2, 'Entry',  NULL, NULL),
    (3, 'Modify', NULL, NULL),
    (4, 'Print',  NULL, NULL);


####################
###    USER      ###
####################
SELECT 'USER';
DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user(
    user_id                 INT(6)                  NOT NULL AUTO_INCREMENT,
    user_name               VARCHAR(50)             NOT NULL UNIQUE,
    user_password           VARCHAR(50)             NOT NULL,
    del                     ENUM('*')               DEFAULT NULL,
    PRIMARY KEY(user_id)
);
INSERT INTO user VALUES
    (1, 'Milan Das',            'milandas63',   NULL),
    (2, 'Abhijit Sahu',         'abhijit',      NULL),
    (3, 'Aditya Das',           'aditya',       NULL),
    (4, 'Aman Kumar',           'aman',         NULL),
    (6, 'Arti Kumari',          'arti',         NULL),
    (7, 'Arup Kumar Patra',     'arup',         NULL),
    (8, 'Asish Kumar Panda',    'ashish',       NULL);


#########################
###    PRIVILEGE      ###
#########################
SELECT 'PRIVILEGE';
DROP TABLE IF EXISTS privilege;
CREATE TABLE IF NOT EXISTS privilege(
    privilege_id            INT(6)              NOT NULL AUTO_INCREMENT,
    user_id                 INT(6)              NOT NULL REFERENCES user(user_id),
    user_action_id          INT(6)              NOT NULL REFERENCES user_action(user_action_id),
    del                     ENUM('*')           DEFAULT NULL,
    PRIMARY KEY(privilege_id)
);
INSERT INTO privilege VALUES
    (1, 1, 1, NULL),
    (2, 1, 2, NULL),
    (3, 1, 3, NULL),
    (4, 1, 4, NULL),
    (5, 1, 2, NULL),
    (6, 1, 3, NULL),
    (7, 1, 4, NULL);


#############################
###    LOGIN-TRACKER      ###
#############################
SELECT 'LOGIN-TRACKER';
DROP TABLE IF EXISTS login_tracker;
CREATE TABLE IF NOT EXISTS login_tracker(
    log_track_id            INT(6)              NOT NULL AUTO_INCREMENT,
    log_date                DATE,
    login_time              TIMESTAMP,
    logout_time             TIME,
    user_id                 INT(6)              NOT NULL REFERENCES user(user_id),
    del                     ENUM('*')           DEFAULT NULL,
    PRIMARY KEY(log_track_id)
);


################################
###    TRANSACTION-TYPE      ###
################################
SELECT 'TRANSACTION-TYPE';
DROP TABLE IF EXISTS transaction_type;
CREATE TABLE IF NOT EXISTS transaction_type(
    ttype_id                INT(6)                  NOT NULL AUTO_INCREMENT,
    ttype_desc              VARCHAR(50)             NOT NULL UNIQUE,
    ttype_abbr              VARCHAR(10)             DEFAULT NULL UNIQUE,
    action                  ENUM('+','-','=')       NOT NULL,
    del                     ENUM('*')               NOT NULL,
    PRIMARY KEY(ttype_id)
);
INSERT INTO transaction_type VALUES
    ( 1, 'Opening Stock',   'OS', '+', NULL),
    ( 2, 'Purchase',        'PR', '+', NULL),
    ( 3, 'Sales',           'SL', '-', NULL),
    ( 4, 'Expiry',          'EX', '-', NULL),
    ( 5, 'Theft',           'TH', '-', NULL),
    ( 6, 'Breakage',        'BR', '-', NULL),
    ( 7, 'Customer Return', 'CR', '+', NULL),
    ( 8, 'Return to Vendor','RV', '-', NULL);


###########################
###    MANUFACTURER     ###
###########################
SELECT 'MANUFACTURER';
DROP TABLE IF EXISTS manufacturer;
CREATE TABLE IF NOT EXISTS manufacturer(
    mfg_id                  INT(6)               NOT NULL AUTO_INCREMENT,
    mfg_desc                VARCHAR(50)          NOT NULL UNIQUE,
    mfg_abbr                VARCHAR(10)          DEFAULT NULL UNIQUE,
    del                     ENUM('*')            DEFAULT NULL,
    PRIMARY KEY (mfg_id)
);
INSERT INTO manufacturer VALUES
    (1, 'Cipla',                'CP', NULL),
    (2, 'Pfizer',               'PF', NULL),
    (3, 'Cadila',               'CD', NULL),
    (4, 'Dr Reddy',             'DR', NULL),
    (5, 'Johnson & Johnson.',   'JJ', NULL);


######################
###    LOCATION    ###
######################
SELECT 'LOCATION';
DROP TABLE IF EXISTS location;
CREATE TABLE IF NOT EXISTS location;
CREATE TABLE location(
    location_id				INT(6)			NOT NULL AUTO_INCREMENT,
    location_name			VARCHAR(100)	NOT NULL UNIQUE,
    location_abbr			VARCHAR(20)		DEFAULT NULL UNIQUE,
    del						ENUM('*')		DEFAULT NULL,
    PRIMARY KEY(location_id)
);



#####################
###    VENDOR     ###
#####################
SELECT 'VENDOR';
DROP TABLE IF EXISTS vendor;
CREATE TABLE IF NOT EXISTS vendor;
CREATE TABLE vendor(
    vendor_id               INT(6)               NOT NULL AUTO_INCREMENT,
    vendor_name             VARCHAR(100)         NOT NULL UNIQUE,
    vendor_gst_no           VARCHAR(20)          NOT NULL UNIQUE,
    vendor_address          VARCHAR(200)         DEFAULT NULL,
    vendor_location         INT(6)               NOT NULL REFERENCES location(location_id),
    vendor_phone            VARCHAR(20)          NOT NULL,
    vendor_contact_person   VARCHAR(100)         DEFAULT NULL,
    balance_amt             DOUBLE(12,2)         DEFAULT 0.00,
    del                     ENUM('*')            DEFAULT NULL,
    PRIMARY KEY(vendor_id)
);
INSERT INTO vendor VALUES
    (1, 'Santuka Pharmaceuticals', 'OR-3322', 'Dolmundai, Cuttack',         1, '9797168568', 'Suresh Santuka', 0.00, NULL),
    (2, 'Modi Pharmaceuticals',    'OR-4432', 'Ashok Nagar, Bhubaneswar',   2, '7978143432', 'Brahmadev Rao',  0.00, NULL);


#####################
###    PACKING    ###
#####################
SELECT 'PACKING';
DROP TABLE IF EXISTS Packing;
CREATE TABLE IF NOT EXISTS packing(
    pack_id                 INT(6)                  NOT NULL AUTO_INCREMENT,
    pack_desc               VARCHAR(30)             NOT NULL UNIQUE,
    pack_abbr               VARCHAR(10)             DEFAULT NULL UNIQUE,
    pack_unit               INT(6)                  DEFAULT NULL,
    del                     ENUM('*')               DEFAULT NULL,
    PRIMARY KEY(pack_id)
);
INSERT INTO packing VALUES
    (1, '1 bottle',     '1bot', 1, NULL),
    (2, '4 strip',      '4-S',  1, NULL),
    (3, '5 strip',      '5-S',  1, NULL),
    (4, '6 strip',      '6-S',  1, NULL),
    (5, '10 strip',     '10-S', 1, NULL),
    (6, '15 strip',     '15-S', 1, NULL),
    (7, '25 strip',     '25-S', 1, NULL),
    (8, '1 box',        '1box', 1, NULL);


#####################
###    PRODUCT    ###
#####################
SELECT 'PRODUCT';
DROP TABLE IF EXISTS product;
CREATE TABLE IF NOT EXISTS product(
    product_id              INT(6)                  NOT NULL AUTO_INCREMENT,
    product_desc            VARCHAR(50)             NOT NULL UNIQUE,
    pack_id                 INT(6)                  DEFAULT NULL REFERENCES packing(pack_id),
    mfg_id                  INT(6)                  NOT NULL REFERENCES manufacturer(mfg_id),
    del                     ENUM('*')               DEFAULT NULL,
    PRIMARY KEY(product_id)
);
INSERT INTO product VALUES
    (001, 'Agithromicin DS', 5, 3, NULL),
    (002, 'DX Paracetamol',  5, 4, NULL);
INSERT INTO product VALUES
    (003, 'Strepcil DX', 5, 3, NULL),
    (004, 'Dolo 650',  5, 4, NULL);


#######################
###    CUSTOMER     ###
#######################
SELECT 'CUSTOMER';
DROP TABLE IF EXISTS customer;
CREATE TABLE IF NOT EXISTS customer(
    cust_id                 INT(6)                  NOT NULL AUTO_INCREMENT,
    cust_name               VARCHAR(50)             NOT NULL,
    cust_address            VARCHAR(50),
    cust_phone              VARCHAR(50),
    balance_amt             DOUBLE(12,2)            DEFAULT 0.00,
    del                     ENUM('*')               DEFAULT NULL,
    PRIMARY KEY(cust_id)
);
INSERT INTO customer VALUES
    (001, 'Cash Sales', NULL, NULL, 0.00, NULL);


############################
###    TRANSACTION-HR    ###
############################
SELECT 'TRANSACTION_HR';
DROP TABLE IF EXISTS transaction_hr;
CREATE TABLE IF NOT EXISTS transaction_hr(
    tran_id                 INT(8)                  NOT NULL AUTO_INCREMENT,
    tran_date               DATE                    NOT NULL,
    ttype_id                INT(6)                  NOT NULL REFERENCES transaction_type(ttype_id),
    ttype_seq_no			INT(8)					DEFAULT NULL,
    ttype_ref_no			VARCHAR(50)				DEFAULT NULL,
    party_id                INT(6)                  DEFAULT NULL,
    party_name              VARCHAR(100)            DEFAULT NULL,
    transport_detail        VARCHAR(100),
    bill_amt                DOUBLE(10,2),
    gst_amt                 DOUBLE(8,2),
    excise_amt              DOUBLE(8,2),
    round_amt               DOUBLE(5,2),
    PRIMARY KEY(tran_id)
);


############################
###    TRANSACTION-DT    ###
############################
SELECT 'TRANSACTION_DT';
DROP TABLE IF EXISTS transaction_dt;
CREATE TABLE IF NOT EXISTS transaction_dt(
    tran_detail_id          INT(10)                 NOT NULL AUTO_INCREMENT,
    tran_id                 INT(8)                  NOT NULL REFERENCES transaction_hr(tran_id),
    product_id				INT(6)					NOT NULL REFERENCES product(product_id),
    rate					DOUBLE(12,2)			DEFAULT 0,
    pack_id					INT(6)					DEFAULT NULL REFERENCES packing(pack_id),
    quantity				INT(6)                  NOT NULL,
    free					INT(6)                  DEFAULT 0,
    batch_no				VARCHAR(30),
    exp_date				VARCHAR(5),
    mfg_date				VARCHAR(5),
    PRIMARY KEY(tran_detail_id)
);

SELECT p.product_id,p.product_desc,m.mfg_desc,k.pack_desc FROM product AS p
LEFT JOIN manufacturer AS m ON p.mfg_id=m.mfg_id
LEFT JOIN packing AS k ON p.pack_id=k.pack_id;


SELECT p.product_id,p.product_desc,m.mfg_desc,k.pack_desc FROM product AS p LEFT JOIN manufacturer AS m ON p.mfg_id=m.mfg_id LEFT JOIN packing AS k ON p.pack_id=k.pack_id;
