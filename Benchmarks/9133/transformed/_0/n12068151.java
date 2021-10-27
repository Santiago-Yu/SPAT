class n12068151 {
	@Override
	public void onCreate(Bundle rfOfsX1i) {
		super.onCreate(rfOfsX1i);
		setContentView(R.layout.cautaprodus);
		HttpGet jI79P83r = new HttpGet(SERVICE_URI + "/json/getproducts");
		jI79P83r.setHeader("Accept", "application/json");
		jI79P83r.setHeader("Content-type", "application/json");
		DefaultHttpClient OBiUT14a = new DefaultHttpClient();
		String qXcXxDK4 = new String("");
		try {
			HttpResponse D7dxP3Lq = OBiUT14a.execute(jI79P83r);
			HttpEntity sVYGVdCC = D7dxP3Lq.getEntity();
			InputStream S8LKGNXt = sVYGVdCC.getContent();
			BufferedReader NmuIdrDa = new BufferedReader(new InputStreamReader(S8LKGNXt));
			Vector<String> g8MyEXXc = new Vector<String>();
			String M1e8NX9l = new String();
			StringBuilder UlooH3Ng = new StringBuilder();
			String bTCsw11N;
			while ((bTCsw11N = NmuIdrDa.readLine()) != null) {
				UlooH3Ng.append(bTCsw11N);
			}
			S8LKGNXt.close();
			qXcXxDK4 = UlooH3Ng.toString();
			JSONObject T094ycI7 = new JSONObject(qXcXxDK4);
			Log.i("_GetPerson_", "<jsonobject>\n" + T094ycI7.toString() + "\n</jsonobject>");
			JSONArray Z8f7Wki5 = T094ycI7.getJSONArray("getProductsResult");
			for (int jtXB4TfG = 0; jtXB4TfG < Z8f7Wki5.length(); jtXB4TfG++) {
				Log.i("_GetProducts_", "<ID" + jtXB4TfG + ">" + Z8f7Wki5.getJSONObject(jtXB4TfG).getString("ID")
						+ "</ID" + jtXB4TfG + ">\n");
				Log.i("_GetProducts_", "<Name" + jtXB4TfG + ">" + Z8f7Wki5.getJSONObject(jtXB4TfG).getString("Name")
						+ "</Name" + jtXB4TfG + ">\n");
				Log.i("_GetProducts_", "<Price" + jtXB4TfG + ">" + Z8f7Wki5.getJSONObject(jtXB4TfG).getString("Price")
						+ "</Price" + jtXB4TfG + ">\n");
				Log.i("_GetProducts_", "<Symbol" + jtXB4TfG + ">" + Z8f7Wki5.getJSONObject(jtXB4TfG).getString("Symbol")
						+ "</Symbol" + jtXB4TfG + ">\n");
				M1e8NX9l = Z8f7Wki5.getJSONObject(jtXB4TfG).getString("Name") + "\n"
						+ Z8f7Wki5.getJSONObject(jtXB4TfG).getString("Price") + "\n"
						+ Z8f7Wki5.getJSONObject(jtXB4TfG).getString("Symbol");
				g8MyEXXc.add(new String(M1e8NX9l));
			}
			int QnUFrMQJ = g8MyEXXc.size();
			String[] wq6I5LCF = new String[QnUFrMQJ];
			g8MyEXXc.copyInto(wq6I5LCF);
			setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wq6I5LCF));
		} catch (Exception esZHCQLz) {
			esZHCQLz.printStackTrace();
		}
	}

}