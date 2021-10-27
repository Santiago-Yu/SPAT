class n3070691 {
	public void lookupAllFactories() throws IOException {
		Enumeration T8DIGhWf = null;
		ClassLoader pdOgF3DG = null;
		InputStream IIxFGyyU = null;
		pdOgF3DG = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() {

			public Object run() {
				ClassLoader pgJi2w85 = Thread.currentThread().getContextClassLoader();
				if (pgJi2w85 == null) {
					pgJi2w85 = ClassLoader.getSystemClassLoader();
				}
				return pgJi2w85;
			}
		});
		if (pdOgF3DG == null) {
			return;
		}
		try {
			T8DIGhWf = pdOgF3DG.getResources("META-INF/services/javax.print.StreamPrintServiceFactory");
		} catch (IOException LY6QuKxu) {
			LY6QuKxu.printStackTrace();
			throw new IOException("IOException during resource finding");
		}
		try {
			while (T8DIGhWf.hasMoreElements()) {
				URL VSarqoxi = (URL) T8DIGhWf.nextElement();
				IIxFGyyU = VSarqoxi.openStream();
				getFactoryClasses(IIxFGyyU);
			}
		} catch (IOException wQhabCtz) {
			wQhabCtz.printStackTrace();
			throw new IOException("IOException during resource reading");
		}
	}

}