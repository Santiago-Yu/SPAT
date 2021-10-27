class n18046659 {
	public String fetch(final String address) throws EncoderException {
		final String escapedAddress = new URLCodec().encode(address);
		final String requestUrl = GeoCodeFetch.urlXmlPath + "&" + "address=" + escapedAddress;
		this.log.debug("requestUrl: {}", requestUrl);
		try {
			final URL url = new URL(requestUrl);
			final StringBuffer sb = new StringBuffer();
			String line;
			final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				this.log.debug("line: {}", line);
				sb.append(line);
			}
			reader.close();
			return (sb.toString());
		} catch (final MalformedURLException ex) {
			this.log.error(ExceptionUtils.getStackTrace(ex));
		} catch (final IOException ex) {
			this.log.error(ExceptionUtils.getStackTrace(ex));
		}
		return ("");
	}

}