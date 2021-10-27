class n17662180 {
	public XlsBook(String path) throws IOException {
        boolean isHttp = path.startsWith("http://");
        InputStream is = null;
        if (!(isHttp)) {
			File file = new File(path);
			is = new FileInputStream(file);
		} else {
			URL url = new URL(path);
			is = url.openStream();
		}
        workbook = XlsBook.createWorkbook(is);
        is.close();
    }

}