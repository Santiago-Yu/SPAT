class n4385640 {
	public static void copyFile(File spyKQMsQ, File Qvvq2ZYD) throws IOException {
		if (!Qvvq2ZYD.exists()) {
			Qvvq2ZYD.createNewFile();
		}
		FileChannel q9oqz4wA = null;
		FileChannel CbLk2oAK = null;
		try {
			q9oqz4wA = new FileInputStream(spyKQMsQ).getChannel();
			CbLk2oAK = new FileOutputStream(Qvvq2ZYD).getChannel();
			CbLk2oAK.transferFrom(q9oqz4wA, 0, q9oqz4wA.size());
		} finally {
			if (q9oqz4wA != null) {
				q9oqz4wA.close();
			}
			if (CbLk2oAK != null) {
				CbLk2oAK.close();
			}
		}
	}

}