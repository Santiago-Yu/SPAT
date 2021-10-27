class n23294396 {
	public static void copyFile(File in, File out) throws IOException {
		FileOutputStream fos = new FileOutputStream(out);
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = fos.getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
		} finally {
			if (inChannel != null)
				inChannel.close();
			if (outChannel != null)
				outChannel.close();
			fos.flush();
			fos.close();
		}
	}

}