-- insert sale parameters
INSERT INTO public.sales_parametrization (id, enabled, min_sale_limit, periodicity, periodicity_unit, created_at, updated_at) VALUES (1, true, 1, 7, 'day', '2017-11-12 16:08:06.796000000', '2017-11-12 16:08:06.932000000');
INSERT INTO public.sales_parametrization (id, enabled, min_sale_limit, periodicity, periodicity_unit, created_at, updated_at) VALUES (2, true, 1, 15, 'day', '2017-11-12 16:08:06.796000000', '2017-11-12 16:08:06.932000000');
INSERT INTO public.sales_parametrization (id, enabled, min_sale_limit, periodicity, periodicity_unit, created_at, updated_at) VALUES (3, true, 10, 1, 'month', '2017-11-12 16:08:06.796000000', '2017-11-12 16:08:06.932000000');
INSERT INTO public.sales_parametrization (id, enabled, min_sale_limit, periodicity, periodicity_unit, created_at, updated_at) VALUES (4, true, 1, 1, 'day', '2017-11-12 16:08:06.796000000', '2017-11-12 16:08:06.932000000');

-- insert books data
INSERT INTO public.books (id, enabled, title, edition, synopsis, isbn, barcode, publishyear, numberofpages, height, width, depth, weight, author_id, sales_parameters_id, price_group_id, publisher_id, created_at, updated_at) VALUES (1, false, 'The Devils', '1', 'Lorem ipsum dolor sit amet', '1', '1', '2000', '250', 1, 1, 1, 1, 1, 1, 1, 1, '2017-11-12 16:08:07.087000000', '2017-11-12 16:08:07.087000000');
INSERT INTO public.books (id, enabled, title, edition, synopsis, isbn, barcode, publishyear, numberofpages, height, width, depth, weight, author_id, sales_parameters_id, price_group_id, publisher_id, created_at, updated_at) VALUES (2, false, 'Memories from underground', '2a', 'Lorem ipsum', '2', '2', '2010', '100', 17, 13, 8, 80, 1, 3, 1, 1, '2017-11-29 00:27:37.438000000', '2017-11-29 00:27:41.948000000');
INSERT INTO public.books (id, enabled, title, edition, synopsis, isbn, barcode, publishyear, numberofpages, height, width, depth, weight, author_id, sales_parameters_id, price_group_id, publisher_id, created_at, updated_at) VALUES (3, false, 'Dead Souls', '1a', 'Dolor sit amet ipsum lorem', '9', '9', '1999', '300', 10, 10, 10, 100, 2, 2, 1, 1, '2017-11-29 00:30:50.005000000', '2017-11-29 00:30:58.104000000');
INSERT INTO public.books (id, enabled, title, edition, synopsis, isbn, barcode, publishyear, numberofpages, height, width, depth, weight, author_id, sales_parameters_id, price_group_id, publisher_id, created_at, updated_at) VALUES (4, false, 'Anna Karenina', '3a', 'Sit dolor ipsum lorem amet', '3', '3', '2001', '830', 18, 15, 10, 300, 3, 4, 1, 1, '2017-11-29 00:34:31.736000000', '2017-11-29 00:34:35.040000000');

-- insert book-category association
INSERT INTO public.books_categories (book_id, category_id, created_at, updated_at) VALUES (1, 2, '2017-11-12 16:08:07.112000000', '2017-11-12 16:08:07.112000000');
INSERT INTO public.books_categories (book_id, category_id, created_at, updated_at) VALUES (2, 2, '2017-11-29 00:45:59.065000000', '2017-11-29 00:46:02.521000000');
INSERT INTO public.books_categories (book_id, category_id, created_at, updated_at) VALUES (2, 4, '2017-11-29 00:46:18.955000000', '2017-11-29 00:46:21.565000000');
INSERT INTO public.books_categories (book_id, category_id, created_at, updated_at) VALUES (3, 2, '2017-11-29 00:46:44.934000000', '2017-11-29 00:46:47.415000000');
INSERT INTO public.books_categories (book_id, category_id, created_at, updated_at) VALUES (4, 2, '2017-11-29 00:47:05.787000000', '2017-11-29 00:47:07.413000000');

-- insert stocks
INSERT INTO public.stocks (enabled, book_id, quantity, purchase_price, created_at, updated_at) VALUES (true, 1, 50, 15, '2017-11-29 13:26:16.658000000', '2017-11-29 13:26:21.918000000');
INSERT INTO public.stocks (enabled, book_id, quantity, purchase_price, created_at, updated_at) VALUES (true, 2, 120, 9.55, '2017-11-29 13:26:49.829000000', '2017-11-29 13:26:55.552000000');
INSERT INTO public.stocks (enabled, book_id, quantity, purchase_price, created_at, updated_at) VALUES (true, 3, 0, 12.34, '2017-11-29 13:27:26.083000000', '2017-11-29 13:27:27.512000000');
INSERT INTO public.stocks (enabled, book_id, quantity, purchase_price, created_at, updated_at) VALUES (true, 4, 80, 17.89, '2017-11-29 13:27:50.501000000', '2017-11-29 13:27:51.251000000');