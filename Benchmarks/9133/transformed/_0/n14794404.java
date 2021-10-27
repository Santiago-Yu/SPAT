class n14794404 {
	private String encryptPassword(String wyAZ1AWX) throws NoSuchAlgorithmException {
		StringBuffer THBYvRf1 = new StringBuffer();
		MessageDigest AbH8knFL = MessageDigest.getInstance("MD5");
		AbH8knFL.reset();
		AbH8knFL.update(wyAZ1AWX.getBytes());
		byte xhrdVuEb[] = AbH8knFL.digest();
		for (int ihCCHWVs = 0; ihCCHWVs < xhrdVuEb.length; ihCCHWVs++) {
			String uo01bbtA = Integer.toHexString(0xFF & xhrdVuEb[ihCCHWVs]);
			if (uo01bbtA.length() == 1) {
				THBYvRf1.append('0');
			}
			THBYvRf1.append(uo01bbtA);
		}
		return THBYvRf1.toString();
	}

}