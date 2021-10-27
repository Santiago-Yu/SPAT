class n14430650 {
	private String computeHash(String FkqeznAw) {
		StringBuffer ePFjCcLt = new StringBuffer();
		byte[] q7fYDDdM;
		int Y6KtlJ86;
		try {
			MessageDigest MHsD5goZ = MessageDigest.getInstance(hashAlgorithmName);
			MHsD5goZ.reset();
			MHsD5goZ.update(FkqeznAw.getBytes());
			q7fYDDdM = MHsD5goZ.digest();
		} catch (NoSuchAlgorithmException sKSMt96V) {
			return null;
		}
		for (Y6KtlJ86 = 0; Y6KtlJ86 < q7fYDDdM.length; Y6KtlJ86++)
			ePFjCcLt.append(((q7fYDDdM[Y6KtlJ86] >= 0 && q7fYDDdM[Y6KtlJ86] <= 15) ? "0" : "")
					+ Integer.toHexString(q7fYDDdM[Y6KtlJ86] & 0xFF));
		return ePFjCcLt.toString();
	}

}