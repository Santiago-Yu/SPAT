class n18287600 {
	public static String getMD5Hash(String input) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(input.getBytes());
			byte[] result = md5.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				String byteStr = Integer.toHexString(result[i]);
				String swap = null;
				if (byteStr.length() == 1) {
					swap = "0" + Integer.toHexString(result[i]);
				} else if (byteStr.length() == 8) {
					swap = (Integer.toHexString(result[i])).substring(6, 8);
				} else if (byteStr.length() == 2) {
					swap = Integer.toHexString(result[i]);
				}
				hexString.append(swap);
			}
			return hexString.toString();
		} catch (Exception ex) {
			System.out.println("Fehler beim Ermitteln eines Hashs (" + ex.getMessage() + ")");
		}
		return null;
	}

}