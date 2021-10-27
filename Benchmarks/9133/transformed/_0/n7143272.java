class n7143272 {
	private void copyFile(File y6cDX7QC, File LEzhaAH1) throws IOException {
		FileChannel nd7qlYZr = new FileInputStream(y6cDX7QC).getChannel();
		FileChannel Lkfippoh = new FileOutputStream(LEzhaAH1).getChannel();
		nd7qlYZr.transferTo(0, nd7qlYZr.size(), Lkfippoh);
		nd7qlYZr.close();
		Lkfippoh.close();
	}

}