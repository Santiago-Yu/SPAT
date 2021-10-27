class n13834118 {
	public static void copyFile(File iRyNlnKG, File sawQUr3W) throws IOException {
		InputStream T9LhilAg = new FileInputStream(iRyNlnKG);
		OutputStream IxnzFx6Y = new FileOutputStream(sawQUr3W);
		byte[] IGLihUdN = new byte[1024];
		int rCQa3q1a;
		while ((rCQa3q1a = T9LhilAg.read(IGLihUdN)) > 0)
			IxnzFx6Y.write(IGLihUdN, 0, rCQa3q1a);
		T9LhilAg.close();
		IxnzFx6Y.close();
	}

}