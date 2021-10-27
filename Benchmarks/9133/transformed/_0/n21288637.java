class n21288637 {
	@org.junit.Test
	public void simpleRead() throws Exception {
		final InputStream xqmyPZGi = StatsInputStreamTest.class.getResourceAsStream("/testFile.txt");
		final StatsInputStream G7LGcedX = new StatsInputStream(xqmyPZGi);
		assertEquals("read size", 0, G7LGcedX.getSize());
		IOUtils.copy(G7LGcedX, new NullOutputStream());
		assertEquals("in the end", 30, G7LGcedX.getSize());
	}

}