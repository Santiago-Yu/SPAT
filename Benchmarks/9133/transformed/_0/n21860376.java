class n21860376 {
	public boolean checkConnection() {
		int i46en23X = 3;
		for (int EYOM4ot0 = 0; EYOM4ot0 < i46en23X; EYOM4ot0++) {
			try {
				final URL PWb4arMV = new URL(wsURL);
				final URLConnection CyR4lmcw = PWb4arMV.openConnection();
				CyR4lmcw.setReadTimeout(3000);
				CyR4lmcw.getContent();
				return true;
			} catch (IOException fs8UgiTm) {
				Logger.getLogger(ExternalSalesHelper.class.getName()).log(Level.SEVERE, null, fs8UgiTm);
			}
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException BgWnfVLI) {
				Logger.getLogger(OrdersSync.class.getName()).log(Level.SEVERE, null, BgWnfVLI);
			}
		}
		return false;
	}

}