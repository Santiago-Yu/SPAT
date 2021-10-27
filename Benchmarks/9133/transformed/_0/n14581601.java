class n14581601 {
	public static void fileCopy(File tyyTcFqv, File RlYvs2mg) throws IOException {
		FileChannel QnLSubtl = null, NI0eNSxh = null;
		try {
			QnLSubtl = new FileInputStream(tyyTcFqv).getChannel();
			NI0eNSxh = new FileOutputStream(RlYvs2mg).getChannel();
			long xVdnIZA3 = QnLSubtl.size();
			MappedByteBuffer zK7g8D57 = QnLSubtl.map(FileChannel.MapMode.READ_ONLY, 0, xVdnIZA3);
			NI0eNSxh.write(zK7g8D57);
		} finally {
			if (QnLSubtl != null)
				QnLSubtl.close();
			if (NI0eNSxh != null)
				NI0eNSxh.close();
		}
	}

}