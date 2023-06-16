package simonedesignPatterns2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import simonedesignPatterns2.centroControllo.CentroControllo;
import simonedesignPatterns2.exceptions.LivelloFumoInvalidoException;
import simonedesignPatterns2.exceptions.OsservatoreDuplicatoException;
import simonedesignPatterns2.proxy.ProxyURL;
import simonedesignPatterns2.proxy.ProxyURLFactory;
import simonedesignPatterns2.sonda.SondaConcreta;

@SpringBootTest
class U2D11DesignPatterns2ApplicationTests {

	private SondaConcreta sonda;
	private CentroControllo centroControllo;

	@BeforeEach
	public void setUp() throws OsservatoreDuplicatoException {
		sonda = new SondaConcreta("s1", 45.4642, 9.1900);
		centroControllo = new CentroControllo("http://host");
		sonda.aggiungiOsservatore(centroControllo);
	}

	@Test
	void testAggiornamentoLivelloFumo() throws LivelloFumoInvalidoException {
		sonda.setLivelloFumo(6);
		assertEquals(6, sonda.getLivelloFumo());
	}

	@Test
	void testNotificaOsservatori() throws LivelloFumoInvalidoException {
		MockProxyURL proxyMock = new MockProxyURL();
		ProxyURLFactory.setProxyURL(proxyMock);

		sonda.setLivelloFumo(6);

		assertEquals("http://host/alarm?idsonda=s1&lat=45.4642&lon=9.19&smokelevel=6", proxyMock.getUrl());
	}

	private static class MockProxyURL implements ProxyURL {

		private String url;

		@Override
		public void invia(String url) {
			this.url = url;
		}

		public String getUrl() {
			return url;
		}
	}

	@Test
	void contextLoads() {
	}
}
