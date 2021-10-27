class n9805889 {
	@Override
	public void onClick(View EipYbpgP) {
		username = textusername.getText().toString();
		password = textpassword.getText().toString();
		ArrayList<NameValuePair> IDwXMhq8 = new ArrayList<NameValuePair>();
		IDwXMhq8.add(new name_value("uname", username));
		IDwXMhq8.add(new name_value("upass", password));
		try {
			HttpClient DZ4YuUmz = new DefaultHttpClient();
			HttpPost wsFje5jZ = new HttpPost("http://www.gotrackit.net/server/check_user.php");
			wsFje5jZ.setEntity(new UrlEncodedFormEntity(IDwXMhq8));
			HttpResponse Xl0ueRbI = DZ4YuUmz.execute(wsFje5jZ);
			HttpEntity HkKBwB4g = Xl0ueRbI.getEntity();
			is = HkKBwB4g.getContent();
		} catch (Exception qFh19qF5) {
			Log.e("log_tag", "Error in http connection" + qFh19qF5.toString());
		}
		try {
			BufferedReader e4p9KzyS = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			sb = new StringBuilder();
			sb.append(e4p9KzyS.readLine() + "\n");
			String rOOKfekY = "0";
			while ((rOOKfekY = e4p9KzyS.readLine()) != null) {
				sb.append(rOOKfekY + "\n");
			}
			is.close();
			result = sb.toString();
		} catch (Exception wDIY7K0a) {
			Log.e("log_tag", "Error converting result " + wDIY7K0a.toString());
		}
		if (result.contains("reject")) {
			Context kwzb2ILS = getApplicationContext();
			int iY5GRO0X = Toast.LENGTH_SHORT;
			String qv23TxcG = "Invalid  Username or Password";
			Toast d0DPhsDm = Toast.makeText(kwzb2ILS, qv23TxcG, iY5GRO0X);
			d0DPhsDm.show();
		} else {
			MyApp tyvSzrDu = (MyApp) getApplicationContext();
			tyvSzrDu.setStringValue(result);
			Intent dMDEayk3 = new Intent(EipYbpgP.getContext(), UserMap.class);
			startActivityForResult(dMDEayk3, 0);
		}
	}

}