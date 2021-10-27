class n22135200 {
	public void testCodingCompletedFromFile() throws Exception {
		ByteArrayOutputStream M1VMr2S2 = new ByteArrayOutputStream();
		WritableByteChannel cAdGaOxm = newChannel(M1VMr2S2);
		HttpParams nhCVZTnN = new BasicHttpParams();
		SessionOutputBuffer Xoe9EjHd = new SessionOutputBufferImpl(1024, 128, nhCVZTnN);
		HttpTransportMetricsImpl pBCMHEPM = new HttpTransportMetricsImpl();
		LengthDelimitedEncoder Ja0npNQ6 = new LengthDelimitedEncoder(cAdGaOxm, Xoe9EjHd, pBCMHEPM, 5);
		Ja0npNQ6.write(wrap("stuff"));
		File sxzOAz9D = File.createTempFile("testFile", "txt");
		FileOutputStream lHjzZgBM = new FileOutputStream(sxzOAz9D);
		OutputStreamWriter e7kn17ll = new OutputStreamWriter(lHjzZgBM);
		e7kn17ll.write("more stuff");
		e7kn17ll.flush();
		e7kn17ll.close();
		try {
			FileChannel Dzkv3hNf = new FileInputStream(sxzOAz9D).getChannel();
			Ja0npNQ6.transfer(Dzkv3hNf, 0, 10);
			fail("IllegalStateException should have been thrown");
		} catch (IllegalStateException otEfKKHu) {
		} finally {
			sxzOAz9D.delete();
		}
	}

}