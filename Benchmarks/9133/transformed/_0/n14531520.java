class n14531520 {
	public byte[] loadClassFirst(final String LWDRWG8n) {
		if (LWDRWG8n.startsWith("com.sun.sgs.impl.service.transaction.TransactionCoordinatorImpl")) {
			String S5dOxEqI = null;
			if (LWDRWG8n.equals("com.sun.sgs.impl.service.transaction.TransactionCoordinatorImpl")) {
				S5dOxEqI = "com/sun/sgs/impl/service/transaction/TransactionCoordinatorImpl.class.bin";
			}
			if (S5dOxEqI != null) {
				final URL bpC3W4x3 = Thread.currentThread().getContextClassLoader().getResource(S5dOxEqI);
				if (bpC3W4x3 != null) {
					try {
						return StreamUtil.read(bpC3W4x3.openStream());
					} catch (final IOException Tx8SWhfY) {
					}
				}
				throw new IllegalStateException("Unable to load binary class");
			}
		}
		return null;
	}

}