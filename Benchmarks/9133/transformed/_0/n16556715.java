class n16556715 {
	public boolean checkPassword(String mHKZcoAI, String PpOHHfb4) {
		boolean CkmSlMe2 = false;
		MessageDigest AHT6anmI = null;
		try {
			AHT6anmI = MessageDigest.getInstance("SHA-1");
			if (PpOHHfb4.regionMatches(true, 0, "{SHA}", 0, 5)) {
				PpOHHfb4 = PpOHHfb4.substring(5);
			} else if (PpOHHfb4.regionMatches(true, 0, "{SSHA}", 0, 6)) {
				PpOHHfb4 = PpOHHfb4.substring(6);
			}
			byte[][] Y2eh2Z8W = split(Base64.decode(PpOHHfb4.getBytes()), 20);
			byte[] BVETRmcA = Y2eh2Z8W[0];
			byte[] QrnXoFgw = Y2eh2Z8W[1];
			AHT6anmI.reset();
			AHT6anmI.update(mHKZcoAI.getBytes());
			AHT6anmI.update(QrnXoFgw);
			byte[] cf32RtR6 = AHT6anmI.digest();
			if (MessageDigest.isEqual(BVETRmcA, cf32RtR6)) {
				CkmSlMe2 = true;
			}
		} catch (NoSuchAlgorithmException FF1wIrWE) {
			CofaxToolsUtil.log("Algorithme SHA-1 non supporte a la verification du password" + FF1wIrWE + id);
		}
		return CkmSlMe2;
	}

}