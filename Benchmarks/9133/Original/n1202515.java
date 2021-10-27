class n1202515{
    public static void copyFile(URL url, File local) throws IOException {
        InputStream in = null;
        FileWriter writer = null;
        try {
            writer = new FileWriter(local);
            in = url.openStream();
            int c;
            while ((c = in.read()) != -1) {
                writer.write(c);
            }
        } finally {
            try {
                writer.flush();
                writer.close();
                in.close();
            } catch (Exception ignore) {
                LOGGER.error(ignore);
            }
        }
    }

}