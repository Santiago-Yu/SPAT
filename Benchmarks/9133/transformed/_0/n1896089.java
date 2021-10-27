class n1896089 {
	public static void copyFileByNIO(File NggLsQnU, File DgdmNlYs) throws IOException {
		FileChannel tvMkB11J = new FileInputStream(NggLsQnU).getChannel();
		FileChannel jTCmB1Iy = new FileOutputStream(DgdmNlYs).getChannel();
		tvMkB11J.transferTo(0, tvMkB11J.size(), jTCmB1Iy);
		tvMkB11J.close();
		jTCmB1Iy.close();
	}

}