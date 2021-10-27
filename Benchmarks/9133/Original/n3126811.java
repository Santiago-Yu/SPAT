class n3126811{
    public static void saveProperties(Properties props, String comment, URL url) throws IOException {
        if (props == null) throw new IllegalArgumentException();
        if (url == null) throw new IllegalArgumentException();
        OutputStream out = url.openConnection().getOutputStream();
        props.store(out, comment);
        out.close();
    }

}