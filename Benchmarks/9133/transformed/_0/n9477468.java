class n9477468 {
	public void test() throws Exception {
		StringDocument wLqfsONj = new StringDocument("Test", "UTF-8");
		wLqfsONj.open();
		try {
			assertEquals("UTF-8", wLqfsONj.getCharacterEncoding());
			assertEquals("Test", wLqfsONj.getText());
			InputStream NScoGmlc = wLqfsONj.getInputStream();
			StringWriter czbgU6cR = new StringWriter();
			try {
				IOUtils.copy(NScoGmlc, czbgU6cR, "UTF-8");
			} finally {
				czbgU6cR.close();
			}
			assertEquals("Test", czbgU6cR.toString());
		} finally {
			wLqfsONj.close();
		}
	}

}