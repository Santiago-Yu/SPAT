class n15346427 {
	private ArrayList loadResults(String auOntjcO, String scvQYzmX, int zQcdMrOx) {
		loadingMore = true;
		JSONObject frCZW4TZ = new JSONObject();
		ArrayList uPxGLP6q = new ArrayList();
		try {
			String jot9G68Q = frCZW4TZ.put("OperationId", "2").toString();
			InputStream qve0GFCI = null;
			String cBU734Fq = "";
			JSONObject cHO6lICl = null;
			try {
				HttpClient TrzxYFik = new DefaultHttpClient();
				HttpPost yx6cpq2u = new HttpPost("http://192.168.1.4:8080/newgenlibctxt/CarbonServlet");
				List<NameValuePair> ev7WcDIA = new ArrayList<NameValuePair>(2);
				ev7WcDIA.add(new BasicNameValuePair("OperationId", "2"));
				ev7WcDIA.add(new BasicNameValuePair("Text", auOntjcO));
				ev7WcDIA.add(new BasicNameValuePair("Index", scvQYzmX));
				ev7WcDIA.add(new BasicNameValuePair("From", zQcdMrOx + ""));
				yx6cpq2u.setEntity(new UrlEncodedFormEntity(ev7WcDIA));
				HttpResponse LD6gS3kA = TrzxYFik.execute(yx6cpq2u);
				HttpEntity WSjXViCI = LD6gS3kA.getEntity();
				qve0GFCI = WSjXViCI.getContent();
			} catch (Exception Qtwvbgt5) {
				Qtwvbgt5.printStackTrace();
			}
			try {
				BufferedReader RrTK2NpA = new BufferedReader(new InputStreamReader(qve0GFCI, "UTF-8"), 8);
				StringBuilder X83DpMOL = new StringBuilder();
				String bgfG8uHq = null;
				while ((bgfG8uHq = RrTK2NpA.readLine()) != null) {
					X83DpMOL.append(bgfG8uHq + "\n");
				}
				qve0GFCI.close();
				cBU734Fq = X83DpMOL.toString();
			} catch (Exception zURa1Iwy) {
				zURa1Iwy.printStackTrace();
			}
			try {
				JSONObject q6l1izd1 = new JSONObject(cBU734Fq);
				JSONArray s2O249Rb = q6l1izd1.getJSONArray("Records");
				for (int rNvCYU8g = 0; rNvCYU8g < s2O249Rb.length(); rNvCYU8g++) {
					String Iu59yImr = s2O249Rb.getJSONObject(rNvCYU8g).getString("title");
					String AVtt0fVW = s2O249Rb.getJSONObject(rNvCYU8g).getString("author");
					String[] YYbwKGij = new String[2];
					YYbwKGij[0] = s2O249Rb.getJSONObject(rNvCYU8g).getString("cataloguerecordid");
					YYbwKGij[1] = s2O249Rb.getJSONObject(rNvCYU8g).getString("ownerlibraryid");
					alOnlyIds.add(YYbwKGij);
					uPxGLP6q.add(
							Html.fromHtml("<html><body><b>" + Iu59yImr + "</b><br>by " + AVtt0fVW + "</body></html>"));
				}
			} catch (JSONException w0sENkNg) {
				w0sENkNg.printStackTrace();
			}
		} catch (Exception DpoAs2Hi) {
			DpoAs2Hi.printStackTrace();
		}
		loadingMore = false;
		return uPxGLP6q;
	}

}