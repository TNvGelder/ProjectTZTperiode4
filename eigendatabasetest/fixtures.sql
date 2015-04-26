-- we gebruiken REPLACE zodat bestaande records overschreven worden
-- alle wachtwoorden zijn 123


-- gebruikers
INSERT INTO Stakeholder (Type, naam, emailadres, telefoonnr)
  VALUES ('koerier', 'Bob', 'adsfl@hotmail.com', '0581-123718')
  ON DUPLICATE KEY UPDATE Type=VALUES(Type), naam=VALUES(naam), type=VALUES(emailadres), telefoonnr=VALUES(telefoonnr);