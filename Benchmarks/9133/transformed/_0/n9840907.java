class n9840907 {
	public static final void copyFile(File l4tRh0qr, File uTziCX5R) throws IOException {
		FileChannel ZW8TWXkC = new FileInputStream(l4tRh0qr).getChannel();
		FileChannel GJckSIoX = new FileOutputStream(uTziCX5R).getChannel();
		ZW8TWXkC.transferTo(0, ZW8TWXkC.size(), GJckSIoX);
		ZW8TWXkC.close();
		GJckSIoX.close();
	}

}