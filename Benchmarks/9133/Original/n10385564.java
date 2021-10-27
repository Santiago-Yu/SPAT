class n10385564{
    public SparqlQueryLoaderImpl() throws IOException {
        ClassLoader loader = SparqlQueryLoaderImpl.class.getClassLoader();
        URL url = loader.getResource(PROPERTIES_FILENAME);
        InputStream stream = url.openStream();
        properties.load(stream);
        stream.close();
        String names = getProperties().getProperty(NAMES_PARAMETER);
        StringTokenizer st = new StringTokenizer(names, ",");
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            String value = readContents(String.format("sparql/%s.sparql", name));
            getName2Query().put(name, value);
        }
    }

}