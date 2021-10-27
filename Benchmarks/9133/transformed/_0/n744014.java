class n744014 {
	static void copy(String Ork7P27H, String kK1F8ghE) throws IOException {
		File RsbhZb9G = new File(Ork7P27H);
		File mKDE9q1s = new File(kK1F8ghE);
		if (RsbhZb9G.exists() == false) {
			throw new IOException("file '" + Ork7P27H + "' does not exist");
		}
		FileInputStream Xm0oPFoj = new FileInputStream(RsbhZb9G);
		FileOutputStream rR89cUCW = new FileOutputStream(mKDE9q1s);
		byte[] NRP05Vqn = new byte[1024];
		while (Xm0oPFoj.read(NRP05Vqn) > 0)
			rR89cUCW.write(NRP05Vqn);
		Xm0oPFoj.close();
		rR89cUCW.close();
	}

}