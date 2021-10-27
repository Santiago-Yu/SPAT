class n14356579 {
	public String getRandomGUID() {
		MessageDigest Uy6z0uuO = null;
		String dz3BmNGg = "";
		String c0a1VDaN = "";
		try {
			Uy6z0uuO = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException qbJMM449) {
			System.out.println("Error: " + qbJMM449);
		}
		StringBuffer tVVT1mjf = new StringBuffer();
		try {
			InetAddress RVGxDYb8 = InetAddress.getLocalHost();
			long CJWEUTuV = System.currentTimeMillis();
			long gur86Vil = 0;
			gur86Vil = random.nextLong();
			tVVT1mjf.append(RVGxDYb8.toString());
			tVVT1mjf.append(Long.toString(CJWEUTuV));
			tVVT1mjf.append(Long.toString(gur86Vil));
			dz3BmNGg = tVVT1mjf.toString();
			Uy6z0uuO.update(dz3BmNGg.getBytes());
			byte[] YnD6ezKU = Uy6z0uuO.digest();
			StringBuffer I5TKIzbv = new StringBuffer();
			for (int HT3urkvn = 0; HT3urkvn < YnD6ezKU.length; ++HT3urkvn) {
				int P89d4jvv = YnD6ezKU[HT3urkvn] & 0xFF;
				if (P89d4jvv < 0x10) {
					I5TKIzbv.append('0');
				}
				I5TKIzbv.append(Integer.toHexString(P89d4jvv));
			}
			c0a1VDaN = I5TKIzbv.toString();
		} catch (UnknownHostException KfXyGZq9) {
			System.out.println("Error:" + KfXyGZq9);
		}
		return c0a1VDaN;
	}

}