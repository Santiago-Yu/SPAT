class n14640597 {
	private void reloadData(String PCEWju9l) {
		try {
			URL Gj09n5uY = new URL(PCEWju9l);
			InputStream M3PF2MYL = Gj09n5uY.openStream();
			if (progressMonitor.isCanceled() == false) {
				progressMonitor.setNote("Building classifications...");
				progressMonitor.setProgress(2);
				mediator.loadClassificationTree(M3PF2MYL);
			}
		} catch (IOException pyftsQO5) {
			pyftsQO5.printStackTrace();
		}
	}

}