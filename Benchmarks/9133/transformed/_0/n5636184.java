class n5636184 {
	public static Element postMessage() throws Exception {
		final URL NpN3AVjn = getHostURL();
		lf.debug("url = " + NpN3AVjn.toExternalForm());
		final HttpURLConnection h9vyysAy = (HttpURLConnection) (NpN3AVjn).openConnection();
		h9vyysAy.setRequestMethod("POST");
		h9vyysAy.setDoInput(true);
		h9vyysAy.setDoOutput(true);
		final BufferedOutputStream oYm4SN2G = new BufferedOutputStream(h9vyysAy.getOutputStream());
		final InputStream X6KIJdxM = h9vyysAy.getInputStream();
		final ByteArrayOutputStream IcbYQLn7 = new ByteArrayOutputStream();
		final byte[] pbSyYZuy = new byte[1024];
		int puXnQvKP = 0;
		while ((puXnQvKP = X6KIJdxM.read(pbSyYZuy)) > -1) {
			IcbYQLn7.write(pbSyYZuy, 0, puXnQvKP);
		}
		final SAXBuilder V7yW1tT6 = new SAXBuilder();
		lf.debug("Received XML response from server: " + IcbYQLn7.toString());
		return V7yW1tT6.build(new StringReader(IcbYQLn7.toString())).getRootElement();
	}

}