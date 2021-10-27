class n9835797{
    public static void loadFile(final URL url, final StringBuffer buffer) throws IOException {
        InputStream in = null;
        BufferedReader dis = null;
        try {
            in = url.openStream();
            dis = new BufferedReader(new InputStreamReader(in));
            int i;
            while ((i = dis.read()) != -1) {
                buffer.append((char) i);
            }
        } finally {
            closeStream(in);
            closeReader(dis);
        }
    }

}