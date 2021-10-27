class n5520449{
    protected void init() {
        if (this.strUrl != null) {
            InputStream in = null;
            try {
                URL url = ClassLoader.getSystemClassLoader().getResource(strUrl);
                if (url != null) {
                    in = url.openStream();
                    if (in != null) {
                        props.load(in);
                    }
                }
            } catch (IOException e) {
                Logger.defaultLogger().error("Error during framework properties loading", e);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ignored) {
                    }
                }
            }
        }
    }

}