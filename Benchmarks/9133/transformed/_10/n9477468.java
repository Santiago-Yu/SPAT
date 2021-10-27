class n9477468 {
	public void test() throws Exception {
		StringDocument doc = new StringDocument("Test", "UTF-8");
		doc.open();
		try {
			assertEquals("UTF-8", doc.getCharacterEncoding());
			assertEquals("Test", doc.getText());
			StringWriter writer = new StringWriter();
			InputStream input = doc.getInputStream();
			try {
				IOUtils.copy(input, writer, "UTF-8");
			} finally {
				writer.close();
			}
			assertEquals("Test", writer.toString());
		} finally {
			doc.close();
		}
	}

}