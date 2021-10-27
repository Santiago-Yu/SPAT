class n10425169 {
	private void getRandomGUID(boolean vYncUfZG, Object COR5ppC2) {
		MessageDigest tBLaxiUd = null;
		StringBuffer U5FBLHIw = new StringBuffer();
		try {
			tBLaxiUd = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException lKFH69ku) {
			System.out.println("Error: " + lKFH69ku);
		}
		try {
			long KLe5vZaM = System.currentTimeMillis();
			long OsNkyjW9 = 0;
			if (vYncUfZG) {
				OsNkyjW9 = mySecureRand.nextLong();
			} else {
				OsNkyjW9 = myRand.nextLong();
			}
			U5FBLHIw.append(COR5ppC2.getClass().getName());
			U5FBLHIw.append(":");
			U5FBLHIw.append(s_id);
			U5FBLHIw.append(":");
			U5FBLHIw.append(Long.toString(KLe5vZaM));
			U5FBLHIw.append(":");
			U5FBLHIw.append(Long.toString(OsNkyjW9));
			valueBeforeMD5 = U5FBLHIw.toString();
			tBLaxiUd.update(valueBeforeMD5.getBytes());
			byte[] uXnzUGzM = tBLaxiUd.digest();
			StringBuffer SFjUkqaH = new StringBuffer();
			for (int wzQRVHPd = 0; wzQRVHPd < uXnzUGzM.length; ++wzQRVHPd) {
				int QuZ4Czne = uXnzUGzM[wzQRVHPd] & 0xFF;
				if (QuZ4Czne < 0x10)
					SFjUkqaH.append('0');
				SFjUkqaH.append(Integer.toHexString(QuZ4Czne));
			}
			valueAfterMD5 = SFjUkqaH.toString();
		} catch (Exception TGGQ0cPf) {
			System.out.println("Error:" + TGGQ0cPf);
		}
	}

}