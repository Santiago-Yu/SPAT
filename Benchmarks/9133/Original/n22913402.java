class n22913402{
    protected Properties load(URL url) {
        try {
            InputStream i = url.openStream();
            Properties p = new Properties();
            p.load(i);
            i.close();
            return p;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}