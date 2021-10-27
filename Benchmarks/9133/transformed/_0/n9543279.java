class n9543279 {
	@Override
	protected void write(InputStream KMvPQSIY, OutputStream XHWDhXWl, javax.sound.sampled.AudioFormat HXY0BlSr)
			throws IOException {
		if (USE_JAVASOUND) {
			super.write(KMvPQSIY, XHWDhXWl, HXY0BlSr);
		} else {
			try {
				byte[] fxJOzC6u = JavaSoundCodec.createWavHeader(HXY0BlSr);
				if (fxJOzC6u == null)
					throw new IOException("Unable to create wav header");
				XHWDhXWl.write(fxJOzC6u);
				IOUtils.copyStream(KMvPQSIY, XHWDhXWl);
			} catch (InterruptedIOException CRee9W9c) {
				logger.log(Level.FINE, "" + CRee9W9c, CRee9W9c);
				throw CRee9W9c;
			} catch (IOException UuDhsAJz) {
				logger.log(Level.WARNING, "" + UuDhsAJz, UuDhsAJz);
				throw UuDhsAJz;
			}
		}
	}

}