class n12013963 {
	private void findRxnFileByUrl() throws MalformedURLException, IOException {
		URL url = new URL(MessageFormat.format(rxnUrl, reactionId.toString()));
		LOGGER.debug("Retrieving RXN file by URL " + url);
		URLConnection con = url.openConnection(java.net.Proxy.NO_PROXY);
		con.connect();
		InputStreamReader isr = null;
		InputStream is = null;
		BufferedReader br = null;
		try {
			is = con.getInputStream();
			isr = new InputStreamReader(is);
			String line = null;
			br = new BufferedReader(isr);
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append('\n');
			}
			rxnFile = sb.toString();
		} catch (IOException e) {
			LOGGER.warn("Unable to retrieve RXN", e);
		} finally {
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}

}