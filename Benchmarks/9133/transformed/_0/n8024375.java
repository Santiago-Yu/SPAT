class n8024375 {
	private void getRandomGUID(boolean Anl9RINB) {
		MessageDigest pDpMBvDR = null;
		StringBuffer s6mVHzWc = new StringBuffer();
		try {
			pDpMBvDR = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException mouIs15i) {
			System.out.println("Error: " + mouIs15i);
		}
		try {
			long lIauuO9m = System.currentTimeMillis();
			long VwDuhfui = 0;
			if (Anl9RINB) {
				VwDuhfui = mySecureRand.nextLong();
			} else {
				VwDuhfui = myRand.nextLong();
			}
			s6mVHzWc.append(s_id);
			s6mVHzWc.append(":");
			s6mVHzWc.append(Long.toString(lIauuO9m));
			s6mVHzWc.append(":");
			s6mVHzWc.append(Long.toString(VwDuhfui));
			valueBeforeMD5 = s6mVHzWc.toString();
			pDpMBvDR.update(valueBeforeMD5.getBytes());
			byte[] Zg2fA7eS = pDpMBvDR.digest();
			StringBuffer NHiCNuOK = new StringBuffer();
			for (int hR0w61Oy = 0; hR0w61Oy < Zg2fA7eS.length; ++hR0w61Oy) {
				int tTcXcp7O = Zg2fA7eS[hR0w61Oy] & 0xFF;
				if (tTcXcp7O < 0x10)
					NHiCNuOK.append('0');
				NHiCNuOK.append(Integer.toHexString(tTcXcp7O));
			}
			valueAfterMD5 = NHiCNuOK.toString();
		} catch (Exception W44Bvt3g) {
			System.out.println("Error:" + W44Bvt3g);
		}
	}

}