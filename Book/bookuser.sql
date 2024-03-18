CREATE TABLE TB_BOOK_USER(
	BOOK_NO NUMBER CONSTRAINT TB_BOOKUSER_PK PRIMARY KEY,
	BOOK_TITLE VARCHAR2(100) NOT NULL,
	BOOK_INTRO VARCHAR2(3000) NOT NULL,
	BOOK_RESERVATION CHAR(1) DEFAULT 'Y' CONSTRAINT RESERV2_YN CHECK (BOOK_RESERVATION IN ('Y', 'N') )
);


CREATE SEQUENCE SEQ_BOOKUSER_NO NOCACHE;

INSERT INTO TB_BOOK_USER 
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'책 제목','책 소개',DEFAULT);

SELECT *
FROM TB_BOOK_USER;

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'마지막 마음','상을 떠난 사람의 마지막 마음을 들을 수 있다면?',DEFAULT);

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'대단한 세상','이 시대의 발자크로 칭송받는 거장 피에르 르메트르의 장편소설.',DEFAULT);

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'지식인의 자격','노암 촘스키의 〈지식인의 책임〉과 〈지식인의 책임> 후편',DEFAULT);

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'거짓과 정전','일본 문단을 대표하는 작가로 급부상한 그가 첫 번째 SF 단편집 《거짓과 정전》을 선보인다.',DEFAULT);

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'이상한 책들의 도서관 ','세상의 괴상한 책들을 그러모아 소개한 책, 이 짧은 소개만으로 애서가의 심장은 두근거린다. ',DEFAULT);

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'고층 입원실의 갱스터 할머니','10년 동안 난치병 환자로 살아오며 생사의 갈림길마다 자신을 일으켜 세운 사람들의 털털하고도 다정한 사랑이 저자가 이 책을 쓰게 한 동기다. ',DEFAULT);

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'샤이닝','2023년 노벨 문학상을 수상한 욘 포세의 최신작.',DEFAULT);

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'대단한 세상','이 시대의 발자크로 칭송받는 거장 피에르 르메트르의 장편소설. ',DEFAULT);

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'금단의 마술','1988년에 발표된 <탐정 갈릴레오>를 시작으로 장장 26년째 이어지면서 ‘가가 형사 시리즈’와 함께 히가시노 게이고 작품 ',DEFAULT);

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'왜냐하면 고양이기 때문이지','고양이의 다양한 매력을 영화, 드라마, 애니메이션을 통해 들여다볼 수 있는 에세이로, 영화와 드라마, 애니메이션 속 고양이를 통해 우리네 삶을 이야기한다. ',DEFAULT);

INSERT INTO TB_BOOK_USER
VALUES (SEQ_BOOKUSER_NO.NEXTVAL,'물질의 세계','나의 세계와 관련이 없다고 여길 때, 물질의 이름들은 사실 조금 따분하게 느껴지기도 한다. 역설적으로 이 책이 흥미로운 이유도 여기에 있다.',DEFAULT);

SELECT *
FROM TB_BOOK_USER;

COMMIT;

-- 도서 목록 조회
SELECT BOOK_NO,BOOK_TITLE,BOOK_RESERVATION
FROM TB_BOOK_USER
WHERE BOOK_TITLE LIKE '%샤이%';

SELECT *
FROM TB_BOOK_USER;

SELECT *
FROM TB_BOOK_USER
WHERE BOOK_NO = '1';

UPDATE TB_BOOK_USER SET 
BOOK_RESERVATION = 'N'
WHERE BOOK_NO ='1';








