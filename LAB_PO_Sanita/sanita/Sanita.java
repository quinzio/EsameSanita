package sanita;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Sanita {
	Map<String, Persona> persone = new HashMap<>();
	Map<String, Medico> medici = new HashMap<>();
	
	public void aggiungiPersona(String nome, String cognome, String cf) {
		Persona paz = new Paziente(nome, cognome, cf);
		persone.put(cf, paz);
		
	}

	public Persona getPersona(String cf) throws ErrPersonaInesistente { 
		if (! persone.containsKey(cf)) throw new ErrPersonaInesistente();
		return persone.get(cf);
	}

	public void aggiungiMedico(String matricola, String nome, String cognome, String cf) {
		Medico med = new MedicoImpl(cf, nome, cognome, matricola);
		persone.put(cf, med);
		medici.put(matricola, med);
	}

	public Medico getMedico(String matricola) throws ErrMedicoInesistente {
		if (! medici.containsKey(matricola)) throw new ErrMedicoInesistente();
		return medici.get(matricola);
	}

	public void assegnaMedico(String matricola, String cf) 
		throws ErrPersonaInesistente, ErrMedicoInesistente {
		Paziente paz = (Paziente)getPersona(cf);
		MedicoImpl medimpl = (MedicoImpl)getMedico(matricola);
		paz.setMedico(getMedico(matricola));
		medimpl.addPaziente(paz);
		
		
	}
	
	public int caricaDati(String nomeFile) throws IOException{
		Path p = Paths.get(nomeFile);
		List<String> lines = Files.readAllLines(p);
		String type;
		String codiceFiscale;
		String matricola;
		String nome;
		String cognome;
		
		for (String s: lines) {
			Scanner scan = new Scanner(s);
			scan.useDelimiter(";");
			try {
				type = scan.next();
				if (type.equals("P")) {
					nome = scan.next();
					cognome = scan.next();
					codiceFiscale = scan.next();
					aggiungiPersona(nome, cognome, codiceFiscale);
				}
				if (type.equals("M")) {
					matricola = scan.next();
					nome = scan.next();
					cognome = scan.next();
					codiceFiscale = scan.next();
					aggiungiMedico(matricola, nome, cognome, codiceFiscale);
				}
			} catch (Exception e) {
			}
		}
		return 0;		
	}
}
