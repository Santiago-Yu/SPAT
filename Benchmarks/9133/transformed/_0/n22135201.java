class n22135201 {
	public void testCodingFromFileSmaller() throws Exception {
		ByteArrayOutputStream HJ8QoSWb = new ByteArrayOutputStream();
		WritableByteChannel aUlwrZwy = newChannel(HJ8QoSWb);
		HttpParams Q5Om7hI3 = new BasicHttpParams();
		SessionOutputBuffer RpdeXU4I = new SessionOutputBufferImpl(1024, 128, Q5Om7hI3);
		HttpTransportMetricsImpl qb8FAfQf = new HttpTransportMetricsImpl();
		LengthDelimitedEncoder Wy8KvCyF = new LengthDelimitedEncoder(aUlwrZwy, RpdeXU4I, qb8FAfQf, 16);
		File L0s5cD7D = File.createTempFile("testFile", "txt");
		FileOutputStream SQ0OgexJ = new FileOutputStream(L0s5cD7D);
		OutputStreamWriter z8t5Cq04 = new OutputStreamWriter(SQ0OgexJ);
		z8t5Cq04.write("stuff;");
		z8t5Cq04.write("more stuff;");
		z8t5Cq04.flush();
		z8t5Cq04.close();
		FileChannel ZMLCTt3U = new FileInputStream(L0s5cD7D).getChannel();
		Wy8KvCyF.transfer(ZMLCTt3U, 0, 20);
		String zBqOfESi = HJ8QoSWb.toString("US-ASCII");
		assertTrue(Wy8KvCyF.isCompleted());
		assertEquals("stuff;more stuff", zBqOfESi);
		L0s5cD7D.delete();
	}

}