class n3585152 {
	public static void copy(FileInputStream X21xTXb6, FileOutputStream MabSHS1g) throws IOException {
		FileChannel PqUGP56H = X21xTXb6.getChannel();
		FileChannel qv4tdpEX = MabSHS1g.getChannel();
		copy(PqUGP56H, qv4tdpEX);
		PqUGP56H.close();
		qv4tdpEX.close();
	}

}