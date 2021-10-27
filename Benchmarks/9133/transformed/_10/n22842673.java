class n22842673 {
	private Map fetchAdData(String url) throws ClientProtocolException, IOException {
		String app = "1";
		String owner = "tx";
		String session = "";
		String sdk = "ad1.0";
		String version = "txLove1.0";
		String timestamp = String.valueOf(System.currentTimeMillis());
		String sign = "";
		String appSecret = "test";
		Map<String, String> protocal = new HashMap<String, String>();
		protocal.put(AuthUtils.AUTH_APP, app);
		protocal.put(AuthUtils.AUTH_OWNER, owner);
		protocal.put(AuthUtils.AUTH_SESSION, session);
		protocal.put(AuthUtils.SDK, sdk);
		protocal.put(AuthUtils.VERSION, version);
		protocal.put(AuthUtils.TIMESTAMP, timestamp);
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("uid", String.valueOf(user.getUserId()));
		parameter.put("ip", "0");
		parameter.put("imsi", imsi);
		parameter.put("width", "0");
		HttpClient client = new DefaultHttpClient();
		sign = AuthUtils.sign(protocal, parameter, appSecret);
		HttpGet request = new HttpGet(url.toString());
		request.setHeader(AuthUtils.AUTH_APP, app);
		request.setHeader(AuthUtils.AUTH_OWNER, owner);
		request.setHeader(AuthUtils.AUTH_SESSION, session);
		request.setHeader(AuthUtils.SDK, sdk);
		request.setHeader(AuthUtils.VERSION, version);
		request.setHeader(AuthUtils.TIMESTAMP, timestamp);
		request.setHeader(AuthUtils.SIGN, sign);
		HttpResponse response = client.execute(request);
		if (response.getStatusLine().getStatusCode() == 200) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			JSONObject object;
			String line = reader.readLine();
			Map map = new HashMap();
			try {
				System.out.println("##################### line = " + line);
				object = new JSONObject(line);
				if (object != null) {
					System.out.println(object.toString());
					map.put("imgAddress", object.getString("imgurl"));
					map.put("imgUrl", object.getString("url"));
					return map;
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}