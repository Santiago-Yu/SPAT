class n22135199 {
	public void testCodingEmptyFile() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		HttpParams params = new BasicHttpParams();
		WritableByteChannel channel = newChannel(baos);
		HttpTransportMetricsImpl metrics = new HttpTransportMetricsImpl();
		SessionOutputBuffer outbuf = new SessionOutputBufferImpl(1024, 128, params);
		LengthDelimitedEncoder encoder = new LengthDelimitedEncoder(channel, outbuf, metrics, 16);
		encoder.write(wrap("stuff;"));
		File tmpFile = File.createTempFile("testFile", "txt");
		FileOutputStream fout = new FileOutputStream(tmpFile);
		OutputStreamWriter wrtout = new OutputStreamWriter(fout);
		wrtout.flush();
		wrtout.close();
		FileChannel fchannel = new FileInputStream(tmpFile).getChannel();
		encoder.transfer(fchannel, 0, 20);
		encoder.write(wrap("more stuff"));
		String s = baos.toString("US-ASCII");
		assertTrue(encoder.isCompleted());
		assertEquals("stuff;more stuff", s);
		tmpFile.delete();
	}

}