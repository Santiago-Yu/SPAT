    public static InputStream getResourceAsStreamIfAny(String resPath) {
        URL url = findResource(resPath);
        try {
            return url == null ? null : url.openStream();
        } catch (IOException e) {
            ZMLog.warn(e, " URL open Connection got an exception!");
            return null;
        }
    }
