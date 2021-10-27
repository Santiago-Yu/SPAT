class n10005879 {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGetRequest = new HttpGet("http://www.google.com/");
		String line = "", responseString = "";
		try {
			HttpResponse response = client.execute(httpGetRequest);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				while ((line = br.readLine()) != null) {
					responseString += line;
				}
				br.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		tv.setText(responseString);
		setContentView(tv);
	}

}