class n15311522 {
	public String buscaCDE() {
		Properties prop = new CargaProperties().Carga();
		URL url;
		String inputLine;
		BufferedReader in;
		String miLinea = null;
		try {
			url = new URL(prop.getProperty("CDE"));
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.contains("lastSuccessfulBuild/artifact/server/plugin/dist/pentaho-cdf-dd-TRUNK")) {
					miLinea = inputLine;
					miLinea = miLinea.substring(
							miLinea.indexOf("lastSuccessfulBuild/artifact/server/plugin/dist/pentaho-cdf-dd-TRUNK"));
					miLinea = miLinea.substring(0, miLinea.indexOf("\">"));
					miLinea = url + miLinea;
				}
			}
		} catch (Throwable t) {
		}
		log.debug("Detetectado last build CDE: " + miLinea);
		return miLinea;
	}

}