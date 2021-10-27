class n20109527 {
	private void writeMessage(ChannelBuffer buffer, File dst) throws IOException {
		OutputStream os = null;
		ChannelBufferInputStream is = new ChannelBufferInputStream(buffer);
		try {
			os = new FileOutputStream(dst);
			IOUtils.copyLarge(is, os);
		} finally {
			IOUtils.closeQuietly(os);
		}
	}

}