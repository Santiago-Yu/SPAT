class n616260 {
	static void copy(String JgvmATSF, String jpuW3cCa) throws IOException {
		File o66HyjFa = new File(JgvmATSF);
		File vmYiI22O = new File(jpuW3cCa);
		if (o66HyjFa.exists() == false) {
			throw new IOException("file '" + JgvmATSF + "' does not exist");
		}
		FileInputStream Oz0GRz6Q = new FileInputStream(o66HyjFa);
		FileOutputStream oKm8BQMc = new FileOutputStream(vmYiI22O);
		byte[] wRCtifBc = new byte[1024];
		while (Oz0GRz6Q.read(wRCtifBc) > 0)
			oKm8BQMc.write(wRCtifBc);
		Oz0GRz6Q.close();
		oKm8BQMc.close();
	}

}