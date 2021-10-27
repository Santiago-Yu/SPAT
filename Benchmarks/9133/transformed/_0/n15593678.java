class n15593678 {
	private static void copyFile(File HgnrQqi8, File sMTaoXmi) throws Exception {
		final FileInputStream KFyvvp5k = new FileInputStream(HgnrQqi8);
		try {
			final FileOutputStream PR5bgJj0 = new FileOutputStream(sMTaoXmi);
			try {
				final byte[] NpMbZ3BJ = new byte[4096];
				int nnedeDuy = 0;
				while ((nnedeDuy = KFyvvp5k.read(NpMbZ3BJ)) != -1) {
					PR5bgJj0.write(NpMbZ3BJ, 0, nnedeDuy);
				}
			} finally {
				PR5bgJj0.close();
			}
		} finally {
			KFyvvp5k.close();
		}
	}

}