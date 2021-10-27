class n14658498 {
	private Properties loadPropertiesFromURL(String propertiesURL, Properties defaultProperties) {
		URL url;
		Properties properties = new Properties(defaultProperties);
		try {
			url = new URL(propertiesURL);
			URLConnection urlConnection = url.openConnection();
			properties.load(urlConnection.getInputStream());
		} catch (MalformedURLException e) {
			System.out.println("Error while loading url " + propertiesURL + " (" + e.getClass().getName() + ")");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while loading url " + propertiesURL + " (" + e.getClass().getName() + ")");
			e.printStackTrace();
		}
		return properties;
	}

}