class n2399802{
    public static InputStream getInputStream(String fileName) throws IOException {
        InputStream input;
        if (fileName.startsWith("http:")) {
            URL url = new URL(fileName);
            URLConnection connection = url.openConnection();
            input = connection.getInputStream();
        } else {
            input = new FileInputStream(fileName);
        }
        return input;
    }

}