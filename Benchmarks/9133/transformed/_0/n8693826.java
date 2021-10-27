class n8693826 {
	private String readJsonString() {
		StringBuilder JtWwRYpy = new StringBuilder();
		HttpClient SfHsahBK = new DefaultHttpClient();
		HttpGet SiufjDQt = new HttpGet(SERVER_URL);
		try {
			HttpResponse iuurmPCN = SfHsahBK.execute(SiufjDQt);
			StatusLine wXzuiCVM = iuurmPCN.getStatusLine();
			int XT4mZvJ6 = wXzuiCVM.getStatusCode();
			if (XT4mZvJ6 == 200) {
				HttpEntity h3ioZrIg = iuurmPCN.getEntity();
				InputStream NEQKebHp = h3ioZrIg.getContent();
				BufferedReader s6AXPc9G = new BufferedReader(new InputStreamReader(NEQKebHp));
				String IFKRxsUV;
				while ((IFKRxsUV = s6AXPc9G.readLine()) != null) {
					JtWwRYpy.append(IFKRxsUV);
				}
			} else {
				Log.e(TAG, "Failed to download file");
			}
		} catch (ClientProtocolException i4RvJV2W) {
			i4RvJV2W.printStackTrace();
		} catch (IOException AloJdUbV) {
			AloJdUbV.printStackTrace();
		}
		return JtWwRYpy.toString();
	}

}