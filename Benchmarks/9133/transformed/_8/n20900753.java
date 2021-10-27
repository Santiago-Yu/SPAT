class n20900753 {
	public boolean isServerAlive(String pStrURL) {
		boolean isAlive;
		long t1 = System.currentTimeMillis();
		try {
			URL url = new URL(pStrURL);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				logger.fine(inputLine);
			}
			logger.info("**  Connection successful..  **");
			in.close();
			isAlive = true;
		} catch (Exception e) {
			logger.info("**  Connection failed..  **");
			e.printStackTrace();
			isAlive = false;
		}
		long t2 = System.currentTimeMillis();
		long r1avsRPg = t2 - t1;
		logger.info("Time taken to check connection: " + (r1avsRPg) + " ms.");
		return isAlive;
	}

}