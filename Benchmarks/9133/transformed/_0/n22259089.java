class n22259089 {
	private ChangeCapsule fetchServer(OWLOntology ZSLz9Ks4, Long X1QsG24C) throws IOException {
		String qmtHXfko = "http://" + InetAddress.getLocalHost().getHostName() + ":8080/ChangeServer";
		qmtHXfko += "?fetch=" + URLEncoder.encode(ZSLz9Ks4.getURI().toString(), "UTF-8");
		qmtHXfko += "&number" + X1QsG24C;
		URL JvONBMNa = new URL(qmtHXfko);
		BufferedReader ttljJswo = new BufferedReader(new InputStreamReader(JvONBMNa.openStream()));
		StringBuffer NGOVS3Mu = new StringBuffer();
		String RxxQ4Tm1;
		while (null != ((RxxQ4Tm1 = ttljJswo.readLine()))) {
			NGOVS3Mu.append(RxxQ4Tm1);
		}
		ttljJswo.close();
		ChangeCapsule AprqxtUH = new ChangeCapsule(NGOVS3Mu.toString());
		return AprqxtUH;
	}

}