class n607094 {
	public static String MD5(String ziRoA6Hw) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest gfyJ7coj;
		gfyJ7coj = MessageDigest.getInstance("MD5");
		byte[] rOqdGZjs = new byte[32];
		gfyJ7coj.update(ziRoA6Hw.getBytes("iso-8859-1"), 0, ziRoA6Hw.length());
		rOqdGZjs = gfyJ7coj.digest();
		return convertToHex(rOqdGZjs);
	}

}