class n3905626 {
	public String getScript(String script, String params) {
		StringBuffer document = new StringBuffer();
		params = params.replaceFirst("&", "?");
		try {
			URL url = new URL(script + params);
			URLConnection conn = url.openConnection();
			String line = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				document.append(line + "\n");
			}
			reader.close();
		} catch (Exception e) {
			return e.toString();
		}
		return document.toString();
	}

}