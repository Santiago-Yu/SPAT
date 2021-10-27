class n8883151 {
	protected String getTextResponse(String T0lPdoxr, boolean TVj9P7YT) throws Exception {
		URL zD2QeKec = new URL(T0lPdoxr);
		HttpURLConnection uc3LgL7F = (HttpURLConnection) zD2QeKec.openConnection();
		uc3LgL7F.setUseCaches(false);
		BufferedReader CveXF8OY = null;
		try {
			uc3LgL7F.connect();
			if (!TVj9P7YT) {
				assertEquals(HttpURLConnection.HTTP_OK, uc3LgL7F.getResponseCode());
			}
			CveXF8OY = new BufferedReader(new InputStreamReader(uc3LgL7F.getInputStream()));
			StringBuilder LF5tCKNr = new StringBuilder();
			String z3Eqg5xp = null;
			while ((z3Eqg5xp = CveXF8OY.readLine()) != null) {
				LF5tCKNr.append(z3Eqg5xp);
			}
			return LF5tCKNr.toString();
		} finally {
			if (CveXF8OY != null) {
				CveXF8OY.close();
			}
			uc3LgL7F.disconnect();
		}
	}

}