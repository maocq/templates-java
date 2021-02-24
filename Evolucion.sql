# --- !Ups
CREATE TABLE nombre
(
id                          SERIAL,
--uuid                        UUID PRIMARY KEY,
nombre                      VARCHAR(500) NOT NULL,
segundo_nombnre             VARCHAR(250),
datos                       TEXT NOT NULL,
id_otra_tabla               INTEGER,
numero_pequeno              SMALLINT NOT NULL,
numero                      NUMERIC(8) UNIQUE,
monto                       NUMERIC(1000, 2) NOT NULL,
dias                        SMALLINT NOT NULL CHECK (dias IN (1, 2, 3, 4, 5, 6, 7)),
--unico                       INTEGER NOT NULL UNIQUE,
activo                      BOOLEAN NOT NULL,
fecha_nacimiento            TIMESTAMP,
fecha_creacion              TIMESTAMP WITH TIME ZONE NOT NULL,
fecha_actualizacion         TIMESTAMP WITH TIME ZONE NOT NULL,
CONSTRAINT nombre_pk PRIMARY KEY (id)
--CONSTRAINT <campo>_unique UNIQUE (<campo1>, <campo2>),
--CONSTRAINT <campo>_fk FOREIGN KEY (<campo>) REFERENCES <otra_tabla> (<campo_otra_tabla>)
);

COMMENT ON TABLE nombre IS 'Tabla con la información de ...';
COMMENT ON COLUMN nombre.id IS 'xxx';
COMMENT ON COLUMN nombre.nombre IS 'xxx';

# --- !Downs
DROP TABLE nombre;
