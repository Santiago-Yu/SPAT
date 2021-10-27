class n17224030 {
	private void getRandomGUID(boolean JKolROxe) {
		MessageDigest NCB6lBrC = null;
		StringBuffer Ql0ZoVrF = new StringBuffer();
		try {
			NCB6lBrC = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ZoRd9ML8) {
			System.out.println("Error: " + ZoRd9ML8);
		}
		try {
			long zHyg8Lbw = System.currentTimeMillis();
			long mhxNT771 = 0;
			if (JKolROxe) {
				mhxNT771 = mySecureRand.nextLong();
			} else {
				mhxNT771 = myRand.nextLong();
			}
			Ql0ZoVrF.append(s_id);
			Ql0ZoVrF.append(":");
			Ql0ZoVrF.append(Long.toString(zHyg8Lbw));
			Ql0ZoVrF.append(":");
			Ql0ZoVrF.append(Long.toString(mhxNT771));
			valueBeforeMD5 = Ql0ZoVrF.toString();
			NCB6lBrC.update(valueBeforeMD5.getBytes());
			byte[] uLUtx0lZ = NCB6lBrC.digest();
			StringBuffer Zj8funul = new StringBuffer();
			for (int ts0dBLB4 = 0; ts0dBLB4 < uLUtx0lZ.length; ++ts0dBLB4) {
				int oty1Oz0A = uLUtx0lZ[ts0dBLB4] & 0xFF;
				if (oty1Oz0A < 0x10)
					Zj8funul.append('0');
				Zj8funul.append(Integer.toHexString(oty1Oz0A));
			}
			valueAfterMD5 = Zj8funul.toString();
		} catch (Exception zg2vRGNL) {
			System.out.println("Error:" + zg2vRGNL);
		}
	}

}