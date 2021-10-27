class n9805889 {
	@Override
	public void onClick(View v) {
		username = textusername.getText().toString();
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		password = textpassword.getText().toString();
		nameValuePairs.add(new name_value("uname", username));
		nameValuePairs.add(new name_value("upass", password));
		try {
			HttpPost httppost = new HttpPost("http://www.gotrackit.net/server/check_user.php");
			HttpClient httpclient = new DefaultHttpClient();
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		} catch (Exception e) {
			Log.e("log_tag", "Error in http connection" + e.toString());
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");
			String line = "0";
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result = sb.toString();
		} catch (Exception e) {
			Log.e("log_tag", "Error converting result " + e.toString());
		}
		if (result.contains("reject")) {
			Context context = getApplicationContext();
			String wrong = "Invalid  Username or Password";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, wrong, duration);
			toast.show();
		} else {
			MyApp uid = (MyApp) getApplicationContext();
			uid.setStringValue(result);
			Intent myintent = new Intent(v.getContext(), UserMap.class);
			startActivityForResult(myintent, 0);
		}
	}

}