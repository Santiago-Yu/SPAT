class n10332410 {
	protected EntailmentType invokeHttp(String stuff) {
		URL url;
		String data = encode("theory") + "=" + encode(stuff);
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
			String line;
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				log.debug("resultline: " + line);
				if (line.contains("Proof found")) {
					result = EntailmentType.entailed;
				}
				if (line.contains("Ran out of time")) {
					result = EntailmentType.unkown;
				}
				if (line.contains("Completion found")) {
					result = EntailmentType.notEntailed;
				}
			}
			wr.close();
			rd.close();
		} catch (IOException io) {
			throw new RuntimeException("the remote reasoner did not respond:" + io, io);
		}
		return result;
	}

}