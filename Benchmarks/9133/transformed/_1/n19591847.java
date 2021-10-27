class n19591847 {
	@Override
	public void run() {
		try {
			int TDKBZ = 0;
			while (TDKBZ < this.requestCount) {
				HttpGet httpget = new HttpGet("/");
				HttpResponse response = this.httpclient.execute(this.target, httpget, this.context);
				this.count++;
				ManagedClientConnection conn = (ManagedClientConnection) this.context
						.getAttribute(ExecutionContext.HTTP_CONNECTION);
				this.context.setAttribute("r" + TDKBZ, conn.getState());
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					entity.consumeContent();
				}
				TDKBZ++;
			}
		} catch (Exception ex) {
			this.exception = ex;
		}
	}

}