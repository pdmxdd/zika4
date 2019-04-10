BEGIN;

CREATE EXTENSION IF NOT EXISTS postgis;
CREATE EXTENSION IF NOT EXISTS postgis_topology;
CREATE EXTENSION IF NOT EXISTS fuzzystrmatch;
CREATE EXTENSION IF NOT EXISTS postgis_tiger_geocoder;
CREATE EXTENSION IF NOT EXISTS unaccent;

-- COPY report() FROM '/tmp/report.csv' DELIMITER ',' CSV HEADER;
COPY report(date_string, location_string, location_type, data_field, data_field_code, time_period, time_period_type, value, unit, location) FROM '/tmp/Brazil_Zika-2016-04-02.csv' DELIMITER ',' CSV HEADER;
COPY report(date_string, location_string, location_type, data_field, data_field_code, time_period, time_period_type, value, unit) FROM '/tmp/El_Salvador-2016-02-20.csv' DELIMITER ',' CSV HEADER;
COPY report(date_string, location_string, location_type, data_field, data_field_code, time_period, time_period_type, value, unit, location) FROM '/tmp/Haiti_Zika-2016-02-03.csv' DELIMITER ',' CSV HEADER;
COPY report(date_string, location_string, location_type, data_field, data_field_code, time_period, time_period_type, value, unit, location) FROM '/tmp/Mexico_Zika-2016-02-20.csv' DELIMITER ',' CSV HEADER;
COPY report(date_string, location_string, location_type, data_field, data_field_code, time_period, time_period_type, value, unit) FROM '/tmp/MINSA_ZIKA_Search-Week_08.csv' DELIMITER ',' CSV HEADER;
COPY report(date_string, location_string, location_type, data_field, data_field_code, time_period, time_period_type, value, unit, location) FROM '/tmp/Panama_Zika-2016-02-18.csv' DELIMITER ',' CSV HEADER;

COMMIT;