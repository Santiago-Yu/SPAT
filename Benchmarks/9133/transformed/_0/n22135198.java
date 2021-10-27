class n22135198 {
	public void testCodingBeyondContentLimitFromFile() throws Exception {
		ByteArrayOutputStream dWAKa7cJ = new ByteArrayOutputStream();
		WritableByteChannel nyci9Ppb = newChannel(dWAKa7cJ);
		HttpParams xOrOUJde = new BasicHttpParams();
		SessionOutputBuffer Ui9Wn5Te = new SessionOutputBufferImpl(1024, 128, xOrOUJde);
		HttpTransportMetricsImpl b2otyu2B = new HttpTransportMetricsImpl();
		LengthDelimitedEncoder l4DAXGns = new LengthDelimitedEncoder(nyci9Ppb, Ui9Wn5Te, b2otyu2B, 16);
		File lnHybQ8k = File.createTempFile("testFile", "txt");
		FileOutputStream BYTvohi5 = new FileOutputStream(lnHybQ8k);
		OutputStreamWriter DPPhL46A = new OutputStreamWriter(BYTvohi5);
		DPPhL46A.write("stuff;");
		DPPhL46A.write("more stuff; and a lot more stuff");
		DPPhL46A.flush();
		DPPhL46A.close();
		FileChannel WLxfxOdn = new FileInputStream(lnHybQ8k).getChannel();
		l4DAXGns.transfer(WLxfxOdn, 0, 20);
		String YmVVblWv = dWAKa7cJ.toString("US-ASCII");
		assertTrue(l4DAXGns.isCompleted());
		assertEquals("stuff;more stuff", YmVVblWv);
		lnHybQ8k.delete();
	}

}