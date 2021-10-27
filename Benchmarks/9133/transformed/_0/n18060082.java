class n18060082 {
	public static String generateDigest(String MSGEymJP, String OmC6pAIy, String VQZke2Wa) {
		try {
			MessageDigest HDJZheyX = MessageDigest.getInstance(VQZke2Wa);
			byte[] y88ClF9z = new byte[0];
			if (OmC6pAIy != null) {
				y88ClF9z = fromHex(OmC6pAIy);
			}
			String NGy90ZrN = null;
			if (VQZke2Wa.startsWith("SHA")) {
				NGy90ZrN = (y88ClF9z.length <= 0) ? "{SHA}" : "{SSHA}";
			} else if (VQZke2Wa.startsWith("MD5")) {
				NGy90ZrN = (y88ClF9z.length <= 0) ? "{MD5}" : "{SMD5}";
			}
			HDJZheyX.reset();
			HDJZheyX.update(MSGEymJP.getBytes());
			HDJZheyX.update(y88ClF9z);
			byte[] vk3N5CcR = HDJZheyX.digest();
			StringBuffer V6bPiPAU = new StringBuffer(NGy90ZrN);
			V6bPiPAU.append(Base64.encode(concatenate(vk3N5CcR, y88ClF9z)).toCharArray());
			return V6bPiPAU.toString();
		} catch (NoSuchAlgorithmException liEh9bur) {
			throw new RuntimeException("failed to find " + "algorithm for password hashing.", liEh9bur);
		}
	}

}