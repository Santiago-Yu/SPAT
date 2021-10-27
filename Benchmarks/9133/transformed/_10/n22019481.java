class n22019481 {
	private static boolean copyFile(File srcFile, File tagFile) throws IOException {
		int length = 2097152;
		if (srcFile == null || tagFile == null) {
			return false;
		}
		FileOutputStream out = new FileOutputStream(tagFile);
		FileInputStream in = new FileInputStream(srcFile);
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