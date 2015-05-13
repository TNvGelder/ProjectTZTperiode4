

INSERT INTO stakeholdertype VALUES(2, 'geverifieerd');
INSERT INTO locatie VALUES(1, 'Stationsweg', '5B', 'Zwolle', '1234AB');
INSERT into stakeholder VALUES(1, 2, 'Test', 'Tester', 'test', 0636546686, 'link naar IDkaartscan', 'link naar OVscan', 1337.00, NULL, 'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3', 1, NULL, 'NL99 INGB 0123456789');
INSERT INTO verzendorder VALUES(1, 1, now());

INSERT INTO `karsbaj97_tzt`.`pakket` (`pakketID`, `gewicht`, `formaat`, `opmerking`, `routeID`, `kosten`, `orderID`) VALUES ('1', '200', '20x20x13', 'Breekbaar', '1', '2', '1')
INSERT INTO `karsbaj97_tzt`.`pakket` (`pakketID`, `gewicht`, `formaat`, `opmerking`, `routeID`, `kosten`, `orderID`) VALUES ('2', '300', '20x20x13', 'Zwaar', '1', '2', '1')

INSERT INTO  verzendorde` (
`orderID` ,
`klantID` ,
`aanmeldtijd`
)
VALUES (
'1',  '1', 
CURRENT_TIMESTAMP
);