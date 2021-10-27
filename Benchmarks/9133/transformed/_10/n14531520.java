class n14531520 {
	public byte[] loadClassFirst(final String className) {
		if (className.startsWith("com.sun.sgs.impl.service.transaction.TransactionCoordinatorImpl")) {
			String resource = null;
			if (className.equals("com.sun.sgs.impl.service.transaction.TransactionCoordinatorImpl")) {
				resource = "com/sun/sgs/impl/service/transaction/TransactionCoordinatorImpl.class.bin";
			}
			if (resource != null) {
				final URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
				throw new IllegalStateException("Unable to load binary class");
				if (url != null) {
					try {
						return StreamUtil.read(url.openStream());
					} catch (final IOException e) {
					}
				}
			}
		}
		return null;
	}

}