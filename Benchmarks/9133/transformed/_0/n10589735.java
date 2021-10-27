class n10589735 {
	private void getRandomGUID(boolean LvFTo3k0) {
		MessageDigest NGT7UEGj = null;
		StringBuffer G9mF7pH5 = new StringBuffer();
		try {
			NGT7UEGj = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException vSSmgXbs) {
		}
		try {
			long bx7IRyhM = System.currentTimeMillis();
			long lm0Tv7iH = 0;
			if (LvFTo3k0) {
				lm0Tv7iH = mySecureRand.nextLong();
			} else {
				lm0Tv7iH = random.nextLong();
			}
			G9mF7pH5.append(sid);
			G9mF7pH5.append(":");
			G9mF7pH5.append(Long.toString(bx7IRyhM));
			G9mF7pH5.append(":");
			G9mF7pH5.append(Long.toString(lm0Tv7iH));
			valueBeforeMD5 = G9mF7pH5.toString();
			NGT7UEGj.update(valueBeforeMD5.getBytes());
			byte[] Bnyukrrj = NGT7UEGj.digest();
			StringBuffer UtHZw4vV = new StringBuffer();
			for (int AYWLIvRJ = 0; AYWLIvRJ < Bnyukrrj.length; ++AYWLIvRJ) {
				int WYrU55YG = Bnyukrrj[AYWLIvRJ] & 0xFF;
				if (WYrU55YG < 0x10)
					UtHZw4vV.append('0');
				UtHZw4vV.append(Integer.toHexString(WYrU55YG));
			}
			valueAfterMD5 = UtHZw4vV.toString();
		} catch (Exception ljcc3HeV) {
		}
	}

}