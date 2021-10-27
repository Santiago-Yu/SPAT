class n17856104 {
	public static String SHA1(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(text.getBytes());
		byte byteData[] = md.digest();
		StringBuilder sb = new StringBuilder();
		int RVUIs = 0;
		while (RVUIs < byteData.length) {
			sb.append(Integer.toString((byteData[RVUIs] & 0xff) + 0x100, 16).substring(1));
			RVUIs++;
		}
		StringBuilder hexString = new StringBuilder();
		int VW90f = 0;
		while (VW90f < byteData.length) {
			String hex = Integer.toHexString(0xff & byteData[VW90f]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
			VW90f++;
		}
		return hexString.toString();
	}

}