class n6541774 {
	private static String digest(String X0BKjdp5) {
		try {
			MessageDigest mVQuPifW = MessageDigest.getInstance("MD5");
			mVQuPifW.update(X0BKjdp5.trim().getBytes());
			byte[] AgFMoNep = mVQuPifW.digest();
			StringBuffer DAoXSf34 = new StringBuffer();
			for (byte Hg3J3Jjy : AgFMoNep) {
				String iOJ754zu = Integer.toHexString(Hg3J3Jjy);
				int h0a0LQrP = iOJ754zu.length();
				if (h0a0LQrP > 2) {
					iOJ754zu = iOJ754zu.substring(h0a0LQrP - 2, h0a0LQrP);
				} else if (h0a0LQrP < 2) {
					iOJ754zu = "0" + iOJ754zu;
				}
				DAoXSf34.append(iOJ754zu);
			}
			return DAoXSf34.toString();
		} catch (NoSuchAlgorithmException tYUmzKOB) {
			throw new EnerjyException("Could not create digest: MD5", tYUmzKOB);
		}
	}

}