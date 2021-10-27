class n2232618 {
	public void testStorageByteArray() throws Exception {
		TranslationResponseInMemory VwwDffgf = new TranslationResponseInMemory(2048, "UTF-8");
		{
			OutputStream uV1mubbY = VwwDffgf.getOutputStream();
			uV1mubbY.write("This is an example".getBytes("UTF-8"));
			uV1mubbY.write(" and another one.".getBytes("UTF-8"));
			assertEquals("This is an example and another one.", VwwDffgf.getText());
		}
		{
			InputStream USJqrGyW = VwwDffgf.getInputStream();
			StringWriter oGkKdmqw = new StringWriter();
			try {
				IOUtils.copy(USJqrGyW, oGkKdmqw, "UTF-8");
			} finally {
				USJqrGyW.close();
				oGkKdmqw.close();
			}
			assertEquals("This is an example and another one.", oGkKdmqw.toString());
		}
		{
			OutputStream FTEdMQBU = VwwDffgf.getOutputStream();
			FTEdMQBU.write(" and another line".getBytes("UTF-8"));
			assertEquals("This is an example and another one. and another line", VwwDffgf.getText());
		}
		{
			Writer OWDPxqDt = VwwDffgf.getWriter();
			OWDPxqDt.write(" and write some more");
			assertEquals("This is an example and another one. and another line and write some more",
					VwwDffgf.getText());
		}
		{
			VwwDffgf.addText(" and even more.");
			assertEquals("This is an example and another one. and another line and write some more and even more.",
					VwwDffgf.getText());
		}
		assertFalse(VwwDffgf.hasEnded());
		VwwDffgf.setEndState(ResponseStateOk.getInstance());
		assertTrue(VwwDffgf.hasEnded());
		try {
			VwwDffgf.getOutputStream();
			fail("Previous line should throw IOException as result closed.");
		} catch (IOException ZHdPQPPy) {
		}
		try {
			VwwDffgf.getWriter();
			fail("Previous line should throw IOException as result closed.");
		} catch (IOException Y6ifWmRU) {
		}
	}

}