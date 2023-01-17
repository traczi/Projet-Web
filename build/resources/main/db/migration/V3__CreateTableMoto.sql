CREATE TABLE IF NOT EXISTS motos  (
    id_moto SERIAL PRIMARY KEY,
    marquemoto varchar(255),
    modelmoto varchar(255),
    anneemoto int,
    prixmoto int,
    imagemoto varchar(400)
    );