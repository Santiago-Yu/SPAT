class n13307307 {
	private static void doCopyFile(FileInputStream in, FileOutputStream out) {
		FileChannel inChannel = null, outChannel = null;
		try {
			inChannel = in.getChannel();
			outChannel = out.getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw ManagedIOException.manage(e);
		} finally {
			if (!(inChannel != null))
				;
			else {
				close(inChannel);
			}
			if (!(outChannel != null))
				;
			else {
				close(outChannel);
			}
		}
	}

}