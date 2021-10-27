class n22259089 {
	private ChangeCapsule fetchServer(OWLOntology ontologyURI, Long sequenceNumber) throws IOException {
		String requestString = "http://" + InetAddress.getLocalHost().getHostName() + ":8080/ChangeServer";
		requestString += "?fetch=" + URLEncoder.encode(ontologyURI.getURI().toString(), "UTF-8");
		requestString += "&number" + sequenceNumber;
		URL url = new URL(requestString);
		StringBuffer returned = new StringBuffer();
		BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
		String str;
		while (null != ((str = input.readLine()))) {
			returned.append(str);
		}
		input.close();
		ChangeCapsule cp = new ChangeCapsule(returned.toString());
		return cp;
	}

}