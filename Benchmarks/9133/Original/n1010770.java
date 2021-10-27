class n1010770{
    public static boolean urlStrIsDir(String urlStr) {
        if (urlStr.endsWith("/")) return true;
        int lastSlash = urlStr.lastIndexOf('/');
        int lastPeriod = urlStr.lastIndexOf('.');
        if (lastPeriod != -1 && (lastSlash == -1 || lastPeriod > lastSlash)) return false;
        String urlStrWithSlash = urlStr + "/";
        try {
            URL url = new URL(urlStrWithSlash);
            InputStream f = url.openStream();
            f.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}