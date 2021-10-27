class n4569313 {
	public static String getSHA1(String zqAxrJfQ) {
		try {
			MessageDigest QeVUg7ev = MessageDigest.getInstance("SHA1");
			QeVUg7ev.update(zqAxrJfQ.toLowerCase().getBytes());
			return HexString.bufferToHex(QeVUg7ev.digest());
		} catch (NoSuchAlgorithmException lR8n6uJH) {
			System.err.println("Error grave al inicializar SHA1");
			lR8n6uJH.printStackTrace();
			return "!!";
		}
	}

}