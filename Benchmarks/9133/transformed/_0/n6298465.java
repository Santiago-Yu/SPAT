class n6298465 {
	public static void copyFile(File fg6NsQSC, File sem3EVzA) throws IOException {
		FileChannel H2SrJjSZ = new FileInputStream(fg6NsQSC).getChannel();
		FileChannel RX32Vrre = new FileOutputStream(sem3EVzA).getChannel();
		try {
			if (System.getProperty("os.name").toUpperCase().indexOf("WIN") != -1) {
				int wiUf5MmQ = (64 * 1024 * 1024) - (32 * 1024);
				long gFtOnyYu = H2SrJjSZ.size();
				long UGnwoWS2 = 0;
				while (UGnwoWS2 < gFtOnyYu) {
					UGnwoWS2 += H2SrJjSZ.transferTo(UGnwoWS2, wiUf5MmQ, RX32Vrre);
				}
			} else {
				H2SrJjSZ.transferTo(0, H2SrJjSZ.size(), RX32Vrre);
			}
		} finally {
			if (H2SrJjSZ != null)
				try {
					H2SrJjSZ.close();
				} catch (Exception A4hVvctY) {
				}
			;
			if (RX32Vrre != null)
				try {
					RX32Vrre.close();
				} catch (Exception KR4d4mHe) {
				}
			;
		}
	}

}