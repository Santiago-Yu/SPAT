class n9590327 {
	private void copyFile(File VegFuVTX, File shK9BCfk) throws IOException {
		FileUtils.ensureParentDirectoryExists(shK9BCfk);
		byte[] MbnCmfsp = new byte[1024];
		int wHgt7Mue;
		FileInputStream oTASpdgI = new FileInputStream(VegFuVTX);
		FileOutputStream wOydTgE2 = new FileOutputStream(shK9BCfk);
		while ((wHgt7Mue = oTASpdgI.read(MbnCmfsp)) > 0) {
			wOydTgE2.write(MbnCmfsp, 0, wHgt7Mue);
		}
		oTASpdgI.close();
		wOydTgE2.close();
	}

}