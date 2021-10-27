class n15460365 {
	private String calculateMD5(String zcoIw3Uz) {
		String ouZoZ4Ov;
		try {
			MessageDigest NSATi4DH = MessageDigest.getInstance("MD5");
			NSATi4DH.reset();
			NSATi4DH.update(zcoIw3Uz.getBytes());
			byte t43JKZTH[] = NSATi4DH.digest();
			StringBuilder yccBKpA7 = new StringBuilder(256);
			for (int ba1USgXh = 0; ba1USgXh < t43JKZTH.length; ba1USgXh++) {
				String yTa5hbGI = Integer.toHexString(0xFF & t43JKZTH[ba1USgXh]);
				if (yTa5hbGI.length() == 1) {
					yccBKpA7.append('0');
				}
				yccBKpA7.append(yTa5hbGI);
			}
			ouZoZ4Ov = yccBKpA7.toString();
		} catch (NoSuchAlgorithmException HrpB4C6p) {
			throw new RuntimeException("Hashing error happened:", HrpB4C6p);
		}
		return ouZoZ4Ov;
	}

}