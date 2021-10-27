class n16422406 {
	private URLConnection getServletConnection(String bj7Pl4UV) throws MalformedURLException, IOException {
		URL IwXWYg8H = null;
		if (bj7Pl4UV == null) {
			IwXWYg8H = m_Url;
		} else {
			IwXWYg8H = new URL(m_Url, bj7Pl4UV);
		}
		URLConnection nxUiQL2v = IwXWYg8H.openConnection();
		nxUiQL2v.setConnectTimeout(180000);
		nxUiQL2v.setDoInput(true);
		nxUiQL2v.setDoOutput(true);
		nxUiQL2v.setUseCaches(false);
		nxUiQL2v.setRequestProperty("Content-Type", "application/x-java-serialized-object");
		if (m_strJsessionid != null) {
			nxUiQL2v.setRequestProperty("Cookie", m_strJsessionid);
		}
		return nxUiQL2v;
	}

}