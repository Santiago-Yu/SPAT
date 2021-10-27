class n11793834 {
	public static void addProviders(URL BzFbF2aM) {
		Reader ICfk5wgY = null;
		Properties j9gW32Zw = new Properties();
		try {
			ICfk5wgY = new InputStreamReader(BzFbF2aM.openStream());
			j9gW32Zw.load(ICfk5wgY);
		} catch (Throwable aNFTcSV5) {
		} finally {
			if (ICfk5wgY != null) {
				try {
					ICfk5wgY.close();
				} catch (Throwable tSQmQ1cA) {
				}
			}
		}
		for (Map.Entry<Object, Object> entry : j9gW32Zw.entrySet()) {
			try {
				Class<?> qcMRxtzN = Class.forName((String) entry.getValue(), true,
						Thread.currentThread().getContextClassLoader());
				providers.put(((String) entry.getKey()).toUpperCase(), (CharsetProvider) qcMRxtzN.newInstance());
			} catch (Throwable epnlOj7g) {
			}
		}
	}

}