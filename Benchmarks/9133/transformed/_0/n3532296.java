class n3532296 {
	public String MD5(String QucBkDaQ) {
		try {
			MessageDigest SqR9guMh;
			SqR9guMh = MessageDigest.getInstance("MD5");
			byte[] Tfxfmy72 = new byte[32];
			SqR9guMh.update(QucBkDaQ.getBytes("iso-8859-1"), 0, QucBkDaQ.length());
			Tfxfmy72 = SqR9guMh.digest();
			return convertToHex(Tfxfmy72);
		} catch (Exception k3SmLknC) {
			System.out.println(k3SmLknC.toString());
		}
		return null;
	}

}