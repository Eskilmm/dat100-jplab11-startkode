package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	private int nesteledig;
	
	private Innlegg[] innleggtabell;

	public Blogg() {
		innleggtabell = new Innlegg [20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg [lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		int posisjon = 0;
		boolean funnet = false;
		
		while(posisjon > nesteledig && !funnet) {
			
			if(innleggtabell[posisjon].erLik(innlegg) == true) {
				funnet = true;
						return posisjon;
			} else {
				posisjon++;
			}
			
		}
		return -1; //hhh
	}

	public boolean finnes(Innlegg innlegg) {
		boolean funnet = false;
		int posisjon = 0;
		
		while(posisjon < nesteledig && !funnet) {
			if(innlegg.getId() == innleggtabell[posisjon].getId()) {
				funnet = true;
			} else {
				posisjon ++;
			}
		}
		return funnet;
	}

	public boolean ledigPlass() {
		
		if(nesteledig < innleggtabell.length) {
			return true;
		} else {
			return false;
		}
		

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (finnes(innlegg) == false) {
			
			innleggtabell[nesteledig] = innlegg;
			nesteledig ++;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nesteledig).append("\n");
		
		for(int i = 0; i <nesteledig; i ++) {
			if(innleggtabell[i] instanceof Tekst) {
				
				sb.append(((Tekst) innleggtabell[i]).toString());
			} else if(innleggtabell[i] instanceof Bilde) {
				sb.append(((Bilde)innleggtabell[i]).toString());
			}
				
			
			
		}
		return sb.toString();
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}