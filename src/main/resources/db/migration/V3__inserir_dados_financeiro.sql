INSERT INTO matriculas(aluno_id, data_matricula, dia_vencimento, status)
VALUES(4, CURRENT_DATE - INTERVAL '90 days', 10, 'ATIVA');

INSERT INTO matriculas(aluno_id, data_matricula, dia_vencimento, status)
VALUES(5, CURRENT_DATE - INTERVAL '60 days', 15, 'ATIVA');




INSERT INTO matriculas_modalidades( matricula_id, modalidade_id, plano_id, data_inicio)
SELECT m.id, mo.id, p.id, CURRENT_DATE - INTERVAL '90 days'
FROM
    matriculas m
JOIN modalidades mo ON mo.nome = 'Musculação'
JOIN planos p ON p.modalidade_id = mo.id AND p.nome = 'Mensal'
WHERE m.aluno_id = 4;


INSERT INTO matriculas_modalidades( matricula_id, modalidade_id, graduacao_id, plano_id, data_inicio)
SELECT m.id, mo.id, g.id,p.id, CURRENT_DATE - INTERVAL '60 days'
FROM
    matriculas m
    JOIN modalidades mo ON mo.nome = 'Jiu-Jitsu'
    JOIN graduacoes g ON g.modalidade_id = mo.id AND g.nome = 'Faixa Branca'
    JOIN planos p ON p.modalidade_id = mo.id AND p.nome = 'Mensal'
WHERE m.aluno_id = 5;


/*aluno 4 */
INSERT INTO faturas_matriculas( matricula_id, data_vencimento, valor, data_pagamento, status )
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '59 days',
    120.00,
    CURRENT_TIMESTAMP - INTERVAL '45 days',
    'PAGA'
FROM matriculas m
WHERE m.aluno_id = 4;


INSERT INTO faturas_matriculas( matricula_id, data_vencimento, valor, data_pagamento, status )
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '28 days',
    120.00,
    CURRENT_TIMESTAMP - INTERVAL '24 days',
    'PAGA'
FROM matriculas m
WHERE m.aluno_id = 4;


INSERT INTO faturas_matriculas( matricula_id, data_vencimento, valor, status )
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '8 days',
    120.00,
    'ABERTA'
FROM matriculas m
WHERE m.aluno_id = 4;



/*aluno 5 */
INSERT INTO faturas_matriculas( matricula_id, data_vencimento, valor, data_pagamento, status )
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '26 days',
    180.00,
    CURRENT_TIMESTAMP - INTERVAL '22 days',
    'PAGA'
FROM matriculas m
WHERE m.aluno_id = 5;


INSERT INTO faturas_matriculas( matricula_id, data_vencimento, valor, data_pagamento, status )
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '50 days',
    120.00,
    CURRENT_TIMESTAMP - INTERVAL '13 days',
    'PAGA'
FROM matriculas m
WHERE m.aluno_id = 5;


INSERT INTO faturas_matriculas( matricula_id, data_vencimento, valor, status )
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '11 days',
    120.00,
    'ABERTA'
FROM matriculas m
WHERE m.aluno_id = 5;

