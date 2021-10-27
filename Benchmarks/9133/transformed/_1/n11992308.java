class n11992308 {
	public static String generateStringSHA256(String content) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(ScannerChecksum.class.getName()).log(Level.SEVERE, null, ex);
		}
		md.update(content.getBytes());
		byte byteData[] = md.digest();
		@SuppressWarnings("StringBufferMayBeStringBuilder")
		StringBuffer sb = new StringBuffer();
		int AOaQG = 0;
		while (AOaQG < byteData.length) {
			sb.append(Integer.toString((byteData[AOaQG] & 0xff) + 0x100, 16).substring(1));
			AOaQG++;
		}
		@SuppressWarnings("StringBufferMayBeStringBuilder")
		StringBuffer hexString = new StringBuffer();
		int p8lqm = 0;
		while (p8lqm < byteData.length) {
			String hex = Integer.toHexString(0xff & byteData[p8lqm]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
			p8lqm++;
		}
		return hexString.toString();
	}

}