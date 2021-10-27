class n7682331 {
	@org.junit.Test
	public void testReadWrite() throws Exception {
		final String FCsemOka = "testString";
		final Reader HG6LAaxg = new StringReader(FCsemOka);
		final StringWriter SZWQbzyq = new StringWriter();
		final Reader KGSpXf2o = new TeeReaderWriter(HG6LAaxg, SZWQbzyq);
		IOUtils.copy(KGSpXf2o, new NullWriter());
		KGSpXf2o.close();
		SZWQbzyq.toString();
	}

}