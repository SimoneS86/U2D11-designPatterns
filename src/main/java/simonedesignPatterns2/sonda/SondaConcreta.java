package simonedesignPatterns2.sonda;

import java.util.ArrayList;
import java.util.List;

import simonedesignPatterns2.centroControllo.Osservatore;

public class SondaConcreta implements Sonda {
	private String id;
	private double latitudine;
	private double longitudine;
	private int livelloFumo;
	private List<Osservatore> osservatori;

	public SondaConcreta(String id, double latitudine, double longitudine) {
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = 0;
		this.osservatori = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public double getLatitudine() {
		return latitudine;
	}

	public double getLongitudine() {
		return longitudine;
	}

	public int getLivelloFumo() {
		return livelloFumo;
	}

	public void setLivelloFumo(int livelloFumo) {
		this.livelloFumo = livelloFumo;
		notificaOsservatori();
	}

	public void aggiungiOsservatore(Osservatore osservatore) {
		osservatori.add(osservatore);
	}

	public void rimuoviOsservatore(Osservatore osservatore) {
		osservatori.remove(osservatore);
	}

	public void notificaOsservatori() {
		for (Osservatore o : osservatori) {
			o.aggiorna(this);
		}
	}
}
