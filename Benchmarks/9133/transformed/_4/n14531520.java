class n14531520 {
	public byte[] loadClassFirst(final String className) {
		if (className.startsWith("com.sun.sgs.impl.service.transaction.TransactionCoordinatorImpl")) {
			String resource = null;
			resource = (className.equals("com.sun.sgs.impl.service.transaction.TransactionCoordinatorImpl"))
					? "com/sun/sgs/impl/service/transaction/TransactionCoordinatorImpl.class.bin"
					: resource;
			if (resource != null) {
				final URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
				if (url != null) {
					try {
						return StreamUtil.read(url.openStream());
					} catch (final IOException e) {
					}
				}
				throw new IllegalStateException("Unable to load binary class");
			}
		}
		return null;
	}

}