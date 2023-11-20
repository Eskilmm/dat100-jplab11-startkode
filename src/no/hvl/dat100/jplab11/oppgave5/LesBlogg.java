package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		Blogg nySamling = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(mappe + filnavn))) {
			String line = br.readLine();
			
			if (line != null) {
				int antallInnlegg = Integer.parseInt(line.trim());
				nySamling = new Blogg(antallInnlegg);
			}
			
			while (line != null) {
				line = br.readLine();
				
				if (line != null && line.trim().equals(TEKST)) {
					int id = Integer.parseInt(br.readLine().trim());
					String bruker = br.readLine().trim();
					String dato = br.readLine().trim();
					int likes = Integer.parseInt(br.readLine().trim());
					String tekst = br.readLine().trim();
					
					nySamling.leggTil(new Tekst(id, bruker, dato, likes, tekst));
				} else if (line != null && line.trim().equals(BILDE)) {
					int id = Integer.parseInt(br.readLine().trim());
					String bruker = br.readLine().trim();
					String dato = br.readLine().trim();
					int likes = Integer.parseInt(br.readLine().trim());
					String tekst = br.readLine().trim();
					String url = br.readLine().trim();
					
					nySamling.leggTil(new Bilde(id, bruker, dato, likes, tekst, url));
				}
			} 
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return nySamling;

	}
}
