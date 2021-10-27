class n2723378 {
	public String getMD5Str(String yR1nx398) {
		MessageDigest GonPRwin = null;
		String mhY8O1p9 = null;
		try {
			GonPRwin = MessageDigest.getInstance("MD5");
			GonPRwin.reset();
			GonPRwin.update(yR1nx398.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException iEzlz8Jf) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException xgGqHDnw) {
			xgGqHDnw.printStackTrace();
		}
		byte[] kgb8ryaP = GonPRwin.digest();
		StringBuffer v0J7I9QS = new StringBuffer();
		for (int E9oK505x = 0; E9oK505x < kgb8ryaP.length; E9oK505x++) {
			if (Integer.toHexString(0xFF & kgb8ryaP[E9oK505x]).length() == 1)
				v0J7I9QS.append("0").append(Integer.toHexString(0xFF & kgb8ryaP[E9oK505x]));
			else
				v0J7I9QS.append(Integer.toHexString(0xFF & kgb8ryaP[E9oK505x]));
		}
		mhY8O1p9 = v0J7I9QS.toString();
		return mhY8O1p9;
	}

}