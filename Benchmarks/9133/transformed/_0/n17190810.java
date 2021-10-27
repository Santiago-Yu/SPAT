class n17190810 {
	static Collection<InetSocketAddress> getAddresses(Context k9hi7TIi, long QXHibDOZ) throws Exception {
		AGLog.d(TAG, "Connecting to HTTP service to obtain IP addresses");
		String ARGPQUQF = (String) k9hi7TIi.getResources().getText(R.string.gg_webservice_addr);
		String KCEkM30g = App.getInstance().getGGClientVersion();
		String Fda7lBoc = ARGPQUQF + "?fmnumber=" + Long.toString(QXHibDOZ) + "&lastmsg=0&version=" + KCEkM30g;
		HttpClient eMJ5VIyt = new DefaultHttpClient();
		AGLog.d(TAG, "connecting to http service at " + Fda7lBoc);
		HttpGet Q6y1FtcC = new HttpGet(Fda7lBoc);
		HttpResponse Fh1o16ZF = eMJ5VIyt.execute(Q6y1FtcC);
		AGLog.d(TAG, "response status:" + Fh1o16ZF.getStatusLine().getReasonPhrase());
		HttpEntity HgnlmGEo = Fh1o16ZF.getEntity();
		if (HgnlmGEo == null) {
			AGLog.e(TAG, "No response entity");
			throw new ClientProtocolException("No response entity");
		}
		InputStream bu5tW5Iz = HgnlmGEo.getContent();
		BufferedReader bdA7fWr5 = new BufferedReader(new InputStreamReader(bu5tW5Iz));
		String u02egl2a = bdA7fWr5.readLine();
		AGLog.d(TAG, "response: " + u02egl2a);
		StringTokenizer ELl31X1x = new StringTokenizer(u02egl2a, " ");
		@SuppressWarnings("unused")
		String pnX98tvI = ELl31X1x.nextToken();
		@SuppressWarnings("unused")
		String maV46Pki = ELl31X1x.nextToken();
		ArrayList<InetSocketAddress> ge2Fo5SO = new ArrayList<InetSocketAddress>();
		while (ELl31X1x.hasMoreTokens()) {
			StringTokenizer jM5W8k5k = new StringTokenizer(ELl31X1x.nextToken(), ":");
			String ElAOGyM1 = jM5W8k5k.nextToken();
			if (InetAddressUtils.isIPv4Address(ElAOGyM1)) {
				AGLog.d(TAG, "Address decoded successfully: " + ElAOGyM1);
			} else {
				AGLog.w(TAG, "Failed to decode address: " + ElAOGyM1);
				continue;
			}
			String s4TPT7su;
			if (jM5W8k5k.hasMoreTokens()) {
				s4TPT7su = jM5W8k5k.nextToken();
			} else {
				s4TPT7su = (String) k9hi7TIi.getResources().getText(R.string.gg_default_port);
			}
			AGLog.d(TAG, "Port decoded successfully: " + s4TPT7su);
			short vwmPCsXS = Short.decode(s4TPT7su);
			ge2Fo5SO.add(new InetSocketAddress(ElAOGyM1, vwmPCsXS));
		}
		return ge2Fo5SO;
	}

}