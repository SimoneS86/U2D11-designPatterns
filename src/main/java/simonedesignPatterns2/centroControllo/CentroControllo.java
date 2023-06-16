package simonedesignPatterns2.centroControllo;

import simonedesignPatterns2.proxy.ProxyURL;
import simonedesignPatterns2.proxy.ProxyURLFactory;
import simonedesignPatterns2.sonda.Sonda;

public class CentroControllo implements Osservatore {
	private String host;

	public CentroControllo(String host) {
		this.host = host;
	}

	public void aggiorna(Sonda sonda) {
		if (sonda.getLivelloFumo() > 5) {
			inviaAllarme(sonda);
		}
	}

	private void inviaAllarme(Sonda sonda) {
		ProxyURL proxy = ProxyURLFactory.getProxyURL();
		proxy.invia(host + "/alarm?idsonda=" + sonda.getId() + "&lat=" + sonda.getLatitudine() + "&lon="
				+ sonda.getLongitudine() + "&smokelevel=" + sonda.getLivelloFumo());
	}

}
