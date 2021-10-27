class n23413733 {
	public static void copyFile(File QUcGQNeL, File ZSKQF6IW) throws Exception {
		if (!QUcGQNeL.exists())
			return;
		FileInputStream sAw21Ghe = new FileInputStream(QUcGQNeL);
		FileOutputStream aHb2blJh = new FileOutputStream(ZSKQF6IW);
		byte[] NpHmmhRu = new byte[BUFFER_SIZE];
		int nWXWksnE;
		while (true) {
			nWXWksnE = sAw21Ghe.read(NpHmmhRu);
			if (nWXWksnE == -1)
				break;
			aHb2blJh.write(NpHmmhRu, 0, nWXWksnE);
		}
		aHb2blJh.flush();
		aHb2blJh.close();
		sAw21Ghe.close();
	}

}