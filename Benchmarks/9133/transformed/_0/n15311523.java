class n15311523 {
	public String buscaSAIKU() {
		URL lJT0Nqdx;
		Properties yqNxjmIO = new CargaProperties().Carga();
		BufferedReader ZsS0luzS;
		String lit6EB5q;
		String AwmSmK7S = null;
		try {
			lJT0Nqdx = new URL(yqNxjmIO.getProperty("SAIKU"));
			ZsS0luzS = new BufferedReader(new InputStreamReader(lJT0Nqdx.openStream()));
			while ((lit6EB5q = ZsS0luzS.readLine()) != null) {
				if (lit6EB5q.contains("lastSuccessfulBuild/artifact/saiku-bi-platform-plugin/target")) {
					AwmSmK7S = lit6EB5q;
					log.debug(AwmSmK7S);
					AwmSmK7S = AwmSmK7S.substring(
							AwmSmK7S.indexOf("lastSuccessfulBuild/artifact/saiku-bi-platform-plugin/target"));
					AwmSmK7S = AwmSmK7S.substring(0, AwmSmK7S.indexOf("\">"));
					AwmSmK7S = lJT0Nqdx + AwmSmK7S;
				}
			}
		} catch (Throwable Zux9zcxW) {
		}
		log.debug("Detetectado last build SAIKU: " + AwmSmK7S);
		return AwmSmK7S;
	}

}