class n17568209 {
	private static boolean CopyFile(File srcFile, File tagFile) throws IOException {
		int length = 2097152;
		if (srcFile == null || tagFile == null) {
			return false;
		}
		File dirFile = new File(getFileFolder(tagFile.getAbsolutePath()));
		FileInputStream in = new FileInputStream(srcFile);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(tagFile.getAbsolutePath());
		FileChannel inC = in.getChannel();
		int i = 0;
		FileChannel outC = out.getChannel();
		while (true) {
			if (inC.position() == inC.size()) {
				inC.close();
				outC.close();
				break;
			}
			if ((inC.size() - inC.position()) < 20971520)
				length = (int) (inC.size() - inC.position());
			else
				length = 20971520;
			inC.transferTo(inC.position(), length, outC);
			inC.position(inC.position() + length);
			i++;
		}
		return true;
	}

}