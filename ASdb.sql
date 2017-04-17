--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: animalshelter; Type: DATABASE; Schema: -; Owner: rickiecashwell
--

CREATE DATABASE animalshelter WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE animalshelter OWNER TO rickiecashwell;

\connect animalshelter

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: rickiecashwell
--

CREATE TABLE animals (
    animal_name character varying(20) NOT NULL,
    animal_breed character varying(20),
    animal_species character varying(20) NOT NULL,
    animalid integer NOT NULL,
    animal_description character varying(30)
);


ALTER TABLE animals OWNER TO rickiecashwell;

--
-- Name: animals_animalid_seq; Type: SEQUENCE; Schema: public; Owner: rickiecashwell
--

CREATE SEQUENCE animals_animalid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_animalid_seq OWNER TO rickiecashwell;

--
-- Name: animals_animalid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rickiecashwell
--

ALTER SEQUENCE animals_animalid_seq OWNED BY animals.animalid;


--
-- Name: animals animalid; Type: DEFAULT; Schema: public; Owner: rickiecashwell
--

ALTER TABLE ONLY animals ALTER COLUMN animalid SET DEFAULT nextval('animals_animalid_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: rickiecashwell
--

COPY animals (animal_name, animal_breed, animal_species, animalid, animal_description) FROM stdin;
bear	grizzly	species	57	description
bear	grizzly	species	58	Description
\.


--
-- Name: animals_animalid_seq; Type: SEQUENCE SET; Schema: public; Owner: rickiecashwell
--

SELECT pg_catalog.setval('animals_animalid_seq', 58, true);


--
-- Name: animals animals_animalid_pk; Type: CONSTRAINT; Schema: public; Owner: rickiecashwell
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_animalid_pk PRIMARY KEY (animalid);


--
-- Name: animals_animalid_uindex; Type: INDEX; Schema: public; Owner: rickiecashwell
--

CREATE UNIQUE INDEX animals_animalid_uindex ON animals USING btree (animalid);


--
-- PostgreSQL database dump complete
--

