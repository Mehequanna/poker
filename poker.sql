--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
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
-- Name: leader_board; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE leader_board (
    id integer NOT NULL,
    name character varying,
    score integer,
    date timestamp without time zone
);


ALTER TABLE leader_board OWNER TO "Guest";

--
-- Name: leader_board_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE leader_board_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE leader_board_id_seq OWNER TO "Guest";

--
-- Name: leader_board_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE leader_board_id_seq OWNED BY leader_board.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY leader_board ALTER COLUMN id SET DEFAULT nextval('leader_board_id_seq'::regclass);


--
-- Data for Name: leader_board; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY leader_board (id, name, score, date) FROM stdin;
1	Blake	500	2016-10-06 09:45:43.812442
2	Stephen	2500	2016-10-06 09:45:43.827313
3	Blake	500	2016-10-06 09:58:55.66909
4	Stephen	2500	2016-10-06 09:58:55.687377
5	Blake	500	2016-10-06 10:04:17.665635
6	Stephen	2500	2016-10-06 10:04:17.680624
7	Blake	500	2016-10-06 10:06:52.858683
8	Stephen	2500	2016-10-06 10:06:52.896289
\.


--
-- Name: leader_board_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('leader_board_id_seq', 8, true);


--
-- Name: leader_board_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY leader_board
    ADD CONSTRAINT leader_board_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

