CREATE TABLE CUSTOMERS_ADDRESSES
(
  ID integer AUTO_INCREMENT PRIMARY KEY NOT NULL,
  ADDRESS_ID integer NOT NULL,
  CUSTOMER_ID integer,
  CONSTRAINT CUSTOMERS_ADDRESSES_ADDRESSES_ID_FK FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESSES (ID),
  CONSTRAINT CUSTOMERS_ADDRESSES_CUSTOMERS_ID_FK FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS (ID)
)