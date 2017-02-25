CREATE TABLE TIPOLOGIA(
	NOME CHAR(15),
	DESCRIZIONE TEXT,
	PRIMARY KEY(NOME)
);

CREATE TABLE QUOTA(
	ID INT AUTO_INCREMENT,
	DATA_INIZIO DATE NOT NULL,
	DATA_FINE DATE,
	VALORE DECIMAL(6,2) NOT NULL,
	TIPOLOGIA CHAR(15) NOT NULL,
	PRIMARY KEY(ID),
	FOREIGN KEY(TIPOLOGIA) REFERENCES TIPOLOGIA(NOME) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE SOCIO(
	CF CHAR(16),
	NOME VARCHAR(20) NOT NULL,
	COGNOME VARCHAR(20) NOT NULL,
	SESSO CHAR(1) NOT NULL,
	DATA_NASCITA DATE NOT NULL,
	LUOGO_NASCITA VARCHAR(50) NOT NULL,
	INDIRIZZO VARCHAR(200) NOT NULL,
	CITTA VARCHAR(20) NOT NULL,
	CAP CHAR(5) NOT NULL,
	EMAIL VARCHAR(100),
	TELEFONO CHAR(10) NOT NULL,
	PROFESSIONE VARCHAR(30) NOT NULL,
	STATO_CIVILE VARCHAR(10) NOT NULL,
	CONIUGE VARCHAR(20),
	DATA_AMMISSIONE DATE NOT NULL,
	TASSA_AMMISSIONE DECIMAL(6,2) NOT NULL,
	MOD_PAGAMENTO VARCHAR(20) NOT NULL,
	MET_PAGAMENTO VARCHAR(20) NOT NULL,
	TIPOLOGIA CHAR(15) NOT NULL,
	PRIMARY KEY(CF),
	FOREIGN KEY(TIPOLOGIA) REFERENCES TIPOLOGIA(NOME) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE FIGLIO(
	CF CHAR(16),
	NOME VARCHAR(20) NOT NULL,
	DATA_NASCITA DATE,
	ACARICO BOOLEAN,
	GENITORE CHAR(16),
	PRIMARY KEY(CF),
	FOREIGN KEY(GENITORE) REFERENCES SOCIO(CF) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE NONSOCIO(
	CF CHAR(16),
	NOME VARCHAR(20) NOT NULL,
	COGNOME VARCHAR(20) NOT NULL,
	SESSO CHAR(1),
	DATA_NASCITA DATE,
	INDIRIZZO VARCHAR(200),
	CITTA VARCHAR(20),
	CAP CHAR(5),
	EMAIL VARCHAR(100),
	TELEFONO CHAR(10) NOT NULL,
	PRIMARY KEY(CF)
);

CREATE TABLE SALA(
	ID CHAR(5),
	NOME VARCHAR(20),
	CAPIENZA INT,
	DESCRIZIONE TEXT,
	PRIMARY KEY(ID)
);

CREATE TABLE TARIFFA(
	ID INT AUTO_INCREMENT,
	PREZZO DECIMAL(6,2),
	DATA_INIZIO DATE,
	DATA_FINE DATE,
	CATEGORIA VARCHAR(10),
	SALA CHAR(5),
	PRIMARY KEY(ID),
	FOREIGN KEY(SALA) REFERENCES SALA(ID)
);

CREATE TABLE AFFITTOS(
	DATA DATE,
	SOCIO CHAR(16),
	SALA CHAR(5),
	FOREIGN KEY(SOCIO) REFERENCES SOCIO(CF),
	FOREIGN KEY(SALA) REFERENCES SALA(ID),
	PRIMARY KEY(DATA,SOCIO,SALA)
);

CREATE TABLE AFFITTON(
	DATA DATE,
	NONSOCIO CHAR(16),
	SALA CHAR(5),
	FOREIGN KEY(NONSOCIO) REFERENCES NONSOCIO(CF),
	FOREIGN KEY(SALA) REFERENCES SALA(ID),
	PRIMARY KEY(DATA,NONSOCIO,SALA)
);

CREATE TABLE EVENTO(
	ID CHAR(5),
	NOME VARCHAR(20),
	DATA DATE,
	DESCRIZIONE TEXT,
	N_POSTI INT,
	LUOGO VARCHAR(30),
	PREZZO DECIMAL(6,2),
    PRIMARY KEY(ID)
);

CREATE TABLE PRENOTAZIONES(
	N_BIGLIETTI INT,
	DATA_ACQUSITO DATE,
	SOCIO CHAR(16),
	EVENTO CHAR(5),
	FOREIGN KEY(SOCIO) REFERENCES SOCIO(CF),
	FOREIGN KEY(EVENTO) REFERENCES EVENTO(ID),
	PRIMARY KEY(SOCIO,EVENTO,N_BIGLIETTI, DATA_ACQUSITO)
);

CREATE TABLE PRENOTAZIONEN(
	N_BIGLIETTI INT,
	DATA_ACQUSITO DATE,
	NONSOCIO CHAR(16),
	EVENTO CHAR(5),
	FOREIGN KEY(NONSOCIO) REFERENCES NONSOCIO(CF),
	FOREIGN KEY(EVENTO) REFERENCES EVENTO(ID),
	PRIMARY KEY(NONSOCIO,EVENTO,N_BIGLIETTI, DATA_ACQUSITO)
);

CREATE TABLE VERSAMENTO(
	ID INT AUTO_INCREMENT,
	DATA DATE,
	IMPORTO DECIMAL(6,2),
	DESCRIZIONE TEXT,
	SOCIO CHAR(16),
	PRIMARY KEY(ID),
	FOREIGN KEY(SOCIO) REFERENCES SOCIO(CF)
);

CREATE TABLE MESE(
	DATA CHAR(9),
	VERSAMENTO INT,
	FOREIGN KEY(VERSAMENTO) REFERENCES VERSAMENTO(ID) ON DELETE CASCADE,
	PRIMARY KEY(VERSAMENTO, DATA)
);

CREATE TABLE CONVENZIONE(
	ID INT AUTO_INCREMENT,
	RAGIONE_SOCIALE VARCHAR(100),
	INDIRIZZO VARCHAR(100),
	DESCRIZIONE TEXT,
	PERCENTUALE_SCONTO DECIMAL(4,1),
	PRIMARY KEY(ID)
);

CREATE TABLE EXSOCIO(
	CF CHAR(16),
	NOME VARCHAR(20) NOT NULL,
	COGNOME VARCHAR(20) NOT NULL,
	SESSO CHAR(1) NOT NULL,
	DATA_NASCITA DATE NOT NULL,
	LUOGO_NASCITA VARCHAR(20) NOT NULL,
	INDIRIZZO VARCHAR(200) NOT NULL,
	CITTA VARCHAR(20) NOT NULL,
	CAP CHAR(5) NOT NULL,
	EMAIL VARCHAR(100),
	TELEFONO CHAR(10) NOT NULL,
	PROFESSIONE VARCHAR(30) NOT NULL,
	STATO_CIVILE VARCHAR(10) NOT NULL,
	CONIUGE VARCHAR(20),
	DATA_AMMISSIONE DATE NOT NULL,
	TASSA_AMMISSIONE DECIMAL(6,2) NOT NULL,
	MOD_PAGAMENTO VARCHAR(20) NOT NULL,
	MET_PAGAMENTO VARCHAR(20) NOT NULL,
	TIPOLOGIA CHAR(15) NOT NULL,
	PRIMARY KEY(CF)
);

CREATE TABLE FIGLIOEX(
	CF CHAR(16),
	NOME VARCHAR(20) NOT NULL,
	DATA_NASCITA DATE,
	ACARICO BOOLEAN,
	GENITORE CHAR(16),
	PRIMARY KEY(CF),
	FOREIGN KEY(GENITORE) REFERENCES EXSOCIO(CF) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE UTENTE(
	NOMEUSER CHAR(20),
	PASSWORD VARCHAR(200) NOT NULL,
	PRIMARY KEY(NOMEUSER)
);
