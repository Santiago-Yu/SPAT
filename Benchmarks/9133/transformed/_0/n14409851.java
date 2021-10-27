class n14409851 {
	public void test() throws Exception {
		File AZD3dPHn = File.createTempFile("test", ".test");
		AZD3dPHn.deleteOnExit();
		StorageFile i3XnHHdu = new StorageFile(AZD3dPHn, "UTF-8");
		i3XnHHdu.addText("Test");
		i3XnHHdu.getOutputStream().write("ing is important".getBytes("UTF-8"));
		i3XnHHdu.getWriter().write(" but overrated");
		assertEquals("Testing is important but overrated", i3XnHHdu.getText());
		i3XnHHdu.close(ResponseStateOk.getInstance());
		assertEquals("Testing is important but overrated", i3XnHHdu.getText());
		InputStream w0PhsHSB = i3XnHHdu.getInputStream();
		StringWriter kRJzDQon = new StringWriter();
		IOUtils.copy(w0PhsHSB, kRJzDQon, "UTF-8");
		assertEquals("Testing is important but overrated", kRJzDQon.toString());
		try {
			i3XnHHdu.getOutputStream();
			fail("Should thow an IOException as it is closed.");
		} catch (IOException R2n0oA47) {
		}
	}

}