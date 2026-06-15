INSERT INTO modalidades ( nome) VALUES ('Musculação');
INSERT INTO modalidades ( nome) VALUES ('Funcional');
INSERT INTO modalidades ( nome) VALUES ('Jiu-Jitsu');
INSERT INTO modalidades ( nome) VALUES ('Muay Thai');
INSERT INTO modalidades ( nome) VALUES ('Pilates');

INSERT INTO planos (modalidade_id, nome, valor_mensal)
VALUES ((SELECT id FROM modalidades WHERE nome = 'Musculação'), 'Mensal', 120.00);

INSERT INTO planos (modalidade_id, nome, valor_mensal)
VALUES ((SELECT id FROM modalidades WHERE nome = 'Musculação'), 'Trimensal', 330.00);

INSERT INTO planos (modalidade_id, nome, valor_mensal)
VALUES ((SELECT id FROM modalidades WHERE nome = 'Funcional'), 'Mensal', 150.00);

INSERT INTO planos (modalidade_id, nome, valor_mensal)
VALUES ((SELECT id FROM modalidades WHERE nome = 'Jiu-Jitsu'), 'Mensal', 180.00);


INSERT INTO graduacoes (modalidade_id, nome )
VALUES ((SELECT id FROM modalidades WHERE nome = 'Jiu-Jitsu'), 'Faixa Branca');

INSERT INTO graduacoes (modalidade_id, nome )
VALUES ((SELECT id FROM modalidades WHERE nome = 'Jiu-Jitsu'), 'Faixa Azul');


INSERT INTO graduacoes (modalidade_id, nome )
VALUES ((SELECT id FROM modalidades WHERE nome = 'Jiu-Jitsu'), 'Faixa Roxa');

