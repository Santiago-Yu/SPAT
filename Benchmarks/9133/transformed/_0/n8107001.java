class n8107001 {
	@Override
	public void onCreate(Bundle pk7CqXAO) {
		super.onCreate(pk7CqXAO);
		setContentView(R.layout.listview);
		HttpGet JLl5uhbj = new HttpGet(SERVICE_URI + "/json/getroutes/1");
		JLl5uhbj.setHeader("Accept", "application/json");
		JLl5uhbj.setHeader("Content-type", "application/json");
		DefaultHttpClient MrmA2TJu = new DefaultHttpClient();
		String dY6eZev6 = new String("");
		try {
			HttpResponse On5HAywr = MrmA2TJu.execute(JLl5uhbj);
			HttpEntity HZjROwON = On5HAywr.getEntity();
			InputStream gvtMT4Kb = HZjROwON.getContent();
			BufferedReader idn4gIgs = new BufferedReader(new InputStreamReader(gvtMT4Kb));
			Vector<String> P8GEmyC4 = new Vector<String>();
			String cMYC9mJJ = new String();
			String RgRd5WzN = new String();
			String iH2uAbRl = new String();
			String POrLKJxu = new String();
			String vvBr3qiy = new String();
			StringBuilder lJx9X2Y2 = new StringBuilder();
			String jB8wQfPd;
			while ((jB8wQfPd = idn4gIgs.readLine()) != null) {
				lJx9X2Y2.append(jB8wQfPd);
			}
			gvtMT4Kb.close();
			dY6eZev6 = lJx9X2Y2.toString();
			JSONObject QtT5GxBl = new JSONObject(dY6eZev6);
			Log.i("_GetClient_", "<jsonobject>\n" + QtT5GxBl.toString() + "\n</jsonobject>");
			this.dm = new DataManipulator(this);
			JSONArray T3v3PWaO = QtT5GxBl.getJSONArray("GetRoutesByAgentResult");
			for (int gYabDh0P = 0; gYabDh0P < T3v3PWaO.length(); gYabDh0P++) {
				RgRd5WzN = T3v3PWaO.getJSONObject(gYabDh0P).getString("Agent");
				iH2uAbRl = T3v3PWaO.getJSONObject(gYabDh0P).getString("Client");
				POrLKJxu = T3v3PWaO.getJSONObject(gYabDh0P).getString("Route");
				vvBr3qiy = T3v3PWaO.getJSONObject(gYabDh0P).getString("Zone");
				Log.i("_GetClient_", "<Agent" + gYabDh0P + ">" + RgRd5WzN + "</Agent" + gYabDh0P + ">\n");
				Log.i("_GetClient_", "<Client" + gYabDh0P + ">" + iH2uAbRl + "</Client" + gYabDh0P + ">\n");
				Log.i("_GetClient_", "<Route" + gYabDh0P + ">" + POrLKJxu + "</Route" + gYabDh0P + ">\n");
				Log.i("_GetClient_", "<Zone" + gYabDh0P + ">" + vvBr3qiy + "</Zone" + gYabDh0P + ">\n");
				cMYC9mJJ = T3v3PWaO.getJSONObject(gYabDh0P).getString("Client") + "\n"
						+ T3v3PWaO.getJSONObject(gYabDh0P).getString("Route") + "\n"
						+ T3v3PWaO.getJSONObject(gYabDh0P).getString("Zone");
				P8GEmyC4.add(new String(cMYC9mJJ));
			}
			int TcsdCcbV = P8GEmyC4.size();
			String[] JJFeKxWo = new String[TcsdCcbV];
			P8GEmyC4.copyInto(JJFeKxWo);
			setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, JJFeKxWo));
		} catch (Exception S1XHprEz) {
			S1XHprEz.printStackTrace();
		}
	}

}