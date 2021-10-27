class n5673928{
    void loadImage(Frame frame, URL url) throws Exception {
        URLConnection conn = url.openConnection();
        String mimeType = conn.getContentType();
        long length = conn.getContentLength();
        InputStream is = conn.getInputStream();
        loadImage(frame, is, length, mimeType);
    }

}