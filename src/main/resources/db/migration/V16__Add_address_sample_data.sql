INSERT INTO public.addresses (id, enabled, alias, district, number, postal_code, public_place_name, public_place_type, created_at, updated_at) VALUES (1, true, 'home', 'vinewood', '89890', '086000000', 'power', 'street', '2017-12-10 15:44:27.995000000', '2017-12-10 15:44:29.398000000');
INSERT INTO public.addresses (id, enabled, alias, district, number, postal_code, public_place_name, public_place_type, created_at, updated_at) VALUES (2, true, 'work', 'downtown', '1024', '186240039', 'elgin', 'avenue', '2017-12-10 15:46:12.488000000', '2017-12-10 15:46:13.907000000');
INSERT INTO public.addresses (id, enabled, alias, district, number, postal_code, public_place_name, public_place_type, created_at, updated_at) VALUES (3, true, null, 'south', '69690', '841075112', 'grove', 'street', '2017-12-10 15:48:09.512000000', '2017-12-10 15:48:11.621000000');
INSERT INTO public.addresses (id, enabled, alias, district, number, postal_code, public_place_name, public_place_type, created_at, updated_at) VALUES (4, true, null, 'south', '100', '100200300', 'carson', 'avenue', '2017-12-10 15:49:47.569000000', '2017-12-10 15:49:48.907000000');
INSERT INTO public.addresses (id, enabled, alias, district, number, postal_code, public_place_name, public_place_type, created_at, updated_at) VALUES (5, true, null, 'east', '55', '555000999', 'el rancho', 'boulevard', '2017-12-10 15:50:53.434000000', '2017-12-10 15:50:54.625000000');
INSERT INTO public.addresses (id, enabled, alias, district, number, postal_code, public_place_name, public_place_type, created_at, updated_at) VALUES (6, true, null, 'del perro', '345', '666123098', 'red desert', 'avenue', '2017-12-10 15:52:49.630000000', '2017-12-10 15:52:50.715000000');
INSERT INTO public.addresses (id, enabled, alias, district, number, postal_code, public_place_name, public_place_type, created_at, updated_at) VALUES (7, true, null, 'little seoul', '10248', '100100100', 'vespucci', 'boulevard', '2017-12-10 15:54:09.709000000', '2017-12-10 15:54:10.866000000');
INSERT INTO public.addresses (id, enabled, alias, district, number, postal_code, public_place_name, public_place_type, created_at, updated_at) VALUES (8, true, null, 'vespucci', '98', '333222111', 'palomino', 'avenue', '2017-12-10 15:56:38.432000000', '2017-12-10 15:56:39.875000000');
INSERT INTO public.addresses (id, enabled, alias, district, number, postal_code, public_place_name, public_place_type, created_at, updated_at) VALUES (9, true, null, 'richman', '1', '546208917', 'richman', 'street', '2017-12-10 15:59:22.391000000', '2017-12-10 15:59:24.232000000');
INSERT INTO public.addresses (id, enabled, alias, district, number, postal_code, public_place_name, public_place_type, created_at, updated_at) VALUES (10, true, null, 'harmony', '23', '000000001', 'joshua', 'road', '2017-12-10 16:00:59.786000000', '2017-12-10 16:01:00.680000000');

-- address types
INSERT INTO PUBLIC.ADDRESS_TYPES (NAME, CREATED_AT, UPDATED_AT) VALUES ('delivery', '2017-12-10 16:05:06.985000000', '2017-12-10 16:05:07.877000000');
INSERT INTO PUBLIC.ADDRESS_TYPES (NAME, CREATED_AT, UPDATED_AT) VALUES ('charge', '2017-12-10 16:05:13.904000000', '2017-12-10 16:05:14.848000000');

-- address associations
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (1, 1);
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (1, 2);
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (1, 3);
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (2, 1);
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (2, 4);
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (2, 5);
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (2, 6);
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (1, 7);
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (1, 8);
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (1, 9);
INSERT INTO PUBLIC.ADDRESSES_TO_ADDRESS_TYPES (ADDRESS_TYPE_ID, ADDRESS_ID) VALUES (2, 9);

-- customers addresses
INSERT INTO PUBLIC.CUSTOMERS_ADDRESSES (ADDRESS_ID, CUSTOMER_ID) VALUES (1, 1);
INSERT INTO PUBLIC.CUSTOMERS_ADDRESSES (ADDRESS_ID, CUSTOMER_ID) VALUES (2, 1);
INSERT INTO PUBLIC.CUSTOMERS_ADDRESSES (ADDRESS_ID, CUSTOMER_ID) VALUES (3, 1);
INSERT INTO PUBLIC.CUSTOMERS_ADDRESSES (ADDRESS_ID, CUSTOMER_ID) VALUES (4, 2);
INSERT INTO PUBLIC.CUSTOMERS_ADDRESSES (ADDRESS_ID, CUSTOMER_ID) VALUES (5, 2);
INSERT INTO PUBLIC.CUSTOMERS_ADDRESSES (ADDRESS_ID, CUSTOMER_ID) VALUES (6, 2);
INSERT INTO PUBLIC.CUSTOMERS_ADDRESSES (ADDRESS_ID, CUSTOMER_ID) VALUES (7, 3);
INSERT INTO PUBLIC.CUSTOMERS_ADDRESSES (ADDRESS_ID, CUSTOMER_ID) VALUES (8, 3);
INSERT INTO PUBLIC.CUSTOMERS_ADDRESSES (ADDRESS_ID, CUSTOMER_ID) VALUES (9, 3);