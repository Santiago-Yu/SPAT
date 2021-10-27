class n18634052{
    public static String readRss(String feed, int num) {
        InputStream stream = null;
        try {
            feed = appendParam(feed, "num", "" + num);
            System.out.println("feed=" + feed);
            URL url = new URL(feed);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", RSS_USER_AGENT);
            stream = connection.getInputStream();
            return CFileHelper.readInputStream(stream);
        } catch (Exception e) {
            throw new CException(e);
        } finally {
            CFileHelper.closeStream(stream);
        }
    }

}