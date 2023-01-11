Alter table ARTICLES_VENDUS drop constraint articles_vendus_categories_fk; 

Alter table ARTICLES_VENDUS drop constraint ventes_utilisateur_fk; 

Drop table ARTICLES_VENDUS, ENCHERES, RETRAITS, UTILISATEURS; 