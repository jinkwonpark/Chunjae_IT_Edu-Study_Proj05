-- TT DATABASE
CREATE DATABASE tt;

USE tt;

--------------------

-- 회원 TABLE
CREATE TABLE USER(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 회원 번호
	userId VARCHAR(50) NOT NULL,  -- 회원 ID
	pwd VARCHAR(350) NOT NULL,  -- 회원 PW
	NAME VARCHAR(100) NOT NULL,  -- 회원 이름
	tel VARCHAR(20),  -- 회원 전화번호
	email VARCHAR(100) NOT NULL,  -- 회원 이메일
	addr1 VARCHAR(300) NOT NULL,  -- 회원 주소1
	addr2 VARCHAR(300),  -- 회원 주소2
	regdate TIMESTAMP DEFAULT CURRENT_TIME  -- 회원 등록일
);

-- role TABLE
CREATE TABLE role(
	id INT AUTO_INCREMENT PRIMARY KEY,
	roleName VARCHAR(20)
);

-- userRole TABLE
CREATE TABLE userRole(
	userId BIGINT,
	roleId INT
);

DESC ROLE;

DESC USER;

DESC user_role;

--------------------

SELECT * from user WHERE id = 'jin'

-- 회원 TABLE
CREATE TABLE user(
	uno INT AUTO_INCREMENT PRIMARY KEY,  -- 회원 번호
	id VARCHAR(20) NOT NULL UNIQUE KEY,  -- 회원 ID
	pw VARCHAR(350) NOT NULL,  -- 회원 PW
	NAME VARCHAR(100) NOT NULL,  -- 회원 이름
	tel VARCHAR(13) NOT NULL,  -- 회원 전화번호
	email VARCHAR(100) NOT NULL,  -- 회원 이메일
	addr1 VARCHAR(300) NOT NULL,  -- 회원 주소1
	addr2 VARCHAR(300),  -- 회원 주소2
	postcode VARCHAR(10) NOT NULL, -- 회원 우편번호
	regdate TIMESTAMP DEFAULT CURRENT_TIME  -- 회원 등록일
);

INSERT INTO user VALUES (DEFAULT, 'admin', '1234', '관리자', '010-8525-8525', 'admin@admin.com', '기본주소', '상세주소', '11111', default)

-- 공지사항 TABLE
CREATE TABLE notice(
	nno INT AUTO_INCREMENT PRIMARY KEY,  -- 공지사항 번호
	title VARCHAR(200) NOT NULL,  -- 공지사항 제목
	content VARCHAR(2000) NOT NULL,  -- 공지사항 내용
	regdate TIMESTAMP DEFAULT CURRENT_TIME,  -- 공지사항 작성일
	visited INT DEFAULT 0 -- 공지사항 조회수
);

INSERT INTO notice(title, content) VALUES('공지사항1', '공지사항 내용1 입니다');
INSERT INTO notice(title, content) VALUES('공지사항2', '공지사항 내용2 입니다');
INSERT INTO notice(title, content) VALUES('공지사항3', '공지사항 내용3 입니다');
INSERT INTO notice(title, content) VALUES('공지사항4', '공지사항 내용4 입니다');
INSERT INTO notice(title, content) VALUES('공지사항5', '공지사항 내용5 입니다');

-- FAQ TABLE
CREATE TABLE faq(
 	fno INT AUTO_INCREMENT PRIMARY KEY,
 	question VARCHAR(200),
 	answer VARCHAR(2000)
);

INSERT INTO faq(question, answer) VALUES('FAQ1', 'FAQ 내용1입니다.');
INSERT INTO faq(question, answer) VALUES('FAQ2', 'FAQ 내용2입니다.');
INSERT INTO faq(question, answer) VALUES('FAQ3', 'FAQ 내용3입니다.');
INSERT INTO faq(question, answer) VALUES('FAQ4', 'FAQ 내용4입니다.');
INSERT INTO faq(question, answer) VALUES('FAQ5', 'FAQ 내용5입니다.');

-- 자유게시판 TABLE
CREATE TABLE board(
	bno INT AUTO_INCREMENT PRIMARY KEY,  -- 자유게시판 번호
	title VARCHAR(200) NOT NULL,  -- 자유게시판 제목
	content VARCHAR(2000) NOT NULL,  -- 자유게시판 내용
	author VARCHAR(20),  -- 자유게시판 작성자
	regdate TIMESTAMP DEFAULT CURRENT_TIME,  -- 자유게시판 작성일
	visited INT DEFAULT 0  -- 자유게시판 조회수
);

INSERT INTO board VALUES (DEFAULT, '자유게시판1', '자유게시판 내용1 입니다', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO board VALUES (DEFAULT, '자유게시판2', '자유게시판 내용2 입니다', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO board VALUES (DEFAULT, '자유게시판3', '자유게시판 내용3 입니다', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO board VALUES (DEFAULT, '자유게시판4', '자유게시판 내용4 입니다', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO board VALUES (DEFAULT, '자유게시판5', '자유게시판 내용5 입니다', DEFAULT, DEFAULT, DEFAULT);

-- 상품 TABLE
CREATE TABLE product(
	pno INT AUTO_INCREMENT PRIMARY KEY,  -- 상품 번호
	title VARCHAR(200) NOT NULL,  -- 상품 제목
	content VARCHAR(2000) NOT NULL,  -- 상품 내용
	price VARCHAR(200) NOT NULL,  -- 상품 가격
	location INT NOT NULL,  -- 상품 지역
	STATUS INT DEFAULT 1, -- 상품 상태 : 판매중(1), 예약중(2), 판매완료(3)
	author VARCHAR(20), -- 상품 작성자
	regdate TIMESTAMP DEFAULT CURRENT_TIME,  -- 상품 작성일
	visited INT DEFAULT 0,  -- 상품 조회수
	contact VARCHAR(100) NOT NULL  -- 연락 방법
);

INSERT INTO product VALUES (DEFAULT, '상품1', '상품 내용1 입니다', '10000원', '1', '1', '김이름', DEFAULT, DEFAULT, '전화번호');

-- 상품파일 TABLE
CREATE TABLE fileData(
	fdno INT AUTO_INCREMENT PRIMARY KEY,
	originName VARCHAR(100),
	saveName VARCHAR(255),
	savePath VARCHAR(255)
);

COMMIT;