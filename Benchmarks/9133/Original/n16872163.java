class n16872163{
    public static int getNetFileSize(String netFile) throws InvalidActionException {
        URL url;
        URLConnection conn;
        int size;
        try {
            url = new URL(netFile);
            conn = url.openConnection();
            size = conn.getContentLength();
            conn.getInputStream().close();
            if (size < 0) {
                throw new InvalidActionException("Could not determine file size.");
            } else {
                return size;
            }
        } catch (Exception e) {
            throw new InvalidActionException(e.getMessage());
        }
    }

}