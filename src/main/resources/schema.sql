-- Table: WyposazenieTeatru
CREATE TABLE WyposazenieTeatru (
                                   ID_Wyposazenie integer NOT NULL CONSTRAINT WyposazenieTeatru_pk PRIMARY KEY,
                                   identyfikator_magazynowy varchar(255) NOT NULL,
                                   nazwa varchar(255),
                                   opis varchar(1020)
);