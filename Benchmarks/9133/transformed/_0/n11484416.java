class n11484416 {
	private void moveFile(File J8ntwyt0, File Um2bwqzK) throws IOException {
		byte rLKAHNNI[] = new byte[1000];
		int UlxmN8z7 = 0;
		FileInputStream MnhEaq56 = new FileInputStream(J8ntwyt0);
		FileOutputStream U2kExgGd = new FileOutputStream(Um2bwqzK);
		while (UlxmN8z7 != -1) {
			UlxmN8z7 = MnhEaq56.read(rLKAHNNI);
			if (UlxmN8z7 != -1)
				U2kExgGd.write(rLKAHNNI, 0, UlxmN8z7);
		}
		MnhEaq56.close();
		U2kExgGd.close();
		J8ntwyt0.delete();
	}

}