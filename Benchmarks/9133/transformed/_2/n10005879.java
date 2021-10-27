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
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				for (; (line = br.readLine()) != null;) {
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