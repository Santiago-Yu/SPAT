class n11026476 {
	public Object invoke(Invocation invocation) throws Throwable {
		HttpURLConnection connection = null;
		SmartRef smartRef = (SmartRef) invocation.getValue(Invocation.SMARTREF);
		URL url = null;
		ObjectOutputStream out = null;
		boolean isThrowable = false;
		try {
			url = new URL(smartRef.getProperties().getProperty("org.smartcc.connector.url"));
			url = new URL(url, smartRef.getLookup());
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Content-Type", "application/octet-stream");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			out = new ObjectOutputStream(connection.getOutputStream());
			out.writeObject(invocation);
			out.flush();
		} catch (ObjectStreamException e) {
			System.err.println("error: during serialization");
			throw new EJBException("error: during serialization", e);
		} catch (IOException e) {
			System.err.println("error: could not connect to " + url);
			throw new ConnectIOException("could not connect to " + url, e);
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}
		ObjectInputStream in = null;
		Object result = null;
		try {
			in = new ObjectInputStream(connection.getInputStream());
			isThrowable = in.readBoolean();
			if (isThrowable || !invocation.getMethod().getReturnType().equals(void.class))
				result = in.readObject();
		} catch (ObjectStreamException e) {
			System.err.println("error: during deserialization");
			throw new EJBException("error: during deserialization", e);
		} catch (IOException e) {
			System.err.println("error: could not connect to " + url);
			throw new ConnectIOException("could not connect to " + url, e);
		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
		}
		if (isThrowable)
			throw (Throwable) result;
		return result;
	}

}