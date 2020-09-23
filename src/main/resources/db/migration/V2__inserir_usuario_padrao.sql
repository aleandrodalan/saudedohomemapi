insert into usuario
(login, cpf, data_nascimento, email, nome, telefone, senha, status, alteracao, grupo_acesso)
values
('admin', '617.946.200-36', '10/05/1976', 'admin.admin@loglab.com.br', 
 'Nome do administrador', '(65) 99999-9999', '$2a$10$Y.OydGnyMbXzj6jLShvwpuD3VJcpne0Us2eOVccku/Zj06NRNGYeG',
 'ATIVO', NOW(), 'COORDENADOR');