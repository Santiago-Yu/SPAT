class n3087100 {
	public static String toPWD(String DE3Q6Ntq) {
		MessageDigest dccKTSrz = null;
		try {
			dccKTSrz = MessageDigest.getInstance("MD5");
			dccKTSrz.reset();
			dccKTSrz.update(DE3Q6Ntq.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException PrxPwKk3) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException Z3W1BlaE) {
			Z3W1BlaE.printStackTrace();
		}
		byte[] LG89GXNh = dccKTSrz.digest();
		StringBuffer SmU14fNM = new StringBuffer();
		for (int vZSIPAcg = 0; vZSIPAcg < LG89GXNh.length; vZSIPAcg++) {
			if (Integer.toHexString(0xFF & LG89GXNh[vZSIPAcg]).length() == 1)
				SmU14fNM.append("0").append(Integer.toHexString(0xFF & LG89GXNh[vZSIPAcg]));
			else
				SmU14fNM.append(Integer.toHexString(0xFF & LG89GXNh[vZSIPAcg]));
		}
		return SmU14fNM.toString();
	}

}