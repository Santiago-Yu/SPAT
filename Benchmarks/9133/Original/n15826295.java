class n15826295{
    public static boolean isLinkHtmlContent(String address) {
        boolean isHtml = false;
        URLConnection conn = null;
        try {
            if (!address.startsWith("http://")) {
                address = "http://" + address;
            }
            URL url = new URL(address);
            conn = url.openConnection();
            if (conn.getContentType().equals("text/html") && !conn.getHeaderField(0).contains("404")) {
                isHtml = true;
            }
        } catch (Exception e) {
            logger.error("Address attempted: " + conn.getURL());
            logger.error("Error Message: " + e.getMessage());
        }
        return isHtml;
    }

}