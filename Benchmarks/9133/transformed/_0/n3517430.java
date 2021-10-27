class n3517430 {
	public static String getMD5Str(String v4M3KIwO) {
		MessageDigest Ox1c9jpX = null;
		try {
			Ox1c9jpX = MessageDigest.getInstance("MD5");
			Ox1c9jpX.reset();
			Ox1c9jpX.update(v4M3KIwO.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException zN8c37DJ) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException OH0ebdtR) {
			OH0ebdtR.printStackTrace();
		}
		byte[] SKERfFhD = Ox1c9jpX.digest();
		StringBuffer UOv9tNWi = new StringBuffer();
		for (int hDSfzx15 = 0; hDSfzx15 < SKERfFhD.length; hDSfzx15++) {
			if (Integer.toHexString(0xFF & SKERfFhD[hDSfzx15]).length() == 1)
				UOv9tNWi.append("0").append(Integer.toHexString(0xFF & SKERfFhD[hDSfzx15]));
			else
				UOv9tNWi.append(Integer.toHexString(0xFF & SKERfFhD[hDSfzx15]));
		}
		return UOv9tNWi.toString();
	}

}