class n10142186 {
	public static String getMD5Str(String WHghh0DQ) {
		MessageDigest jxFfnU4c = null;
		try {
			jxFfnU4c = MessageDigest.getInstance("MD5");
			jxFfnU4c.reset();
			jxFfnU4c.update(WHghh0DQ.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException s0HVo7Dh) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException SCcmQO9B) {
			SCcmQO9B.printStackTrace();
		}
		byte[] AoH7FGnk = jxFfnU4c.digest();
		StringBuffer Pic6egCG = new StringBuffer();
		for (int KU63JlmZ = 0; KU63JlmZ < AoH7FGnk.length; KU63JlmZ++) {
			if (Integer.toHexString(0xFF & AoH7FGnk[KU63JlmZ]).length() == 1)
				Pic6egCG.append("0").append(Integer.toHexString(0xFF & AoH7FGnk[KU63JlmZ]));
			else
				Pic6egCG.append(Integer.toHexString(0xFF & AoH7FGnk[KU63JlmZ]));
		}
		return Pic6egCG.toString();
	}

}