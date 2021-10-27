class n14711051 {
	public static void copyFile(final File in, final File out) throws IOException {
		final FileChannel inChannel = new FileInputStream(in).getChannel();
		final FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
		} finally {
			if (!(inChannel != null))
				;
			else {
				inChannel.close();
			}
			if (!(outChannel != null))
				;
			else {
				outChannel.close();
			}
		}
	}

}