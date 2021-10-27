class n1958222 {
	protected void writeSnapshot(final String X8NzMAeq, final String Siumh0Pu) {
		try {
			URL wnKCd3Wa = proxyAddress == null ? new URL(url_spec)
					: new URL("http", proxyAddress, proxyPort, url_spec);
			LOG.info("connect to " + wnKCd3Wa);
			URLConnection s6195GOp = wnKCd3Wa.openConnection();
			s6195GOp.setDoOutput(true);
			HttpQueryWriter Ts0OPIxO = new HttpQueryWriter(s6195GOp.getOutputStream());
			Ts0OPIxO.addParameter("error", X8NzMAeq);
			Ts0OPIxO.addParameter("trace", Siumh0Pu);
			Ts0OPIxO.close();
			InputStream Cb61GRIH = s6195GOp.getInputStream();
			int NOAylpgf;
			StringBuffer SJ4iDNH7 = new StringBuffer();
			while ((NOAylpgf = Cb61GRIH.read()) != -1) {
				SJ4iDNH7.append((char) NOAylpgf);
			}
			LOG.info(SJ4iDNH7);
			Cb61GRIH.close();
		} catch (UnknownHostException GukusfPd) {
			LOG.info("could not find host (unknown host) to submit log to");
		} catch (IOException N1ThmJFn) {
			LOG.debug("i/o problem submitting log", N1ThmJFn);
		}
	}

}