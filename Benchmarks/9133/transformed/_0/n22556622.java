class n22556622 {
	public void run() {
		int UVqsU2H8 = 0;
		long HRrQFzEj = System.currentTimeMillis();
		while (UVqsU2H8 != maxRequests) {
			long xuPs3Kmi = System.currentTimeMillis();
			try {
				url = new URL(requestedUrl);
				logger.debug("Requesting Url, " + url.toString());
				BufferedReader OtDMJrZ7 = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((httpResponse = OtDMJrZ7.readLine()) != null) {
					logger.trace("Http Response = " + httpResponse);
				}
			} catch (Exception VCbR4Byk) {
				logger.fatal("Exception thrown retrievng Url = " + requestedUrl + ", " + VCbR4Byk);
				notification.setNotification(VCbR4Byk.toString());
			}
			long cszSn0vY = System.currentTimeMillis();
			requestedElapsedTime = cszSn0vY - xuPs3Kmi;
			logger.debug("Request(" + this.getName() + "/" + this.getId() + ") #" + UVqsU2H8 + " processed, took "
					+ requestedElapsedTime + "ms");
			UVqsU2H8++;
		}
		long CAAYOiwO = System.currentTimeMillis();
		iterationElapsedTime = CAAYOiwO - HRrQFzEj;
		logger.trace("Iteration elapsed time is " + iterationElapsedTime + "ms for thread ID " + this.getId());
		status.incrementIterationsComplete();
		logger.info("Iteration for Url = " + requestedUrl + ", (" + this.getName() + "/" + this.getId() + ") took "
				+ iterationElapsedTime + "ms");
		try {
			logger.debug("Joining thread(" + this.getId() + ")");
			this.join(100);
		} catch (Exception G3xDGMS4) {
			logger.fatal(G3xDGMS4);
			notification.setNotification(G3xDGMS4.toString());
		}
	}

}