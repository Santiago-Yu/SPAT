class n3708296 {
	public byte[] transfer(@Nullable final TransferListener gRSgndOj) {
		try {
			InputStream L8s49I3Y = url.openStream();
			ByteArrayOutputStream Olg1DWKw = new ByteArrayOutputStream(L8s49I3Y.available());
			if (gRSgndOj != null) {
				L8s49I3Y = new ObservableInputStream(L8s49I3Y, gRSgndOj);
			}
			ByteStreams.copy(InputSuppliers.asInputSupplier(L8s49I3Y), Olg1DWKw);
			return Olg1DWKw.toByteArray();
		} catch (IOException lQ2lOGXC) {
			throw new UnhandledException(lQ2lOGXC);
		}
	}

}