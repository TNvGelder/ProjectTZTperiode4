-- we gebruiken REPLACE zodat bestaande records overschreven worden
-- alle wachtwoorden zijn 123


-- gebruikers
INSERT INTO gebruiker (id, email, wachtwoord, type, voornaam, achternaam, telefoon)
  VALUES (1, 'klant@osp.nl', '$2y$10$74IbyQbkueNW0mTM7AoSAOI7bI5zecN6NCwTHxxbpAiQgkcIlEVW6', 'klant', 'Kees', 'de Chinees', '0673648734')
  ON DUPLICATE KEY UPDATE email=VALUES(email), wachtwoord=VALUES(wachtwoord), type=VALUES(type), voornaam=VALUES(voornaam);

INSERT INTO klant (id, bedrijf) VALUES (1, 'Brocolli fabriek') ON DUPLICATE KEY UPDATE bedrijf=VALUES(bedrijf);

INSERT INTO gebruiker (id, email, wachtwoord, type, voornaam, achternaam, telefoon)
  VALUES (2, 'medewerker@osp.nl', '$2y$10$74IbyQbkueNW0mTM7AoSAOI7bI5zecN6NCwTHxxbpAiQgkcIlEVW6', 'medewerker', 'Piet', 'van de Wiet', '0647587465')
  ON DUPLICATE KEY UPDATE email=VALUES(email), wachtwoord=VALUES(wachtwoord), type=VALUES(type), voornaam=VALUES(voornaam);

INSERT INTO medewerker (id, functie) VALUES (2, 'Project manager') ON DUPLICATE KEY UPDATE functie=VALUES(functie);

INSERT INTO gebruiker (id, email, wachtwoord, type)
  VALUES (3, 'admin@osp.nl', '$2y$10$74IbyQbkueNW0mTM7AoSAOI7bI5zecN6NCwTHxxbpAiQgkcIlEVW6', 'beheerder')
  ON DUPLICATE KEY UPDATE email=VALUES(email), wachtwoord=VALUES(wachtwoord), type=VALUES(type);

-- load projects
INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (1, 1, 'Kranten B.V.', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (2, 1, 'Reve Mobile Game', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (3, 1, 'Preischotelfabriek B.V.', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (4, 1, 'Project A', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (5, 1, 'Project B', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (6, 1, 'Project C', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (7, 1, 'Project D', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (8, 1, 'Project E', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (9, 1, 'Project F', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (10, 1, 'Project G', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (11, 1, 'Project H', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

INSERT INTO project (id, gebruiker_id, naam, url)
  VALUES (12, 1, 'Project I', 'https://projects.zoho.com/portal/onlinesupporter#dashboard/500270000002725005')
  ON DUPLICATE KEY UPDATE gebruiker_id=VALUES(gebruiker_id), naam=VALUES(naam), url=VALUES(url);

-- load support tickets
INSERT INTO support_ticket (id, klant_id, onderwerp, prioriteit, gepost_op, afgehandeld_op, bericht)
  VALUES (1, 1, 'Bekijken voortgang projecten', 'hoog', '2014-12-01 12:34:23', null, 'Hoe kan ik de voortgang van mijn projecten bekijken?')
  ON DUPLICATE KEY UPDATE klant_id=VALUES(klant_id), gepost_op=VALUES(gepost_op), afgehandeld_op=VALUES(afgehandeld_op), bericht=VALUES(bericht);

INSERT INTO support_ticket (id, klant_id, onderwerp, prioriteit, gepost_op, afgehandeld_op, bericht)
  VALUES (2, 1, 'Ticket A', 'gemiddeld', '2014-12-01 12:34:23', null, 'Ik heb een vraag, hoe los ik dit op?')
  ON DUPLICATE KEY UPDATE klant_id=VALUES(klant_id), gepost_op=VALUES(gepost_op), afgehandeld_op=VALUES(afgehandeld_op), bericht=VALUES(bericht);