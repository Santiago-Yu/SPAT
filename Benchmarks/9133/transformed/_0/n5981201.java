class n5981201 {
	public static void copyFile(File tS6BKa7V, File UJl2QCTe) throws IOException {
		if (T.t)
			T.info("Copying " + tS6BKa7V + " -> " + UJl2QCTe + "...");
		FileInputStream KS8W2L5H = new FileInputStream(tS6BKa7V);
		FileOutputStream rSv2JmeP = new FileOutputStream(UJl2QCTe);
		byte zdCMWmlZ[] = new byte[40 * KB];
		int WvZ3u1Wx;
		while ((WvZ3u1Wx = KS8W2L5H.read(zdCMWmlZ)) != -1) {
			rSv2JmeP.write(zdCMWmlZ, 0, WvZ3u1Wx);
		}
		rSv2JmeP.flush();
		rSv2JmeP.close();
		KS8W2L5H.close();
		if (T.t)
			T.info("File copied.");
	}

}