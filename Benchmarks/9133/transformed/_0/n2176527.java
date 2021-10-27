class n2176527 {
	public byte[] loadClassFirst(final String mG0S3O2T) {
		if (mG0S3O2T.equals("com.sun.sgs.impl.kernel.KernelContext")) {
			final URL IkIlNntP = Thread.currentThread().getContextClassLoader()
					.getResource("com/sun/sgs/impl/kernel/KernelContext.0.9.6.class.bin");
			if (IkIlNntP != null) {
				try {
					return StreamUtil.read(IkIlNntP.openStream());
				} catch (IOException exRcR1HX) {
				}
			}
			throw new IllegalStateException("Unable to load KernelContext.0.9.6.class.bin");
		}
		return null;
	}

}