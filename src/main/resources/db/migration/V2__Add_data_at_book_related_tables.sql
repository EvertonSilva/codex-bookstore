-- insert authors
INSERT INTO AUTHORS (name, CREATED_AT, UPDATED_AT) VALUES ('DOSTOIEVSKI, Fiodor', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO AUTHORS (name, CREATED_AT, UPDATED_AT) VALUES ('GOGÓL, Nikolai', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO AUTHORS (name, CREATED_AT, UPDATED_AT) VALUES ('TOLSTÓI, Liev', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- insert categories
INSERT INTO CATEGORIES (NAME, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES ('Romance',
        'The romance genre - which includes verse or prose works dedicated to idealism and associated with ' ||
        'love and daring deeds - has been providing respite from the real world for centuries.',
        current_timestamp(), current_timestamp());
INSERT INTO CATEGORIES (NAME, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES ('Mistery & Suspense',
        'The mystery genre is a type of fiction in which a detective, or other professional, solves a crime ' ||
        'or series of crimes. It can take the form of a novel or short story.',
        current_timestamp(), current_timestamp());
INSERT INTO CATEGORIES (NAME, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES ('Terror',
        'Horror is a genre of fiction which is intended to, or has the capacity to frighten, scare, disgust, ' ||
        'or startle its readers or viewers by inducing feelings of horror and terror.',
        current_timestamp(), current_timestamp());
INSERT INTO CATEGORIES (NAME, DESCRIPTION, CREATED_AT, UPDATED_AT)
VALUES ('Sci-Fi & Fantasy',
        'Science fiction is a genre of speculative fiction, typically dealing with imaginative concepts such as ' ||
        'futuristic science and technology, space travel, time travel, faster than light travel, parallel universes,' ||
        'and extraterrestrial life',
        current_timestamp(), current_timestamp());

-- insert publishers
INSERT INTO PUBLISHERS (NAME, CREATED_AT, UPDATED_AT) VALUES ('Editora 34', current_timestamp(), current_timestamp());
INSERT INTO PUBLISHERS (NAME, CREATED_AT, UPDATED_AT) VALUES ('Novatec', current_timestamp(), current_timestamp());
INSERT INTO PUBLISHERS (NAME, CREATED_AT, UPDATED_AT) VALUES ('Casa do código', current_timestamp(), current_timestamp());

-- insert price group
INSERT INTO PRICE_GROUP (MARKUP, CREATED_AT, UPDATED_AT) VALUES ('5', current_timestamp(), current_timestamp());
INSERT INTO PRICE_GROUP (MARKUP, CREATED_AT, UPDATED_AT) VALUES ('7.5', current_timestamp(), current_timestamp());
INSERT INTO PRICE_GROUP (MARKUP, CREATED_AT, UPDATED_AT) VALUES ('10', current_timestamp(), current_timestamp());
