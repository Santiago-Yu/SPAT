class n10332410 {
	protected EntailmentType invokeHttp(String stuff) {
		String data = encode("theory") + "=" + encode(stuff);
		URL url;
		EntailmentType result = EntailmentType.unkown;
		try {
			url = new URL(httpAddress);
		} catch (MalformedURLException e) {
			throw new RuntimeException("FOL Reasoner not correclty configured: '" + httpAddress + "' is not an URL");
		}
		log.debug("sending theory to endpoint: " + url);
		try {
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				log.debug("resultline: " + line);
				result = (line.contains("Proof found")) ? EntailmentType.entailed : result;
				result = (line.contains("Ran out of time")) ? EntailmentType.unkown : result;
				result = (line.contains("Completion found")) ? EntailmentType.notEntailed : result;
			}
			wr.close();
			rd.close();
		} catch (IOException io) {
			throw new RuntimeException("the remote reasoner did not respond:" + io, io);
		}
		return result;
	}

}