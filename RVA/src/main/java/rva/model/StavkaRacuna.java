package rva.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the stavka_racuna database table.
 * 
 */
@Entity
@Table(name="stavka_racuna")
@NamedQuery(name="StavkaRacuna.findAll", query="SELECT s FROM StavkaRacuna s")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StavkaRacuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STAVKA_RACUNA_ID_GENERATOR", sequenceName="STAVKA_RACUNA_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STAVKA_RACUNA_ID_GENERATOR")
	private Integer id;

	private BigDecimal cena;

	@Column(name="jedinica_mere")
	private String jedinicaMere;

	private Integer kolicina;

	@Column(name="redni_broj")
	private Integer redniBroj;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne
	@JoinColumn(name="proizvod")
	private Proizvod proizvod;

	//bi-directional many-to-one association to Racun
	@ManyToOne
	@JoinColumn(name="racun")
	private Racun racun;

	public StavkaRacuna() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCena() {
		return this.cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public String getJedinicaMere() {
		return this.jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public Integer getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public Integer getRedniBroj() {
		return this.redniBroj;
	}

	public void setRedniBroj(Integer redniBroj) {
		this.redniBroj = redniBroj;
	}

	public Proizvod getProizvod() {
		return this.proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public Racun getRacun() {
		return this.racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

}