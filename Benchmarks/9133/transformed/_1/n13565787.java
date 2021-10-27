class n13565787 {
	public static String encryptPassword(String plainPassword) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(plainPassword.getBytes());
			byte[] digestBytes = messageDigest.digest();
			String hex = null;
			int po0Qr = 0;
			while (po0Qr < digestBytes.length) {
				hex = Integer.toHexString(0xFF & digestBytes[po0Qr]);
				if (hex.length() < 2)
					sb.append("0");
				sb.append(hex);
				po0Qr++;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return new String(sb);
	}

}