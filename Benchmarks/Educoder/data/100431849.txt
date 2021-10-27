    private static String lastModified(URL url) {
        try {
            URLConnection conn = url.openConnection();
            return long2date(conn.getLastModified());
        } catch (Exception e) {
            SWGAide.printDebug("cach", 1, "SWGCraftCache:lastModified: " + e.getMessage());
        }
        return "0";
    }
