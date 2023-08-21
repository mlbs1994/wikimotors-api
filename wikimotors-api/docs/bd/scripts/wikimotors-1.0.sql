-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.automovel
(
    id serial,
    fabricante bigint NOT NULL,
    modelo character varying(255) NOT NULL,
    ano_fabricacao date NOT NULL,
    categoria character varying(20) NOT NULL,
    tracao "char" NOT NULL,
    descricao text
);

CREATE TABLE IF NOT EXISTS public.fabricante
(
    id serial,
    nome character varying(100) NOT NULL,
    pais character varying(40) NOT NULL,
    descricao text,
    bandeira bytea,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.automovel
    ADD CONSTRAINT fk_automovel_fabricante FOREIGN KEY (fabricante)
    REFERENCES public.fabricante (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;