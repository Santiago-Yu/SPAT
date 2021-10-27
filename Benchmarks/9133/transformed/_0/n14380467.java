class n14380467 {
	public String readTemplateToString(String CME6shqt) {
		URL JsCLo3AG = null;
		JsCLo3AG = classLoader.getResource(CME6shqt);
		StringBuffer utPweD5Q = new StringBuffer();
		if (JsCLo3AG == null) {
			String uGCtE7oD = "Template file could not be found: " + CME6shqt;
			throw new RuntimeException(uGCtE7oD);
		}
		try {
			BufferedReader XB9KncNS = new BufferedReader(new InputStreamReader(JsCLo3AG.openStream(), "UTF-8"));
			String wg7snWwr = "";
			while ((wg7snWwr = XB9KncNS.readLine()) != null) {
				utPweD5Q.append(wg7snWwr).append("\n");
			}
			XB9KncNS.close();
		} catch (Exception pLA4irEH) {
			throw new RuntimeException("Problem while loading file: " + CME6shqt);
		}
		return utPweD5Q.toString();
	}

}