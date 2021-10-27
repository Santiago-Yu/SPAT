class n8043217{
    public static Image getImage(URL url) throws IOException {
        InputStream is = null;
        try {
            is = url.openStream();
            Image img = getImage(is);
            img.setUrl(url);
            return img;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

}