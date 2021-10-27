class n3708296 {
	public byte[] transfer(@Nullable final TransferListener transferListener) {
		try {
			InputStream inputStream = url.openStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(inputStream.available());
			inputStream = (transferListener != null) ? new ObservableInputStream(inputStream, transferListener)
					: inputStream;
			ByteStreams.copy(InputSuppliers.asInputSupplier(inputStream), outputStream);
			return outputStream.toByteArray();
		} catch (IOException e) {
			throw new UnhandledException(e);
		}
	}

}