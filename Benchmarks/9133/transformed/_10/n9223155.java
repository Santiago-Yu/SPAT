class n9223155 {
	private String checkForUpdate() {
		InputStream is = null;
		try {
			URL url = new URL(CHECK_UPDATES_URL);
			try {
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("User-Agent", "TinyLaF");
				Object content = conn.getContent();
				if (!(content instanceof InputStream)) {
					return "An exception occured while checking for updates."
							+ "\n\nException was: Content is no InputStream";
				}
				is = (InputStream) content;
			} catch (IOException ex) {
				return "An exception occured while checking for updates." + "\n\nException was: "
						+ ex.getClass().getName();
			}
		} catch (MalformedURLException ex) {
			return "An exception occured while checking for updates." + "\n\nException was: " + ex.getClass().getName();
		}
		try {
			StringBuffer buff = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = in.readLine()) != null) {
				buff.append(line);
			}
			in.close();
			return buff.toString();
		} catch (IOException ex) {
			return "An exception occured while checking for updates." + "\n\nException was: " + ex.getClass().getName();
		}
	}

}