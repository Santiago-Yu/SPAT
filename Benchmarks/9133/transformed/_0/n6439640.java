class n6439640 {
	public Properties load() {
		Properties pCDTi2uS = new Properties();
		try {
			InputStream o3jpJEJE = url.openStream();
			pCDTi2uS.load(o3jpJEJE);
		} catch (Exception xVXqWyAc) {
			throw new PropertiesLoadException("Error in load-method:", xVXqWyAc);
		}
		return pCDTi2uS;
	}

}