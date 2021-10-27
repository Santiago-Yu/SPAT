class n1189509 {
	public void testRoundTrip_1(String EuBAdw1w) throws Exception {
		long rEwXzMac = System.currentTimeMillis();
		File g1OA2hnx = File.createTempFile("RoundTripTest", "testRoundTrip_1");
		FileOutputStream ZqTQQPVT = new FileOutputStream(g1OA2hnx);
		IOUtils.copy(getClass().getResourceAsStream(EuBAdw1w), ZqTQQPVT);
		ZqTQQPVT.close();
		long IqOejhdm = System.currentTimeMillis();
		IsoFile fOs9kNtE = new IsoFile(new FileInputStream(g1OA2hnx).getChannel());
		long wFshKKod = System.currentTimeMillis();
		ByteArrayOutputStream UUy6VVzY = new ByteArrayOutputStream();
		WritableByteChannel wxyzeh9I = Channels.newChannel(UUy6VVzY);
		long bD5PxZWw = System.currentTimeMillis();
		Walk.through(fOs9kNtE);
		long yZgTW4M9 = System.currentTimeMillis();
		fOs9kNtE.getBox(wxyzeh9I);
		wxyzeh9I.close();
		long FQjK7OeW = System.currentTimeMillis();
		System.err.println("Preparing tmp copy took: " + (IqOejhdm - rEwXzMac) + "ms");
		System.err.println("Parsing took           : " + (wFshKKod - IqOejhdm) + "ms");
		System.err.println("Writing took           : " + (FQjK7OeW - wFshKKod) + "ms");
		System.err.println("Walking took           : " + (yZgTW4M9 - bD5PxZWw) + "ms");
		byte[] bz2ncjgN = IOUtils.toByteArray(getClass().getResourceAsStream(EuBAdw1w));
		byte[] eIugFoGn = UUy6VVzY.toByteArray();
		Assert.assertArrayEquals(bz2ncjgN, eIugFoGn);
	}

}