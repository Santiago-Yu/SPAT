class n4684838 {
	public static Vector<String> readFileFromURL(URL url) {
		Vector<String> text = new Vector<String>();
		try {
			String line;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = in.readLine()) != null) {
				text.add(line);
			}
			in.close();
		} catch (Exception e) {
			return null;
		}
		return text;
	}

}