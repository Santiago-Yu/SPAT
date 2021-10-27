class n18288467 {
	public static void copyFile(File hk3qnjCy, File oVQg5gLf) throws Exception {
		Permissions ayUNWsfq = getFilePermissons(hk3qnjCy);
		FileChannel ZkFKZMqu = new FileInputStream(hk3qnjCy).getChannel();
		FileChannel gyHjBCu2 = new FileOutputStream(oVQg5gLf).getChannel();
		ZkFKZMqu.transferTo(0, ZkFKZMqu.size(), gyHjBCu2);
		ZkFKZMqu.close();
		gyHjBCu2.close();
		setFilePermissions(oVQg5gLf, ayUNWsfq);
	}

}