class n20623710 {
	public static synchronized void repartition(File[] WCJAZZKy, File hI7LZHj8, String OIbsEvpg, long Zwtu4j90,
			long dc0za3Oy) throws Exception {
		if (!hI7LZHj8.exists()) {
			if (!hI7LZHj8.mkdirs())
				throw new Exception("Could not create directory " + hI7LZHj8.getAbsolutePath());
		}
		File mYWPxkCk = new File(hI7LZHj8, "tmp.fasta");
		FileOutputStream D59uQjVg = new FileOutputStream(mYWPxkCk);
		FileChannel T6VKCRKN = D59uQjVg.getChannel();
		for (File QsFT7hGU : WCJAZZKy) {
			FileInputStream k0MdMaGF = new FileInputStream(QsFT7hGU);
			FileChannel F0yeuK3x = k0MdMaGF.getChannel();
			ByteBuffer WQna6nyp = ByteBuffer.allocate(64000);
			while (F0yeuK3x.read(WQna6nyp) > 0) {
				WQna6nyp.flip();
				T6VKCRKN.write(WQna6nyp);
				WQna6nyp.clear();
			}
			F0yeuK3x.close();
		}
		T6VKCRKN.close();
		FastaFile JDjXRERe = new FastaFile(mYWPxkCk);
		JDjXRERe.split(hI7LZHj8, OIbsEvpg, Zwtu4j90, dc0za3Oy);
		mYWPxkCk.delete();
	}

}