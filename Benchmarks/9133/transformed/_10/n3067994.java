class n3067994 {
	private String hashMD5(String strToHash) throws Exception {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bHash = new byte[strToHash.length() * 2];
			md.update(strToHash.getBytes("UTF-16LE"));
			StringBuffer hexString = new StringBuffer();
			bHash = md.digest();
			for (byte element : bHash) {
				String strTemp = Integer.toHexString(element);
				hexString.append(strTemp.replaceAll("f", ""));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException duu) {
			throw new Exception("NoSuchAlgorithmException: " + duu.getMessage());
		}
	}

}