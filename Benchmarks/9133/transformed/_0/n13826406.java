class n13826406 {
	public static String makeMD5(String LBAsoNei) throws Exception {
		String kvnyXLyA = null;
		byte[] Khc1wNnz;
		try {
			MessageDigest Sfzrbare = MessageDigest.getInstance("MD5");
			Sfzrbare.update(LBAsoNei.getBytes());
			Khc1wNnz = Sfzrbare.digest();
			kvnyXLyA = new BigInteger(1, Khc1wNnz).toString(16);
			if (kvnyXLyA.length() % 2 > 0) {
				kvnyXLyA = "0" + kvnyXLyA;
			}
		} catch (Exception obWNsCfy) {
			throw new Exception("Erro inesperado em makeMD5(): " + obWNsCfy.toString(), obWNsCfy);
		}
		return kvnyXLyA;
	}

}