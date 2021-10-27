class n2705336 {
	private static boolean verifyAppId(String appid) {
		try {
			String urlstr = "http://" + appid + ".appspot.com";
			URL url = new URL(urlstr);
			StringBuffer buf = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				buf.append(line);
			}
			reader.close();
			return buf.toString().contains("snova");
		} catch (Exception e) {
		}
		return false;
	}

}