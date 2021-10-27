class n3724533{
    public static Document getDocument(URL url) throws Exception {
        InputStream is = null;
        try {
            is = new BufferedInputStream(url.openStream());
            return getDocumentBuilder().parse(is);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
    }

}