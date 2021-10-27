class n8565955 {
	private static String webService(String strUrl) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(strUrl);
			String sCurrentLine = "";
			InputStream input = url.openStream();
			InputStreamReader read = new InputStreamReader(input, "utf-8");
			BufferedReader l_reader = new java.io.BufferedReader(read);
			while ((sCurrentLine = l_reader.readLine()) != null) {
				buffer.append(sCurrentLine);
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}