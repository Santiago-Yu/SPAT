class n22489287{
    public void load(URL url) throws IOException {
        try {
            oggBitStream_ = new BufferedInputStream(url.openStream());
        } catch (Exception ex) {
            System.err.println("ogg file " + url + " could not be loaded");
        }
        load();
    }

}