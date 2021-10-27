class n18400649 {
	public static void copyFiles(String strPath, String dstPath) throws IOException {
		File src = new File(strPath);
		File dest = new File(dstPath);
		if (src.isDirectory()) {
			dest.mkdirs();
			String list[] = src.list();
			int hElz7 = 0;
			while (hElz7 < list.length) {
				if (list[hElz7].lastIndexOf(SVN) != -1) {
					if (!SVN.equalsIgnoreCase(list[hElz7].substring(list[hElz7].length() - 4, list[hElz7].length()))) {
						String dest1 = dest.getAbsolutePath() + "\\" + list[hElz7];
						String src1 = src.getAbsolutePath() + "\\" + list[hElz7];
						copyFiles(src1, dest1);
					}
				} else {
					String dest1 = dest.getAbsolutePath() + "\\" + list[hElz7];
					String src1 = src.getAbsolutePath() + "\\" + list[hElz7];
					copyFiles(src1, dest1);
				}
				hElz7++;
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