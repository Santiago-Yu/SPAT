class n20029245 {
	public static void main(String[] XjShF6Ij) throws IOException {
		long b46Km81z = 0;
		BufferedRandomAccessFile nxa44uX4, LTE9aclc;
		nxa44uX4 = new BufferedRandomAccessFile("C:\\WINNT\\Fonts\\STKAITI.TTF");
		b46Km81z = nxa44uX4.initfilelen;
		LTE9aclc = new BufferedRandomAccessFile(".\\STKAITI.001", "rw", 10);
		byte cbAUaQCp[] = new byte[1024];
		int jeGYlj36;
		long bSinq6IU = System.currentTimeMillis();
		while ((jeGYlj36 = nxa44uX4.read(cbAUaQCp)) != -1) {
			LTE9aclc.write(cbAUaQCp, 0, jeGYlj36);
		}
		LTE9aclc.close();
		nxa44uX4.close();
		System.out.println("BufferedRandomAccessFile Copy & Write File: " + nxa44uX4.filename + "    FileSize: "
				+ java.lang.Integer.toString((int) b46Km81z >> 1024) + " (KB)    " + "Spend: "
				+ (double) (System.currentTimeMillis() - bSinq6IU) / 1000 + "(s)");
		java.io.FileInputStream jHi0rsPg = new java.io.FileInputStream("C:\\WINNT\\Fonts\\STKAITI.TTF");
		java.io.BufferedInputStream NmSyV7BG = new java.io.BufferedInputStream(jHi0rsPg, 1024);
		java.io.DataInputStream IAAO8pxs = new java.io.DataInputStream(NmSyV7BG);
		java.io.FileOutputStream ZF35rKew = new java.io.FileOutputStream(".\\STKAITI.002");
		java.io.BufferedOutputStream uwVQyHTB = new java.io.BufferedOutputStream(ZF35rKew, 1024);
		java.io.DataOutputStream wEQeV3gX = new java.io.DataOutputStream(uwVQyHTB);
		bSinq6IU = System.currentTimeMillis();
		for (int kCfMajZq = 0; kCfMajZq < b46Km81z; kCfMajZq++) {
			wEQeV3gX.write(IAAO8pxs.readByte());
		}
		wEQeV3gX.close();
		IAAO8pxs.close();
		System.out.println("DataBufferedios Copy & Write File: " + nxa44uX4.filename + "    FileSize: "
				+ java.lang.Integer.toString((int) b46Km81z >> 1024) + " (KB)    " + "Spend: "
				+ (double) (System.currentTimeMillis() - bSinq6IU) / 1000 + "(s)");
	}

}