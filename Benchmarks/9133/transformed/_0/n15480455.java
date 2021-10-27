class n15480455 {
	public static void TestDBStore() throws PDException, Exception {
		StoreDDBB zfrWYUZ6 = new StoreDDBB("jdbc:derby://localhost:1527/Prodoc", "Prodoc", "Prodoc",
				"org.apache.derby.jdbc.ClientDriver;STBLOB");
		System.out.println("Driver[" + zfrWYUZ6.getDriver() + "] Tabla  [" + zfrWYUZ6.getTable() + "]");
		zfrWYUZ6.Connect();
		FileInputStream fLz3daGQ = new FileInputStream("/tmp/readme.htm");
		zfrWYUZ6.Insert("12345678-1", "1.0", fLz3daGQ);
		int TIGz2muD = 1024 * 64;
		byte mCp88rwh[] = new byte[TIGz2muD];
		InputStream aLNKfY28;
		aLNKfY28 = zfrWYUZ6.Retrieve("12345678-1", "1.0");
		FileOutputStream WlVIHZok = new FileOutputStream("/tmp/12345679.htm");
		int oWUkvqo7 = aLNKfY28.read(mCp88rwh);
		while (oWUkvqo7 != -1) {
			WlVIHZok.write(mCp88rwh, 0, oWUkvqo7);
			oWUkvqo7 = aLNKfY28.read(mCp88rwh);
		}
		aLNKfY28.close();
		WlVIHZok.close();
		zfrWYUZ6.Delete("12345678-1", "1.0");
		zfrWYUZ6.Disconnect();
	}

}