class n22495693 {
	public byte[] loadClassFirst(final String className) {
		if ("com.sun.sgs.impl.kernel.KernelContext".equals(className)) {
			final URL url = Thread.currentThread().getContextClassLoader()
					.getResource("com/sun/sgs/impl/kernel/KernelContext.0.9.7.class.bin");
			if (url != null) {
				try {
					return StreamUtil.read(url.openStream());
				} catch (IOException e) {
				}
			}
			throw new IllegalStateException("Unable to load KernelContext.0.9.7.class.bin");
		}
		return null;
	}

}