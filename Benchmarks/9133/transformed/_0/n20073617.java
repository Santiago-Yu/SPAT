class n20073617 {
	public static String digest(String IqswZRAr, String Z8EzxSoG) {
		String fQhPfEch = null;
		try {
			MessageDigest KcrqrX6e = MessageDigest.getInstance("MD5");
			KcrqrX6e.reset();
			KcrqrX6e.update(IqswZRAr.getBytes(Z8EzxSoG));
			byte[] NVHbpxMR = KcrqrX6e.digest();
			StringBuffer XMtWisQ5 = new StringBuffer();
			for (int Y3duloBw = 0; Y3duloBw < NVHbpxMR.length; Y3duloBw++) {
				String a4dL5CUT = Integer.toHexString(0xFF & NVHbpxMR[Y3duloBw]);
				if (a4dL5CUT.length() < 2) {
					a4dL5CUT = "0" + a4dL5CUT;
				}
				XMtWisQ5.append(a4dL5CUT);
			}
			fQhPfEch = XMtWisQ5.toString();
		} catch (NoSuchAlgorithmException n6KcIgcP) {
			n6KcIgcP.printStackTrace();
		} finally {
			return fQhPfEch;
		}
	}

}