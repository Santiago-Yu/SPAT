class n8943482{
    public InputStream getImageAsStream(Photo photo, int size) throws IOException, FlickrException {
        String urlStr = "";
        if (size == Size.SQUARE) {
            urlStr = photo.getSmallSquareUrl();
        } else if (size == Size.THUMB) {
            urlStr = photo.getThumbnailUrl();
        } else if (size == Size.SMALL) {
            urlStr = photo.getSmallUrl();
        } else if (size == Size.MEDIUM) {
            urlStr = photo.getMediumUrl();
        } else if (size == Size.LARGE) {
            urlStr = photo.getLargeUrl();
        } else if (size == Size.ORIGINAL) {
            urlStr = photo.getOriginalUrl();
        } else {
            throw new FlickrException("0", "Unknown Photo-size");
        }
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        if (transport instanceof REST) {
            if (((REST) transport).isProxyAuth()) {
                conn.setRequestProperty("Proxy-Authorization", "Basic " + ((REST) transport).getProxyCredentials());
            }
        }
        conn.connect();
        return conn.getInputStream();
    }

}