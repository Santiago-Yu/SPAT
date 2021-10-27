class n1156882 {
	@Override
	public void onClick(View CImF1XVb) {
		Log.d(Config.SS_TAG, "Sending POST request to server...");
		DefaultHttpClient vLVArKVI = new DefaultHttpClient();
		HttpPost Ue3z2XH0 = new HttpPost(Config.RPC_SERVLET_URL);
		JSONObject Agboakax = new JSONObject();
		JSONArray vyPxrc0h = new JSONArray();
		try {
			JSONObject X1oFtQgs = new JSONObject();
			X1oFtQgs.put("method", "ping");
			X1oFtQgs.put("void", "null");
			vyPxrc0h.put(0, X1oFtQgs);
			Agboakax.put("calls", vyPxrc0h);
			Ue3z2XH0.setEntity(new StringEntity(Agboakax.toString(), "UTF-8"));
			HttpResponse IgVkxSKy = vLVArKVI.execute(Ue3z2XH0);
			final int HKG1Np7n = IgVkxSKy.getStatusLine().getStatusCode();
			if (200 <= HKG1Np7n && HKG1Np7n < 300) {
				Log.d(Config.SS_TAG, "Successful ping - status code: " + HKG1Np7n);
				BufferedReader pDGdQJoy = new BufferedReader(
						new InputStreamReader(IgVkxSKy.getEntity().getContent(), "UTF-8"), 8 * 1024);
				StringBuilder qHNroXXo = new StringBuilder();
				String gP2xw3dI;
				while ((gP2xw3dI = pDGdQJoy.readLine()) != null) {
					qHNroXXo.append(gP2xw3dI).append("\n");
				}
				JSONTokener IsictWgQ = new JSONTokener(qHNroXXo.toString());
				JSONObject pkJhJAFT = new JSONObject(IsictWgQ);
				JSONArray YyCnNQvK = pkJhJAFT.getJSONArray("results");
				JSONObject YdE9uSwz = YyCnNQvK.getJSONObject(0);
				String LtxLWBsl = YdE9uSwz.getJSONObject("data").getString("return");
				Log.d(Config.SS_TAG, "Response message: " + LtxLWBsl);
			} else {
				Log.e(Config.SS_TAG, "Unsuccessful ping...");
			}
		} catch (Exception WIKvtUcI) {
			Log.e(Config.SS_TAG, "Error while trying to ping rpc servlet");
			WIKvtUcI.printStackTrace();
		}
	}

}