class n9835798{
    public static void saveFile(final URL url, final File file) throws IOException {
        final InputStream in = url.openStream();
        final FileOutputStream out = new FileOutputStream(file);
        byte[] data = new byte[8 * 1024];
        int length;
        while ((length = in.read(data)) != -1) {
            out.write(data, 0, length);
        }
        in.close();
        out.close();
    }

}