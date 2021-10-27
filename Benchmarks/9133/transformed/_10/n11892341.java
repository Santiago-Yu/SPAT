class n11892341 {
	private static byte[] getHashValue(INewEntryDescriptor descriptor) {
		MessageDigest sha1;
		String timeStamp = Calendar.getInstance().getTime().toString();
		byte[] digest = { 0 };
		try {
			sha1 = MessageDigest.getInstance("SHA-1");
			sha1.update(descriptor.getContactName().getBytes());
			sha1.update(descriptor.getAlgorithmName().getBytes());
			sha1.update(descriptor.getProvider().getBytes());
			return digest = sha1.digest(timeStamp.getBytes());
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException while digesting", e);
		}
		return digest;
	}

}