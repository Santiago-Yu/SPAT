class n14885369 {
	public File copyFile(File z9w42xWm, File ToOnft2F) throws IOException {
		FileChannel WXKBJLre = new FileInputStream(z9w42xWm).getChannel();
		FileChannel LEtwQWaX = new FileOutputStream(ToOnft2F).getChannel();
		copyChannel(WXKBJLre, LEtwQWaX);
		return ToOnft2F;
	}

}