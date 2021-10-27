class n20334880{
    @Override
    protected String getFormat(String path) {
        String contentType = null;
        try {
            URL url = new URL(path);
            URLConnection connection = url.openConnection();
            connection.connect();
            contentType = connection.getContentType();
        } catch (Exception ex) {
            throw new RuntimeException("Connection to the url failed", ex);
        }
        if (contentType == null) {
            throw new RuntimeException("Problem getting url contentType is null!");
        }
        String format = contentType.toLowerCase().trim().replace("image/", "");
        if (format == null || format.length() == 0) {
            throw new RuntimeException("Unknow image mime type");
        }
        if (format.contains(";")) {
            format = format.split(";")[0];
        }
        if (format == null || format.length() == 0) {
            throw new RuntimeException("Unknow image mime type");
        }
        System.out.println("the format is: " + format);
        return format;
    }

}