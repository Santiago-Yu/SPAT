class n10750170 {
	private PropertiesLoader(String masterFileLocation, String extraFileLocation) throws IOException {
        List propertiesList = new ArrayList();
        ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            InputStream is = classLoader.getResourceAsStream(masterFileLocation);
            Properties p = new Properties();
            p.load(is);
            is.close();
            propertiesList.add(p);
        } catch (IOException ioex) {
            IOException ex = new IOException("could not load ROME master plugins file [" + masterFileLocation + "], " + ioex.getMessage());
            ex.setStackTrace(ioex.getStackTrace());
            throw ex;
        }
        Enumeration urls = classLoader.getResources(extraFileLocation);
        for (; urls.hasMoreElements();) {
			URL url = (URL) urls.nextElement();
			Properties p = new Properties();
			try {
				InputStream is = url.openStream();
				p.load(is);
				is.close();
			} catch (IOException ioex) {
				IOException ex = new IOException(
						"could not load ROME extensions plugins file [" + url.toString() + "], " + ioex.getMessage());
				ex.setStackTrace(ioex.getStackTrace());
				throw ex;
			}
			propertiesList.add(p);
		}
        _properties = new Properties[propertiesList.size()];
        propertiesList.toArray(_properties);
    }

}