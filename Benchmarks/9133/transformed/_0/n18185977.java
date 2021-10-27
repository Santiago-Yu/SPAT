class n18185977 {
	@Override
	public void onCreate(Bundle Iteistgx) {
		super.onCreate(Iteistgx);
		setContentView(R.layout.listview);
		HttpGet eVAoUP9H = new HttpGet(SERVICE_URI + "/json/getroutes/1");
		eVAoUP9H.setHeader("Accept", "application/json");
		eVAoUP9H.setHeader("Content-type", "application/json");
		DefaultHttpClient ekO9gnCY = new DefaultHttpClient();
		String dziEvLb4 = new String("");
		try {
			HttpResponse ScYrObMH = ekO9gnCY.execute(eVAoUP9H);
			HttpEntity Js7EUg6W = ScYrObMH.getEntity();
			InputStream wWHYyUC4 = Js7EUg6W.getContent();
			BufferedReader KsC7LKiI = new BufferedReader(new InputStreamReader(wWHYyUC4));
			Vector<String> HLXQfyPh = new Vector<String>();
			String VTM4JyJN = new String();
			String qUme7YyP = new String();
			String vyNZJPAf = new String();
			String enVucv0O = new String();
			String LDdWmizG = new String();
			StringBuilder gssfFbel = new StringBuilder();
			String Ln1eHAjA;
			while ((Ln1eHAjA = KsC7LKiI.readLine()) != null) {
				gssfFbel.append(Ln1eHAjA);
			}
			wWHYyUC4.close();
			dziEvLb4 = gssfFbel.toString();
			JSONObject gryhmfaW = new JSONObject(dziEvLb4);
			Log.i("_GetClient_", "<jsonobject> \n " + gryhmfaW.toString() + " \n </jsonobject>");
			this.dm = new DataManipulator(this);
			JSONArray inKBcAmE = gryhmfaW.getJSONArray("GetRoutesByAgentResult");
			for (int O6EcdzH0 = 0; O6EcdzH0 < inKBcAmE.length(); O6EcdzH0++) {
				qUme7YyP = inKBcAmE.getJSONObject(O6EcdzH0).getString("Agent");
				vyNZJPAf = inKBcAmE.getJSONObject(O6EcdzH0).getString("Client");
				enVucv0O = inKBcAmE.getJSONObject(O6EcdzH0).getString("Route");
				LDdWmizG = inKBcAmE.getJSONObject(O6EcdzH0).getString("Zone");
				Log.i("_GetClient_", "<Agent" + O6EcdzH0 + ">" + qUme7YyP + "</Agent" + O6EcdzH0 + ">\n");
				Log.i("_GetClient_", "<Client" + O6EcdzH0 + ">" + vyNZJPAf + "</Client" + O6EcdzH0 + ">\n");
				Log.i("_GetClient_", "<Route" + O6EcdzH0 + ">" + enVucv0O + "</Route" + O6EcdzH0 + ">\n");
				Log.i("_GetClient_", "<Zone" + O6EcdzH0 + ">" + LDdWmizG + "</Zone" + O6EcdzH0 + ">\n");
				this.dm.insertIntoClients(qUme7YyP, vyNZJPAf, enVucv0O, LDdWmizG);
				VTM4JyJN = inKBcAmE.getJSONObject(O6EcdzH0).getString("Client") + "\n"
						+ inKBcAmE.getJSONObject(O6EcdzH0).getString("Route") + "\n"
						+ inKBcAmE.getJSONObject(O6EcdzH0).getString("Zone");
				HLXQfyPh.add(new String(VTM4JyJN));
			}
			int AG09Kgj1 = HLXQfyPh.size();
			String[] wnUtuGDt = new String[AG09Kgj1];
			HLXQfyPh.copyInto(wnUtuGDt);
			setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wnUtuGDt));
		} catch (Exception tZt06Ffs) {
			tZt06Ffs.printStackTrace();
		}
	}

}