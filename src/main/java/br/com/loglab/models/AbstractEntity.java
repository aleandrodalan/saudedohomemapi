package br.com.loglab.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;
}