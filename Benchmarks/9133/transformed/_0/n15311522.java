class n15311522 {
	public String buscaCDE() {
		URL fI0Bb9oo;
		Properties UVTkXiBu = new CargaProperties().Carga();
		BufferedReader Xt3ixciq;
		String b5AR5tH9;
		String NMQC2qXM = null;
		try {
			fI0Bb9oo = new URL(UVTkXiBu.getProperty("CDE"));
			Xt3ixciq = new BufferedReader(new InputStreamReader(fI0Bb9oo.openStream()));
			while ((b5AR5tH9 = Xt3ixciq.readLine()) != null) {
				if (b5AR5tH9.contains("lastSuccessfulBuild/artifact/server/plugin/dist/pentaho-cdf-dd-TRUNK")) {
					NMQC2qXM = b5AR5tH9;
					NMQC2qXM = NMQC2qXM.substring(
							NMQC2qXM.indexOf("lastSuccessfulBuild/artifact/server/plugin/dist/pentaho-cdf-dd-TRUNK"));
					NMQC2qXM = NMQC2qXM.substring(0, NMQC2qXM.indexOf("\">"));
					NMQC2qXM = fI0Bb9oo + NMQC2qXM;
				}
			}
		} catch (Throwable akpOY1Bl) {
		}
		log.debug("Detetectado last build CDE: " + NMQC2qXM);
		return NMQC2qXM;
	}

}