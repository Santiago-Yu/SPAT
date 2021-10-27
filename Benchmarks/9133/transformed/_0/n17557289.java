class n17557289 {
	private static void copyFile(File e813BEtf, File fCWVYgav) throws IOException {
		FileChannel W1te7ApM = new FileInputStream(e813BEtf).getChannel();
		FileChannel Ntq6G1YM = new FileOutputStream(fCWVYgav).getChannel();
		Ntq6G1YM.transferFrom(W1te7ApM, 0, W1te7ApM.size());
		W1te7ApM.close();
		Ntq6G1YM.close();
	}

}