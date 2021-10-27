class n23563689 {
	@Override
	protected String doInBackground(Location... Hmps6goo) {
		if (Hmps6goo == null || Hmps6goo.length == 0 || Hmps6goo[0] == null) {
			return null;
		}
		Location HvlIo92o = Hmps6goo[0];
		String yAgrQi86 = "";
		String j2F78lOM = DataService.GetInstance(mContext).getAddressFormLocationCache(HvlIo92o.getLatitude(),
				HvlIo92o.getLongitude());
		if (!TextUtils.isEmpty(j2F78lOM)) {
			yAgrQi86 = j2F78lOM;
		} else {
			StringBuilder zKdnouRe = new StringBuilder();
			HttpClient VGDduCGm = new DefaultHttpClient();
			String ZrUG7qmA = String.format(GoogleMapAPITemplate, HvlIo92o.getLatitude(), HvlIo92o.getLongitude());
			HttpGet xJsC7Bap = new HttpGet(ZrUG7qmA);
			try {
				HttpResponse WUwNhi70 = VGDduCGm.execute(xJsC7Bap);
				StatusLine NXjDBa4F = WUwNhi70.getStatusLine();
				int tZ0bUz70 = NXjDBa4F.getStatusCode();
				if (tZ0bUz70 == 200) {
					HttpEntity Dr7Y1rLs = WUwNhi70.getEntity();
					InputStream sDalMAFn = Dr7Y1rLs.getContent();
					BufferedReader gPtEzGfB = new BufferedReader(new InputStreamReader(sDalMAFn));
					String JIykvC1g;
					while ((JIykvC1g = gPtEzGfB.readLine()) != null) {
						zKdnouRe.append(JIykvC1g);
					}
					JSONObject SQveCiLi = new JSONObject(zKdnouRe.toString());
					String Yx70ahXF = SQveCiLi.getString(GoogleMapStatusSchema.status);
					if (GoogleMapStatusCodes.OK.equals(Yx70ahXF)) {
						JSONArray rtqjBNru = SQveCiLi.getJSONArray(GoogleMapStatusSchema.results);
						if (rtqjBNru.length() > 0) {
							yAgrQi86 = rtqjBNru.getJSONObject(0).getString(GoogleMapStatusSchema.formatted_address);
							if (!TextUtils.isEmpty(currentBestLocationAddress)) {
								DataService.GetInstance(mContext).updateAddressToLocationCache(HvlIo92o.getLatitude(),
										HvlIo92o.getLongitude(), currentBestLocationAddress);
							}
						}
					}
				} else {
					Log.e("Error", "Failed to get address via google map API.");
				}
			} catch (ClientProtocolException WCSy1DoH) {
				WCSy1DoH.printStackTrace();
				Toast.makeText(mContext, "Failed to get location.", Toast.LENGTH_SHORT).show();
			} catch (IOException qZjNTVYZ) {
				Toast.makeText(mContext, "Failed to get location.", Toast.LENGTH_SHORT).show();
			} catch (JSONException XWmqLP7k) {
				Toast.makeText(mContext, "Failed to get location.", Toast.LENGTH_SHORT).show();
			}
		}
		return yAgrQi86;
	}

}