package sanita;


public class Paziente implements Persona{
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private Medico medico;

	/**
	 * @param codiceFiscale
	 * @param nome
	 * @param cognome
	 */
	public Paziente(String nome, String cognome, String codiceFiscale) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
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
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
