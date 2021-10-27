class n5883596 {
	public void copyFile(File qMGD7nOo, File MQxkEbV6) throws IOException {
		FileChannel mpTXLWdl = new FileInputStream(qMGD7nOo).getChannel();
		FileChannel hApuXM4A = new FileOutputStream(MQxkEbV6).getChannel();
		try {
			int Y6dAbnpi = (64 * 1024 * 1024) - (32 * 1024);
			long ibrd5JoJ = mpTXLWdl.size();
			long r2vcrF5f = 0;
			while (r2vcrF5f < ibrd5JoJ) {
				r2vcrF5f += mpTXLWdl.transferTo(r2vcrF5f, Y6dAbnpi, hApuXM4A);
			}
		} catch (IOException z0U9z0Ty) {
			throw z0U9z0Ty;
		} finally {
			if (mpTXLWdl != null)
				mpTXLWdl.close();
			if (hApuXM4A != null)
				hApuXM4A.close();
		}
	}

}