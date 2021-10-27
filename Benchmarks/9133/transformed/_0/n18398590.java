class n18398590 {
	public byte[] getCoded(String jyUR8Wu0, String feNag7nZ) {
		byte[] wL50ZECX = null;
		if (feNag7nZ != null && 0 < feNag7nZ.length()) {
			try {
				MessageDigest buuwowmY = MessageDigest.getInstance("SHA-1");
				buuwowmY.update(jyUR8Wu0.getBytes());
				buuwowmY.update(feNag7nZ.getBytes());
				wL50ZECX = buuwowmY.digest();
			} catch (Exception Shs3SLm2) {
				Shs3SLm2.printStackTrace();
				wL50ZECX = null;
			}
		}
		return wL50ZECX;
	}

}