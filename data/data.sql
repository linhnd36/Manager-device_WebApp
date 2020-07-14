--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3 (Ubuntu 12.3-1.pgdg16.04+1)
-- Dumped by pg_dump version 12.3

-- Started on 2020-07-13 16:20:30

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 206 (class 1259 OID 10200880)
-- Name: Booking; Type: TABLE; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE TABLE public."Booking" (
    "BookingId" character varying(50) NOT NULL,
    "DateRequest" date NOT NULL,
    "DateBookingFrom" date NOT NULL,
    "DateBookingTo" date NOT NULL,
    "StatusId" character varying(50) NOT NULL,
    "Email" character varying(50) NOT NULL
);


ALTER TABLE public."Booking" OWNER TO hdvxvewgymxkdq;

--
-- TOC entry 207 (class 1259 OID 10200897)
-- Name: BookingDetail; Type: TABLE; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE TABLE public."BookingDetail" (
    "BookingDetailId" character varying(50) NOT NULL,
    "Amount" integer NOT NULL,
    "BookingId" character varying(50) NOT NULL,
    "ResourceId" character varying(50) NOT NULL
);


ALTER TABLE public."BookingDetail" OWNER TO hdvxvewgymxkdq;

--
-- TOC entry 205 (class 1259 OID 10200869)
-- Name: Resource; Type: TABLE; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE TABLE public."Resource" (
    "ResourceId" character varying(50) NOT NULL,
    "ItemName" character varying(50) NOT NULL,
    "Category" character varying(50) NOT NULL,
    "Quantity" integer NOT NULL,
    "Color" character varying(50) NOT NULL,
    "HighestOfRole" character varying(50),
    "StatusId" character varying(50) NOT NULL
);


ALTER TABLE public."Resource" OWNER TO hdvxvewgymxkdq;

--
-- TOC entry 203 (class 1259 OID 10200847)
-- Name: Role; Type: TABLE; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE TABLE public."Role" (
    "RoleId" character varying(50) NOT NULL,
    "Name" character varying(50) NOT NULL
);


ALTER TABLE public."Role" OWNER TO hdvxvewgymxkdq;

--
-- TOC entry 202 (class 1259 OID 10200842)
-- Name: Status; Type: TABLE; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE TABLE public."Status" (
    "StatusId" character varying(50) NOT NULL,
    "Name" character varying(50) NOT NULL
);


ALTER TABLE public."Status" OWNER TO hdvxvewgymxkdq;

--
-- TOC entry 204 (class 1259 OID 10200852)
-- Name: Users; Type: TABLE; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE TABLE public."Users" (
    "Email" character varying(50) NOT NULL,
    "Password" character varying(50) NOT NULL,
    "Name" character varying(50) NOT NULL,
    "Address" character varying(50) NOT NULL,
    "Phone" character varying(50) NOT NULL,
    "CreateDate" date NOT NULL,
    "RoleId" character varying(50) NOT NULL,
    "StatusId" character varying(50) NOT NULL
);


ALTER TABLE public."Users" OWNER TO hdvxvewgymxkdq;

--
-- TOC entry 3733 (class 2606 OID 10200884)
-- Name: Booking PK_Booking; Type: CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."Booking"
    ADD CONSTRAINT "PK_Booking" PRIMARY KEY ("BookingId");


--
-- TOC entry 3737 (class 2606 OID 10200901)
-- Name: BookingDetail PK_BookingDetail; Type: CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."BookingDetail"
    ADD CONSTRAINT "PK_BookingDetail" PRIMARY KEY ("BookingDetailId");


--
-- TOC entry 3730 (class 2606 OID 10200873)
-- Name: Resource PK_Resource; Type: CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."Resource"
    ADD CONSTRAINT "PK_Resource" PRIMARY KEY ("ResourceId");


--
-- TOC entry 3724 (class 2606 OID 10200851)
-- Name: Role PK_Role; Type: CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."Role"
    ADD CONSTRAINT "PK_Role" PRIMARY KEY ("RoleId");


