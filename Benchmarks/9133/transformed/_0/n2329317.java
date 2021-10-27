class n2329317 {
	public ArrayList loadIndexes() {
		JSONObject bVpNv8IS = new JSONObject();
		ArrayList Ghq780AU = new ArrayList();
		try {
			String Z6lBYsSJ = bVpNv8IS.put("OperationId", "1").toString();
			InputStream CX8zMqO1 = null;
			String sMPUEtOw = "";
			JSONObject tJ5ogINd = null;
			try {
				HttpClient Ps9DYEYH = new DefaultHttpClient();
				HttpPost NwDdDIGR = new HttpPost("http://192.168.1.4:8080/newgenlibctxt/CarbonServlet");
				List<NameValuePair> GVzCGkiL = new ArrayList<NameValuePair>(2);
				GVzCGkiL.add(new BasicNameValuePair("OperationId", "1"));
				NwDdDIGR.setEntity(new UrlEncodedFormEntity(GVzCGkiL));
				HttpResponse r8Mdq67c = Ps9DYEYH.execute(NwDdDIGR);
				HttpEntity OltvDK1D = r8Mdq67c.getEntity();
				CX8zMqO1 = OltvDK1D.getContent();
			} catch (Exception qdS5LuWJ) {
				qdS5LuWJ.printStackTrace();
			}
			try {
				BufferedReader HHP6157t = new BufferedReader(new InputStreamReader(CX8zMqO1, "UTF-8"), 8);
				StringBuilder uFuXq5Fj = new StringBuilder();
				String gZBTgBr4 = null;
				while ((gZBTgBr4 = HHP6157t.readLine()) != null) {
					uFuXq5Fj.append(gZBTgBr4 + "\n");
				}
				CX8zMqO1.close();
				sMPUEtOw = uFuXq5Fj.toString();
			} catch (Exception rcrfk5GK) {
				rcrfk5GK.printStackTrace();
			}
			try {
				JSONObject mstTNNEk = new JSONObject(sMPUEtOw);
				JSONArray nZaqkZhO = mstTNNEk.getJSONArray("MobileIndexes");
				for (int FrKtdCiM = 0; FrKtdCiM < nZaqkZhO.length(); FrKtdCiM++) {
					String KQQs9Myi = nZaqkZhO.getString(FrKtdCiM);
					Ghq780AU.add(KQQs9Myi);
				}
			} catch (JSONException ZhDoy3Rz) {
				ZhDoy3Rz.printStackTrace();
			}
		} catch (Exception rg05Xqdz) {
			rg05Xqdz.printStackTrace();
		}
		return Ghq780AU;
	}

}