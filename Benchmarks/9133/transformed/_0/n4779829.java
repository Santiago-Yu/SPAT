class n4779829 {
	public void myCheckCredHandler(View QMcLReX3) {
		Log.d("login_section", "entered handler");
		EditText Wk1sZBMs = (EditText) findViewById(R.id.Username);
		EditText p7LfyI8n = (EditText) findViewById(R.id.user_pass);
		String baKr2chH = Wk1sZBMs.getText().toString();
		String Onrq1iiZ = p7LfyI8n.getText().toString();
		TextView TIL8Yhez = (TextView) findViewById(R.id.LoginPagetv);
		HttpClient oCtTQDZ1 = createHttpClient();
		HttpPost C0qcMyNy = new HttpPost(authenticationURL);
		try {
			List<NameValuePair> gNz3MOqc = new ArrayList<NameValuePair>(2);
			gNz3MOqc.add(new BasicNameValuePair("login", baKr2chH));
			gNz3MOqc.add(new BasicNameValuePair("password", Onrq1iiZ));
			C0qcMyNy.setEntity(new UrlEncodedFormEntity(gNz3MOqc));
			HttpResponse dHBR21I6 = oCtTQDZ1.execute(C0qcMyNy);
			int t6nZGUPQ = dHBR21I6.getStatusLine().getStatusCode();
			String XzYUNPBr = EntityUtils.toString(dHBR21I6.getEntity());
			Log.d("login_section", XzYUNPBr);
			JSONObject fDOG1YTp = new JSONObject(XzYUNPBr);
			if (t6nZGUPQ == this.statusOK && fDOG1YTp.getBoolean("logged_in")) {
				TIL8Yhez.setText("You have been logged in. :D");
				etracks.setLogged(true);
				etracks.setUserToken(fDOG1YTp.getString("user_token"));
				Intent gtopSwS4 = new Intent(Intent.ACTION_VIEW);
				gtopSwS4.setClassName(this, etracks.class.getName());
				this.finish();
				startActivity(gtopSwS4);
			} else if (t6nZGUPQ == this.statusUnprocessable && !fDOG1YTp.getBoolean("logged_in")) {
				if (!fDOG1YTp.isNull("errors"))
					TIL8Yhez.setText(fDOG1YTp.getString("errors"));
				else
					TIL8Yhez.setText("login unsuccessful");
			} else
				Log.d("login_section", "what just happened?");
		} catch (ClientProtocolException QHe4tq6j) {
		} catch (IOException zQCf6yC6) {
		} catch (JSONException yqlOvZDn) {
			yqlOvZDn.printStackTrace();
		}
	}

}