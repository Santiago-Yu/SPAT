class n19477334 {
	public String postData(String Ae550Lhs, List<NameValuePair> omQhs9s5) {
		HttpClient elJpGPs1 = new DefaultHttpClient();
		HttpPost lilodasG = new HttpPost(Ae550Lhs);
		StringBuilder GEdcL9jn = new StringBuilder();
		try {
			lilodasG.setEntity(new UrlEncodedFormEntity(omQhs9s5));
			HttpResponse cw4QfLYH = elJpGPs1.execute(lilodasG);
			Header[] TUBOX3t7 = cw4QfLYH.getAllHeaders();
			for (int EBXF2Zty = 0; EBXF2Zty < TUBOX3t7.length; EBXF2Zty++) {
				Log.i(TAG, "HEADER: " + TUBOX3t7[EBXF2Zty].getName() + " - " + TUBOX3t7[EBXF2Zty].getValue());
			}
			InputStream dIEZkMqr = cw4QfLYH.getEntity().getContent();
			BufferedReader GGUzC5ZF = new BufferedReader(new InputStreamReader(dIEZkMqr));
			String FXdn6xgN = "";
			while ((FXdn6xgN = GGUzC5ZF.readLine()) != null) {
				System.out.println("Parsing line... " + FXdn6xgN);
				GEdcL9jn.append(FXdn6xgN);
				if (FXdn6xgN.contains("<html xmlns:fn")) {
					String EMbIOGkt = FXdn6xgN.substring(FXdn6xgN.indexOf("GLN:") + 165,
							FXdn6xgN.indexOf("GLN:") + 176);
					Log.i(TAG, "OUT: " + EMbIOGkt);
					break;
				}
			}
			Log.i(TAG, "Post Communication OK");
		} catch (ClientProtocolException iWoyx3nd) {
			Log.e(TAG, "ClientProtocolException ", iWoyx3nd);
		} catch (IOException sMI9chJ3) {
			Log.e(TAG, "HTTP Not Available", sMI9chJ3);
		}
		return GEdcL9jn.toString();
	}

}