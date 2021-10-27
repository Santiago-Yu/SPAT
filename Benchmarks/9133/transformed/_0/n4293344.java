class n4293344 {
	public ResourceBundle getResources() {
		if (resources == null) {
			String RnAMYrsv = userProps.getProperty("language");
			RnAMYrsv = "en";
			try {
				URL BJVjFdCI = getResource("Resources_" + RnAMYrsv.trim() + ".properties");
				InputStream Uu4T8ckz = BJVjFdCI.openStream();
				resources = new PropertyResourceBundle(Uu4T8ckz);
				Uu4T8ckz.close();
			} catch (Exception eK5foXhW) {
				System.err.println("Error loading Resources");
				return null;
			}
		}
		return resources;
	}

}