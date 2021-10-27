class n23213941 {
	@Override
	protected void writeSnapshot(final String message, final String details) {
		try {
			final URL url = proxyAddress == null ? new URL(url_spec)
					: new URL("http", proxyAddress, proxyPort, url_spec);
			LOG.info("connect to " + url);
			final URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			final HttpQueryWriter out = new HttpQueryWriter(connection.getOutputStream());
			out.addParameter("error", message);
			out.addParameter("trace", details);
			out.close();
			final InputStream in = connection.getInputStream();
			int c;
			final StringBuffer result = new StringBuffer();
			for (; (c = in.read()) != -1;) {
				result.append((char) c);
			}
			LOG.info(result);
			in.close();
		} catch (final UnknownHostException e) {
			LOG.info("could not find host (unknown host) to submit log to");
		} catch (final IOException e) {
			LOG.debug("i/o problem submitting log", e);
		}
	}

}