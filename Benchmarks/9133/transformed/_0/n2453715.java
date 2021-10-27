class n2453715 {
	public String digestPassword(String KR6Gc2DQ) {
		StringBuffer Lg8xMb2y = new StringBuffer();
		try {
			MessageDigest AOeHzCv6 = MessageDigest.getInstance("MD5");
			AOeHzCv6.reset();
			AOeHzCv6.update(KR6Gc2DQ.getBytes());
			byte[] P6Kr27hl = AOeHzCv6.digest();
			for (byte ypCmwQ5m : P6Kr27hl) {
				Lg8xMb2y.append(Integer.toHexString(0xFF & ypCmwQ5m));
			}
		} catch (NoSuchAlgorithmException f3t6HDG2) {
			f3t6HDG2.printStackTrace();
		}
		return Lg8xMb2y.toString();
	}

}