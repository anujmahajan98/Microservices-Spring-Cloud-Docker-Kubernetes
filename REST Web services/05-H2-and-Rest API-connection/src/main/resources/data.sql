insert into USER_DETAILS(birth_date, id, name)
values (current_date(), 1001, 'Anuj');

insert into USER_DETAILS(birth_date, id, name)
values (current_date(), 1002, 'Tanmay');

insert into USER_DETAILS(birth_date, id, name)
values (current_date(), 1003, 'Pragati');

insert into POST(id, description, user_id)
values (2001, 'This is sunny day', 1001);

insert into POST(id, description, user_id)
values (2002, 'Rain is here', 1001);

insert into POST(id, description, user_id)
values (2003, 'I am the smartest I think', 1002);

-- insert into USER_DETAILS(current_date(), 1001, 'Anuj');