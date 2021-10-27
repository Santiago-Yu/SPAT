class n8107001 {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		HttpGet request = new HttpGet(SERVICE_URI + "/json/getroutes/1");
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String theString = new String("");
		try {
			HttpResponse response = httpClient.execute(request);
			HttpEntity responseEntity = response.getEntity();
			InputStream stream = responseEntity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			Vector<String> vectorOfStrings = new Vector<String>();
			String tempString = new String();
			String tempStringAgent = new String();
			String tempStringClient = new String();
			String tempStringRoute = new String();
			String tempStringZone = new String();
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			stream.close();
			theString = builder.toString();
			JSONObject json = new JSONObject(theString);
			Log.i("_GetClient_", "<jsonobject>\n" + json.toString() + "\n</jsonobject>");
			this.dm = new DataManipulator(this);
			JSONArray nameArray = json.getJSONArray("GetRoutesByAgentResult");
			int ko24j = 0;
			while (ko24j < nameArray.length()) {
				tempStringAgent = nameArray.getJSONObject(ko24j).getString("Agent");
				tempStringClient = nameArray.getJSONObject(ko24j).getString("Client");
				tempStringRoute = nameArray.getJSONObject(ko24j).getString("Route");
				tempStringZone = nameArray.getJSONObject(ko24j).getString("Zone");
				Log.i("_GetClient_", "<Agent" + ko24j + ">" + tempStringAgent + "</Agent" + ko24j + ">\n");
				Log.i("_GetClient_", "<Client" + ko24j + ">" + tempStringClient + "</Client" + ko24j + ">\n");
				Log.i("_GetClient_", "<Route" + ko24j + ">" + tempStringRoute + "</Route" + ko24j + ">\n");
				Log.i("_GetClient_", "<Zone" + ko24j + ">" + tempStringZone + "</Zone" + ko24j + ">\n");
				tempString = nameArray.getJSONObject(ko24j).getString("Client") + "\n"
						+ nameArray.getJSONObject(ko24j).getString("Route") + "\n"
						+ nameArray.getJSONObject(ko24j).getString("Zone");
				vectorOfStrings.add(new String(tempString));
				ko24j++;
			}
			int orderCount = vectorOfStrings.size();
			String[] orderTimeStamps = new String[orderCount];
			vectorOfStrings.copyInto(orderTimeStamps);
			setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, orderTimeStamps));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}