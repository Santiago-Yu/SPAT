class n21195765 {
	private void writeFile(FileInputStream lBkMkBsm, FileOutputStream JjUTw1YD) throws IOException {
		byte[] kH2vIB9w = new byte[2048];
		int hvuiWYpZ;
		while ((hvuiWYpZ = lBkMkBsm.read(kH2vIB9w)) > 0)
			JjUTw1YD.write(kH2vIB9w, 0, hvuiWYpZ);
		lBkMkBsm.close();
	}

}