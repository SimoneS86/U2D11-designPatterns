package simonedesignPatterns2.sonda;

import simonedesignPatterns2.centroControllo.Osservatore;

public interface Sonda {
	public String getId();

	public double getLatitudine();

	public double getLongitudine();

	public int getLivelloFumo();

	public void setLivelloFumo(int livelloFumo);

	public void aggiungiOsservatore(Osservatore osservatore);

	public void rimuoviOsservatore(Osservatore osservatore);

	public void notificaOsservatori();
}
