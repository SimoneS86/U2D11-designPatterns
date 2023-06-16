package simonedesignPatterns2.sonda;

import simonedesignPatterns2.centroControllo.Osservatore;
import simonedesignPatterns2.exceptions.LivelloFumoInvalidoException;
import simonedesignPatterns2.exceptions.OsservatoreDuplicatoException;
import simonedesignPatterns2.exceptions.OsservatoreNonTrovatoException;

public interface Sonda {
	public String getId();

	public double getLatitudine();

	public double getLongitudine();

	public int getLivelloFumo();

	public void setLivelloFumo(int livelloFumo) throws LivelloFumoInvalidoException;

	public void aggiungiOsservatore(Osservatore osservatore) throws OsservatoreDuplicatoException;

	public void rimuoviOsservatore(Osservatore osservatore) throws OsservatoreNonTrovatoException;

	public void notificaOsservatori();
}
