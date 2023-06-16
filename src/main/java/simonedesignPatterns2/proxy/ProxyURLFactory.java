package simonedesignPatterns2.proxy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProxyURLFactory {
	private static ProxyURL proxy;

	public static void setProxyURL(ProxyURL proxyURL) {
		proxy = proxyURL;
	}

	public static ProxyURL getProxyURL() {
		if (proxy == null) {
			proxy = new ProxyURLConcreto();
		}
		return proxy;
	}
}
