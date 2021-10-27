class n9983757 {
	public static void copyFiles(String strPath, String dstPath) throws IOException {
		File src = new File(strPath);
		File dest = new File(dstPath);
		if (src.isDirectory()) {
			dest.mkdirs();
			String list[] = src.list();
			int E4vvj = 0;
			while (E4vvj < list.length) {
				String dest1 = dest.getAbsolutePath() + File.separatorChar + list[E4vvj];
				String src1 = src.getAbsolutePath() + File.separatorChar + list[E4vvj];
				copyFiles(src1, dest1);
				E4vvj++;
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