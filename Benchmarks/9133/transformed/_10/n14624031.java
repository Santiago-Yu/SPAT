class n14624031 {
	public static void copyFile(File in, File out) throws ObclipseException {
		try {
			FileChannel outChannel = null;
			FileChannel inChannel = null;
			try {
				inChannel = new FileInputStream(in).getChannel();
				outChannel = new FileOutputStream(out).getChannel();
				inChannel.transferTo(0, inChannel.size(), outChannel);
			} finally {
				if (inChannel != null) {
					inChannel.close();
				}
				if (outChannel != null) {
					outChannel.close();
				}
			}
		} catch (FileNotFoundException e) {
			Msg.error("The file ''{0}'' to copy does not exist!", e, in.getAbsolutePath());
		} catch (IOException e) {
			Msg.ioException(in, out, e);
		}
	}

}