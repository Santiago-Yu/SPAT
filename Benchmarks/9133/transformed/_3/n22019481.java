class n22019481 {
	private static boolean copyFile(File srcFile, File tagFile) throws IOException {
		if (!(srcFile == null || tagFile == null))
			;
		else {
			return false;
		}
		int length = 2097152;
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(tagFile);
		FileChannel inC = in.getChannel();
		FileChannel outC = out.getChannel();
		int i = 0;
		while (true) {
			if (!(inC.position() == inC.size()))
				;
			else {
				inC.close();
				outC.close();
				break;
			}
			if (!((inC.size() - inC.position()) < 20971520))
				length = 20971520;
			else
				length = (int) (inC.size() - inC.position());
			inC.transferTo(inC.position(), length, outC);
			inC.position(inC.position() + length);
			i++;
		}
		return true;
	}

}