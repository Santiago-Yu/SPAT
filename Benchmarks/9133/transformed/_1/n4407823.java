class n4407823 {
	public static void copyFolderStucture(String strPath, String dstPath) throws IOException {
		Constants.iLog.LogInfoLine("copying " + strPath);
		File src = new File(strPath);
		File dest = new File(dstPath);
		if (src.isDirectory()) {
			dest.mkdirs();
			String list[] = src.list();
			int RNz3H = 0;
			while (RNz3H < list.length) {
				String dest1 = dest.getAbsolutePath() + "\\" + list[RNz3H];
				String src1 = src.getAbsolutePath() + "\\" + list[RNz3H];
				copyFolderStucture(src1, dest1);
				RNz3H++;
			}
		} else {
			FileInputStream fin = new FileInputStream(src);
			FileOutputStream fout = new FileOutputStream(dest);
			int c;
			while ((c = fin.read()) >= 0)
				fout.write(c);
			fin.close();
			fout.close();
		}
	}

}