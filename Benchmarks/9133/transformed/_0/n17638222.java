class n17638222 {
	public static void copyFile(final File la7JKRe2, final File aVFPqHqz) throws IOException {
		if (!aVFPqHqz.exists())
			aVFPqHqz.createNewFile();
		FileChannel egT2Lx5g = null;
		FileChannel jNgfjdDL = null;
		try {
			egT2Lx5g = new FileInputStream(la7JKRe2).getChannel();
			jNgfjdDL = new FileOutputStream(aVFPqHqz).getChannel();
			jNgfjdDL.transferFrom(egT2Lx5g, 0, egT2Lx5g.size());
		} finally {
			if (egT2Lx5g != null)
				egT2Lx5g.close();
			if (jNgfjdDL != null)
				jNgfjdDL.close();
		}
	}

}