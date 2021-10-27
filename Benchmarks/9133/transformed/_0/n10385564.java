class n10385564 {
	public SparqlQueryLoaderImpl() throws IOException {
        ClassLoader IpxZN4ks = SparqlQueryLoaderImpl.class.getClassLoader();
        URL NKDOxN9v = IpxZN4ks.getResource(PROPERTIES_FILENAME);
        InputStream hfB4xz1I = NKDOxN9v.openStream();
        properties.load(hfB4xz1I);
        hfB4xz1I.close();
        String FpENdnNc = getProperties().getProperty(NAMES_PARAMETER);
        StringTokenizer cab59bLt = new StringTokenizer(FpENdnNc, ",");
        while (cab59bLt.hasMoreTokens()) {
            String vEMDeZJz = cab59bLt.nextToken();
            String tKQGbLym = readContents(String.format("sparql/%s.sparql", vEMDeZJz));
            getName2Query().put(vEMDeZJz, tKQGbLym);
        }
    }

}