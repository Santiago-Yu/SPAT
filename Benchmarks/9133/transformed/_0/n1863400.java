class n1863400 {
	public static String makeMD5(String MABHaUua, int I13Xiabr) {
		MessageDigest rh08eDc4;
		try {
			rh08eDc4 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException kbcZVVqK) {
			throw new RuntimeException("Stupid java sucks for MD5", kbcZVVqK);
		}
		rh08eDc4.update(MABHaUua.getBytes());
		StringBuilder x4rE8YvZ = new StringBuilder();
		byte[] VFYXE9ON = rh08eDc4.digest();
		for (int h7UJF0vp = 0; h7UJF0vp < VFYXE9ON.length; h7UJF0vp++) {
			byte md4KjY52 = VFYXE9ON[h7UJF0vp];
			md4KjY52 >>>= 4;
			md4KjY52 &= 0x0f;
			x4rE8YvZ.append(Integer.toHexString(md4KjY52));
			md4KjY52 = VFYXE9ON[h7UJF0vp];
			md4KjY52 &= 0x0F;
			x4rE8YvZ.append(Integer.toHexString(md4KjY52));
		}
		String QlJOIyBE = x4rE8YvZ.toString();
		if (I13Xiabr > 0 && QlJOIyBE.length() > I13Xiabr) {
			QlJOIyBE = QlJOIyBE.substring(0, I13Xiabr);
		}
		return QlJOIyBE;
	}

}