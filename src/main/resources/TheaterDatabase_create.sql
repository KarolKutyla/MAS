-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-06-10 18:14:04.987

-- tables
-- Table: Bilet
CREATE TABLE Bilet (
    ID_Bilet integer NOT NULL CONSTRAINT Bilet_pk PRIMARY KEY,
    dane_biletu varchar(1020) NOT NULL,
    Rezerwacja_ID_Rezerwacja integer NOT NULL,
    CONSTRAINT Bilet_Rezerwacja FOREIGN KEY (Rezerwacja_ID_Rezerwacja)
    REFERENCES Rezerwacja (ID_Rezerwacja)
);

-- Table: Klient
CREATE TABLE Klient (
    ID_Klient integer NOT NULL CONSTRAINT Klient_pk PRIMARY KEY,
    imie varchar(255) NOT NULL,
    nazwisko varchar(255) NOT NULL,
    email varchar(255) NOT NULL
);

-- Table: Miejsce
CREATE TABLE Miejsce (
    ID_Miejsce integer NOT NULL CONSTRAINT Miejsce_pk PRIMARY KEY,
    numer_miejsca double precision NOT NULL,
    numer_rzedu double precision NOT NULL,
    Sala_ID_Sala integer NOT NULL,
    CONSTRAINT Miejsce_Sala FOREIGN KEY (Sala_ID_Sala)
    REFERENCES Sala (ID_Sala)
);

-- Table: Platnosc
CREATE TABLE Platnosc (
    ID_Platnosc integer NOT NULL CONSTRAINT Platnosc_pk PRIMARY KEY,
    kwota_platnosci varchar(255) NOT NULL,
    potwierdzenie_przelewu varchar(255) NOT NULL,
    Rezerwacja_ID_Rezerwacja integer NOT NULL,
    CONSTRAINT Platnosc_Rezerwacja FOREIGN KEY (Rezerwacja_ID_Rezerwacja)
    REFERENCES Rezerwacja (ID_Rezerwacja)
);

-- Table: PracownikTeatru
CREATE TABLE PracownikTeatru (
    ID_PracownikTeatru integer NOT NULL CONSTRAINT PracownikTeatru_pk PRIMARY KEY,
    imie varchar(255) NOT NULL,
    nazwisko varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    numer_telefonu varchar(255) NOT NULL
);

-- Table: PracownikTeatru_Przedstawienie
CREATE TABLE PracownikTeatru_Przedstawienie (
    PracownikTeatru_ID_PracownikTeatru integer NOT NULL,
    Przedstawienie_ID_Przedstawienie integer NOT NULL,
    CONSTRAINT PracownikTeatru_Przedstawienie_pk PRIMARY KEY (PracownikTeatru_ID_PracownikTeatru,Przedstawienie_ID_Przedstawienie),
    CONSTRAINT PracownikTeatru_Przedstawienie_PracownikTeatru FOREIGN KEY (PracownikTeatru_ID_PracownikTeatru)
    REFERENCES PracownikTeatru (ID_PracownikTeatru),
    CONSTRAINT PracownikTeatru_Przedstawienie_Przedstawienie FOREIGN KEY (Przedstawienie_ID_Przedstawienie)
    REFERENCES Przedstawienie (ID_Przedstawienie)
);

-- Table: PracownikTeatru_Rola
CREATE TABLE PracownikTeatru_Rola (
    PracownikTeatru_ID_PracownikTeatru integer NOT NULL,
    Rola_ID_Rola integer NOT NULL,
    CONSTRAINT PracownikTeatru_Rola_pk PRIMARY KEY (PracownikTeatru_ID_PracownikTeatru,Rola_ID_Rola),
    CONSTRAINT PracownikTeatru_Rola_PracownikTeatru FOREIGN KEY (PracownikTeatru_ID_PracownikTeatru)
    REFERENCES PracownikTeatru (ID_PracownikTeatru),
    CONSTRAINT PracownikTeatru_Rola_Rola FOREIGN KEY (Rola_ID_Rola)
    REFERENCES Rola (ID_Rola)
);

-- Table: Przedstawienie
CREATE TABLE Przedstawienie (
    ID_Przedstawienie integer NOT NULL CONSTRAINT Przedstawienie_pk PRIMARY KEY,
    data_rozpoczecia varchar(255) NOT NULL,
    data_zakonczenia varchar(255) NOT NULL,
    Sztuka_ID_Sztuka integer NOT NULL,
    CONSTRAINT Przedstawienie_Sztuka FOREIGN KEY (Sztuka_ID_Sztuka)
    REFERENCES Sztuka (ID_Sztuka)
);

-- Table: Raport
CREATE TABLE Raport (
    ID_Raport integer NOT NULL CONSTRAINT Raport_pk PRIMARY KEY,
    liczba_sprzedanych_biletow integer NOT NULL,
    liczba_rezerwacji integer NOT NULL,
    calkowity_przychod real NOT NULL,
    Przedstawienie_ID_Przedstawienie integer NOT NULL,
    CONSTRAINT Raport_Przedstawienie FOREIGN KEY (Przedstawienie_ID_Przedstawienie)
    REFERENCES Przedstawienie (ID_Przedstawienie)
);

-- Table: Rekwizyt
CREATE TABLE Rekwizyt (
    ID_Rekwizyt integer NOT NULL CONSTRAINT Rekwizyt_pk PRIMARY KEY,
    nazwa_rekwizytu varchar(255) NOT NULL,
    opis_rekwizytku varchar(255),
    licznosc integer NOT NULL,
    Sztuka_ID_Sztuka integer NOT NULL,
    CONSTRAINT Rekwizyt_Sztuka FOREIGN KEY (Sztuka_ID_Sztuka)
    REFERENCES Sztuka (ID_Sztuka)
);

