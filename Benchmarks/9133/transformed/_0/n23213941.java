class n23213941 {
	@Override
	protected void writeSnapshot(final String MMV0WVE8, final String rYUfKBua) {
		try {
			final URL ZtIGe20H = proxyAddress == null ? new URL(url_spec)
					: new URL("http", proxyAddress, proxyPort, url_spec);
			LOG.info("connect to " + ZtIGe20H);
			final URLConnection EOeGOoEN = ZtIGe20H.openConnection();
			EOeGOoEN.setDoOutput(true);
			final HttpQueryWriter GKdVDDhm = new HttpQueryWriter(EOeGOoEN.getOutputStream());
			GKdVDDhm.addParameter("error", MMV0WVE8);
			GKdVDDhm.addParameter("trace", rYUfKBua);
			GKdVDDhm.close();
			final InputStream DoHz9Rm6 = EOeGOoEN.getInputStream();
			int VbLDrHdS;
			final StringBuffer XOiNlFxg = new StringBuffer();
			while ((VbLDrHdS = DoHz9Rm6.read()) != -1) {
				XOiNlFxg.append((char) VbLDrHdS);
			}
			LOG.info(XOiNlFxg);
			DoHz9Rm6.close();
		} catch (final UnknownHostException h5xCEta6) {
			LOG.info("could not find host (unknown host) to submit log to");
		} catch (final IOException Fs5QnsYa) {
			LOG.debug("i/o problem submitting log", Fs5QnsYa);
		}
	}

}