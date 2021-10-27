class n10055931 {
	private static Vector<String> getIgnoreList() {
		try {
			URL url = DeclarationTranslation.class.getClassLoader().getResource("ignorelist");
			Vector<String> ret = new Vector<String>();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				ret.add(line);
			}
			return ret;
		} catch (Exception e) {
			return null;
		}
	}

}