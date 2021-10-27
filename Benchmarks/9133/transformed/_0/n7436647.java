class n7436647 {
	@Test
	public void testFromFile() throws IOException {
		File X8L1aIds = File.createTempFile("fannj_", ".tmp");
		X8L1aIds.deleteOnExit();
		IOUtils.copy(this.getClass().getResourceAsStream("xor_float.net"), new FileOutputStream(X8L1aIds));
		Fann r2WyiJTc = new Fann(X8L1aIds.getPath());
		assertEquals(2, r2WyiJTc.getNumInputNeurons());
		assertEquals(1, r2WyiJTc.getNumOutputNeurons());
		assertEquals(-1f, r2WyiJTc.run(new float[] { -1, -1 })[0], .2f);
		assertEquals(1f, r2WyiJTc.run(new float[] { -1, 1 })[0], .2f);
		assertEquals(1f, r2WyiJTc.run(new float[] { 1, -1 })[0], .2f);
		assertEquals(-1f, r2WyiJTc.run(new float[] { 1, 1 })[0], .2f);
		r2WyiJTc.close();
	}

}