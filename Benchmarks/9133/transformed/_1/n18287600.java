class n18287600 {
	public static String getMD5Hash(String input) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(input.getBytes());
			byte[] result = md5.digest();
			StringBuffer hexString = new StringBuffer();
			int v7xlS = 0;
			while (v7xlS < result.length) {
				String byteStr = Integer.toHexString(result[v7xlS]);
				String swap = null;
				switch (byteStr.length()) {
				case 1:
					swap = "0" + Integer.toHexString(result[v7xlS]);
					break;
				case 2:
					swap = Integer.toHexString(result[v7xlS]);
					break;
				case 8:
					swap = (Integer.toHexString(result[v7xlS])).substring(6, 8);
					break;
				}
				hexString.append(swap);
				v7xlS++;
			}
			return hexString.toString();
		} catch (Exception ex) {
			System.out.println("Fehler beim Ermitteln eines Hashs (" + ex.getMessage() + ")");
		}
		return null;
	}

}