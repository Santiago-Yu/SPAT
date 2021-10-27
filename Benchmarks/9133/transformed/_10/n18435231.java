class n18435231 {
	public String getSHA1Hex(String original) {
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("sha1");
			digest.reset();
			digest.update(original.getBytes());
			String hexStr = "";
			byte[] dig = digest.digest();
			for (int i = 0; i < dig.length; i++) {
				hexStr += Integer.toString((dig[i] & 0xff) + 0x100, 16).substring(1);
			}
			result = hexStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}