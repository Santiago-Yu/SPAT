class n22431487 {
	public static String doPost(String oRksWF0Y, List<NameValuePair> ztCdkvZw) {
		try {
			OauthUtil YjwgGYAD = new OauthUtil();
			URI Qvdt8hm3 = new URI(oRksWF0Y);
			HttpClient cUwGy8E1 = YjwgGYAD.getNewHttpClient();
			HttpPost pJhx04Ra = new HttpPost(Qvdt8hm3);
			StringBuffer od2fWIOZ = new StringBuffer();
			od2fWIOZ.append("OAuth");
			for (int LWuhC01N = 0; LWuhC01N < ztCdkvZw.size(); LWuhC01N++) {
				od2fWIOZ.append(" " + ztCdkvZw.get(LWuhC01N).getName());
				od2fWIOZ.append("=\"" + encodeUrl(ztCdkvZw.get(LWuhC01N).getValue()) + "\",");
			}
			String Q7qjzwYd = od2fWIOZ.substring(0, od2fWIOZ.length() - 1);
			pJhx04Ra.addHeader("Authorization", Q7qjzwYd);
			HttpResponse QrZJOzn4 = cUwGy8E1.execute(pJhx04Ra);
			if (QrZJOzn4.getStatusLine().getStatusCode() == 200) {
				String ArnEjcB7 = EntityUtils.toString(QrZJOzn4.getEntity());
				Log.i("DEBUG", "result: " + ArnEjcB7);
				return ArnEjcB7;
			}
		} catch (Exception EBNQdctn) {
			Log.i("DEBUG", EBNQdctn.toString());
		}
		return null;
	}

}