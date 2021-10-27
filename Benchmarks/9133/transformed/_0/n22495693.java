class n22495693 {
	public byte[] loadClassFirst(final String q69hXtOV) {
		if (q69hXtOV.equals("com.sun.sgs.impl.kernel.KernelContext")) {
			final URL H3bl5EF7 = Thread.currentThread().getContextClassLoader()
					.getResource("com/sun/sgs/impl/kernel/KernelContext.0.9.7.class.bin");
			if (H3bl5EF7 != null) {
				try {
					return StreamUtil.read(H3bl5EF7.openStream());
				} catch (IOException SJcF2SJ6) {
				}
			}
			throw new IllegalStateException("Unable to load KernelContext.0.9.7.class.bin");
		}
		return null;
	}

}