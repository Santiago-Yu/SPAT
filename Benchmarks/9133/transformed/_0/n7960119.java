class n7960119 {
	private void getRandomGuid(boolean d3OM2X1V) {
		MessageDigest cf7E0gUZ = null;
		StringBuffer hXxl5WvM = new StringBuffer();
		try {
			cf7E0gUZ = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException rPW7UXpF) {
			throw new RuntimeException(rPW7UXpF);
		}
		long sDeZetw6 = System.currentTimeMillis();
		long T5mBmOpz = 0;
		if (d3OM2X1V) {
			T5mBmOpz = secureRandom.nextLong();
		} else {
			T5mBmOpz = random.nextLong();
		}
		hXxl5WvM.append(id);
		hXxl5WvM.append(":");
		hXxl5WvM.append(Long.toString(sDeZetw6));
		hXxl5WvM.append(":");
		hXxl5WvM.append(Long.toString(T5mBmOpz));
		String kka4ISkD = hXxl5WvM.toString();
		cf7E0gUZ.update(kka4ISkD.getBytes());
		byte[] snxy8ECw = cf7E0gUZ.digest();
		StringBuffer cx6gVYbA = new StringBuffer();
		for (int g73VvsQq = 0; g73VvsQq < snxy8ECw.length; ++g73VvsQq) {
			int paz0DKkD = snxy8ECw[g73VvsQq] & 0xFF;
			if (paz0DKkD < 0x10)
				cx6gVYbA.append('0');
			cx6gVYbA.append(Integer.toHexString(paz0DKkD));
		}
		guid = cx6gVYbA.toString();
	}

}