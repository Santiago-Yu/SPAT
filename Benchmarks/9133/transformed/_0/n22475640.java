class n22475640 {
	@Override
	public void onCreate(Bundle xJrCXIhU) {
		super.onCreate(xJrCXIhU);
		setContentView(R.layout.main);
		mTextView = (TextView) findViewById(R.id.textView001);
		mButton = (Button) findViewById(R.id.Button001);
		tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
		mButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View KGEpJbi7) {
				GsmCellLocation FhaFvx28 = (GsmCellLocation) tm.getCellLocation();
				int tjSjeQv7 = FhaFvx28.getCid();
				int xBMgvw0a = FhaFvx28.getLac();
				int etl2OI2m = Integer.valueOf(tm.getNetworkOperator().substring(0, 3));
				int qjW3gwX6 = Integer.valueOf(tm.getNetworkOperator().substring(3, 5));
				try {
					JSONObject dElYw2vX = new JSONObject();
					dElYw2vX.put("version", "1.1.0");
					dElYw2vX.put("host", "maps.google.com");
					dElYw2vX.put("request_address", true);
					JSONArray gYow41sz = new JSONArray();
					JSONObject bf5L0UPK = new JSONObject();
					bf5L0UPK.put("cell_id", tjSjeQv7);
					bf5L0UPK.put("location_area_code", xBMgvw0a);
					bf5L0UPK.put("mobile_country_code", etl2OI2m);
					bf5L0UPK.put("mobile_network_code", qjW3gwX6);
					gYow41sz.put(bf5L0UPK);
					dElYw2vX.put("cell_towers", gYow41sz);
					DefaultHttpClient LFZZevYq = new DefaultHttpClient();
					HttpPost L13KTspB = new HttpPost("http://www.google.com/loc/json");
					StringEntity NajHqpaG = new StringEntity(dElYw2vX.toString());
					L13KTspB.setEntity(NajHqpaG);
					HttpResponse V9pEKeMW = LFZZevYq.execute(L13KTspB);
					HttpEntity gXJJ2NPv = V9pEKeMW.getEntity();
					BufferedReader nljfVGyI = new BufferedReader(new InputStreamReader(gXJJ2NPv.getContent()));
					StringBuffer mrJHuKmn = new StringBuffer();
					String OCBOj5Ly = nljfVGyI.readLine();
					while (OCBOj5Ly != null) {
						mrJHuKmn.append(OCBOj5Ly);
						OCBOj5Ly = nljfVGyI.readLine();
					}
					JSONObject k9sMBCDB = new JSONObject(mrJHuKmn.toString());
					JSONObject eUOH1V2M = new JSONObject(k9sMBCDB.getString("location"));
					getAddress(eUOH1V2M.getString("latitude"), eUOH1V2M.getString("longitude"));
				} catch (Exception EXlmWnC9) {
				}
			}
		});
	}

}