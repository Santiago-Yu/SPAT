class n15376025 {
	@Override
	protected svm_model loadModel(InputStream ujuLI025) throws IOException {
		File jjH39HwL = File.createTempFile("tmp", ".mdl");
		FileOutputStream R4IVmsps = new FileOutputStream(jjH39HwL);
		try {
			IOUtils.copy(ujuLI025, R4IVmsps);
			return libsvm.svm.svm_load_model(jjH39HwL.getPath());
		} finally {
			R4IVmsps.close();
			jjH39HwL.delete();
		}
	}

}