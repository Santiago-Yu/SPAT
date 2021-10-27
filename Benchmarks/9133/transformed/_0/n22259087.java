class n22259087 {
	private Long queryServer(OWLOntology X28s6HJr) throws IOException {
		String kC6pnpeC = "http://" + InetAddress.getLocalHost().getHostName() + ":8080/ChangeServer";
		kC6pnpeC += "?query=" + URLEncoder.encode(X28s6HJr.getURI().toString(), "UTF-8");
		URL hivctzG5 = new URL(kC6pnpeC);
		BufferedReader TIGfNEp2 = new BufferedReader(new InputStreamReader(hivctzG5.openStream()));
		StringBuffer dAJx70wa = new StringBuffer();
		String jkBhxsHl;
		while (null != ((jkBhxsHl = TIGfNEp2.readLine()))) {
			dAJx70wa.append(jkBhxsHl);
		}
		TIGfNEp2.close();
		return new Long(dAJx70wa.toString());
	}

}