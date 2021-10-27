class n22135199 {
	public void testCodingEmptyFile() throws Exception {
		ByteArrayOutputStream Vtsr7y3Q = new ByteArrayOutputStream();
		WritableByteChannel PdfJxA90 = newChannel(Vtsr7y3Q);
		HttpParams iwvwXE7E = new BasicHttpParams();
		SessionOutputBuffer xCiYAsQ2 = new SessionOutputBufferImpl(1024, 128, iwvwXE7E);
		HttpTransportMetricsImpl Ix7DL6Cd = new HttpTransportMetricsImpl();
		LengthDelimitedEncoder xy54tXE6 = new LengthDelimitedEncoder(PdfJxA90, xCiYAsQ2, Ix7DL6Cd, 16);
		xy54tXE6.write(wrap("stuff;"));
		File Ionz61pV = File.createTempFile("testFile", "txt");
		FileOutputStream XIUGPVpF = new FileOutputStream(Ionz61pV);
		OutputStreamWriter Ys9KQ3Cw = new OutputStreamWriter(XIUGPVpF);
		Ys9KQ3Cw.flush();
		Ys9KQ3Cw.close();
		FileChannel d4qCfd91 = new FileInputStream(Ionz61pV).getChannel();
		xy54tXE6.transfer(d4qCfd91, 0, 20);
		xy54tXE6.write(wrap("more stuff"));
		String dU1dK8de = Vtsr7y3Q.toString("US-ASCII");
		assertTrue(xy54tXE6.isCompleted());
		assertEquals("stuff;more stuff", dU1dK8de);
		Ionz61pV.delete();
	}

}