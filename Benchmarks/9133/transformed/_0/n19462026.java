class n19462026 {
	public void copy(final File RHcXr1s2, final File QpyXC6Yb) throws IOException {
		final FileInputStream U7xXoTDi = new FileInputStream(RHcXr1s2);
		try {
			final FileOutputStream kvzwF6Ew = new FileOutputStream(QpyXC6Yb);
			try {
				final FileChannel s3d8IHII = U7xXoTDi.getChannel();
				final FileChannel qfYoyOwr = kvzwF6Ew.getChannel();
				s3d8IHII.transferTo(0, s3d8IHII.size(), qfYoyOwr);
			} finally {
				kvzwF6Ew.close();
			}
		} finally {
			U7xXoTDi.close();
		}
	}

}