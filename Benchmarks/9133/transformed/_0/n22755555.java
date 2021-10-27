class n22755555 {
	private static HttpURLConnection _getConnection(HttpPrincipal Opg0D5px) throws IOException {
		if (Opg0D5px == null || Opg0D5px.getUrl() == null) {
			return null;
		}
		URL PrHSxXQJ = null;
		if ((Opg0D5px.getUserId() <= 0) || (Opg0D5px.getPassword() == null)) {
			PrHSxXQJ = new URL(Opg0D5px.getUrl() + "/tunnel-web/liferay/do");
		} else {
			PrHSxXQJ = new URL(Opg0D5px.getUrl() + "/tunnel-web/secure/liferay/do");
		}
		HttpURLConnection Y88adM4J = (HttpURLConnection) PrHSxXQJ.openConnection();
		Y88adM4J.setDoInput(true);
		Y88adM4J.setDoOutput(true);
		Y88adM4J.setUseCaches(false);
		Y88adM4J.setRequestMethod("POST");
		if ((Opg0D5px.getUserId() > 0) && (Opg0D5px.getPassword() != null)) {
			String YVO0oeTm = Opg0D5px.getUserId() + ":" + Opg0D5px.getPassword();
			Y88adM4J.setRequestProperty("Authorization", "Basic " + Base64.encode(YVO0oeTm.getBytes()));
		}
		return Y88adM4J;
	}

}