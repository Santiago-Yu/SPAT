class n18516388 {
	public void test() throws Exception {
		StorageString txt4uliG = new StorageString("UTF-8");
		txt4uliG.addText("Test");
		try {
			txt4uliG.getOutputStream();
			fail("Should throw IOException as method not supported.");
		} catch (IOException ssOivJSu) {
		}
		try {
			txt4uliG.getWriter();
			fail("Should throw IOException as method not supported.");
		} catch (IOException Q401GKmu) {
		}
		txt4uliG.addText("ing is important");
		txt4uliG.close(ResponseStateOk.getInstance());
		assertEquals("Testing is important", txt4uliG.getText());
		InputStream oPSBXqt7 = txt4uliG.getInputStream();
		StringWriter YLXXJtRN = new StringWriter();
		IOUtils.copy(oPSBXqt7, YLXXJtRN, "UTF-8");
		assertEquals("Testing is important", YLXXJtRN.toString());
	}

}