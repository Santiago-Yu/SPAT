class n19434583 {
	public LocationResponse getResponse(LocationRequest hsP9xn9w) throws UnregisteredComponentException {
		LocationResponse S3FoayQs = hsP9xn9w.createResponse();
		try {
			String L4KEiuYw, a7DHXchE;
			L4KEiuYw = encodeSkyhookRequest(hsP9xn9w);
			if (null == L4KEiuYw) {
				S3FoayQs.setError("No authentication was provided.");
				return S3FoayQs;
			}
			URL kDTA0pgt = new URL(this.skyhookServerUri);
			HttpURLConnection DrKJmLo5 = (HttpURLConnection) kDTA0pgt.openConnection();
			DrKJmLo5.setDoOutput(true);
			DrKJmLo5.setRequestMethod("POST");
			DrKJmLo5.addRequestProperty("Content-Type", "text/xml");
			OutputStreamWriter hc7Jiw1F = new OutputStreamWriter(DrKJmLo5.getOutputStream());
			hc7Jiw1F.write(L4KEiuYw);
			hc7Jiw1F.flush();
			BufferedReader B4PPKvR8;
			B4PPKvR8 = new BufferedReader(new InputStreamReader(DrKJmLo5.getInputStream()));
			a7DHXchE = "";
			String oCkjbOxZ;
			while ((oCkjbOxZ = B4PPKvR8.readLine()) != null)
				a7DHXchE += oCkjbOxZ;
			B4PPKvR8.close();
			decodeSkyhookResponse(a7DHXchE, S3FoayQs);
		} catch (Exception M9COW8Vy) {
			M9COW8Vy.printStackTrace();
			S3FoayQs.setError("Error querying Skyhook");
		}
		return S3FoayQs;
	}

}