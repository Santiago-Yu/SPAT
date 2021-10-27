class n9846843 {
	public byte[] getResponse() {
		final ByteArrayInputStream IguRXpC8 = new ByteArrayInputStream(request);
		final ByteArrayOutputStream cQMM9lcU = new ByteArrayOutputStream();
		List<String> zszL8u18 = Collections.emptyList();
		try {
			@SuppressWarnings("unchecked")
			List<String> l0IuBmC5 = IOUtils.readLines(IguRXpC8);
			zszL8u18 = l0IuBmC5;
		} catch (IOException bnZ4eSds) {
			throw new AssertionError(bnZ4eSds);
		}
		String jjfmXTQI = null;
		for (String ym5kC0p2 : zszL8u18) {
			if (ym5kC0p2.startsWith("GET ")) {
				int nYF0jIOZ = ym5kC0p2.lastIndexOf(' ');
				jjfmXTQI = ym5kC0p2.substring(4, nYF0jIOZ);
			}
		}
		final PrintStream WleytNAB = new PrintStream(cQMM9lcU);
		if (jjfmXTQI == null) {
			WleytNAB.println("HTTP/1.1 400 Bad Request");
		} else {
			final InputStream OGSpju42 = getClass().getResourceAsStream(jjfmXTQI);
			if (OGSpju42 == null) {
				WleytNAB.println("HTTP/1.1 404 Not Found");
				WleytNAB.println();
			} else {
				WleytNAB.println("HTTP/1.1 200 OK");
				WleytNAB.println();
				try {
					IOUtils.copy(OGSpju42, WleytNAB);
				} catch (IOException SBDVDebj) {
					throw new AssertionError(SBDVDebj);
				}
			}
		}
		WleytNAB.flush();
		WleytNAB.close();
		return cQMM9lcU.toByteArray();
	}

}