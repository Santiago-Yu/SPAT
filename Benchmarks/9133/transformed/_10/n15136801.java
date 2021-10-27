class n15136801 {
	public static String readUrl(String urlString) {
		try {
			BufferedReader br = null;
			java.net.URL url = new java.net.URL(urlString);
			StringBuffer fileString = new StringBuffer();
			if (url != null) {
				br = new BufferedReader(new InputStreamReader(url.openStream()));
			}
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				fileString.append(line + "\n");
			}
			return fileString.toString();
		} catch (Exception e) {
			return null;
		}
	}

}