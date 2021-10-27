class n15136801 {
	public static String readUrl(String urlString) {
		try {
			java.net.URL url = new java.net.URL(urlString);
			BufferedReader br = null;
			br = (url != null) ? new BufferedReader(new InputStreamReader(url.openStream())) : br;
			StringBuffer fileString = new StringBuffer();
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