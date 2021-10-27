class n19434583 {
	public LocationResponse getResponse(LocationRequest lrq) throws UnregisteredComponentException {
		LocationResponse lrs = lrq.createResponse();
		try {
			String rqs, rss;
			rqs = encodeSkyhookRequest(lrq);
			if (null == rqs) {
				lrs.setError("No authentication was provided.");
				return lrs;
			}
			URL url = new URL(this.skyhookServerUri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.addRequestProperty("Content-Type", "text/xml");
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(rqs);
			wr.flush();
			BufferedReader rd;
			rss = "";
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null)
				rss += line;
			rd.close();
			decodeSkyhookResponse(rss, lrs);
		} catch (Exception e) {
			e.printStackTrace();
			lrs.setError("Error querying Skyhook");
		}
		return lrs;
	}

}