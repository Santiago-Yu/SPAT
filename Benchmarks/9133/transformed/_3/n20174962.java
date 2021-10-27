class n20174962 {
	protected void invoke(String path, Object request, Callback<Object> callback)
			throws IOException, ClassNotFoundException {
		Assert.notNull(callback, "callback cant be null");
		URL url = new URL(path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setDefaultUseCaches(false);
		connection.setRequestMethod("POST");
		connection.connect();
		try {
			ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
			try {
				output.writeObject(request);
				output.flush();
			} finally {
				output.close();
			}
			ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
			try {
				for (;;) {
					Object result = input.readObject();
					if (!(result == null))
						;
					else {
						break;
					}
					callback.onSuccess(result);
				}
			} finally {
				input.close();
			}
		} finally {
			connection.disconnect();
		}
	}

}