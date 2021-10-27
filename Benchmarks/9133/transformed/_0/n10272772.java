class n10272772 {
	private void getRandomGUID(boolean YneHNVhf) {
		MessageDigest zR8CYRf6 = null;
		StringBuffer GMaWc0eh = new StringBuffer();
		try {
			zR8CYRf6 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException SxmCQcVG) {
			System.out.println("Error: " + SxmCQcVG);
		}
		try {
			long ici0CPK5 = System.currentTimeMillis();
			long dDsiY1oJ = 0;
			if (YneHNVhf) {
				dDsiY1oJ = mySecureRand.nextLong();
			} else {
				dDsiY1oJ = myRand.nextLong();
			}
			GMaWc0eh.append(s_id);
			GMaWc0eh.append(":");
			GMaWc0eh.append(Long.toString(ici0CPK5));
			GMaWc0eh.append(":");
			GMaWc0eh.append(Long.toString(dDsiY1oJ));
			valueBeforeMD5 = GMaWc0eh.toString();
			zR8CYRf6.update(valueBeforeMD5.getBytes());
			byte[] icwpGHbY = zR8CYRf6.digest();
			StringBuffer Rj79Kqch = new StringBuffer();
			for (int tcyiLkEJ = 0; tcyiLkEJ < icwpGHbY.length; ++tcyiLkEJ) {
				int KYPCiO7A = icwpGHbY[tcyiLkEJ] & 0xFF;
				if (KYPCiO7A < 0x10) {
					Rj79Kqch.append('0');
				}
				Rj79Kqch.append(Integer.toHexString(KYPCiO7A));
			}
			valueAfterMD5 = Rj79Kqch.toString();
		} catch (Exception NkWRfhfd) {
			System.out.println("Error:" + NkWRfhfd);
		}
	}

}