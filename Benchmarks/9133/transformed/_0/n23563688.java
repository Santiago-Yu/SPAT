class n23563688 {
	private void getLocationAddressByGoogleMapAsync(Location VN4ug9is) {
		if (VN4ug9is == null) {
			return;
		}
		AsyncTask<Location, Void, String> UXTo1ei0 = new AsyncTask<Location, Void, String>() {

			@Override
			protected String doInBackground(Location... JqoBleBI) {
				if (JqoBleBI == null || JqoBleBI.length == 0 || JqoBleBI[0] == null) {
					return null;
				}
				Location pDVhG7ae = JqoBleBI[0];
				String jhJPyxxc = "";
				String u4byn676 = DataService.GetInstance(mContext).getAddressFormLocationCache(pDVhG7ae.getLatitude(),
						pDVhG7ae.getLongitude());
				if (!TextUtils.isEmpty(u4byn676)) {
					jhJPyxxc = u4byn676;
				} else {
					StringBuilder XyhHyngZ = new StringBuilder();
					HttpClient c1TJfpA4 = new DefaultHttpClient();
					String zABRSjm0 = String.format(GoogleMapAPITemplate, pDVhG7ae.getLatitude(),
							pDVhG7ae.getLongitude());
					HttpGet aAcyGrtm = new HttpGet(zABRSjm0);
					try {
						HttpResponse IDLzwYNL = c1TJfpA4.execute(aAcyGrtm);
						StatusLine OgHQ1oJl = IDLzwYNL.getStatusLine();
						int IQ4g3WBp = OgHQ1oJl.getStatusCode();
						if (IQ4g3WBp == 200) {
							HttpEntity qfkTUy3B = IDLzwYNL.getEntity();
							InputStream hDCXyKaZ = qfkTUy3B.getContent();
							BufferedReader cA9FUOkA = new BufferedReader(new InputStreamReader(hDCXyKaZ));
							String WvADXlrb;
							while ((WvADXlrb = cA9FUOkA.readLine()) != null) {
								XyhHyngZ.append(WvADXlrb);
							}
							JSONObject B2CGd4tj = new JSONObject(XyhHyngZ.toString());
							String x2lXXgqL = B2CGd4tj.getString(GoogleMapStatusSchema.status);
							if (GoogleMapStatusCodes.OK.equals(x2lXXgqL)) {
								JSONArray GYYdVVJB = B2CGd4tj.getJSONArray(GoogleMapStatusSchema.results);
								if (GYYdVVJB.length() > 0) {
									jhJPyxxc = GYYdVVJB.getJSONObject(0)
											.getString(GoogleMapStatusSchema.formatted_address);
									if (!TextUtils.isEmpty(currentBestLocationAddress)) {
										DataService.GetInstance(mContext).updateAddressToLocationCache(
												pDVhG7ae.getLatitude(), pDVhG7ae.getLongitude(),
												currentBestLocationAddress);
									}
								}
							}
						} else {
							Log.e("Error", "Failed to get address via google map API.");
						}
					} catch (ClientProtocolException qaCpC79b) {
						qaCpC79b.printStackTrace();
						Toast.makeText(mContext, "Failed to get location.", Toast.LENGTH_SHORT).show();
					} catch (IOException MAY8puBU) {
						Toast.makeText(mContext, "Failed to get location.", Toast.LENGTH_SHORT).show();
					} catch (JSONException n7mBTBrO) {
						Toast.makeText(mContext, "Failed to get location.", Toast.LENGTH_SHORT).show();
					}
				}
				return jhJPyxxc;
			}

			@Override
			protected void onPostExecute(String CkjpTSe5) {
				setCurrentBestLocationAddress(currentBestLocation, CkjpTSe5);
			}
		};
		UXTo1ei0.execute(currentBestLocation);
	}

}