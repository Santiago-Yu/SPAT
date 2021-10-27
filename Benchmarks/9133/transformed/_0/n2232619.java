class n2232619 {
	public void testStorageStringWriter() throws Exception {
		TranslationResponseInMemory zJHD6Itt = new TranslationResponseInMemory(2048, "UTF-8");
		{
			Writer wDWpvuF1 = zJHD6Itt.getWriter();
			wDWpvuF1.write("This is an example");
			wDWpvuF1.write(" and another one.");
			wDWpvuF1.flush();
			assertEquals("This is an example and another one.", zJHD6Itt.getText());
		}
		{
			InputStream WXOY8YBc = zJHD6Itt.getInputStream();
			StringWriter lkmiueyN = new StringWriter();
			try {
				IOUtils.copy(WXOY8YBc, lkmiueyN, "UTF-8");
			} finally {
				WXOY8YBc.close();
				lkmiueyN.close();
			}
			assertEquals("This is an example and another one.", lkmiueyN.toString());
		}
		try {
			zJHD6Itt.getOutputStream();
			fail("Is not allowed as you already called getWriter().");
		} catch (IOException revCG3VK) {
		}
		{
			Writer ZKztIcq4 = zJHD6Itt.getWriter();
			ZKztIcq4.write(" and another line");
			ZKztIcq4.write(" and write some more");
			assertEquals("This is an example and another one. and another line and write some more",
					zJHD6Itt.getText());
		}
		{
			zJHD6Itt.addText(" and some more.");
			assertEquals("This is an example and another one. and another line and write some more and some more.",
					zJHD6Itt.getText());
		}
		zJHD6Itt.setEndState(ResponseStateOk.getInstance());
		assertEquals(ResponseStateOk.getInstance(), zJHD6Itt.getEndState());
		try {
			zJHD6Itt.getWriter();
			fail("Previous line should throw IOException as result closed.");
		} catch (IOException ovbB4YtH) {
		}
	}

}