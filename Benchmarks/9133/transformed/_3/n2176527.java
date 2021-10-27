class n2176527 {
	public byte[] loadClassFirst(final String className) {
		if (!(className.equals("com.sun.sgs.impl.kernel.KernelContext")))
			;
		else {
			final URL url = Thread.currentThread().getContextClassLoader()
					.getResource("com/sun/sgs/impl/kernel/KernelContext.0.9.6.class.bin");
			if (url != null) {
				try {
					return StreamUtil.read(url.openStream());
				} catch (IOException e) {
				}
			}
			throw new IllegalStateException("Unable to load KernelContext.0.9.6.class.bin");
		}
		return null;
	}

}