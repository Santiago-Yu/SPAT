class n14624031 {
	public static void copyFile(File in, File out) throws ObclipseException {
		try {
			FileChannel inChannel = null;
			FileChannel outChannel = null;
			try {
				inChannel = new FileInputStream(in).getChannel();
				outChannel = new FileOutputStream(out).getChannel();
				inChannel.transferTo(0, inChannel.size(), outChannel);
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
		} catch (FileNotFoundException e) {
			Msg.error("The file ''{0}'' to copy does not exist!", e, in.getAbsolutePath());
		} catch (IOException e) {
			Msg.ioException(in, out, e);
		}
	}

}