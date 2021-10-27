class n16879559 {
	@Override
	public void onCreate(Bundle w3PmrOnQ) {
		super.onCreate(w3PmrOnQ);
		setContentView(R.layout.main);
		final EditText oEWAL4HV = (EditText) findViewById(R.id.address);
		final Button Y8wXh3ma = (Button) findViewById(R.id.ButtonGo);
		Y8wXh3ma.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View mKmKziEh) {
				try {
					HttpClient kdByrtQn = new DefaultHttpClient();
					HttpPost Fk1MqQRd = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
					List<NameValuePair> GDyqUenE = new ArrayList<NameValuePair>(2);
					GDyqUenE.add(new BasicNameValuePair("m", "login"));
					GDyqUenE.add(new BasicNameValuePair("c", "User"));
					GDyqUenE.add(new BasicNameValuePair("password", "cloudisgreat"));
					GDyqUenE.add(new BasicNameValuePair("alias", "cs588"));
					Fk1MqQRd.setEntity(new UrlEncodedFormEntity(GDyqUenE));
					String d2ppeDx9 = "";
					try {
						HttpResponse LgLA15qk = kdByrtQn.execute(Fk1MqQRd);
						d2ppeDx9 = EntityUtils.toString(LgLA15qk.getEntity());
					} catch (Exception b9bKEmpK) {
						d2ppeDx9 = b9bKEmpK.getMessage();
					}
					LayoutInflater WFcrLlQL = (LayoutInflater) WebTest.this
							.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					final View bEZBGNdv = WFcrLlQL.inflate(R.layout.window1, null);
					final PopupWindow A8XNSJhi = new PopupWindowTest(bEZBGNdv, 100, 100);
					Button bdRcSn6t = (Button) bEZBGNdv.findViewById(R.id.test_button);
					bdRcSn6t.setOnTouchListener(new OnTouchListener() {

						@Override
						public boolean onTouch(View VsB2B5nh, MotionEvent dQl5GWIe) {
							Log.d("Debug", "Button activate");
							A8XNSJhi.dismiss();
							return false;
						}
					});
					A8XNSJhi.showAtLocation(bEZBGNdv, Gravity.CENTER, 0, 0);
					View PrC5e4CQ = WFcrLlQL.inflate(R.layout.window1, null);
					final PopupWindow pbM0Jpx1 = new PopupWindowTest(PrC5e4CQ, 100, 100);
					TextView wOhmeQ7g = (TextView) PrC5e4CQ.findViewById(R.id.pagetext);
					wOhmeQ7g.setText(d2ppeDx9);
					pbM0Jpx1.showAtLocation(bEZBGNdv, Gravity.CENTER, 50, -90);
				} catch (Exception VqN3lP0h) {
					Log.d("Debug", VqN3lP0h.toString());
				}
			}
		});
	}

}