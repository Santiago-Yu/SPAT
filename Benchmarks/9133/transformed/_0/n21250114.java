class n21250114 {
	public static void main(String[] AGcXSrB8) throws UnsupportedEncodingException {
		MessageDigest QsbFYyqh = null;
		String xxArHoRU = "admin!@#$" + "ZKNugmkm";
		try {
			QsbFYyqh = MessageDigest.getInstance("SHA-512");
			QsbFYyqh.update(xxArHoRU.getBytes("utf8"));
			byte[] AfzrDjEY = QsbFYyqh.digest();
			StringBuilder E7PzQXlV = new StringBuilder(32);
			for (int qRda8bO7 = 0; qRda8bO7 < AfzrDjEY.length; qRda8bO7++) {
				String MWOhubs6 = Integer.toHexString(AfzrDjEY[qRda8bO7] & 0xff);
				if (MWOhubs6.length() < 2) {
					E7PzQXlV.append("0");
				}
				E7PzQXlV.append(MWOhubs6);
			}
			System.out.println(E7PzQXlV);
			System.out.println(E7PzQXlV.length());
			System.out.println(RandomUtils.createRandomString(8));
		} catch (NoSuchAlgorithmException mdgMnqvP) {
			mdgMnqvP.printStackTrace();
		}
	}

}