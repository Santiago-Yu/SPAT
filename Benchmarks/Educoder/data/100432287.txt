    private File unpackZIP(URL url, String dirName) {
        try {
            URLConnection connection = url.openConnection();
            if (connection instanceof JarURLConnection) {
                File destDir = new File(getExtensionsDirectory() + EGEConstants.fS + dirName);
                destDir.mkdirs();
                EGEIOUtils.unzipFile(((JarURLConnection) connection).getJarFile(), destDir);
                return destDir;
            }
        } catch (IOException e) {
            LOGGER.error("Could not unzip jar file.", e);
        }
        return null;
    }