--
-- TOC entry 3722 (class 2606 OID 10200846)
-- Name: Status PK_Status; Type: CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."Status"
    ADD CONSTRAINT "PK_Status" PRIMARY KEY ("StatusId");


--
-- TOC entry 3726 (class 2606 OID 10200856)
-- Name: Users PK_Users; Type: CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT "PK_Users" PRIMARY KEY ("Email");


--
-- TOC entry 3727 (class 1259 OID 10200867)
-- Name: fkIdx_22; Type: INDEX; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE INDEX "fkIdx_22" ON public."Users" USING btree ("RoleId");


--
-- TOC entry 3738 (class 1259 OID 10200912)
-- Name: fkIdx_48; Type: INDEX; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE INDEX "fkIdx_48" ON public."BookingDetail" USING btree ("BookingId");


--
-- TOC entry 3731 (class 1259 OID 10200879)
-- Name: fkIdx_55; Type: INDEX; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE INDEX "fkIdx_55" ON public."Resource" USING btree ("StatusId");


--
-- TOC entry 3734 (class 1259 OID 10200895)
-- Name: fkIdx_58; Type: INDEX; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE INDEX "fkIdx_58" ON public."Booking" USING btree ("StatusId");


--
-- TOC entry 3728 (class 1259 OID 10200868)
-- Name: fkIdx_61; Type: INDEX; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE INDEX "fkIdx_61" ON public."Users" USING btree ("StatusId");


--
-- TOC entry 3735 (class 1259 OID 10200896)
-- Name: fkIdx_65; Type: INDEX; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE INDEX "fkIdx_65" ON public."Booking" USING btree ("Email");


--
-- TOC entry 3739 (class 1259 OID 10200913)
-- Name: fkIdx_68; Type: INDEX; Schema: public; Owner: hdvxvewgymxkdq
--

CREATE INDEX "fkIdx_68" ON public."BookingDetail" USING btree ("ResourceId");


--
-- TOC entry 3740 (class 2606 OID 10200857)
-- Name: Users FK_22; Type: FK CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT "FK_22" FOREIGN KEY ("RoleId") REFERENCES public."Role"("RoleId");


--
-- TOC entry 3745 (class 2606 OID 10200902)
-- Name: BookingDetail FK_48; Type: FK CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."BookingDetail"
    ADD CONSTRAINT "FK_48" FOREIGN KEY ("BookingId") REFERENCES public."Booking"("BookingId");


--
-- TOC entry 3742 (class 2606 OID 10200874)
-- Name: Resource FK_55; Type: FK CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."Resource"
    ADD CONSTRAINT "FK_55" FOREIGN KEY ("StatusId") REFERENCES public."Status"("StatusId");


--
-- TOC entry 3743 (class 2606 OID 10200885)
-- Name: Booking FK_58; Type: FK CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."Booking"
    ADD CONSTRAINT "FK_58" FOREIGN KEY ("StatusId") REFERENCES public."Status"("StatusId");


--
-- TOC entry 3741 (class 2606 OID 10200862)
-- Name: Users FK_61; Type: FK CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT "FK_61" FOREIGN KEY ("StatusId") REFERENCES public."Status"("StatusId");


--
-- TOC entry 3744 (class 2606 OID 10200890)
-- Name: Booking FK_65; Type: FK CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."Booking"
    ADD CONSTRAINT "FK_65" FOREIGN KEY ("Email") REFERENCES public."Users"("Email");


--
-- TOC entry 3746 (class 2606 OID 10200907)
-- Name: BookingDetail FK_68; Type: FK CONSTRAINT; Schema: public; Owner: hdvxvewgymxkdq
--

ALTER TABLE ONLY public."BookingDetail"
    ADD CONSTRAINT "FK_68" FOREIGN KEY ("ResourceId") REFERENCES public."Resource"("ResourceId");


--
-- TOC entry 3878 (class 0 OID 0)
-- Dependencies: 644
-- Name: LANGUAGE plpgsql; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON LANGUAGE plpgsql TO hdvxvewgymxkdq;


-- Completed on 2020-07-13 16:20:52

--
-- PostgreSQL database dump complete
--

