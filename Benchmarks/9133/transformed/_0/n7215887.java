class n7215887 {
	public static String encrypt(String pQNRblBq, Long fqlJ1njT) {
		try {
			MessageDigest klCY4exi = MessageDigest.getInstance("MD5");
			klCY4exi.reset();
			klCY4exi.update(pQNRblBq.getBytes("UTF-8"));
			klCY4exi.update(fqlJ1njT.toString().getBytes("UTF-8"));
			byte[] eKseRVdA = klCY4exi.digest();
			StringBuffer CKHN50EA = new StringBuffer();
			for (int mohys5tj = 0; mohys5tj < eKseRVdA.length; mohys5tj++) {
				CKHN50EA.append(Integer.toHexString(0xff & eKseRVdA[mohys5tj]));
			}
			return CKHN50EA.toString();
		} catch (NoSuchAlgorithmException RGZM6aqQ) {
			throw new RuntimeException(RGZM6aqQ);
		} catch (UnsupportedEncodingException oMiSnXnd) {
			throw new RuntimeException(oMiSnXnd);
		}
	}

}