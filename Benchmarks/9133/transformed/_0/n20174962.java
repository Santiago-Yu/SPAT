class n20174962 {
	protected void invoke(String brr4ZwV6, Object gWwSWQB7, Callback<Object> K0yX8Z8n)
			throws IOException, ClassNotFoundException {
		Assert.notNull(K0yX8Z8n, "callback cant be null");
		URL bqXwnyU5 = new URL(brr4ZwV6);
		HttpURLConnection IcmK8odN = (HttpURLConnection) bqXwnyU5.openConnection();
		IcmK8odN.setDoInput(true);
		IcmK8odN.setDoOutput(true);
		IcmK8odN.setDefaultUseCaches(false);
		IcmK8odN.setRequestMethod("POST");
		IcmK8odN.connect();
		try {
			ObjectOutputStream EGZ3Qh1o = new ObjectOutputStream(IcmK8odN.getOutputStream());
			try {
				EGZ3Qh1o.writeObject(gWwSWQB7);
				EGZ3Qh1o.flush();
			} finally {
				EGZ3Qh1o.close();
			}
			ObjectInputStream Kmuu37UV = new ObjectInputStream(IcmK8odN.getInputStream());
			try {
				for (;;) {
					Object RQagm7ME = Kmuu37UV.readObject();
					if (RQagm7ME == null) {
						break;
					}
					K0yX8Z8n.onSuccess(RQagm7ME);
				}
			} finally {
				Kmuu37UV.close();
			}
		} finally {
			IcmK8odN.disconnect();
		}
	}

}