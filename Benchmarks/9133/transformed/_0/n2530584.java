class n2530584 {
	public static String md5(String ZeHSB1qM) {
		try {
			MessageDigest ne5kbbPM = MessageDigest.getInstance("MD5");
			ne5kbbPM.update(ZeHSB1qM.getBytes());
			return convertToHex(ne5kbbPM.digest());
		} catch (Exception ia989j6i) {
			throw new RuntimeException(ia989j6i.getMessage(), ia989j6i);
		}
	}

}