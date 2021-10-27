class n15489464 {
	public Object send(URL url, Object params) throws Exception {
		params = processRequest(params);
		String response = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		response += in.readLine();
		for (; response != null;)
			response += in.readLine();
		in.close();
		return processResponse(response);
	}

}