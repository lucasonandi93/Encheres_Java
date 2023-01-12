Alter table ARTICLES_VENDUS drop constraint articles_vendus_categories_fk; 

Alter table ARTICLES_VENDUS drop constraint ventes_utilisateur_fk; 

Alter table ENCHERES drop constraint encheres_no_article_fk;

Alter table RETRAITS drop constraint retrait_article_fk;

Drop table ARTICLES_VENDUS, ENCHERES, RETRAITS, UTILISATEURS; 