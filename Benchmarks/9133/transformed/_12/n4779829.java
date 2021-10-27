class n4779829 {
	public void myCheckCredHandler(View v) {
		Log.d("login_section", "entered handler");
		EditText Username = (EditText) findViewById(R.id.Username);
		EditText Password = (EditText) findViewById(R.id.user_pass);
		String username_S = Username.getText().toString(), pass_S = Password.getText().toString();
		TextView ltv = (TextView) findViewById(R.id.LoginPagetv);
		HttpClient httpclient = createHttpClient();
		HttpPost httppost = new HttpPost(authenticationURL);
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("login", username_S));
			nameValuePairs.add(new BasicNameValuePair("password", pass_S));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			int status = response.getStatusLine().getStatusCode();
			String responseBody = EntityUtils.toString(response.getEntity());
			Log.d("login_section", responseBody);
			JSONObject jsonObject = new JSONObject(responseBody);
			if (status == this.statusOK && jsonObject.getBoolean("logged_in")) {
				ltv.setText("You have been logged in. :D");
				etracks.setLogged(true);
				etracks.setUserToken(jsonObject.getString("user_token"));
				Intent it = new Intent(Intent.ACTION_VIEW);
				it.setClassName(this, etracks.class.getName());
				this.finish();
				startActivity(it);
			} else if (status == this.statusUnprocessable && !jsonObject.getBoolean("logged_in")) {
				if (!jsonObject.isNull("errors"))
					ltv.setText(jsonObject.getString("errors"));
				else
					ltv.setText("login unsuccessful");
			} else
				Log.d("login_section", "what just happened?");
		} catch (ClientProtocolException e) {
		} catch (IOException e) {
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}