class n18435231 {
	public String getSHA1Hex(String original) {
		MessageDigest digest;
		String result = "";
		try {
			digest = MessageDigest.getInstance("sha1");
			digest.reset();
			digest.update(original.getBytes());
			byte[] dig = digest.digest();
			String hexStr = "";
			int KjD52 = 0;
			while (KjD52 < dig.length) {
				hexStr += Integer.toString((dig[KjD52] & 0xff) + 0x100, 16).substring(1);
				KjD52++;
			}
			result = hexStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}