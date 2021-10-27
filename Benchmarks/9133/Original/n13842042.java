class n13842042{
    @Override
    protected Properties loadFile(String fileName) {
        Properties prop = new Properties();
        try {
            URL url = new File(fileName).toURI().toURL();
            final InputStream input = url.openStream();
            prop.load(input);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}