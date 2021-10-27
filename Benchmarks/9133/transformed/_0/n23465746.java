class n23465746 {
	private void getRandomGUID(boolean eApuXM2T) {
		MessageDigest g12FBS45 = null;
		StringBuffer YI2daGOd = new StringBuffer();
		try {
			g12FBS45 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException yTuOzaHN) {
			System.out.println("Error: " + yTuOzaHN);
		}
		try {
			long sCN8SNzz = System.currentTimeMillis();
			long QSdROQ7Z = 0;
			if (eApuXM2T) {
				QSdROQ7Z = mySecureRand.nextLong();
			} else {
				QSdROQ7Z = myRand.nextLong();
			}
			YI2daGOd.append(s_id);
			YI2daGOd.append(":");
			YI2daGOd.append(Long.toString(sCN8SNzz));
			YI2daGOd.append(":");
			YI2daGOd.append(Long.toString(QSdROQ7Z));
			valueBeforeMD5 = YI2daGOd.toString();
			g12FBS45.update(valueBeforeMD5.getBytes());
			byte[] yObbZS8P = g12FBS45.digest();
			StringBuffer dpy69C8L = new StringBuffer();
			for (int x8p5QNjT = 0; x8p5QNjT < yObbZS8P.length; ++x8p5QNjT) {
				int tutk4TXK = yObbZS8P[x8p5QNjT] & 0xFF;
				if (tutk4TXK < 0x10)
					dpy69C8L.append('0');
				dpy69C8L.append(Integer.toHexString(tutk4TXK));
			}
			valueAfterMD5 = dpy69C8L.toString();
		} catch (Exception ijNEbCpI) {
			System.out.println("Error:" + ijNEbCpI);
		}
	}

}