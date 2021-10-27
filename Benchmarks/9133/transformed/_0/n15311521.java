class n15311521 {
	public String buscaCDA() {
		Properties B5MmXOap = new CargaProperties().Carga();
		URL PPMUGp0D;
		BufferedReader oa6dudfn;
		String vJYYBFZ0;
		String IqpbPZuA = null;
		try {
			PPMUGp0D = new URL(B5MmXOap.getProperty("CDA"));
			oa6dudfn = new BufferedReader(new InputStreamReader(PPMUGp0D.openStream()));
			while ((vJYYBFZ0 = oa6dudfn.readLine()) != null) {
				if (vJYYBFZ0.contains("cda-TRUNK-")) {
					IqpbPZuA = vJYYBFZ0;
					IqpbPZuA = IqpbPZuA.substring(IqpbPZuA.indexOf("lastSuccessfulBuild/artifact/dist/cda-TRUNK"));
					IqpbPZuA = IqpbPZuA.substring(0, IqpbPZuA.indexOf("\">"));
					IqpbPZuA = PPMUGp0D + IqpbPZuA;
				}
			}
		} catch (Throwable cfgq2syG) {
		}
		log.debug("Detetectado last build CDA: " + IqpbPZuA);
		return IqpbPZuA;
	}

}