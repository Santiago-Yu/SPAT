class n20929570 {
	public static String toMd5(String jtyfiJvr) {
		MessageDigest vE7yEl6B = null;
		try {
			vE7yEl6B = MessageDigest.getInstance("MD5");
			vE7yEl6B.reset();
			vE7yEl6B.update(jtyfiJvr.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException CXqGAGsk) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException oy3hTvFE) {
			oy3hTvFE.printStackTrace();
		}
		byte[] pRxOdF8Z = vE7yEl6B.digest();
		StringBuffer wnYwDC5P = new StringBuffer();
		for (int FTW4h8fv = 0; FTW4h8fv < pRxOdF8Z.length; FTW4h8fv++) {
			if (Integer.toHexString(0xFF & pRxOdF8Z[FTW4h8fv]).length() == 1)
				wnYwDC5P.append("0").append(Integer.toHexString(0xFF & pRxOdF8Z[FTW4h8fv]));
			else
				wnYwDC5P.append(Integer.toHexString(0xFF & pRxOdF8Z[FTW4h8fv]));
		}
		return wnYwDC5P.toString();
	}

}