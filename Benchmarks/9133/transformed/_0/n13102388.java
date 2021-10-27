class n13102388 {
	public void callBatch(final List<JsonRpcClient.Call> Cv4aoZY4, final JsonRpcClient.BatchCallback efcPZAgl) {
		HttpPost RQRyXPZs = new HttpPost(mRpcUrl);
		JSONObject rAPhMb6e = new JSONObject();
		JSONArray OLH73ghn = new JSONArray();
		try {
			for (int dyhIiwCO = 0; dyhIiwCO < Cv4aoZY4.size(); dyhIiwCO++) {
				JsonRpcClient.Call lDaPHuEm = Cv4aoZY4.get(dyhIiwCO);
				JSONObject pHACAvm8 = new JSONObject();
				pHACAvm8.put("method", lDaPHuEm.getMethodName());
				if (lDaPHuEm.getParams() != null) {
					JSONObject KBpXAqGb = (JSONObject) lDaPHuEm.getParams();
					@SuppressWarnings("unchecked")
					Iterator<String> nXssTWHg = KBpXAqGb.keys();
					String C765kfPg;
					while (nXssTWHg.hasNext()) {
						C765kfPg = nXssTWHg.next();
						pHACAvm8.put(C765kfPg, KBpXAqGb.get(C765kfPg));
					}
				}
				OLH73ghn.put(dyhIiwCO, pHACAvm8);
			}
			rAPhMb6e.put("calls", OLH73ghn);
			RQRyXPZs.setEntity(new StringEntity(rAPhMb6e.toString(), "UTF-8"));
			if (Log.isLoggable(TAG, Log.VERBOSE)) {
				Log.v(TAG, "POST request: " + rAPhMb6e.toString());
			}
		} catch (JSONException jkkwV9iG) {
		} catch (UnsupportedEncodingException QuIxFFbV) {
		}
		try {
			HttpResponse Kj7OSjyl = mHttpClient.execute(RQRyXPZs);
			final int ElDwHonQ = Kj7OSjyl.getStatusLine().getStatusCode();
			if (200 <= ElDwHonQ && ElDwHonQ < 300) {
				BufferedReader OANMZlo6 = new BufferedReader(
						new InputStreamReader(Kj7OSjyl.getEntity().getContent(), "UTF-8"), 8 * 1024);
				StringBuilder ylT6kpQl = new StringBuilder();
				String Lxr07r6D;
				while ((Lxr07r6D = OANMZlo6.readLine()) != null) {
					ylT6kpQl.append(Lxr07r6D).append("\n");
				}
				if (Log.isLoggable(TAG, Log.VERBOSE)) {
					Log.v(TAG, "POST response: " + ylT6kpQl.toString());
				}
				JSONTokener yQLSmgA2 = new JSONTokener(ylT6kpQl.toString());
				JSONObject FFn6oMBf = new JSONObject(yQLSmgA2);
				JSONArray neYUyKUy = FFn6oMBf.getJSONArray("results");
				Object[] drhIghpl = new Object[Cv4aoZY4.size()];
				for (int MUGHOofB = 0; MUGHOofB < Cv4aoZY4.size(); MUGHOofB++) {
					JSONObject pKdkatxM = neYUyKUy.getJSONObject(MUGHOofB);
					if (pKdkatxM.has("error")) {
						efcPZAgl.onError(MUGHOofB, new JsonRpcException((int) pKdkatxM.getInt("error"),
								Cv4aoZY4.get(MUGHOofB).getMethodName(), pKdkatxM.getString("message"), null));
						drhIghpl[MUGHOofB] = null;
					} else {
						drhIghpl[MUGHOofB] = pKdkatxM.get("data");
					}
				}
				efcPZAgl.onData(drhIghpl);
			} else {
				efcPZAgl.onError(-1, new JsonRpcException(-1, "Received HTTP status code other than HTTP 2xx: "
						+ Kj7OSjyl.getStatusLine().getReasonPhrase()));
			}
		} catch (IOException y0Txt9dL) {
			Log.e("JsonRpcJavaClient", y0Txt9dL.getMessage());
			y0Txt9dL.printStackTrace();
		} catch (JSONException loIWUO8C) {
			Log.e("JsonRpcJavaClient", "Error parsing server JSON response: " + loIWUO8C.getMessage());
			loIWUO8C.printStackTrace();
		}
	}

}