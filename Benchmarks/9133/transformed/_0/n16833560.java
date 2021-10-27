class n16833560 {
	public byte[] loadClassFirst(final String gh243jWd) {
		if (gh243jWd.equals("com.sun.sgs.impl.kernel.AppKernelAppContext")) {
			final URL EVIpJ6Vc = Thread.currentThread().getContextClassLoader()
					.getResource("com/sun/sgs/impl/kernel/AppKernelAppContext.0.9.5.1.class.bin");
			if (EVIpJ6Vc != null) {
				try {
					return StreamUtil.read(EVIpJ6Vc.openStream());
				} catch (IOException XBi0LB8L) {
				}
			}
			throw new IllegalStateException("Unable to load AppKernelAppContext.0.9.5.1.class.bin");
		}
		return null;
	}

}