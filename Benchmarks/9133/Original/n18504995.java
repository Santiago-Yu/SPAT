class n18504995{
    private static InputStream openFileOrURL(String url) throws IOException {
        if (url.startsWith("resource:")) {
            return DcmRcv.class.getClassLoader().getResourceAsStream(url.substring(9));
        }
        try {
            return new URL(url).openStream();
        } catch (MalformedURLException e) {
            return new FileInputStream(url);
        }
    }

}