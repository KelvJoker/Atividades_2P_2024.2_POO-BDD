use projetoif;

-- Produto que mais saiu
SELECT p.nome AS produto, SUM(pp.quantidade) AS total_vendido
FROM pedido_produto pp
JOIN produto p ON pp.id_produto = p.id
GROUP BY p.id
ORDER BY total_vendido DESC
LIMIT 1;

-- Produto que menos saiu
SELECT p.nome AS produto, SUM(pp.quantidade) AS total_vendido
FROM pedido_produto pp
JOIN produto p ON pp.id_produto = p.id
GROUP BY p.id
ORDER BY total_vendido ASC
LIMIT 1;

-- Mês do ano que mais vendeu
SELECT MONTH(p.data) AS mes, YEAR(p.data) AS ano, COUNT(*) AS total_vendas
FROM pedido p
GROUP BY YEAR(p.data), MONTH(p.data)
ORDER BY total_vendas DESC
LIMIT 1;

-- Tipo de pag mais usado
SELECT fp.tipo_de_pagamento, COUNT(*) AS total_usos
FROM pedido p
JOIN forma_pagamento fp ON p.id_forma_pagamento = fp.id
GROUP BY fp.id
ORDER BY total_usos DESC
LIMIT 1;

-- Endereço que mais entregou 
SELECT e.rua, e.numero, COUNT(p.id) AS total_entregas
FROM pedido p
JOIN endereco e ON p.id_endereco = e.id
GROUP BY e.id
ORDER BY total_entregas DESC
LIMIT 1;

-- Venda com mais produtos
SELECT pp.id_pedido, SUM(pp.quantidade) AS total_produtos
FROM pedido_produto pp
GROUP BY pp.id_pedido
ORDER BY total_produtos DESC
LIMIT 1;

-- Vendas do mes atual
SELECT fp.tipo_de_pagamento, SUM(p.valor) AS total_vendas
FROM pedido p
JOIN forma_pagamento fp ON p.id_forma_pagamento = fp.id
WHERE MONTH(p.data) = MONTH(CURDATE()) AND YEAR(p.data) = YEAR(CURDATE())
GROUP BY fp.id;

-- Vendas do mes passado
SELECT fp.tipo_de_pagamento, SUM(p.valor) AS total_vendas
FROM pedido p
JOIN forma_pagamento fp ON p.id_forma_pagamento = fp.id
WHERE MONTH(p.data) = MONTH(CURDATE()) - 1 AND YEAR(p.data) = YEAR(CURDATE())
GROUP BY fp.id;
