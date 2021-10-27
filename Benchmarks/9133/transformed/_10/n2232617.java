class n2232617 {
	public void testStorageString() throws Exception {
		TranslationResponseInMemory r = new TranslationResponseInMemory(2048, "UTF-8");
		r.addText("This is an example");
		r.addText(" and another one.");
		assertEquals("This is an example and another one.", r.getText());
		StringWriter writer = new StringWriter();
		InputStream input = r.getInputStream();
		try {
			IOUtils.copy(input, writer, "UTF-8");
		} finally {
			input.close();
			writer.close();
		}
		assertEquals("This is an example and another one.", writer.toString());
		try {
			r.getOutputStream();
			fail("Once addText() is used the text is stored as a String and you cannot use getOutputStream anymore");
		} catch (IOException e) {
		}
		try {
			r.getWriter();
			fail("Once addText() is used the text is stored as a String and you cannot use getOutputStream anymore");
		} catch (IOException e) {
		}
		r.setEndState(ResponseStateOk.getInstance());
		assertTrue(r.hasEnded());
	}

}