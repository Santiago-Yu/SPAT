class n9806878{
    private static void validateJarFile(URL url) throws IOException {
        InputStream stream = url.openStream();
        JarInputStream jarStream = new JarInputStream(stream, true);
        try {
            while (null != jarStream.getNextEntry()) {
            }
        } finally {
            try {
                jarStream.close();
            } catch (Exception ignore) {
            }
        }
    }

}