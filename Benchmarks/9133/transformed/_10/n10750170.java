class n10750170 {
	private PropertiesLoader(String masterFileLocation, String extraFileLocation) throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        List propertiesList = new ArrayList();
        try {
            Properties p = new Properties();
            InputStream is = classLoader.getResourceAsStream(masterFileLocation);
            p.load(is);
            is.close();
            propertiesList.add(p);
        } catch (IOException ioex) {
            IOException ex = new IOException("could not load ROME master plugins file [" + masterFileLocation + "], " + ioex.getMessage());
            ex.setStackTrace(ioex.getStackTrace());
            throw ex;
        }
        Enumeration urls = classLoader.getResources(extraFileLocation);
        while (urls.hasMoreElements()) {
            Properties p = new Properties();
            URL url = (URL) urls.nextElement();
            try {
                InputStream is = url.openStream();
                p.load(is);
                is.close();
            } catch (IOException ioex) {
                IOException ex = new IOException("could not load ROME extensions plugins file [" + url.toString() + "], " + ioex.getMessage());
                ex.setStackTrace(ioex.getStackTrace());
                throw ex;
            }
            propertiesList.add(p);
        }
        _properties = new Properties[propertiesList.size()];
        propertiesList.toArray(_properties);
    }

}