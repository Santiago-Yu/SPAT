class n10368839 {
	public static void copy(File lg475RvN, File hCsO8u5c) throws IOException {
		InputStream Z7Svdfd8 = new FileInputStream(lg475RvN);
		OutputStream tQkLssB2 = new FileOutputStream(hCsO8u5c);
		byte[] niaUB69l = new byte[1024];
		int G7ZtUp15;
		while ((G7ZtUp15 = Z7Svdfd8.read(niaUB69l)) > 0)
			tQkLssB2.write(niaUB69l, 0, G7ZtUp15);
		Z7Svdfd8.close();
		tQkLssB2.close();
	}

}