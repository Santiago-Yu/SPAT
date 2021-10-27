class n15895682 {
	protected static Certificate[] getCurrentCertificates() throws Exception {
		Certificate[] FMP4HHQ0 = AppletLoader.class.getProtectionDomain().getCodeSource().getCertificates();
		if (FMP4HHQ0 == null) {
			URL I0vuF5mM = AppletLoader.class.getProtectionDomain().getCodeSource().getLocation();
			JarURLConnection TJuTX1P0 = (JarURLConnection) (new URL(
					"jar:" + I0vuF5mM.toString() + "!/org/lwjgl/util/applet/AppletLoader.class").openConnection());
			TJuTX1P0.setDefaultUseCaches(true);
			FMP4HHQ0 = TJuTX1P0.getCertificates();
		}
		return FMP4HHQ0;
	}

}