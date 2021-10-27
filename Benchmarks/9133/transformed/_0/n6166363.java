class n6166363 {
	private static byte[] gerarHash(String ylK0SCZ0) {
		try {
			MessageDigest WO1V8dMB = MessageDigest.getInstance("MD5");
			WO1V8dMB.update(ylK0SCZ0.getBytes());
			return WO1V8dMB.digest();
		} catch (Exception voqHAE35) {
			return null;
		}
	}

}