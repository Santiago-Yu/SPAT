class n8106130 {
	private void copyFile(File pDPt8Iyw, File CEEJ0nii) throws IOException {
		FileChannel F1fiiTGB = new FileInputStream(pDPt8Iyw).getChannel();
		FileChannel CCJQRaQf = new FileOutputStream(CEEJ0nii).getChannel();
		F1fiiTGB.transferTo(0, F1fiiTGB.size(), CCJQRaQf);
		F1fiiTGB.close();
		CCJQRaQf.close();
	}

}