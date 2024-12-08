-- Insert data into Station table
INSERT INTO station (id, name, status) VALUES (nextval('station_seq'), 'Station1', 'ACTIVE');
INSERT INTO station (id, name, status) VALUES (nextval('station_seq'), 'Station2', 'INACTIVE');
INSERT INTO station (id, name, status) VALUES (nextval('station_seq'), 'Station3', 'MAINTENANCE');
INSERT INTO station (id, name, status) VALUES (nextval('station_seq'), 'Station4', 'ACTIVE');
INSERT INTO station (id, name, status) VALUES (nextval('station_seq'), 'Station5', 'ACTIVE');


-- Insert data into Slot table for each station
-- Slots for Station 1
INSERT INTO public.slot (id, slot_number, is_fast_charger, status, available_hour, price_per_hour, station_id)
VALUES
    (nextval('slot_seq'), 1, TRUE, 'AVAILABLE', 10, 5.99, (SELECT id FROM station WHERE name = 'Station1')),
    (nextval('slot_seq'), 2, FALSE, 'OCCUPIED', 5, 3.99, (SELECT id FROM station WHERE name = 'Station1')),
    (nextval('slot_seq'), 3, TRUE, 'RESERVED', 8, 6.99, (SELECT id FROM station WHERE name = 'Station1')),
    (nextval('slot_seq'), 4, FALSE, 'MAINTENANCE', 12, 4.49, (SELECT id FROM station WHERE name = 'Station1')),
    (nextval('slot_seq'), 5, TRUE, 'AVAILABLE', 6, 7.99, (SELECT id FROM station WHERE name = 'Station1'));

-- Slots for Station 2
INSERT INTO public.slot (id, slot_number, is_fast_charger, status, available_hour, price_per_hour, station_id)
VALUES
    (nextval('slot_seq'), 1, TRUE, 'AVAILABLE', 9, 5.49, (SELECT id FROM station WHERE name = 'Station2')),
    (nextval('slot_seq'), 2, FALSE, 'RESERVED', 7, 4.79, (SELECT id FROM station WHERE name = 'Station2')),
    (nextval('slot_seq'), 3, TRUE, 'OCCUPIED', 10, 6.99, (SELECT id FROM station WHERE name = 'Station2')),
    (nextval('slot_seq'), 4, TRUE, 'MAINTENANCE', 8, 6.29, (SELECT id FROM station WHERE name = 'Station2')),
    (nextval('slot_seq'), 5, FALSE, 'AVAILABLE', 11, 3.59, (SELECT id FROM station WHERE name = 'Station2'));

-- Slots for Station 3
INSERT INTO public.slot (id, slot_number, is_fast_charger, status, available_hour, price_per_hour, station_id)
VALUES
    (nextval('slot_seq'), 1, TRUE, 'MAINTENANCE', 6, 5.99, (SELECT id FROM station WHERE name = 'Station3')),
    (nextval('slot_seq'), 2, FALSE, 'MAINTENANCE', 8, 4.49, (SELECT id FROM station WHERE name = 'Station3')),
    (nextval('slot_seq'), 3, TRUE, 'MAINTENANCE', 10, 6.49, (SELECT id FROM station WHERE name = 'Station3')),
    (nextval('slot_seq'), 4, TRUE, 'MAINTENANCE', 12, 7.19, (SELECT id FROM station WHERE name = 'Station3')),
    (nextval('slot_seq'), 5, FALSE, 'MAINTENANCE', 5, 4.19, (SELECT id FROM station WHERE name = 'Station3'));

-- Slots for Station 4
INSERT INTO public.slot (id, slot_number, is_fast_charger, status, available_hour, price_per_hour, station_id)
VALUES
    (nextval('slot_seq'), 1, TRUE, 'AVAILABLE', 15, 5.99, (SELECT id FROM station WHERE name = 'Station4')),
    (nextval('slot_seq'), 2, FALSE, 'OCCUPIED', 6, 4.29, (SELECT id FROM station WHERE name = 'Station4')),
    (nextval('slot_seq'), 3, TRUE, 'RESERVED', 9, 6.99, (SELECT id FROM station WHERE name = 'Station4')),
    (nextval('slot_seq'), 4, TRUE, 'MAINTENANCE', 12, 6.79, (SELECT id FROM station WHERE name = 'Station4')),
    (nextval('slot_seq'), 5, FALSE, 'AVAILABLE', 8, 3.99, (SELECT id FROM station WHERE name = 'Station4'));

-- Slots for Station 5
INSERT INTO public.slot (id, slot_number, is_fast_charger, status, available_hour, price_per_hour, station_id)
VALUES
    (nextval('slot_seq'), 1, TRUE, 'AVAILABLE', 14, 5.29, (SELECT id FROM station WHERE name = 'Station5')),
    (nextval('slot_seq'), 2, FALSE, 'OCCUPIED', 10, 4.69, (SELECT id FROM station WHERE name = 'Station5')),
    (nextval('slot_seq'), 3, TRUE, 'RESERVED', 7, 6.99, (SELECT id FROM station WHERE name = 'Station5')),
    (nextval('slot_seq'), 4, TRUE, 'AVAILABLE', 9, 6.59, (SELECT id FROM station WHERE name = 'Station5')),
    (nextval('slot_seq'), 5, FALSE, 'AVAILABLE', 11, 3.79, (SELECT id FROM station WHERE name = 'Station5'));
