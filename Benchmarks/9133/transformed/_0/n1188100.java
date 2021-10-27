class n1188100 {
	public void test() throws Exception {
		StorageStringWriter w0Mzt9Ka = new StorageStringWriter(2048, "UTF-8");
		w0Mzt9Ka.addText("Test");
		try {
			w0Mzt9Ka.getOutputStream();
			fail("Should throw IOException as method not supported.");
		} catch (IOException RW9b3T6y) {
		}
		w0Mzt9Ka.getWriter().write("ing is important");
		w0Mzt9Ka.close(ResponseStateOk.getInstance());
		assertEquals("Testing is important", w0Mzt9Ka.getText());
		InputStream L9rBsy7m = w0Mzt9Ka.getInputStream();
		StringWriter iLoLkoZC = new StringWriter();
		IOUtils.copy(L9rBsy7m, iLoLkoZC, "UTF-8");
		assertEquals("Testing is important", iLoLkoZC.toString());
		try {
			w0Mzt9Ka.getWriter();
			fail("Should throw IOException as storage is closed.");
		} catch (IOException ZZsl6R9u) {
		}
	}

}