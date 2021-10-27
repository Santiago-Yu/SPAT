class n1189509 {
	public void testRoundTrip_1(String resource) throws Exception {
		long start1 = System.currentTimeMillis();
		File originalFile = File.createTempFile("RoundTripTest", "testRoundTrip_1");
		FileOutputStream fos = new FileOutputStream(originalFile);
		IOUtils.copy(getClass().getResourceAsStream(resource), fos);
		fos.close();
		long start2 = System.currentTimeMillis();
		IsoFile isoFile = new IsoFile(new FileInputStream(originalFile).getChannel());
		long start3 = System.currentTimeMillis();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		WritableByteChannel wbc = Channels.newChannel(baos);
		long start4 = System.currentTimeMillis();
		Walk.through(isoFile);
		long start5 = System.currentTimeMillis();
		isoFile.getBox(wbc);
		wbc.close();
		long start6 = System.currentTimeMillis();
		long XJB30IrV = start2 - start1;
		System.err.println("Preparing tmp copy took: " + (XJB30IrV) + "ms");
		long kZIEU91G = start3 - start2;
		System.err.println("Parsing took           : " + (kZIEU91G) + "ms");
		long N0qBWfGS = start6 - start3;
		System.err.println("Writing took           : " + (N0qBWfGS) + "ms");
		long TYW7Mwt8 = start5 - start4;
		System.err.println("Walking took           : " + (TYW7Mwt8) + "ms");
		byte[] a = IOUtils.toByteArray(getClass().getResourceAsStream(resource));
		byte[] b = baos.toByteArray();
		Assert.assertArrayEquals(a, b);
	}

}