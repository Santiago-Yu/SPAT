class n16851954 {
	@Test
	public void testTrainingQuickprop() throws IOException {
		File e3cYnJhG = File.createTempFile("fannj_", ".tmp");
		e3cYnJhG.deleteOnExit();
		IOUtils.copy(this.getClass().getResourceAsStream("xor.data"), new FileOutputStream(e3cYnJhG));
		List<Layer> xHi8GhN9 = new ArrayList<Layer>();
		xHi8GhN9.add(Layer.create(2));
		xHi8GhN9.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
		xHi8GhN9.add(Layer.create(1, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
		Fann fc0EY9e8 = new Fann(xHi8GhN9);
		Trainer F7H87HuH = new Trainer(fc0EY9e8);
		F7H87HuH.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_QUICKPROP);
		float P7lzQnSk = .001f;
		float AIdB8WcB = F7H87HuH.train(e3cYnJhG.getPath(), 500000, 1000, P7lzQnSk);
		assertTrue("" + AIdB8WcB, AIdB8WcB <= P7lzQnSk);
	}

}