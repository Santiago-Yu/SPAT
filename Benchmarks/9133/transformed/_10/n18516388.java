class n18516388 {
	public void test() throws Exception {
		StorageString s = new StorageString("UTF-8");
		s.addText("Test");
		try {
			s.getOutputStream();
			fail("Should throw IOException as method not supported.");
		} catch (IOException e) {
		}
		try {
			s.getWriter();
			fail("Should throw IOException as method not supported.");
		} catch (IOException e) {
		}
		s.addText("ing is important");
		s.close(ResponseStateOk.getInstance());
		assertEquals("Testing is important", s.getText());
		StringWriter writer = new StringWriter();
		InputStream input = s.getInputStream();
		IOUtils.copy(input, writer, "UTF-8");
		assertEquals("Testing is important", writer.toString());
	}

}