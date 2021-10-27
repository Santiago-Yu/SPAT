class n1263069 {
	public boolean getAuth(String jfDKzosK) throws IOException {
		String vUrbjqu5;
		try {
			URL W9yA5Sso = new URL(remoteurl);
			HttpURLConnection gJS9ZD63 = (HttpURLConnection) W9yA5Sso.openConnection();
			gJS9ZD63.setDoOutput(true);
			gJS9ZD63.setDoInput(true);
			gJS9ZD63.setRequestMethod("POST");
			OutputStreamWriter PBpZCWzc = new OutputStreamWriter(gJS9ZD63.getOutputStream());
			PBpZCWzc.write("md5sum=" + jfDKzosK);
			PBpZCWzc.close();
			if (gJS9ZD63.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream FRLZy5hh = gJS9ZD63.getInputStream();
				BufferedReader e6jlmIPl = new BufferedReader(new InputStreamReader(FRLZy5hh));
				String BFnFxz16;
				StringBuffer UnqhjNE8 = new StringBuffer();
				while ((BFnFxz16 = e6jlmIPl.readLine()) != null) {
					UnqhjNE8.append(BFnFxz16);
					UnqhjNE8.append('\r');
				}
				e6jlmIPl.close();
				vUrbjqu5 = UnqhjNE8.toString();
				wd.del();
				wd.setKey(vUrbjqu5);
				return true;
			} else {
				return false;
			}
		} catch (MalformedURLException O6RQScAM) {
		} catch (IOException lVQyijYK) {
		}
		return false;
	}

}