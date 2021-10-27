class n2467221 {
	void copyFile(File mpkLe8Oi, File HI6acKZP) throws IOException {
		InputStream lxsXhHVl = new FileInputStream(mpkLe8Oi);
		OutputStream Ti2xra0V = new FileOutputStream(HI6acKZP);
		byte[] tdrPfXho = new byte[1024];
		int dOhQXPpv;
		while ((dOhQXPpv = lxsXhHVl.read(tdrPfXho)) > 0)
			Ti2xra0V.write(tdrPfXho, 0, dOhQXPpv);
		lxsXhHVl.close();
		Ti2xra0V.close();
	}

}