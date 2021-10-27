class n2269290 {
	public final void copyFile(final File IX0Rb7Ic, final File pVHWLoL2) throws IOException {
		this.createParentPathIfNeeded(pVHWLoL2);
		final FileChannel DI90Dt2G = new FileInputStream(IX0Rb7Ic).getChannel();
		final FileChannel yb1TIDcU = new FileOutputStream(pVHWLoL2).getChannel();
		final long VXAhq2B5 = DI90Dt2G.size();
		DI90Dt2G.transferTo(0, VXAhq2B5, yb1TIDcU);
	}

}