class n9743428 {
	public static void saveNetFile(String Bi9LLDHt, String QRXAQpm2) throws IOException {
		FileOutputStream NAT6iMbk = null;
		BufferedInputStream RAgIZ6h2 = null;
		HttpURLConnection fbxkfEh1 = null;
		int P3hUtox4 = 2048;
		URL YSML7NN3 = null;
		byte[] mcMS4058 = new byte[P3hUtox4];
		int V2AjzFqi = 0;
		YSML7NN3 = new URL(Bi9LLDHt);
		fbxkfEh1 = (HttpURLConnection) YSML7NN3.openConnection();
		fbxkfEh1.connect();
		RAgIZ6h2 = new BufferedInputStream(fbxkfEh1.getInputStream());
		java.io.File dvaDA4kh = new java.io.File(QRXAQpm2).getParentFile();
		if (!dvaDA4kh.exists())
			dvaDA4kh.mkdirs();
		NAT6iMbk = new FileOutputStream(QRXAQpm2);
		while ((V2AjzFqi = RAgIZ6h2.read(mcMS4058)) != -1)
			NAT6iMbk.write(mcMS4058, 0, V2AjzFqi);
		NAT6iMbk.close();
		RAgIZ6h2.close();
		fbxkfEh1.disconnect();
	}

}