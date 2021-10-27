class n22942858{
    public void readHTMLFromURL(URL url) throws IOException {
        InputStream in = url.openStream();
        try {
            readHTMLFromStream(new InputStreamReader(in));
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(HTMLTextAreaModel.class.getName()).log(Level.SEVERE, "Exception while closing InputStream", ex);
            }
        }
    }

}