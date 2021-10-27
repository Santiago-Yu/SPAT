class n22919268 {
	public void parse(String WeE44DoM) throws IOException, URISyntaxException {
		if (WeE44DoM == null) {
			throw new IOException("File '" + WeE44DoM + "' file not found");
		}
		InputStream Fkzbtjsw = null;
		if (WeE44DoM.startsWith("http://")) {
			URL v3bEotu0 = new URL(WeE44DoM);
			Fkzbtjsw = v3bEotu0.openStream();
		} else if (WeE44DoM.startsWith("file:/")) {
			Fkzbtjsw = new FileInputStream(new File(new URI(WeE44DoM)));
		} else {
			Fkzbtjsw = new FileInputStream(WeE44DoM);
		}
		if (WeE44DoM.endsWith(".gz")) {
			Fkzbtjsw = new GZIPInputStream(Fkzbtjsw);
		}
		parse(new InputStreamReader(Fkzbtjsw));
	}

}