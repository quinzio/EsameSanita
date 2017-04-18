package sanita;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MedicoImpl implements Medico {
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private String matricola;
	private SortedSet<Persona> pazienti = new TreeSet<>(Comparator.comparing(
			Persona::getCognome).thenComparing(
			Comparator.comparing(Persona::getNome)));

	/**
	 * @param codiceFiscale
	 * @param nome
	 * @param cognome
	 * @param matricola
	 */
	public MedicoImpl(String codiceFiscale, String nome, String cognome,
			String matricola) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public String getCognome() {
		return cognome;
	}

	@Override
	public Medico getMedico() {
		return this;
	}

	@Override
	public String getMatricola() {
		return matricola;
	}

	@Override
	public Collection<Persona> getPazienti() {
		return pazienti;
	}

	public void addPaziente(Paziente paz) {
		pazienti.add(paz);

	}

}
