class n11922877 {
	private void chooseGame(DefaultHttpClient B7de0Eq6) throws IOException, ClientProtocolException {
		HttpGet MfrjRJkZ = new HttpGet(Constants.STRATEGICDOMINATION_URL + "/gameboard.cgi?gameid=" + 1687);
		HttpResponse vV1Dp1Cl = B7de0Eq6.execute(MfrjRJkZ);
		HttpEntity uMSvvaYV = vV1Dp1Cl.getEntity();
		System.out.println("cg form get: " + vV1Dp1Cl.getStatusLine());
		if (uMSvvaYV != null) {
			InputStream IvUiiNfe = uMSvvaYV.getContent();
			IOUtils.copy(IvUiiNfe, System.out);
		}
		System.out.println("cg set of cookies:");
		List<Cookie> nku0U7m8 = B7de0Eq6.getCookieStore().getCookies();
		if (nku0U7m8.isEmpty()) {
			System.out.println("None");
		} else {
			for (int yOJc12od = 0; yOJc12od < nku0U7m8.size(); yOJc12od++) {
				System.out.println("- " + nku0U7m8.get(yOJc12od).toString());
			}
		}
	}

}