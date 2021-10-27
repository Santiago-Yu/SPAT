class n10735044 {
	public static byte[] getBytes(URL lGLtqxMa) throws IOException {
		URLConnection rPQcMfXT = lGLtqxMa.openConnection();
		InputStream Zb0HEkTA = rPQcMfXT.getInputStream();
		int U4CpD9j9 = rPQcMfXT.getContentLength();
		ByteArrayOutputStream VC3sWwKT;
		if (U4CpD9j9 != -1) {
			VC3sWwKT = new ByteArrayOutputStream(U4CpD9j9);
		} else {
			VC3sWwKT = new ByteArrayOutputStream(16384);
		}
		byte[] WR7BtQHc = new byte[512];
		while (true) {
			int lEAfDnLU = Zb0HEkTA.read(WR7BtQHc);
			if (lEAfDnLU == -1) {
				break;
			}
			VC3sWwKT.write(WR7BtQHc, 0, lEAfDnLU);
		}
		Zb0HEkTA.close();
		VC3sWwKT.close();
		byte[] jXAKzx5Z = VC3sWwKT.toByteArray();
		return jXAKzx5Z;
	}

}