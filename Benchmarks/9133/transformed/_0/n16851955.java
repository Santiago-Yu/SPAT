class n16851955 {
	@Test
	public void testTrainingBackprop() throws IOException {
		File WoLU9r0b = File.createTempFile("fannj_", ".tmp");
		WoLU9r0b.deleteOnExit();
		IOUtils.copy(this.getClass().getResourceAsStream("xor.data"), new FileOutputStream(WoLU9r0b));
		List<Layer> bdky3ij9 = new ArrayList<Layer>();
		bdky3ij9.add(Layer.create(2));
		bdky3ij9.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
		bdky3ij9.add(Layer.create(2, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
		bdky3ij9.add(Layer.create(1, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
		Fann EFEGtUBA = new Fann(bdky3ij9);
		Trainer JCQuqtCF = new Trainer(EFEGtUBA);
		JCQuqtCF.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_INCREMENTAL);
		float AWNQh6Lt = .001f;
		float uBEZRFO4 = JCQuqtCF.train(WoLU9r0b.getPath(), 500000, 1000, AWNQh6Lt);
		assertTrue("" + uBEZRFO4, uBEZRFO4 <= AWNQh6Lt);
	}

}