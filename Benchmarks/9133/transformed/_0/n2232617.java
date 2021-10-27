class n2232617 {
	public void testStorageString() throws Exception {
		TranslationResponseInMemory MJg2F14B = new TranslationResponseInMemory(2048, "UTF-8");
		MJg2F14B.addText("This is an example");
		MJg2F14B.addText(" and another one.");
		assertEquals("This is an example and another one.", MJg2F14B.getText());
		InputStream CCA1uF7n = MJg2F14B.getInputStream();
		StringWriter KhuWihT6 = new StringWriter();
		try {
			IOUtils.copy(CCA1uF7n, KhuWihT6, "UTF-8");
		} finally {
			CCA1uF7n.close();
			KhuWihT6.close();
		}
		assertEquals("This is an example and another one.", KhuWihT6.toString());
		try {
			MJg2F14B.getOutputStream();
			fail("Once addText() is used the text is stored as a String and you cannot use getOutputStream anymore");
		} catch (IOException CruUQERA) {
		}
		try {
			MJg2F14B.getWriter();
			fail("Once addText() is used the text is stored as a String and you cannot use getOutputStream anymore");
		} catch (IOException wjKoCGkk) {
		}
		MJg2F14B.setEndState(ResponseStateOk.getInstance());
		assertTrue(MJg2F14B.hasEnded());
	}

}