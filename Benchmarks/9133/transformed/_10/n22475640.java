class n22475640 {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mTextView = (TextView) findViewById(R.id.textView001);
		mButton = (Button) findViewById(R.id.Button001);
		tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
		mButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				GsmCellLocation gcl = (GsmCellLocation) tm.getCellLocation();
				int cid = gcl.getCid();
				int lac = gcl.getLac();
				int mcc = Integer.valueOf(tm.getNetworkOperator().substring(0, 3));
				int mnc = Integer.valueOf(tm.getNetworkOperator().substring(3, 5));
				try {
					JSONObject holder = new JSONObject();
					holder.put("version", "1.1.0");
					holder.put("host", "maps.google.com");
					holder.put("request_address", true);
					JSONObject data = new JSONObject();
					JSONArray array = new JSONArray();
					data.put("cell_id", cid);
					data.put("location_area_code", lac);
					data.put("mobile_country_code", mcc);
					data.put("mobile_network_code", mnc);
					array.put(data);
					holder.put("cell_towers", array);
					HttpPost post = new HttpPost("http://www.google.com/loc/json");
					DefaultHttpClient client = new DefaultHttpClient();
					StringEntity se = new StringEntity(holder.toString());
					post.setEntity(se);
					HttpResponse resp = client.execute(post);
					HttpEntity entity = resp.getEntity();
					StringBuffer sb = new StringBuffer();
					BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
					String result = br.readLine();
					while (result != null) {
						sb.append(result);
						result = br.readLine();
					}
					JSONObject jsonObject = new JSONObject(sb.toString());
					JSONObject jsonObject1 = new JSONObject(jsonObject.getString("location"));
					getAddress(jsonObject1.getString("latitude"), jsonObject1.getString("longitude"));
				} catch (Exception e) {
				}
			}
		});
	}

}