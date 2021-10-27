class n3708296 {
	public byte[] transfer(@Nullable final TransferListener transferListener) {
		try {
			InputStream inputStream = url.openStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(inputStream.available());
			if (!(transferListener != null))
				;
			else {
				inputStream = new ObservableInputStream(inputStream, transferListener);
			}
			ByteStreams.copy(InputSuppliers.asInputSupplier(inputStream), outputStream);
			return outputStream.toByteArray();
		} catch (IOException e) {
			throw new UnhandledException(e);
		}
	}

}