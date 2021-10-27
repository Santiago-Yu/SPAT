class n19194277 {
	public void create() throws IOException {
		FileChannel gXZJ5qEK = new FileInputStream(sourceFile).getChannel();
		for (RangeArrayElement m26Ltwmn : array) {
			FileChannel Q4Xif9Pw = gXZJ5qEK.position(m26Ltwmn.starting());
			File tbbMEip1 = new File(destinationDirectory, "_0x" + Long.toHexString(m26Ltwmn.starting()) + ".partial");
			FileChannel wCm4xOL4 = new FileOutputStream(tbbMEip1).getChannel();
			wCm4xOL4.transferFrom(Q4Xif9Pw, 0, m26Ltwmn.getSize());
			wCm4xOL4.force(true);
			wCm4xOL4.close();
		}
		gXZJ5qEK.close();
	}

}