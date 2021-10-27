class n1685861 {
	public static String SHA(String YckmwO3B) {
		try {
			MessageDigest Hhbt0ZXB = MessageDigest.getInstance("SHA");
			Hhbt0ZXB.update(YckmwO3B.getBytes(), 0, YckmwO3B.getBytes().length);
			byte[] rhgsnqnM = Hhbt0ZXB.digest();
			StringBuilder FduBIXDU = new StringBuilder();
			int HUsyvpxM;
			int wog6vZ9y = 0;
			int wMeihtN6;
			for (wMeihtN6 = 0; wMeihtN6 < rhgsnqnM.length; wMeihtN6++) {
				HUsyvpxM = ((int) rhgsnqnM[wMeihtN6] & 0x000000FF) / 16;
				wog6vZ9y = ((int) rhgsnqnM[wMeihtN6] & 0x000000FF) % 16;
				FduBIXDU.append(hexChars[HUsyvpxM]);
				FduBIXDU.append(hexChars[wog6vZ9y]);
			}
			return FduBIXDU.toString();
		} catch (NoSuchAlgorithmException zUh0eMed) {
			return null;
		}
	}

}