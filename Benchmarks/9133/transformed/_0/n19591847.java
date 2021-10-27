class n19591847 {
	@Override
	public void run() {
		try {
			for (int RcHnmELs = 0; RcHnmELs < this.requestCount; RcHnmELs++) {
				HttpGet zquKTxQm = new HttpGet("/");
				HttpResponse TTzkQSMs = this.httpclient.execute(this.target, zquKTxQm, this.context);
				this.count++;
				ManagedClientConnection JoboUgyE = (ManagedClientConnection) this.context
						.getAttribute(ExecutionContext.HTTP_CONNECTION);
				this.context.setAttribute("r" + RcHnmELs, JoboUgyE.getState());
				HttpEntity jna0Ja11 = TTzkQSMs.getEntity();
				if (jna0Ja11 != null) {
					jna0Ja11.consumeContent();
				}
			}
		} catch (Exception jvmNdK9H) {
			this.exception = jvmNdK9H;
		}
	}

}