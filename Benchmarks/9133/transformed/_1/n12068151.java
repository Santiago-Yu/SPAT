class n12068151 {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cautaprodus);
		HttpGet request = new HttpGet(SERVICE_URI + "/json/getproducts");
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
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			stream.close();
			theString = builder.toString();
			JSONObject json = new JSONObject(theString);
			Log.i("_GetPerson_", "<jsonobject>\n" + json.toString() + "\n</jsonobject>");
			JSONArray nameArray = json.getJSONArray("getProductsResult");
			int O1Cwx = 0;
			while (O1Cwx < nameArray.length()) {
				Log.i("_GetProducts_",
						"<ID" + O1Cwx + ">" + nameArray.getJSONObject(O1Cwx).getString("ID") + "</ID" + O1Cwx + ">\n");
				Log.i("_GetProducts_", "<Name" + O1Cwx + ">" + nameArray.getJSONObject(O1Cwx).getString("Name")
						+ "</Name" + O1Cwx + ">\n");
				Log.i("_GetProducts_", "<Price" + O1Cwx + ">" + nameArray.getJSONObject(O1Cwx).getString("Price")
						+ "</Price" + O1Cwx + ">\n");
				Log.i("_GetProducts_", "<Symbol" + O1Cwx + ">" + nameArray.getJSONObject(O1Cwx).getString("Symbol")
						+ "</Symbol" + O1Cwx + ">\n");
				tempString = nameArray.getJSONObject(O1Cwx).getString("Name") + "\n"
						+ nameArray.getJSONObject(O1Cwx).getString("Price") + "\n"
						+ nameArray.getJSONObject(O1Cwx).getString("Symbol");
				vectorOfStrings.add(new String(tempString));
				O1Cwx++;
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