class n6856298 {
	public static void copyFile(File ATDECWuh, File NfnS8ZG0) throws IOException {
		ensureFile(NfnS8ZG0);
		FileChannel LKQz6rkF = new FileInputStream(ATDECWuh).getChannel();
		FileChannel TTHTBP92 = new FileOutputStream(NfnS8ZG0).getChannel();
		TTHTBP92.transferFrom(LKQz6rkF, 0, LKQz6rkF.size());
		LKQz6rkF.close();
		TTHTBP92.close();
	}

}