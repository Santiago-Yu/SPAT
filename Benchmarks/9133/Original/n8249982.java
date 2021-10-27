class n8249982{
    public void getDownloadInfo(String _url) throws Exception {
        URL url = new URL(_url);
        con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "test");
        con.setRequestProperty("Accept", "*/*");
        con.setRequestProperty("Range", "bytes=0-");
        con.setRequestMethod("HEAD");
        con.setUseCaches(false);
        con.connect();
        con.disconnect();
        if (mustRedirect()) secureRedirect();
        url = con.getURL();
        setURL(url.toString());
        setSize(Long.parseLong(con.getHeaderField("Content-Length")));
        setResumable(con.getResponseCode() == 206);
        setLastModified(con.getLastModified());
        setRangeEnd(getSize() - 1);
    }

}