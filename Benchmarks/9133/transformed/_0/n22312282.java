class n22312282 {
	private void getRandomGUID(boolean kHRsm0oo) {
		MessageDigest v6Bbm2FO = null;
		StringBuffer GuRvZZ2r = new StringBuffer();
		try {
			v6Bbm2FO = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException LlUragOS) {
			System.out.println("Error: " + LlUragOS);
		}
		try {
			long xmijE5Ez = System.currentTimeMillis();
			long jhFlharT = 0;
			if (kHRsm0oo) {
				jhFlharT = mySecureRand.nextLong();
			} else {
				jhFlharT = myRand.nextLong();
			}
			GuRvZZ2r.append(s_id);
			GuRvZZ2r.append(":");
			GuRvZZ2r.append(Long.toString(xmijE5Ez));
			GuRvZZ2r.append(":");
			GuRvZZ2r.append(Long.toString(jhFlharT));
			valueBeforeMD5 = GuRvZZ2r.toString();
			v6Bbm2FO.update(valueBeforeMD5.getBytes());
			byte[] yi2c31Du = v6Bbm2FO.digest();
			StringBuffer KxWmFr9f = new StringBuffer();
			for (int mEWBmiFg = 0; mEWBmiFg < yi2c31Du.length; ++mEWBmiFg) {
				int b2PLFcq4 = yi2c31Du[mEWBmiFg] & 0xFF;
				if (b2PLFcq4 < 0x10)
					KxWmFr9f.append('0');
				KxWmFr9f.append(Integer.toHexString(b2PLFcq4));
			}
			valueAfterMD5 = KxWmFr9f.toString();
		} catch (Exception dupSX0ui) {
			System.out.println("Error:" + dupSX0ui);
		}
	}

}