class n14887616 {
	private void getRandomGUID(boolean BQWYeTfh) {
		MessageDigest qX0Z9vGd = null;
		StringBuffer TXGaqiah = new StringBuffer();
		try {
			qX0Z9vGd = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException GV2bQn6c) {
			System.out.println("Error: " + GV2bQn6c);
		}
		try {
			long mZRrH1Rf = System.currentTimeMillis();
			long Kg7f7rFH = 0;
			if (BQWYeTfh) {
				Kg7f7rFH = mySecureRand.nextLong();
			} else {
				Kg7f7rFH = myRand.nextLong();
			}
			TXGaqiah.append(s_id);
			TXGaqiah.append(":");
			TXGaqiah.append(Long.toString(mZRrH1Rf));
			TXGaqiah.append(":");
			TXGaqiah.append(Long.toString(Kg7f7rFH));
			valueBeforeMD5 = TXGaqiah.toString();
			qX0Z9vGd.update(valueBeforeMD5.getBytes());
			byte[] PRzrHjTC = qX0Z9vGd.digest();
			StringBuffer DtWljFkT = new StringBuffer();
			for (int kgTwz76g = 0; kgTwz76g < PRzrHjTC.length; ++kgTwz76g) {
				int Ao1thgsh = PRzrHjTC[kgTwz76g] & 0xFF;
				if (Ao1thgsh < 0x10)
					DtWljFkT.append('0');
				DtWljFkT.append(Integer.toHexString(Ao1thgsh));
			}
			valueAfterMD5 = DtWljFkT.toString();
		} catch (Exception mJoIAUXb) {
			System.out.println("Error:" + mJoIAUXb);
		}
	}

}