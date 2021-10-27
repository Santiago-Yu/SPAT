class n6399107 {
	private void copyFile(File BfuOqYkg, File XFBVUb6Y) throws Exception {
		FileChannel YAKd5gLs = new FileInputStream(BfuOqYkg).getChannel();
		FileChannel dgTVdfKz = new FileOutputStream(XFBVUb6Y).getChannel();
		YAKd5gLs.transferTo(0, YAKd5gLs.size(), dgTVdfKz);
		YAKd5gLs.close();
		dgTVdfKz.close();
	}

}