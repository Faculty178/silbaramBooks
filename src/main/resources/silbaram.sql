CREATE TABLE `member` (
                          `mid` INT NOT NULL AUTO_INCREMENT,   -- 회원 고유번호
                          `userId` VARCHAR(15) NOT NULL UNIQUE,   -- 회원 아이디 (중복 불가)
                          `password` VARCHAR(20) NOT NULL,   -- 비밀번호
                          `nickName` VARCHAR(15) NOT NULL UNIQUE,   -- 회원 닉네임 (중복 불가)
                          `name` VARCHAR(20) NOT NULL,   -- 이름
                          `birthDate` DATE NOT NULL,   -- 생년월일
                          `gender` VARCHAR(2) NOT NULL,   -- 성별
                          `phoneNumber` VARCHAR(11) NOT NULL,   -- 전화번호
                          `email` VARCHAR(30) NOT NULL UNIQUE,   -- 이메일 (중복 불가)
                          `zipcode` VARCHAR(5) NULL,   -- 우편번호
                          `address` VARCHAR(100) NULL,   -- 주소
                          `socialLogin` BOOLEAN NULL DEFAULT FALSE,   -- 소셜로그인 여부
                          `isAdmin` BOOLEAN NOT NULL DEFAULT FALSE,   -- 관리자 여부
                          `regDate` DATETIME NULL DEFAULT NOW(),   -- 가입일자
                          `uuid` varchar(50) DEFAULT NULL, -- 쿠키(자동로그인)
                          PRIMARY KEY (`mid`)
);

create user 'silbaramAdmin'@'localhost' identified by 'silbaram';
create user 'silbaramAdmin'@'%' identified by 'silbaram';

create database silbaram default character set utf8;
grant all privileges on silbaram.* to 'silbaramAdmin'@'localhost';
grant all privileges on silbaram.* to 'silbaramAdmin'@'%';

use silbaram;

create table Member(
                       mid BIGINT PRIMARY KEY AUTO_INCREMENT,
                       userId VARCHAR(15) UNIQUE NOT NULL,
                       password VARCHAR(20) NOT NULL,
                       nickName VARCHAR(10) UNIQUE NOT NULL,
                       name VARCHAR(15) NOT NULL,
                       birthDate DATE NOT NULL,
                       gender VARCHAR(2) NOT NULL,
                       phoneNumber VARCHAR(11) NOT NULL,
                       email VARCHAR(30) UNIQUE NOT NULL,
                       zipcode VARCHAR(5) NULL,
                       address VARCHAR(100) NULL,
                       socialLogin BOOLEAN NULL DEFAULT false,
                       isAdmin BOOLEAN NOT NULL DEFAULT false,
                       regDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

)AUTO_INCREMENT = 1001;

create table Book(
                     bkid BIGINT PRIMARY KEY auto_increment,
                     name VARCHAR(50) NOT NULL,
                     writer VARCHAR(50) NOT NULL,
                     publisher VARCHAR(50) NOT NULL,
                     price INT NOT NULL,
                     synopsis text NULL,
                     pages INT NOT NULL,
                     isbnNum VARCHAR(13) NULL,
                     category BIGINT NOT NULL,
                     fileSize VARCHAR(10) NULL,
                     language BIGINT NOT NULL,
                     voiceLength VARCHAR(150) NULL,
                     bookUrl VARCHAR(2083) NULL
)AUTO_INCREMENT = 2001;

create table Review(
                       rid BIGINT PRIMARY KEY auto_increment,
                       memberId BIGINT NOT NULL,
                       title VARCHAR(50) NOT NULL,
                       reviewLike BOOLEAN NOT NULL default true,
                       content text null,
                       regDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       bookId BIGINT NOT NULL
)auto_increment = 3001;

create table OrderList(
                          oid BIGINT PRIMARY KEY auto_increment,
                          bookId BIGINT NOT NULL,
                          orderDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          memberId BIGINT NOT NULL,
                          totalPrice INT NOT NULL default 0,
                          orderNum VARCHAR(8) NOT NULL UNIQUE
)auto_increment = 4001;

create table Category(
                         cid BIGINT PRIMARY KEY auto_increment,
                         cateName VARCHAR(15) NOT NULL UNIQUE
)auto_increment = 100;

create table Language(
                         lgid BIGINT PRIMARY KEY auto_increment,
                         language VARCHAR(15) NOT NULL UNIQUE
)auto_increment = 200;

create table Board(
                      bdid BIGINT PRIMARY KEY auto_increment,
                      title VARCHAR(50) NOT NULL,
                      content text NOT NULL,
                      memberId BIGINT NOT NULL,
                      regDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      pageType CHAR(1) default 'R'
)auto_increment = 5001;

create table LikeList(
                         lkid BIGINT PRIMARY KEY auto_increment,
                         memberId BIGINT NOT NULL,
                         bookId BIGINT NOT NULL
)auto_increment = 6001;


ALTER TABLE book
    ADD FOREIGN KEY (category) REFERENCES category(cid);

ALTER TABLE book
    ADD FOREIGN KEY (language) REFERENCES language(lgid);


ALTER TABLE board
    ADD FOREIGN KEY (memberId) REFERENCES member(mid) on delete cascade;

ALTER TABLE likelist
    ADD FOREIGN KEY (memberId) REFERENCES member(mid) on delete cascade;

ALTER TABLE likelist
    MODIFY bookId BIGINT NOT NULL,
    ADD FOREIGN KEY (bookId) REFERENCES book(bkid) on delete cascade;

ALTER TABLE review
    ADD FOREIGN KEY (memberId) REFERENCES member(mid) on delete cascade;

ALTER TABLE review
    ADD FOREIGN KEY (bookId) REFERENCES book(bkid) on delete cascade;

ALTER TABLE orderlist
    ADD FOREIGN KEY (bookId) REFERENCES book(bkid) on delete cascade;

ALTER TABLE orderlist
    ADD FOREIGN KEY (memberId) REFERENCES member(mid) on delete cascade;





