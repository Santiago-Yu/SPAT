class n22842673 {
	private Map fetchAdData(String xNbmvynL) throws ClientProtocolException, IOException {
		String xC0j4zvO = "1";
		String YpObBEFf = "tx";
		String T7Zx3DXw = "";
		String jicCLiQS = "ad1.0";
		String c4JzQ9Tb = "txLove1.0";
		String aXhLDNGD = String.valueOf(System.currentTimeMillis());
		String PZKH6mu6 = "";
		String FMQtdtQK = "test";
		Map<String, String> D670M3za = new HashMap<String, String>();
		D670M3za.put(AuthUtils.AUTH_APP, xC0j4zvO);
		D670M3za.put(AuthUtils.AUTH_OWNER, YpObBEFf);
		D670M3za.put(AuthUtils.AUTH_SESSION, T7Zx3DXw);
		D670M3za.put(AuthUtils.SDK, jicCLiQS);
		D670M3za.put(AuthUtils.VERSION, c4JzQ9Tb);
		D670M3za.put(AuthUtils.TIMESTAMP, aXhLDNGD);
		Map<String, String> SUH0klcg = new HashMap<String, String>();
		SUH0klcg.put("uid", String.valueOf(user.getUserId()));
		SUH0klcg.put("ip", "0");
		SUH0klcg.put("imsi", imsi);
		SUH0klcg.put("width", "0");
		PZKH6mu6 = AuthUtils.sign(D670M3za, SUH0klcg, FMQtdtQK);
		HttpClient d0xn6kgu = new DefaultHttpClient();
		HttpGet DQJrBaVu = new HttpGet(xNbmvynL.toString());
		DQJrBaVu.setHeader(AuthUtils.AUTH_APP, xC0j4zvO);
		DQJrBaVu.setHeader(AuthUtils.AUTH_OWNER, YpObBEFf);
		DQJrBaVu.setHeader(AuthUtils.AUTH_SESSION, T7Zx3DXw);
		DQJrBaVu.setHeader(AuthUtils.SDK, jicCLiQS);
		DQJrBaVu.setHeader(AuthUtils.VERSION, c4JzQ9Tb);
		DQJrBaVu.setHeader(AuthUtils.TIMESTAMP, aXhLDNGD);
		DQJrBaVu.setHeader(AuthUtils.SIGN, PZKH6mu6);
		HttpResponse Sie5TCdi = d0xn6kgu.execute(DQJrBaVu);
		if (Sie5TCdi.getStatusLine().getStatusCode() == 200) {
			BufferedReader TgxHPruM = new BufferedReader(new InputStreamReader(Sie5TCdi.getEntity().getContent()));
			String GRIKrT9E = TgxHPruM.readLine();
			JSONObject sjvGliec;
			Map AZdu5fAT = new HashMap();
			try {
				System.out.println("##################### line = " + GRIKrT9E);
				sjvGliec = new JSONObject(GRIKrT9E);
				if (sjvGliec != null) {
					System.out.println(sjvGliec.toString());
					AZdu5fAT.put("imgAddress", sjvGliec.getString("imgurl"));
					AZdu5fAT.put("imgUrl", sjvGliec.getString("url"));
					return AZdu5fAT;
				}
			} catch (JSONException kvu7aaHI) {
				kvu7aaHI.printStackTrace();
			}
		}
		return null;
	}

}