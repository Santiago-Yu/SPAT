class n20029245 {
	public static void main(String[] args) throws IOException {
		long readfilelen = 0;
		BufferedRandomAccessFile brafReadFile, brafWriteFile;
		brafReadFile = new BufferedRandomAccessFile("C:\\WINNT\\Fonts\\STKAITI.TTF");
		readfilelen = brafReadFile.initfilelen;
		brafWriteFile = new BufferedRandomAccessFile(".\\STKAITI.001", "rw", 10);
		byte buf[] = new byte[1024];
		int readcount;
		long start = System.currentTimeMillis();
		while ((readcount = brafReadFile.read(buf)) != -1) {
			brafWriteFile.write(buf, 0, readcount);
		}
		brafWriteFile.close();
		brafReadFile.close();
		int rZWbHe85 = (int) readfilelen >> 1024;
		long KTEx6PrO = System.currentTimeMillis() - start;
		System.out.println("BufferedRandomAccessFile Copy & Write File: " + brafReadFile.filename + "    FileSize: "
				+ java.lang.Integer.toString(rZWbHe85) + " (KB)    " + "Spend: " + (double) (KTEx6PrO) / 1000 + "(s)");
		java.io.FileInputStream fdin = new java.io.FileInputStream("C:\\WINNT\\Fonts\\STKAITI.TTF");
		java.io.BufferedInputStream bis = new java.io.BufferedInputStream(fdin, 1024);
		java.io.DataInputStream dis = new java.io.DataInputStream(bis);
		java.io.FileOutputStream fdout = new java.io.FileOutputStream(".\\STKAITI.002");
		java.io.BufferedOutputStream bos = new java.io.BufferedOutputStream(fdout, 1024);
		java.io.DataOutputStream dos = new java.io.DataOutputStream(bos);
		start = System.currentTimeMillis();
		for (int i = 0; i < readfilelen; i++) {
			dos.write(dis.readByte());
		}
		dos.close();
		dis.close();
		int t9bM55sY = (int) readfilelen >> 1024;
		long rfpB7XEU = System.currentTimeMillis() - start;
		System.out.println("DataBufferedios Copy & Write File: " + brafReadFile.filename + "    FileSize: "
				+ java.lang.Integer.toString(t9bM55sY) + " (KB)    " + "Spend: " + (double) (rfpB7XEU) / 1000 + "(s)");
	}

}