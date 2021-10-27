class n1768644 {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		try {
			URL url = new URL("https://ajax.googleapis.com/ajax/services/search/news?v=1.0&q=google");
			StringBuilder sb = new StringBuilder();
			String line;
			URLConnection connection = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null)
				sb.append(line);
			JSONObject json = new JSONObject(sb.toString());
			sb.setLength(0);
			JSONObject responseData = (JSONObject) json.get("responseData");
			JSONArray results = (JSONArray) responseData.get("results");
			for (int i = 0; i < results.length(); i++) {
				JSONObject result = (JSONObject) results.get(i);
				sb.append(result.get("title")).append("\n\n");
			}
			TextView tv = (TextView) findViewById(R.id.textView);
			tv.setText(sb.toString());
		} catch (Exception e) {
		}
	}

}