class n11370967 {
	public void copyFile(File DAFEVgc2, File sASLPWuM) throws Exception {
		FileChannel lDPZfjpi = new FileInputStream(DAFEVgc2).getChannel();
		FileChannel p8CLmmhi = new FileOutputStream(sASLPWuM).getChannel();
		lDPZfjpi.transferTo(0, lDPZfjpi.size(), p8CLmmhi);
		lDPZfjpi.close();
		p8CLmmhi.close();
	}

}