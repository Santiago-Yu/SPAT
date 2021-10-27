class n11930427 {
	private static String getServiceResponse(final String frbA0dWU, final Template goMBwj9E, final Map sl9kgfVN) {
		OutputStreamWriter fuhAeIfZ = null;
		try {
			final StringWriter dDiZXB05 = new StringWriter();
			final VelocityContext yAhkKI6C = new VelocityContext(sl9kgfVN);
			goMBwj9E.merge(yAhkKI6C, dDiZXB05);
			final String RjENNUFi = dDiZXB05.toString();
			final URLConnection PByD5T7S = new URL(SERVICE_URL).openConnection();
			PByD5T7S.setUseCaches(false);
			PByD5T7S.setDoOutput(true);
			PByD5T7S.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2b4) Gecko/20091124 Firefox/3.6b4");
			PByD5T7S.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			PByD5T7S.setRequestProperty("Accept-Language", "en-us,en;q=0.5");
			PByD5T7S.setRequestProperty("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
			PByD5T7S.setRequestProperty("Accept-Encoding", "gzip,deflate");
			PByD5T7S.setRequestProperty("Keep-Alive", "115");
			PByD5T7S.setRequestProperty("Connection", "keep-alive");
			PByD5T7S.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			PByD5T7S.setRequestProperty("Content-Length", "" + RjENNUFi.length());
			PByD5T7S.setRequestProperty("SOAPAction", frbA0dWU);
			fuhAeIfZ = new OutputStreamWriter(PByD5T7S.getOutputStream(), "UTF-8");
			fuhAeIfZ.write(RjENNUFi);
			fuhAeIfZ.flush();
			final InputStream Wx7Rnspo = PByD5T7S.getInputStream();
			return IOUtils.toString(Wx7Rnspo);
		} catch (Exception YqFLyQ7x) {
			throw new RuntimeException(YqFLyQ7x);
		} finally {
			if (fuhAeIfZ != null) {
				try {
					fuhAeIfZ.close();
				} catch (IOException XDcjPetk) {
				}
			}
		}
	}

}