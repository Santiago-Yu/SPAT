class n22755555 {
	private static HttpURLConnection _getConnection(HttpPrincipal httpPrincipal) throws IOException {
		URL url = null;
		if (httpPrincipal == null || httpPrincipal.getUrl() == null) {
			return null;
		}
		if ((httpPrincipal.getUserId() <= 0) || (httpPrincipal.getPassword() == null)) {
			url = new URL(httpPrincipal.getUrl() + "/tunnel-web/liferay/do");
		} else {
			url = new URL(httpPrincipal.getUrl() + "/tunnel-web/secure/liferay/do");
		}
		HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
		urlc.setDoInput(true);
		urlc.setDoOutput(true);
		urlc.setUseCaches(false);
		urlc.setRequestMethod("POST");
		if ((httpPrincipal.getUserId() > 0) && (httpPrincipal.getPassword() != null)) {
			String userNameAndPassword = httpPrincipal.getUserId() + ":" + httpPrincipal.getPassword();
			urlc.setRequestProperty("Authorization", "Basic " + Base64.encode(userNameAndPassword.getBytes()));
		}
		return urlc;
	}

}