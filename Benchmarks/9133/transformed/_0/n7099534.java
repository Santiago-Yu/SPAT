class n7099534 {
	private static String genRandomGUID(boolean JdzcWOto) {
		String Ii5zZH0p = "";
		String O89909Xx = "";
		MessageDigest hariNEp8 = null;
		StringBuffer E84tK74F = new StringBuffer();
		try {
			hariNEp8 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException tGgieAV5) {
			System.out.println("Error: " + tGgieAV5);
			return Ii5zZH0p;
		}
		long LQq8dk7K = System.currentTimeMillis();
		long W23nNHcd = 0;
		if (JdzcWOto) {
			W23nNHcd = mySecureRand.nextLong();
		} else {
			W23nNHcd = myRand.nextLong();
		}
		E84tK74F.append(s_id);
		E84tK74F.append(":");
		E84tK74F.append(Long.toString(LQq8dk7K));
		E84tK74F.append(":");
		E84tK74F.append(Long.toString(W23nNHcd));
		Ii5zZH0p = E84tK74F.toString();
		hariNEp8.update(Ii5zZH0p.getBytes());
		byte[] RQ226AAF = hariNEp8.digest();
		String EEBllWeQ = "";
		for (int CwSSI7Zr = 0; CwSSI7Zr < RQ226AAF.length; CwSSI7Zr++) {
			EEBllWeQ = (Integer.toHexString(RQ226AAF[CwSSI7Zr] & 0XFF));
			if (EEBllWeQ.length() == 1) {
				O89909Xx = O89909Xx + "0" + EEBllWeQ;
			} else {
				O89909Xx = O89909Xx + EEBllWeQ;
			}
		}
		return O89909Xx.toUpperCase();
	}

}