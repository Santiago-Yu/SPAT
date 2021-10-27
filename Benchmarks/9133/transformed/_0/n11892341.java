class n11892341 {
	private static byte[] getHashValue(INewEntryDescriptor pyYk37XF) {
		String ElieWISH = Calendar.getInstance().getTime().toString();
		MessageDigest sjkwblc6;
		byte[] p61IEXJB = { 0 };
		try {
			sjkwblc6 = MessageDigest.getInstance("SHA-1");
			sjkwblc6.update(pyYk37XF.getContactName().getBytes());
			sjkwblc6.update(pyYk37XF.getAlgorithmName().getBytes());
			sjkwblc6.update(pyYk37XF.getProvider().getBytes());
			return p61IEXJB = sjkwblc6.digest(ElieWISH.getBytes());
		} catch (NoSuchAlgorithmException B1002icA) {
			logger.error("NoSuchAlgorithmException while digesting", B1002icA);
		}
		return p61IEXJB;
	}

}