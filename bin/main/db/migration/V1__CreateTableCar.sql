CREATE TABLE IF NOT EXISTS cars  (
    id_car SERIAL PRIMARY KEY,
    marque varchar(255),
    model varchar(255),
    annee int,
    prix int,
    image varchar(400)
    );