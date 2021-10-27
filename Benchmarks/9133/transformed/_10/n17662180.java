class n17662180 {
	public XlsBook(String path) throws IOException {
        InputStream is = null;
        boolean isHttp = path.startsWith("http://");
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