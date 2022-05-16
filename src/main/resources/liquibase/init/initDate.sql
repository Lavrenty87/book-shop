--liquibase formatted sql

--changeset bookshop;init-author
insert into author(id, fio, birth_date) values (nextval('author_id_seq'), 'Author 1', '1950-05-28');
insert into author(id, fio, birth_date) values (nextval('author_id_seq'), 'Author 2', '2000-05-28');
insert into author(id, fio, birth_date) values (nextval('author_id_seq'), 'Author 3', '2003-05-28');

--changeset bookshop;init-book
insert into book(id, book_name, page_count, prise, publication_date)
values (nextval('book_id_seq'), 'Book 1', 100, 100, '1960-05-28');
insert into book(id, book_name, page_count, prise, publication_date)
values (nextval('book_id_seq'), 'Book 2', 200, 200, '2010-05-28');
insert into book(id, book_name, page_count, prise, publication_date)
values (nextval('book_id_seq'), 'Book 3', 300, 300, '2012-05-28');
insert into book(id, book_name, page_count, prise, publication_date)
values (nextval('book_id_seq'), 'Book 4', 400, 400, '2015-05-28');
insert into book(id, book_name, page_count, prise, publication_date)
values (nextval('book_id_seq'), 'Book 5', 500, 500, '2018-05-28');

--chengeset author_book;init-author_book
insert into author_book(book_id, author_id) default values ;

--changeset bookshop;init-buyer
insert into buyer(id, fio, birth_date) values (nextval('buyer_id_seq'), 'Buyer 1', '2001-01-01');
insert into buyer(id, fio, birth_date) values (nextval('buyer_id_seq'), 'Buyer 2', '2002-02-02');
insert into buyer(id, fio, birth_date) values (nextval('buyer_id_seq'), 'Buyer 3', '2003-03-03')