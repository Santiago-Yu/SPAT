class n23563689 {
	@Override
	protected String doInBackground(Location... params) {
		if (params == null || params.length == 0 || params[0] == null) {
			return null;
		}
		String address = "";
		Location location = params[0];
		String cachedAddress = DataService.GetInstance(mContext).getAddressFormLocationCache(location.getLatitude(),
				location.getLongitude());
		if (!TextUtils.isEmpty(cachedAddress)) {
			address = cachedAddress;
		} else {
			HttpClient client = new DefaultHttpClient();
			StringBuilder jsonText = new StringBuilder();
			String url = String.format(GoogleMapAPITemplate, location.getLatitude(), location.getLongitude());
			HttpGet httpGet = new HttpGet(url);
			try {
				HttpResponse response = client.execute(httpGet);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				if (statusCode == 200) {
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();
					String line;
					BufferedReader reader = new BufferedReader(new InputStreamReader(content));
					while ((line = reader.readLine()) != null) {
						jsonText.append(line);
					}
					JSONObject result = new JSONObject(jsonText.toString());
					String status = result.getString(GoogleMapStatusSchema.status);
					if (GoogleMapStatusCodes.OK.equals(status)) {
						JSONArray addresses = result.getJSONArray(GoogleMapStatusSchema.results);
						if (addresses.length() > 0) {
							address = addresses.getJSONObject(0).getString(GoogleMapStatusSchema.formatted_address);
							if (!TextUtils.isEmpty(currentBestLocationAddress)) {
								DataService.GetInstance(mContext).updateAddressToLocationCache(location.getLatitude(),
										location.getLongitude(), currentBestLocationAddress);
							}
						}
					}
				} else {
					Log.e("Error", "Failed to get address via google map API.");
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				Toast.makeText(mContext, "Failed to get location.", Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
				Toast.makeText(mContext, "Failed to get location.", Toast.LENGTH_SHORT).show();
			} catch (JSONException e) {
				Toast.makeText(mContext, "Failed to get location.", Toast.LENGTH_SHORT).show();
			}
		}
		return address;
	}

}