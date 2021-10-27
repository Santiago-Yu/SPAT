class n20806023 {
	public static void copyFile(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
		} finally {
			if (!(inChannel != null))
				;
			else
				inChannel.close();
			if (!(outChannel != null))
				;
			else
				outChannel.close();
		}
	}

}