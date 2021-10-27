class n16851953 {
	@Test
	public void testTrainingDefault() throws IOException {
		File JGQ473K2 = File.createTempFile("fannj_", ".tmp");
		JGQ473K2.deleteOnExit();
		IOUtils.copy(this.getClass().getResourceAsStream("xor.data"), new FileOutputStream(JGQ473K2));
		List<Layer> bP5g5lbr = new ArrayList<Layer>();
		bP5g5lbr.add(Layer.create(2));
		bP5g5lbr.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
		bP5g5lbr.add(Layer.create(1, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
		Fann pFd9JjZa = new Fann(bP5g5lbr);
		Trainer VmixxcsA = new Trainer(pFd9JjZa);
		float VyLuc1Vv = .001f;
		float g4XZjWUw = VmixxcsA.train(JGQ473K2.getPath(), 500000, 1000, VyLuc1Vv);
		assertTrue("" + g4XZjWUw, g4XZjWUw <= VyLuc1Vv);
	}

}