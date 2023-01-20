-- dataset for categories
--SET IDENTITY_INSERT [ [ database_name . ] schema_name . ] table_name { ON | OFF }

SET IDENTITY_INSERT CATEGORIES ON;

INSERT INTO CATEGORIES (no_categories, libelle) 
VALUES 
(1, 'Informatique'),
(2, 'Ameublement'),
(3, 'Vêtement'),
(4, 'Sport&Loisirs');

SET IDENTITY_INSERT CATEGORIES OFF;