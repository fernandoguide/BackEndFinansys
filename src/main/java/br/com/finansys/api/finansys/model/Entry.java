package br.com.finansys.api.finansys.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ENTRY")
@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Entry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ENTRY")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "paid")
	private Boolean paid;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "description")
	private String description;

	@OneToOne
	@JoinColumn(name = "ID_CATEGORY")
	private Category categoryId;

}
