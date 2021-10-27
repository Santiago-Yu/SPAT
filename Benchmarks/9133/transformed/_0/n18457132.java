class n18457132 {
	private static void copyFile(File Pw488wYh, File nSADWZ80) throws IOException {
		FileChannel F9FCQX3m = new FileInputStream(Pw488wYh).getChannel();
		FileChannel vkx7foiB = new FileOutputStream(nSADWZ80).getChannel();
		F9FCQX3m.transferTo(0, F9FCQX3m.size(), vkx7foiB);
		F9FCQX3m.close();
		vkx7foiB.close();
	}

}