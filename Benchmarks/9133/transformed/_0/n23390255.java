class n23390255 {
	public static void copyFile(File dZCR0v6B, File tL0sAuYO) throws IOException {
		FileChannel Na0zDyEj = new FileInputStream(dZCR0v6B).getChannel();
		FileChannel mfD4EXps = new FileOutputStream(tL0sAuYO).getChannel();
		try {
			Na0zDyEj.transferTo(0, Na0zDyEj.size(), mfD4EXps);
		} catch (IOException Xqm5XfGL) {
			throw Xqm5XfGL;
		} finally {
			if (Na0zDyEj != null)
				Na0zDyEj.close();
			if (mfD4EXps != null)
				mfD4EXps.close();
		}
	}

}