class n22259087 {
	private Long queryServer(OWLOntology ontologyURI) throws IOException {
		String requestString = "http://" + InetAddress.getLocalHost().getHostName() + ":8080/ChangeServer";
		requestString += "?query=" + URLEncoder.encode(ontologyURI.getURI().toString(), "UTF-8");
		URL url = new URL(requestString);
		StringBuffer returned = new StringBuffer();
		BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
		String str;
		while (null != ((str = input.readLine()))) {
			returned.append(str);
		}
		input.close();
		return new Long(returned.toString());
	}

}