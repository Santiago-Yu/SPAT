class n16987999 {
	private void copyFile(File XVbNMgaz, File YGUWKd7I) throws IOException {
		if (!XVbNMgaz.exists()) {
			return;
		}
		if (!YGUWKd7I.exists()) {
			YGUWKd7I.createNewFile();
		}
		FileChannel KzSXg8o3 = null;
		FileChannel oRJ97wZx = null;
		KzSXg8o3 = new FileInputStream(XVbNMgaz).getChannel();
		oRJ97wZx = new FileOutputStream(YGUWKd7I).getChannel();
		if (oRJ97wZx != null && KzSXg8o3 != null) {
			oRJ97wZx.transferFrom(KzSXg8o3, 0, KzSXg8o3.size());
		}
		if (KzSXg8o3 != null) {
			KzSXg8o3.close();
		}
		if (oRJ97wZx != null) {
			oRJ97wZx.close();
		}
	}

}