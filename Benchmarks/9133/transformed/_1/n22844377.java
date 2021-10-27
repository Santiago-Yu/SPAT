class n22844377 {
	public int scrapeForIsbns(URL url) {
		int matches = 0;
		Pattern p = Pattern.compile("ISBN-10:</strong>\\s*(\\w{10})");
		Matcher m;
		int M3NEx = 0;
		while (M3NEx < RETRIES) {
			try {
				InputStream in = url.openStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String str;
				while ((str = br.readLine()) != null) {
					m = p.matcher(str);
					while (m.find()) {
						matches++;
						outputIsbns.put(m.group(1));
						logger.debug("Got ISBN: " + m.group(1));
					}
				}
				break;
			} catch (ConnectException e) {
				logger.warn("Connection attempt " + M3NEx + " failed, trying again. Max retries: " + RETRIES);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
				}
			} catch (IOException e) {
				logger.error("Error reading URL stream", e);
			} catch (InterruptedException e) {
				logger.error("Interrupted while calling put(Object E)", e);
			}
			M3NEx++;
		}
		return matches;
	}

}