-- Table: Rekwizyt_WyposazenieTeatru
CREATE TABLE Rekwizyt_WyposazenieTeatru (
    Rekwizyt_ID_Rekwizyt integer NOT NULL,
    WyposazenieTeatru_ID_Wyposazenie integer NOT NULL,
    licznosc integer NOT NULL,
    CONSTRAINT Rekwizyt_WyposazenieTeatru_pk PRIMARY KEY (WyposazenieTeatru_ID_Wyposazenie,Rekwizyt_ID_Rekwizyt),
    CONSTRAINT Rekwizyt_WyposazenieTeatru_Rekwizyt FOREIGN KEY (Rekwizyt_ID_Rekwizyt)
    REFERENCES Rekwizyt (ID_Rekwizyt),
    CONSTRAINT Rekwizyt_WyposazenieTeatru_WyposazenieTeatru FOREIGN KEY (WyposazenieTeatru_ID_Wyposazenie)
    REFERENCES WyposazenieTeatru (ID_Wyposazenie)
);

-- Table: Rezerwacja
CREATE TABLE Rezerwacja (
    ID_Rezerwacja integer NOT NULL CONSTRAINT Rezerwacja_pk PRIMARY KEY,
    numer_rezerwacji integer NOT NULL,
    status_rezerwacji varchar(255) NOT NULL,
    Przedstawienie_ID_Przedstawienie integer NOT NULL,
    Klient_ID_Klient integer NOT NULL,
    CONSTRAINT Rezerwacja_Przedstawienie FOREIGN KEY (Przedstawienie_ID_Przedstawienie)
    REFERENCES Przedstawienie (ID_Przedstawienie),
    CONSTRAINT Rezerwacja_Klient FOREIGN KEY (Klient_ID_Klient)
    REFERENCES Klient (ID_Klient)
);

-- Table: Rezerwacja_Miejsce
CREATE TABLE Rezerwacja_Miejsce (
    Rezerwacja_ID_Rezerwacja integer NOT NULL,
    Miejsce_ID_Miejsce integer NOT NULL,
    CONSTRAINT Rezerwacja_Miejsce_pk PRIMARY KEY (Rezerwacja_ID_Rezerwacja,Miejsce_ID_Miejsce),
    CONSTRAINT Rezerwacja_Miejsce_Rezerwacja FOREIGN KEY (Rezerwacja_ID_Rezerwacja)
    REFERENCES Rezerwacja (ID_Rezerwacja),
    CONSTRAINT Rezerwacja_Miejsce_Miejsce FOREIGN KEY (Miejsce_ID_Miejsce)
    REFERENCES Miejsce (ID_Miejsce)
);

-- Table: Rola
CREATE TABLE Rola (
    ID_Rola integer NOT NULL CONSTRAINT Rola_pk PRIMARY KEY,
    nazwa_roli varchar(255) NOT NULL,
    opis_roli varchar(255),
    licznosc integer NOT NULL,
    Sztuka_ID_Sztuka integer NOT NULL,
    CONSTRAINT Rola_Sztuka FOREIGN KEY (Sztuka_ID_Sztuka)
    REFERENCES Sztuka (ID_Sztuka)
);

-- Table: Sala
CREATE TABLE Sala (
    ID_Sala integer NOT NULL CONSTRAINT Sala_pk PRIMARY KEY,
    nazwa_sali varchar(255) NOT NULL,
    Przedstawienie_ID_Przedstawienie integer NOT NULL,
    CONSTRAINT Sala_Przedstawienie FOREIGN KEY (Przedstawienie_ID_Przedstawienie)
    REFERENCES Przedstawienie (ID_Przedstawienie)
);

-- Table: Sztuka
CREATE TABLE Sztuka (
    ID_Sztuka integer NOT NULL CONSTRAINT Sztuka_pk PRIMARY KEY,
    nazwa_sztuki varchar(255) NOT NULL,
    opis_sztuki varchar(1020)
);

-- Table: WyposazenieTeatru
CREATE TABLE WyposazenieTeatru (
    ID_Wyposazenie integer NOT NULL CONSTRAINT WyposazenieTeatru_pk PRIMARY KEY,
    identyfikator_magazynowy varchar(255) NOT NULL,
    nazwa varchar(255),
    opis varchar(1020)
);

-- Table: WyposazenieTeatru_Przedstawienie
CREATE TABLE WyposazenieTeatru_Przedstawienie (
    Przedstawienie_ID_Przedstawienie integer NOT NULL,
    WyposazenieTeatru_ID_Wyposazenie integer NOT NULL,
    CONSTRAINT WyposazenieTeatru_Przedstawienie_pk PRIMARY KEY (Przedstawienie_ID_Przedstawienie,WyposazenieTeatru_ID_Wyposazenie),
    CONSTRAINT WyposazenieTeatru_Przedstawienie_Przedstawienie FOREIGN KEY (Przedstawienie_ID_Przedstawienie)
    REFERENCES Przedstawienie (ID_Przedstawienie),
    CONSTRAINT WyposazenieTeatru_Przedstawienie_WyposazenieTeatru FOREIGN KEY (WyposazenieTeatru_ID_Wyposazenie)
    REFERENCES WyposazenieTeatru (ID_Wyposazenie)
);

-- End of file.

