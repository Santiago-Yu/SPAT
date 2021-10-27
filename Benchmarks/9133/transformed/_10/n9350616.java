class n9350616 {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		HttpGet request = new HttpGet(SERVICE_URI + "/json/getallpersons");
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
		String theString = new String("");
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			HttpResponse response = httpClient.execute(request);
			HttpEntity responseEntity = response.getEntity();
			InputStream stream = responseEntity.getContent();
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			stream.close();
			theString = builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Toast.makeText(this, theString + "\n", Toast.LENGTH_LONG).show();
	}

}