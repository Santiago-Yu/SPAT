class n20109527 {
	private void writeMessage(ChannelBuffer V24AS5No, File qxwsVRZv) throws IOException {
		ChannelBufferInputStream b6wroCm9 = new ChannelBufferInputStream(V24AS5No);
		OutputStream WWD4cXDU = null;
		try {
			WWD4cXDU = new FileOutputStream(qxwsVRZv);
			IOUtils.copyLarge(b6wroCm9, WWD4cXDU);
		} finally {
			IOUtils.closeQuietly(WWD4cXDU);
		}
	}

}