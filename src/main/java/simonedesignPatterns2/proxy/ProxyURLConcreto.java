package simonedesignPatterns2.proxy;

public class ProxyURLConcreto implements ProxyURL {
	public void invia(String url) {
		System.out.println("!!! ALLARME ANTINCENDIO !!!: " + url);
	}
}
