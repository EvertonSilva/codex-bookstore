-- insert authors h2
-- INSERT INTO AUTHORS (name, CREATED_AT, UPDATED_AT) VALUES ('DOSTOIEVSKI, Fiodor', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
-- INSERT INTO AUTHORS (name, CREATED_AT, UPDATED_AT) VALUES ('GOGÓL, Nikolai', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
-- INSERT INTO AUTHORS (name, CREATED_AT, UPDATED_AT) VALUES ('TOLSTÓI, Liev', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

-- insert authors pgsql
INSERT INTO public.authors (id, created_at, enabled, updated_at, name) VALUES (1, '2017-12-11 02:20:33.120000', true, '2017-12-11 02:20:44.294000', 'DOSTOIEVSKI, Fiodor');
INSERT INTO public.authors (id, created_at, enabled, updated_at, name) VALUES (2, '2017-12-11 02:20:33.120000', true, '2017-12-11 02:20:44.294000', 'GOGÓL, Nikolai');
INSERT INTO public.authors (id, created_at, enabled, updated_at, name) VALUES (3, '2017-12-11 02:20:33.120000', true, '2017-12-11 02:20:44.294000', 'TOLSTÓI, Liev');


-- insert categories h2
-- INSERT INTO CATEGORIES (NAME, DESCRIPTION, CREATED_AT, UPDATED_AT)
-- VALUES ('Romance',
--         'The romance genre - which includes verse or prose works dedicated to idealism and associated with ' ||
--         'love and daring deeds - has been providing respite from the real world for centuries.',
--         current_timestamp(), current_timestamp());
-- INSERT INTO CATEGORIES (NAME, DESCRIPTION, CREATED_AT, UPDATED_AT)
-- VALUES ('Mistery & Suspense',
--         'The mystery genre is a type of fiction in which a detective, or other professional, solves a crime ' ||
--         'or series of crimes. It can take the form of a novel or short story.',
--         current_timestamp(), current_timestamp());
-- INSERT INTO CATEGORIES (NAME, DESCRIPTION, CREATED_AT, UPDATED_AT)
-- VALUES ('Terror',
--         'Horror is a genre of fiction which is intended to, or has the capacity to frighten, scare, disgust, ' ||
--         'or startle its readers or viewers by inducing feelings of horror and terror.',
--         current_timestamp(), current_timestamp());
-- INSERT INTO CATEGORIES (NAME, DESCRIPTION, CREATED_AT, UPDATED_AT)
-- VALUES ('Sci-Fi & Fantasy',
--         'Science fiction is a genre of speculative fiction, typically dealing with imaginative concepts such as ' ||
--         'futuristic science and technology, space travel, time travel, faster than light travel, parallel universes,' ||
--         'and extraterrestrial life',
--         current_timestamp(), current_timestamp());

-- insert categories pgsql
INSERT INTO public.categories (id, created_at, enabled, updated_at, description, name)
VALUES (1, '2017-12-11 02:27:11.345000', true, '2017-12-11 02:27:18.004000',
        'The romance genre - which includes verse or prose works ' ||
        'dedicated to idealism and associated with Mistery & Suspense.', 'Romance');

INSERT INTO public.categories (id, created_at, enabled, updated_at, description, name)
VALUES (2, '2017-12-11 02:27:11.345000', true, '2017-12-11 02:27:18.004000',
        'The mystery genre is a type of fiction in which a detective, or other professional, solves a crime ' ||
        'or series of crimes. It can take the form of a novel or short story.', 'Mistery & Suspense');

INSERT INTO public.categories (id, created_at, enabled, updated_at, description, name)
VALUES (3, '2017-12-11 02:27:11.345000', true, '2017-12-11 02:27:18.004000',
        'Horror is a genre of fiction which is intended to, or has the capacity to frighten, scare, disgust, ' ||
        'or startle its readers or viewers by inducing feelings of horror and terror.', 'Terror');

INSERT INTO public.categories (id, created_at, enabled, updated_at, description, name)
VALUES (4, '2017-12-11 02:27:11.345000', true, '2017-12-11 02:27:18.004000',
        'Science fiction is a genre of speculative fiction, typically dealing with imaginative concepts such as, ' ||
        'futuristic science and technology, space travel, time travel, faster than light travel, parallel universes, ' ||
        'and extraterrestrial life.', 'Sci-Fi & Fantasy');

-- insert publishers h2
-- INSERT INTO PUBLISHERS (NAME, CREATED_AT, UPDATED_AT) VALUES ('Editora 34', current_timestamp(), current_timestamp());
-- INSERT INTO PUBLISHERS (NAME, CREATED_AT, UPDATED_AT) VALUES ('Novatec', current_timestamp(), current_timestamp());
-- INSERT INTO PUBLISHERS (NAME, CREATED_AT, UPDATED_AT) VALUES ('Casa do código', current_timestamp(), current_timestamp());

-- insert publishers pgsql
INSERT INTO public.publishers (id, created_at, enabled, updated_at, name)
VALUES (1, '2017-12-11 02:36:29.495000', true, '2017-12-11 02:36:34.029000', 'Editora 34');

INSERT INTO public.publishers (id, created_at, enabled, updated_at, name)
VALUES (2, '2017-12-11 02:36:29.495000', true, '2017-12-11 02:36:34.029000', 'Novatec');

INSERT INTO public.publishers (id, created_at, enabled, updated_at, name)
VALUES (3, '2017-12-11 02:36:29.495000', true, '2017-12-11 02:36:34.029000', 'Casa do código');

-- insert price group h2
-- INSERT INTO PRICE_GROUP (MARKUP, CREATED_AT, UPDATED_AT) VALUES ('5', current_timestamp(), current_timestamp());
-- INSERT INTO PRICE_GROUP (MARKUP, CREATED_AT, UPDATED_AT) VALUES ('7.5', current_timestamp(), current_timestamp());
-- INSERT INTO PRICE_GROUP (MARKUP, CREATED_AT, UPDATED_AT) VALUES ('10', current_timestamp(), current_timestamp());

-- insert price group pgsql
INSERT INTO public.price_group (id, created_at, enabled, updated_at, markup) VALUES (1, '2017-12-11 02:39:35.130000', true, '2017-12-11 02:39:36.341000', 5);
INSERT INTO public.price_group (id, created_at, enabled, updated_at, markup) VALUES (2, '2017-12-11 02:40:06.656000', true, '2017-12-11 02:40:10.717000', 7.5);
INSERT INTO public.price_group (id, created_at, enabled, updated_at, markup) VALUES (3, '2017-12-11 02:40:20.129000', true, '2017-12-11 02:40:23.212000', 10);
