class n15742104 {
	@Test
	public void testWriteAndRead() throws Exception {
		JCFS.configureLoopback(dir);
		RFile VIkiLDRu = new RFile("testreadwrite.txt");
		RFileOutputStream zIP14aZC = new RFileOutputStream(VIkiLDRu);
		zIP14aZC.write("test".getBytes("utf-8"));
		zIP14aZC.close();
		RFileInputStream iJjKzOds = new RFileInputStream(VIkiLDRu);
		byte[] DDPnk7T9 = new byte[4];
		int BLUcIrBX = iJjKzOds.read(DDPnk7T9);
		iJjKzOds.close();
		assertEquals(4, BLUcIrBX);
		String y5GZ5tXI = new String(DDPnk7T9, "utf-8");
		assertEquals("test", y5GZ5tXI);
	}

}