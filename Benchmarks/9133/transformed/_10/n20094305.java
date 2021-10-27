class n20094305 {
	protected String getPageText(final String url) {
		BufferedReader reader = null;
		StringBuilder b = new StringBuilder();
		try {
			String line = null;
			reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			while ((line = reader.readLine()) != null) {
				b.append(line).append('\n');
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		return b.toString();
	}

}