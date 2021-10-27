class n7910536 {
	public static ContextInfo login(Context uBSLx4sW, String axZ22tff, String V0UZoPZ0, String goEQfTtM) {
		HttpClient H6lKbLoo = new DefaultHttpClient();
		StringBuilder cEmr8H58 = new StringBuilder();
		ContextInfo RFhwAeiH = null;
		HttpPost N1bPABCx = new HttpPost(
				new StringBuilder().append("http://").append(LoginActivity.mIpAddress.getText().toString())
						.append("/ZJWHServiceTest/GIS_Duty.asmx/PDALoginCheck").toString());
		List<NameValuePair> R57Wdmo0 = new ArrayList<NameValuePair>(2);
		R57Wdmo0.add(new BasicNameValuePair("username", axZ22tff));
		R57Wdmo0.add(new BasicNameValuePair("password", V0UZoPZ0));
		R57Wdmo0.add(new BasicNameValuePair("deviceid", goEQfTtM));
		try {
			N1bPABCx.setEntity(new UrlEncodedFormEntity(R57Wdmo0));
			HttpResponse AML8UHbd = H6lKbLoo.execute(N1bPABCx);
			BufferedReader F36fTeAu = new BufferedReader(new InputStreamReader(AML8UHbd.getEntity().getContent()));
			for (String jZwxu41C = F36fTeAu.readLine(); jZwxu41C != null; jZwxu41C = F36fTeAu.readLine()) {
				cEmr8H58.append(jZwxu41C);
			}
			String Eqq2MLeQ = cEmr8H58.toString();
			Eqq2MLeQ = DataParseUtil.handleResponse(Eqq2MLeQ);
			RFhwAeiH = LoginParseUtil.onlineParse(Eqq2MLeQ);
			RFhwAeiH.setDeviceid(goEQfTtM);
			if (0 == RFhwAeiH.getLoginFlag()) {
				RFhwAeiH.setLoginFlag(0);
			} else if (1 == RFhwAeiH.getLoginFlag()) {
				RFhwAeiH.setLoginFlag(1);
				updateUserInfo(uBSLx4sW, RFhwAeiH);
			} else if (2 == RFhwAeiH.getLoginFlag()) {
				RFhwAeiH.setLoginFlag(2);
			} else if (3 == RFhwAeiH.getLoginFlag()) {
				RFhwAeiH.setLoginFlag(3);
			}
		} catch (Exception b3dvCx2N) {
			return RFhwAeiH;
		}
		return RFhwAeiH;
	}

}