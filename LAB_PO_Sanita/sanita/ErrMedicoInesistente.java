package sanita;


@SuppressWarnings("serial")
public class ErrMedicoInesistente extends Exception {
	public ErrMedicoInesistente(){
		super("Medico inesistente");
	}
}
