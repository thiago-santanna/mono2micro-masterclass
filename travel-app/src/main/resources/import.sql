create sequence travel_seq start with 1 increment by 1;
INSERT INTO TravelOrder(id) VALUES (nextval('travel_seq'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_seq'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_seq'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_seq'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_seq'));
create sequence fligth_seq start with 1 increment by 1;
INSERT INTO Fligth(id, orderId, fligthFrom, fligthTo) VALUES (nextval('fligth_seq'), 1, 'Sao Paulo', 'Rio de Janeiro');
INSERT INTO Fligth(id, orderId, fligthFrom, fligthTo) VALUES (nextval('fligth_seq'), 1, 'Rio de Janeiro', 'Sao Paulo');
INSERT INTO Fligth(id, orderId, fligthFrom, fligthTo) VALUES (nextval('fligth_seq'), 2, 'Sao Paulo', 'Rio de Janeiro');
INSERT INTO Fligth(id, orderId, fligthFrom, fligthTo) VALUES (nextval('fligth_seq'), 2, 'Rio de Janeiro', 'Sao Paulo');
create sequence hotel_seq start with 1 increment by 1;