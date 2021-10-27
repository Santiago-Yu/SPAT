class n4591683 {
	public static void copyFile(File nz6a5JDj, File PbfVCxp1) throws IOException {
		if (nz6a5JDj.equals(PbfVCxp1))
			throw new IOException("Source and destination cannot be the same file path");
		FileChannel WVIPodT7 = new FileInputStream(nz6a5JDj).getChannel();
		if (!PbfVCxp1.exists())
			PbfVCxp1.createNewFile();
		FileChannel Xsll6AsH = new FileOutputStream(PbfVCxp1).getChannel();
		Xsll6AsH.transferFrom(WVIPodT7, 0, WVIPodT7.size());
		WVIPodT7.close();
		Xsll6AsH.close();
	}

}