CREATE TABLE animals (
  animal_name CHARACTER VARYING(20) NOT NULL,
  animal_breed CHARACTER VARYING(20) NOT NULL,
  animal_species CHARACTER VARYING(20) NOT NULL,
  animal_description CHARACTER VARYING(20) NOT NULL,
  animalid INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('animals_animalid_seq'::regclass)
);
CREATE UNIQUE INDEX animals_animalid_uindex ON animals USING BTREE (animalid);