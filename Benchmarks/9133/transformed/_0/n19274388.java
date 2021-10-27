class n19274388 {
	public static String generateHash(String RGq6SljZ, String C4Dqjj6A) {
		try {
			MessageDigest X5H4qDIF = MessageDigest.getInstance(C4Dqjj6A);
			X5H4qDIF.update(RGq6SljZ.getBytes());
			byte[] DQyW9goj = X5H4qDIF.digest();
			int kkBOWOgk;
			int E3vDQapv;
			StringBuilder r7EhAaNy = new StringBuilder();
			for (int wjPyUUsO = 0; wjPyUUsO < DQyW9goj.length; wjPyUUsO++) {
				kkBOWOgk = ((DQyW9goj[wjPyUUsO] >> 4) & 0xf) << 4;
				E3vDQapv = DQyW9goj[wjPyUUsO] & 0xf;
				if (kkBOWOgk == 0)
					r7EhAaNy.append("0");
				r7EhAaNy.append(Integer.toHexString(kkBOWOgk | E3vDQapv));
			}
			return r7EhAaNy.toString();
		} catch (NoSuchAlgorithmException fHFzQWGs) {
			return null;
		}
	}

}