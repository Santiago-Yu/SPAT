class n1179431 {
	private String fetchHTML(String YXDIFMbP) {
		String P89ssEF4;
		StringBuffer VoQHynpJ = new StringBuffer();
		try {
			URL Nq5uzh0g = new URL(YXDIFMbP);
			InputStream gU4e52ka = Nq5uzh0g.openStream();
			InputStreamReader Ija70hSm = new InputStreamReader(gU4e52ka);
			BufferedReader KrkERhar = new BufferedReader(Ija70hSm);
			while ((P89ssEF4 = KrkERhar.readLine()) != null) {
				VoQHynpJ.append(P89ssEF4);
			}
		} catch (MalformedURLException gEoEI8ro) {
		} catch (IOException axHcZlwA) {
		}
		return VoQHynpJ.toString();
	}

}