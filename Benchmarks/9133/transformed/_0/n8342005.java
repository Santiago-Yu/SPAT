class n8342005 {
	@Override
	protected String doInBackground(String... AeroLaF6) {
		try {
			URL NPuRPiMV = new URL("http://www.foamsnet.com/smsapi/send.php?username=" + username + "&password="
					+ password + "&to=" + to + "&msg=" + URLEncoder.encode(msg));
			URLConnection CgpWrzh4 = NPuRPiMV.openConnection();
			BufferedReader jIiIev1X = new BufferedReader(new InputStreamReader(CgpWrzh4.getInputStream()));
			String qByV3ME4 = jIiIev1X.readLine();
			qByV3ME4 = qByV3ME4 == null ? "null" : qByV3ME4;
			jIiIev1X.close();
			output = qByV3ME4;
			if (logsent) {
				ContentResolver Pkn2gVf9 = cr;
				ContentValues aJit51vw = new ContentValues();
				aJit51vw.put("address", "+91" + qByV3ME4.split(" ")[3]);
				aJit51vw.put("body", msg);
				Pkn2gVf9.insert(Uri.parse("content://sms/sent"), aJit51vw);
			}
		} catch (Exception kcJ0QwF6) {
			kcJ0QwF6.printStackTrace();
		}
		return null;
	}

}