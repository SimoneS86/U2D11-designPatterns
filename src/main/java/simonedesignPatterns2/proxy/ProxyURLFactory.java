package simonedesignPatterns2.proxy;

public class ProxyURLFactory {
	private static ProxyURL proxy;

	public static ProxyURL getProxyURL() {
		if (proxy == null) {
			proxy = new ProxyURLConcreto();
		}
		return proxy;
	}
}
