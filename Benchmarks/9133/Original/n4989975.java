class n4989975{
    public InputStream sendReceive(String trackerURL) throws TorrentException {
        try {
            URL url = new URL(trackerURL);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            in = conn.getInputStream();
        } catch (MalformedURLException e) {
            throw new TorrentException(e);
        } catch (IOException e) {
            throw new TorrentException(e);
        }
        return in;
    }

}