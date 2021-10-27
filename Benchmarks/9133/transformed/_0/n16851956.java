class n16851956 {
	@Test
	public void testCascadeTraining() throws IOException {
		File y3n4Y2Y5 = File.createTempFile("fannj_", ".tmp");
		y3n4Y2Y5.deleteOnExit();
		IOUtils.copy(this.getClass().getResourceAsStream("parity8.train"), new FileOutputStream(y3n4Y2Y5));
		Fann Q7cZE7U8 = new FannShortcut(8, 1);
		Trainer RmeRwlx7 = new Trainer(Q7cZE7U8);
		float d1NwXwFv = .00f;
		float SmHmCK6R = RmeRwlx7.cascadeTrain(y3n4Y2Y5.getPath(), 30, 1, d1NwXwFv);
		assertTrue("" + SmHmCK6R, SmHmCK6R <= d1NwXwFv);
	}

}