class n23310397 {
	public void onCreate(Bundle OrKSrPGp) {
		super.onCreate(OrKSrPGp);
		setContentView(R.layout.main);
		mButton1 = (Button) findViewById(R.id.myButton1);
		mButton2 = (Button) findViewById(R.id.myButton2);
		mTextView1 = (TextView) findViewById(R.id.myTextView1);
		mButton1.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View ui4joTrj) {
				String h8ZawLax = "http://www.sina.com";
				HttpPost rItyMdjG = new HttpPost(h8ZawLax);
				List<NameValuePair> tnjZAZlO = new ArrayList<NameValuePair>();
				tnjZAZlO.add(new BasicNameValuePair("str", "post string"));
				try {
					rItyMdjG.setEntity(new UrlEncodedFormEntity(tnjZAZlO, HTTP.UTF_8));
					HttpResponse ad5mur7Q = new DefaultHttpClient().execute(rItyMdjG);
					if (ad5mur7Q.getStatusLine().getStatusCode() == 200) {
						String oKI6C8Km = EntityUtils.toString(ad5mur7Q.getEntity());
						mTextView1.setText(oKI6C8Km);
					} else {
						mTextView1.setText("Error Response: " + ad5mur7Q.getStatusLine().toString());
					}
				} catch (ClientProtocolException RLif5WrY) {
					mTextView1.setText(RLif5WrY.getMessage().toString());
					RLif5WrY.printStackTrace();
				} catch (IOException DjJC0MNm) {
					mTextView1.setText(DjJC0MNm.getMessage().toString());
					DjJC0MNm.printStackTrace();
				} catch (Exception Jh9lAHPo) {
					mTextView1.setText(Jh9lAHPo.getMessage().toString());
					Jh9lAHPo.printStackTrace();
				}
			}
		});
		mButton2.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View N16tMnHL) {
				String iFTCPjOZ = "http://www.sina.com";
				HttpGet TzZIrc0F = new HttpGet(iFTCPjOZ);
				try {
					HttpResponse MGtudmrw = new DefaultHttpClient().execute(TzZIrc0F);
					if (MGtudmrw.getStatusLine().getStatusCode() == 200) {
						String lV6kyF6B = EntityUtils.toString(MGtudmrw.getEntity());
						lV6kyF6B = eregi_replace("(\r\n|\r|\n|\n\r)", "", lV6kyF6B);
						mTextView1.setText(lV6kyF6B);
					} else {
						mTextView1.setText("Error Response: " + MGtudmrw.getStatusLine().toString());
					}
				} catch (ClientProtocolException C84AQ9aQ) {
					mTextView1.setText(C84AQ9aQ.getMessage().toString());
					C84AQ9aQ.printStackTrace();
				} catch (IOException SW2XQnjg) {
					mTextView1.setText(SW2XQnjg.getMessage().toString());
					SW2XQnjg.printStackTrace();
				} catch (Exception JG8NjgLI) {
					mTextView1.setText(JG8NjgLI.getMessage().toString());
					JG8NjgLI.printStackTrace();
				}
			}
		});
	}

}