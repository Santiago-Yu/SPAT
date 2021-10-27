class n1958222 {
	protected void writeSnapshot(final String message, final String details) {
		try {
			URL url = null == proxyAddress ? new URL(url_spec) : new URL("http", proxyAddress, proxyPort, url_spec);
			LOG.info("connect to " + url);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			HttpQueryWriter out = new HttpQueryWriter(connection.getOutputStream());
			out.addParameter("error", message);
			out.addParameter("trace", details);
			out.close();
			InputStream in = connection.getInputStream();
			int c;
			StringBuffer result = new StringBuffer();
			while ((c = in.read()) != -1) {
				result.append((char) c);
			}
			LOG.info(result);
			in.close();
		} catch (UnknownHostException e) {
			LOG.info("could not find host (unknown host) to submit log to");
		} catch (IOException e) {
			LOG.debug("i/o problem submitting log", e);
		}
	}

}