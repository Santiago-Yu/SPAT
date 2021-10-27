class n13319521{
    protected void loadXmlFromUri(URI uri) {
        URLConnection urlc;
        try {
            urlc = uri.toURL().openConnection();
            InputStream is = urlc.getInputStream();
            Reader rd = new InputStreamReader(is);
            xmlSource = new StreamSource(rd);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}