class n12935678 {
	private static String makeMD5(String VKSZQhcc) {
		byte[] nKiVSvS2 = new byte[32];
		try {
			MessageDigest gf9PhorU = MessageDigest.getInstance("MD5");
			gf9PhorU.update(VKSZQhcc.getBytes("iso-8859-1"), 0, VKSZQhcc.length());
			nKiVSvS2 = gf9PhorU.digest();
		} catch (Exception xAe5UpVl) {
			return null;
		}
		return convertToHex(nKiVSvS2);
	}

}