--------------------------------------------------------
--  File created - �������-������-04-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence FOLKS_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "DAVID"."FOLKS_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 24 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence GROUPS_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "DAVID"."GROUPS_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 22 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence LOGENTRIES_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "DAVID"."LOGENTRIES_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 22 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence USERS_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "DAVID"."USERS_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 22 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table GROUPS
--------------------------------------------------------

  CREATE TABLE "DAVID"."GROUPS" 
   (	"ID" NUMBER(*,0), 
	"NAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table LOGENTRIES
--------------------------------------------------------

  CREATE TABLE "DAVID"."LOGENTRIES" 
   (	"ID" NUMBER(*,0), 
	"USER_ID" NUMBER(*,0), 
	"LOG_DATETIME" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TABLE1
--------------------------------------------------------

  CREATE TABLE "DAVID"."TABLE1" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "DAVID"."USERS" 
   (	"ID" NUMBER(*,0), 
	"NAME" VARCHAR2(20 BYTE), 
	"GROUP_ID" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into DAVID.GROUPS
SET DEFINE OFF;
Insert into DAVID.GROUPS (ID,NAME) values (1,'government');
Insert into DAVID.GROUPS (ID,NAME) values (2,'ubuntu');
REM INSERTING into DAVID.LOGENTRIES
SET DEFINE OFF;
Insert into DAVID.LOGENTRIES (ID,USER_ID,LOG_DATETIME) values (1,1,to_date('04-APR-14','DD-MON-RR'));
Insert into DAVID.LOGENTRIES (ID,USER_ID,LOG_DATETIME) values (2,2,to_date('01-APR-14','DD-MON-RR'));
REM INSERTING into DAVID.TABLE1
SET DEFINE OFF;
Insert into DAVID.TABLE1 (ID,NAME) values (1,'Jimmy');
Insert into DAVID.TABLE1 (ID,NAME) values (2,'Bobby');
Insert into DAVID.TABLE1 (ID,NAME) values (3,'Eminem');
Insert into DAVID.TABLE1 (ID,NAME) values (4,'Steve');
Insert into DAVID.TABLE1 (ID,NAME) values (5,'Rooster');
Insert into DAVID.TABLE1 (ID,NAME) values (6,'omg');
Insert into DAVID.TABLE1 (ID,NAME) values (7,'se7en');
Insert into DAVID.TABLE1 (ID,NAME) values (9,'Tomas');
Insert into DAVID.TABLE1 (ID,NAME) values (10,'Jefferson');
REM INSERTING into DAVID.USERS
SET DEFINE OFF;
Insert into DAVID.USERS (ID,NAME,GROUP_ID) values (1,'James',1);
Insert into DAVID.USERS (ID,NAME,GROUP_ID) values (2,'Tomas',1);
--------------------------------------------------------
--  DDL for Index INDEX_LOGENTRIES_LOG_DATETIMES
--------------------------------------------------------

  CREATE INDEX "DAVID"."INDEX_LOGENTRIES_LOG_DATETIMES" ON "DAVID"."LOGENTRIES" ("LOG_DATETIME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index INDEX_GROUPS_NAMES
--------------------------------------------------------

  CREATE INDEX "DAVID"."INDEX_GROUPS_NAMES" ON "DAVID"."GROUPS" ("NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index INDEX_USERS_NAMES
--------------------------------------------------------

  CREATE INDEX "DAVID"."INDEX_USERS_NAMES" ON "DAVID"."USERS" ("NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table GROUPS
--------------------------------------------------------

  ALTER TABLE "DAVID"."GROUPS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "DAVID"."GROUPS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "DAVID"."GROUPS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TABLE1
--------------------------------------------------------

  ALTER TABLE "DAVID"."TABLE1" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "DAVID"."TABLE1" MODIFY ("NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "DAVID"."USERS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "DAVID"."USERS" MODIFY ("GROUP_ID" NOT NULL ENABLE);
  ALTER TABLE "DAVID"."USERS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "DAVID"."USERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LOGENTRIES
--------------------------------------------------------

  ALTER TABLE "DAVID"."LOGENTRIES" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "DAVID"."LOGENTRIES" MODIFY ("LOG_DATETIME" NOT NULL ENABLE);
  ALTER TABLE "DAVID"."LOGENTRIES" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "DAVID"."LOGENTRIES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table LOGENTRIES
--------------------------------------------------------

  ALTER TABLE "DAVID"."LOGENTRIES" ADD FOREIGN KEY ("USER_ID")
	  REFERENCES "DAVID"."USERS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "DAVID"."USERS" ADD FOREIGN KEY ("GROUP_ID")
	  REFERENCES "DAVID"."GROUPS" ("ID") ENABLE;
--------------------------------------------------------
--  DDL for Trigger GROUPS_SEQUENCE_ID_INSERT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "DAVID"."GROUPS_SEQUENCE_ID_INSERT" 
BEFORE INSERT ON GROUPS
FOR EACH ROW
BEGIN
:NEW.id := groups_sequence.NEXTVAL;
END;
--INSERT INTO users
--VALUES (5, 'Tomas', 1);
/
ALTER TRIGGER "DAVID"."GROUPS_SEQUENCE_ID_INSERT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger LOGENTRIES_SEQUENCE_ID_INSERT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "DAVID"."LOGENTRIES_SEQUENCE_ID_INSERT" 
BEFORE INSERT ON LOGENTRIES
FOR EACH ROW
BEGIN
:NEW.id := logentries_sequence.NEXTVAL;
END;
--INSERT INTO logentries
--VALUES (5, 'ubuntu');
/
ALTER TRIGGER "DAVID"."LOGENTRIES_SEQUENCE_ID_INSERT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USERS_SEQUENCE_ID_INSERT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "DAVID"."USERS_SEQUENCE_ID_INSERT" 
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
:NEW.id := users_sequence.NEXTVAL;
END;
/
ALTER TRIGGER "DAVID"."USERS_SEQUENCE_ID_INSERT" ENABLE;