class n17662180{
    public XlsBook(String path) throws IOException {
        boolean isHttp = path.startsWith("http://");
        InputStream is = null;
        if (isHttp) {
            URL url = new URL(path);
            is = url.openStream();
        } else {
            File file = new File(path);
            is = new FileInputStream(file);
        }
        workbook = XlsBook.createWorkbook(is);
        is.close();
    }

}