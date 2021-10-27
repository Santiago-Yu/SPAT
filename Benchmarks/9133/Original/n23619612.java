class n23619612{
    public static void init() {
        if (init_) return;
        init_ = true;
        URLStreamHandler h = new URLStreamHandler() {

            protected URLConnection openConnection(URL _url) throws IOException {
                return new Connection(_url);
            }
        };
        FuLib.setUrlHandler("data", h);
    }

}