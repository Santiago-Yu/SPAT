class n6214356 {
	public GifImage(URL url) throws IOException {
        InputStream is = null;
        fromUrl = url;
        try {
            is = url.openStream();
            process(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

}