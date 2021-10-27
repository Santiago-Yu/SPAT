class n4507906 {
	private void sendToURL(String B7DETkKt, String J00ZdMbQ) throws Exception {
		URL BN7DlRv3 = new URL(B7DETkKt);
		InputStream XyIxtXoZ = new BufferedInputStream(new FileInputStream(J00ZdMbQ));
		OutputStream nX9CPlZs = BN7DlRv3.openConnection().getOutputStream();
		copyDocument(XyIxtXoZ, nX9CPlZs);
		XyIxtXoZ.close();
		nX9CPlZs.close();
	}

}