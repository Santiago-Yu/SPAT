class n10005879 {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		TextView tv = new TextView(this);
		super.onCreate(savedInstanceState);
		HttpGet httpGetRequest = new HttpGet("http://www.google.com/");
		HttpClient client = new DefaultHttpClient();
		String line = "", responseString = "";
		try {
			HttpResponse response = client.execute(httpGetRequest);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
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