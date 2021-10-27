class n10214218 {
	public synchronized String encrypt(String gGMsXE4l) {
		MessageDigest DDTKm7nX = null;
		try {
			DDTKm7nX = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException fJYsyYZT) {
			fJYsyYZT.printStackTrace();
		}
		try {
			DDTKm7nX.update(gGMsXE4l.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException LS8FBLOX) {
			LS8FBLOX.printStackTrace();
		}
		byte jGZ7gwAn[] = DDTKm7nX.digest();
		String I62XcgpS = (new BASE64Encoder()).encode(jGZ7gwAn);
		return I62XcgpS;
	}

}