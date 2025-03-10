CREATE TABLE IF NOT EXISTS usuario
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    login character varying(50),
    cpf character varying(14),
    data_nascimento date,
    email character varying(50),
    nome character varying(50),
    telefone character varying(15),
    senha character varying(255),
    status character varying(15),
    alteracao timestamp,
    grupo_acesso character varying(15),
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT uk_pm3f4m4fqv89oeeeac4tbe2f4 UNIQUE (login)
);
CREATE TABLE IF NOT EXISTS unidade_saude
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    bairro character varying(50),
    cep character varying(10),
    complemento character varying(50),
    cidade character varying(50),
    logradouro character varying(50),
    numero character varying(10),
    estado character varying(2),
    nome character varying(50),
    telefone character varying(15),
    CONSTRAINT unidade_saude_pkey PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS paciente
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    escolaridade character varying(30),
    estado_civil character varying(30),
    nome_mae character varying(50),
    nome_pai character varying(50),
    nome_social character varying(50),
    ocupacao_atual character varying(50),
    orientacao_sexual character varying(30),
    qual_orientacao_sexual character varying(30),
    raca_cor character varying(20),
    bairro character varying(50),
    cep character varying(10),
    complemento character varying(50),
    cidade character varying(50),
    logradouro character varying(50),
    numero character varying(10),
    estado character varying(2),
    numero_cartao_sus character varying(15),
    cpf character varying(14),
    data_nascimento date,
    email character varying(50),
    nome character varying(50),
    telefone character varying(15),
    CONSTRAINT paciente_pkey PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS prontuario
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    data_coleta timestamp without time zone,
    falar_saude_homem_mulher boolean,
    atualiz_vacina boolean,
    possui_cartao_vacinacao boolean,
    vacinou_dt boolean,
    vacinou_febre_amarela boolean,
    vacinou_gripe_sessenta_anos boolean,
    vacinou_hepatite_b boolean,
    vacinou_triplice_viral boolean,
    farmaceutico_passou_remedio boolean,
    nao_fez_nada boolean,
    outro_como_tratou_problema boolean,
    qual_outro_como_tratou_problema character varying(40),
    tomou_remedio_caseiro boolean,
    tomou_remedio_tinha_casa boolean,
    cons_equipe_saude_fam_matric character varying(40),
    cons_equipe_saude_fam character varying(40),
    cons_nutricionista boolean,
    cons_oftalmologista boolean,
    consultou_urologista boolean,
    tabagista boolean,
    vasectomizado boolean,
    frequenc_ativ_fisica character varying(40),
    faz_uso_bebida_alcoolica boolean,
    tempo_uso_bebida_alcoolica character varying(20),
    gost_atendim_seu_bairro boolean,
    gost_horar_diferenc boolean,
    hist_fami_cancer boolean,
    atend_med_check_up_rotina boolean,
    atend_med_pre_natal boolean,
    atend_med_curativo boolean,
    atend_med_diabetes boolean,
    atend_med_diarreia boolean,
    atend_med_dor_repentina boolean,
    atend_med_exame_adm boolean,
    atend_med_febre boolean,
    atend_med_ferimento_fratura boolean,
    atend_med_hipertensao boolean,
    atend_med_outro boolean,
    atend_med_outro_extenso character varying(40),
    atend_med_probl_resp boolean,
    atend_med_saude_mental boolean,
    atend_med_tosse boolean,
    atend_med_trat_dentario boolean,
    atend_med_troca_rec_med boolean,
    atend_med_vacinacao boolean,
    foi_mal_atend_out_vez boolean,
    nao_achou_import boolean,
    nao_foi_atend_vez_ant boolean,
    nao_podia_ausen_trab boolean,
    nao_sabia_onde_ir boolean,
    nao_tinha_dinh_cons boolean,
    nao_tinha_dinh_transp boolean,
    outro_motivo character varying(40),
    outro_motivo_nao_proc_atend boolean,
    nao_avontade_falar_saude_homem_mulher character varying(40),
    olho_dir_com_correcao boolean,
    olho_esq_com_correcao boolean,
    partic_planej_familiar boolean,
    periodo_atend character varying(30),
    pratica_ativ_fisica boolean,
    procurou_atend_saude character varying(30),
    qual_outro_falar_saude character varying(30),
    qual_tipo_cancer character varying(30),
    quando_cons_dentista character varying(30),
    sabia_homem_cons_cons_pre_natal boolean,
    sofreu_violencia boolean,
    tem_interes_plan_familiar boolean,
    interesse_vasectomizar boolean,
    vontada_parar_tabagismo boolean,
    tempo_tabagista character varying(30),
    teste_hepatite boolean,
    teste_hiv boolean,
    teste_sifilis boolean,
    teve_probl_gastrico boolean,
    teve_probl_renais boolean,
    teve_probl_respiratorio boolean,
    alergia_alimentar boolean,
    alergia_animais boolean,
    alergia_asma boolean,
    alergia_medicamentos boolean,
    alergia_outra boolean,
    alergia_rinite boolean,
    possui_alergia boolean,
    qual_outra_alergia character varying(30),
    possui_deficiencia boolean,
    tipo_deficiencia character varying(30),
    violencia_fisica boolean,
    violencia_psicologica boolean,
    violencia_sexual boolean,
    violencia_todas boolean,
    historico_exames_complementares text,
	PESO DOUBLE PRECISION,
	ALTURA DOUBLE PRECISION,
	IMC DOUBLE PRECISION,
	CIRCUNFERENCIA_ABDOMINAL INTEGER,
	PRESSAO_ARTERIAL VARCHAR(10),
	COLESTEROL INTEGER,
	TSH DOUBLE PRECISION,
	INDICE_GLICEMICO INTEGER,
	FREQUENCIA_CARDIACA INTEGER,
	FREQUENCIA_RESPIRATORIA INTEGER,
	PSA INTEGER,
	ULTIMO_ANO_PROB_SAUDE_NAO_PROC_ATEND_MEDICO boolean,
    paciente_fk bigint NOT NULL,
    unidadesaude_fk bigint NOT NULL,
    CONSTRAINT prontuario_pkey PRIMARY KEY (id),
    CONSTRAINT fk9knisqt7mfknvjp4nws10ddr6 FOREIGN KEY (paciente_fk)
        REFERENCES public.paciente,
    CONSTRAINT fkdy87sujxta6i3mv7gd9urjllh FOREIGN KEY (unidadesaude_fk)
        REFERENCES public.unidade_saude (id)
);
CREATE TABLE IF NOT EXISTS AUDITORIA 
(
    ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    DATA_ACESSO TIMESTAMP,
    NOME_USUARIO CHARACTER VARYING(100),
    LOGIN_USUARIO CHARACTER VARYING(100),
    COMPUTADOR CHARACTER VARYING(255),
    IP CHARACTER VARYING(255),
    JSON TEXT,
   	OPERACAO CHARACTER VARYING(30),
   	CLASSE VARCHAR(100),
    CONSTRAINT auditoria_pkey PRIMARY KEY (id)
);