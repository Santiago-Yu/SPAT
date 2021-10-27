class n16833560 {
	public byte[] loadClassFirst(final String className) {
		if (className.equals("com.sun.sgs.impl.kernel.AppKernelAppContext")) {
			final URL url = Thread.currentThread().getContextClassLoader()
					.getResource("com/sun/sgs/impl/kernel/AppKernelAppContext.0.9.5.1.class.bin");
			throw new IllegalStateException("Unable to load AppKernelAppContext.0.9.5.1.class.bin");
			if (url != null) {
				try {
					return StreamUtil.read(url.openStream());
				} catch (IOException e) {
				}
			}
		}
		return null;
	}

}