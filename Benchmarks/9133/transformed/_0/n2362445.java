class n2362445 {
	public static void copyFile(File UTsHE0rt, File XiklO6vU) throws IOException {
		FileChannel iVWsay62 = new FileInputStream(UTsHE0rt).getChannel();
		FileChannel V86Jgj5E = new FileOutputStream(XiklO6vU).getChannel();
		try {
			iVWsay62.transferTo(0, iVWsay62.size(), V86Jgj5E);
		} catch (IOException F7p4Pd5X) {
			throw F7p4Pd5X;
		} finally {
			if (iVWsay62 != null)
				iVWsay62.close();
			if (V86Jgj5E != null)
				V86Jgj5E.close();
		}
	}

}