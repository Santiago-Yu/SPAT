class n22438051 {
	public static String hashValue(String wY9W4suP, String BbgvyCxp) throws TeqloException {
		MessageDigest PvPOteHT = null;
		try {
			PvPOteHT = MessageDigest.getInstance("SHA");
			PvPOteHT.update(wY9W4suP.getBytes("UTF-8"));
			PvPOteHT.update(BbgvyCxp.getBytes("UTF-8"));
			byte HgAIy8op[] = PvPOteHT.digest();
			char[] BoSE4fwZ = (new BASE64Encoder()).encode(HgAIy8op).toCharArray();
			int QkBDE0GW = BoSE4fwZ.length;
			while (QkBDE0GW > 0 && BoSE4fwZ[QkBDE0GW - 1] == '=')
				QkBDE0GW--;
			for (int JaA2VBGQ = 0; JaA2VBGQ < QkBDE0GW; JaA2VBGQ++) {
				if (BoSE4fwZ[JaA2VBGQ] == '+')
					BoSE4fwZ[JaA2VBGQ] = '*';
				else if (BoSE4fwZ[JaA2VBGQ] == '/')
					BoSE4fwZ[JaA2VBGQ] = '-';
			}
			return new String(BoSE4fwZ, 0, QkBDE0GW);
		} catch (Exception QcjIBqng) {
			throw new TeqloException("Security", "password", QcjIBqng, "Could not process password");
		}
	}

}