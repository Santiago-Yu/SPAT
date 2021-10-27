class n11719103 {
	public static String hash(final String ZQfPEakU) {
		try {
			MessageDigest RkQ49prP;
			RkQ49prP = MessageDigest.getInstance("SHA-1");
			byte[] CLmKcokF = new byte[40];
			RkQ49prP.update(ZQfPEakU.getBytes("iso-8859-1"), 0, ZQfPEakU.length());
			CLmKcokF = RkQ49prP.digest();
			return Sha1.convertToHex(CLmKcokF);
		} catch (final Exception ckUB8guP) {
			return null;
		}
	}

}