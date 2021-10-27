class n12270268 {
	public static void copyFile(File YFxezCUc, File BO0CnAKq) throws IOException {
		FileChannel I7oIXJKM = new FileInputStream(YFxezCUc).getChannel();
		FileChannel ER08QRUm = new FileOutputStream(BO0CnAKq).getChannel();
		try {
			if (System.getProperty("os.name").toUpperCase().indexOf("WIN") != -1) {
				int hC25bpMq = (64 * 1024 * 1024) - (32 * 1024);
				long T11Xz1en = I7oIXJKM.size();
				long YxHaTL6q = 0;
				while (YxHaTL6q < T11Xz1en) {
					YxHaTL6q += I7oIXJKM.transferTo(YxHaTL6q, hC25bpMq, ER08QRUm);
				}
			} else {
				I7oIXJKM.transferTo(0, I7oIXJKM.size(), ER08QRUm);
			}
		} finally {
			if (I7oIXJKM != null)
				I7oIXJKM.close();
			if (ER08QRUm != null)
				ER08QRUm.close();
		}
	}

}