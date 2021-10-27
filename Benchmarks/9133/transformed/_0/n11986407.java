class n11986407 {
	public static String md5(String AsqEkJP7) {
		String eiHpyEh1 = "";
		try {
			MessageDigest tTquwjjg = MessageDigest.getInstance("MD5");
			tTquwjjg.reset();
			tTquwjjg.update(AsqEkJP7.getBytes());
			byte[] wbN8UXPv = tTquwjjg.digest();
			String TvLHyuer = "";
			for (int yUfvT4hq = 0; yUfvT4hq < wbN8UXPv.length; yUfvT4hq++) {
				TvLHyuer = (Integer.toHexString(0xFF & wbN8UXPv[yUfvT4hq]));
				if (TvLHyuer.length() == 1)
					eiHpyEh1 += "0" + TvLHyuer;
				else
					eiHpyEh1 += TvLHyuer;
			}
		} catch (NoSuchAlgorithmException TDQyCvMi) {
		}
		return eiHpyEh1;
	}

}