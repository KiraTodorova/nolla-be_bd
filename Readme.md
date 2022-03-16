CREATE TABLE tweets_ver2
(
twt_id integer NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
created_twt timestamp  WITHOUT TIME ZONE DEFAULT now(),
content_twt char(200)
)

DROP TABLE tweets_ver2

INSERT INTO tweets_ver2(content_twt) VALUES ('I am doing an insert through POSTGRES');

SELECT * FROM tweets_ver2 ORDER BY created_twt DESC LIMIT 2