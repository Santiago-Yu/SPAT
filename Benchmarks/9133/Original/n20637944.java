class n20637944{
    public final Reader open(URL url) throws IOException {
        Reader ret = null;
        Charset cs = this.detectCodepage(url);
        if (cs != null) {
            ret = new InputStreamReader(new BufferedInputStream(url.openStream()), cs);
        }
        return ret;
    }

}