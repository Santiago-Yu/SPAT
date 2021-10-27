class n22135198 {
	public void testCodingBeyondContentLimitFromFile() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		HttpParams params = new BasicHttpParams();
		WritableByteChannel channel = newChannel(baos);
		HttpTransportMetricsImpl metrics = new HttpTransportMetricsImpl();
		SessionOutputBuffer outbuf = new SessionOutputBufferImpl(1024, 128, params);
		File tmpFile = File.createTempFile("testFile", "txt");
		LengthDelimitedEncoder encoder = new LengthDelimitedEncoder(channel, outbuf, metrics, 16);
		FileOutputStream fout = new FileOutputStream(tmpFile);
		OutputStreamWriter wrtout = new OutputStreamWriter(fout);
		wrtout.write("stuff;");
		wrtout.write("more stuff; and a lot more stuff");
		wrtout.flush();
		wrtout.close();
		FileChannel fchannel = new FileInputStream(tmpFile).getChannel();
		encoder.transfer(fchannel, 0, 20);
		String s = baos.toString("US-ASCII");
		assertTrue(encoder.isCompleted());
		assertEquals("stuff;more stuff", s);
		tmpFile.delete();
	}

}