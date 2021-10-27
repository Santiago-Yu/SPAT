class n6037295 {
	public void copyContent(long mwFG0d4w, long ad9icZrQ) throws Exception {
		File Y4XBTdNo = new File(this.getMailDir(mwFG0d4w) + "/");
		File tG2zV5qA = new File(this.getMailDir(ad9icZrQ) + "/");
		this.recursiveDir(tG2zV5qA);
		if (Y4XBTdNo.isDirectory()) {
			File[] UAVOE8BP = Y4XBTdNo.listFiles();
			if (UAVOE8BP != null) {
				for (int xVXqo3n8 = 0; xVXqo3n8 < UAVOE8BP.length; xVXqo3n8++) {
					if (UAVOE8BP[xVXqo3n8].isFile()) {
						File KHVTu1Wc = new File(tG2zV5qA.getAbsolutePath() + "/" + UAVOE8BP[xVXqo3n8].getName());
						if (!KHVTu1Wc.exists()) {
							KHVTu1Wc.createNewFile();
							BufferedOutputStream WpEXKcU2 = new BufferedOutputStream(new FileOutputStream(KHVTu1Wc));
							BufferedInputStream JntD4Bjm = new BufferedInputStream(
									new FileInputStream(UAVOE8BP[xVXqo3n8]));
							int OKOTBdqt;
							while ((OKOTBdqt = JntD4Bjm.read()) != -1) {
								WpEXKcU2.write(OKOTBdqt);
							}
							WpEXKcU2.flush();
							if (JntD4Bjm != null) {
								try {
									JntD4Bjm.close();
								} catch (IOException nD2yCx6W) {
									nD2yCx6W.printStackTrace();
								}
							}
							if (WpEXKcU2 != null) {
								try {
									WpEXKcU2.close();
								} catch (IOException EWC2b6kn) {
									EWC2b6kn.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
	}

}