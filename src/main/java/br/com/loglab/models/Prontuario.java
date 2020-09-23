package br.com.loglab.models;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRONTUARIO")
public class Prontuario extends AbstractEntity<Long> {

	@NotNull(message = "Paciente não pode estar vazio")
	@ManyToOne
	@JoinColumn(name = "paciente_fk")
	private Paciente paciente;
	
	@NotNull(message = "Unidade de Saúde não pode estar vazio")
	@ManyToOne
	@JoinColumn(name = "unidadesaude_fk")
	private UnidadeSaude unidadeSaude;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")	
	@Column(name = "DATA_COLETA")
	private LocalDateTime dataColeta;

	@NotNull(message = "Peso não pode estar vazio")
	@DecimalMin(value = "0.1", message = "Peso deve ser maior do que zero")	
	@NumberFormat(pattern = "##0.00")
	@Column(name = "PESO")
	private Double peso;

	@NotNull(message = "Altura não pode estar vazio")	
	@DecimalMin(value = "0.1", message = "Altura deve ser maior do que zero")	
	@NumberFormat(pattern = "##0.00")
	@Column(name = "ALTURA")
	private Double altura;

	@NumberFormat(pattern = "##0.00")
	@Column(name = "IMC")
	private Double imc;

	@Column(name = "CIRCUNFERENCIA_ABDOMINAL")
	private Integer circunferenciaAbdominal;
	
	@Column(name = "PRESSAO_ARTERIAL")
	private String pressaoArterial;

	@Column(name = "COLESTEROL")	
	private Integer colesterol;

	@NumberFormat(pattern = "#0.00")	
	@Column(name = "TSH")
	private Double tsh;
	
	@Column(name = "INDICE_GLICEMICO")	
	private Integer indiceGlicemico;
	
	@Column(name = "FREQUENCIA_CARDIACA")
	private Integer frequenciaCardiaca;
	
	@Column(name = "PSA")
	private Integer psa;
	
	@Column(name = "FREQUENCIA_RESPIRATORIA")	
	private Integer frequenciaRespiratoria;	
	
	@Embedded
	private QuestionarioAutoReferidoSaude questionario;
	
	@PostConstruct
	public void setDataColeta(LocalDateTime dataColeta) {
		this.dataColeta = LocalDateTime.now(); 
	};
	
}