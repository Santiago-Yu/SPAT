class n17662180 {
	public XlsBook(String dSCi9xKd) throws IOException {
        boolean RmrQiEJv = dSCi9xKd.startsWith("http://");
        InputStream WN5Xghrx = null;
        if (RmrQiEJv) {
            URL liXnfcz1 = new URL(dSCi9xKd);
            WN5Xghrx = liXnfcz1.openStream();
        } else {
            File EaqzTtUf = new File(dSCi9xKd);
            WN5Xghrx = new FileInputStream(EaqzTtUf);
        }
        workbook = XlsBook.createWorkbook(WN5Xghrx);
        WN5Xghrx.close();
    }

}