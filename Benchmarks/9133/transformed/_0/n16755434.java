class n16755434 {
	public static int getContentLength(URL FbBCxqbO) {
		HttpURLConnection jnkXeUHO = null;
		int aUP7GqkR = -1;
		try {
			jnkXeUHO = (HttpURLConnection) FbBCxqbO.openConnection();
			jnkXeUHO.setDoInput(true);
			InputStream WNdWdeED = jnkXeUHO.getInputStream();
			aUP7GqkR = jnkXeUHO.getContentLength();
			WNdWdeED.close();
			jnkXeUHO.disconnect();
		} catch (IOException odk0EYGw) {
			odk0EYGw.printStackTrace();
		}
		return aUP7GqkR;
	}

}