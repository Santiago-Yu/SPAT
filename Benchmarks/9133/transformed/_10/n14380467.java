class n14380467 {
	public String readTemplateToString(String fileName) {
		URL url = null;
		StringBuffer content = new StringBuffer();
		url = classLoader.getResource(fileName);
		if (url == null) {
			String error = "Template file could not be found: " + fileName;
			throw new RuntimeException(error);
		}
		try {
			String strLine = "";
			BufferedReader breader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			while ((strLine = breader.readLine()) != null) {
				content.append(strLine).append("\n");
			}
			breader.close();
		} catch (Exception e) {
			throw new RuntimeException("Problem while loading file: " + fileName);
		}
		return content.toString();
	}

}