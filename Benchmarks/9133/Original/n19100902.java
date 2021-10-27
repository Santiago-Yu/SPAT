class n19100902{
    public static void saveURL(URL url, Writer writer) throws IOException {
        BufferedInputStream in = new BufferedInputStream(url.openStream());
        for (int c = in.read(); c != -1; c = in.read()) {
            writer.write(c);
        }
    }

}