class n19825038 {
	public static byte[] post(String phlpr5cH, Map<String, String> QoL9EIh7, String swMod5dH) throws Exception {
		StringBuilder f8FMBTao = new StringBuilder("");
		if (QoL9EIh7 != null && !QoL9EIh7.isEmpty()) {
			for (Map.Entry<String, String> entry : QoL9EIh7.entrySet()) {
				f8FMBTao.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), swMod5dH))
						.append("&");
			}
			f8FMBTao.deleteCharAt(f8FMBTao.length() - 1);
		}
		byte[] pKtXlp3O = f8FMBTao.toString().getBytes();
		URL gpFaQ1iB = new URL(phlpr5cH);
		HttpURLConnection Ycnsu0ET = (HttpURLConnection) gpFaQ1iB.openConnection();
		Ycnsu0ET.setDoOutput(true);
		Ycnsu0ET.setUseCaches(false);
		Ycnsu0ET.setConnectTimeout(5 * 1000);
		Ycnsu0ET.setRequestMethod("POST");
		Ycnsu0ET.setRequestProperty("Accept",
				"image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
		Ycnsu0ET.setRequestProperty("Accept-Language", "zh-CN");
		Ycnsu0ET.setRequestProperty("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
		Ycnsu0ET.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		Ycnsu0ET.setRequestProperty("Content-Length", String.valueOf(pKtXlp3O.length));
		Ycnsu0ET.setRequestProperty("Connection", "Keep-Alive");
		DataOutputStream MuImJh2X = new DataOutputStream(Ycnsu0ET.getOutputStream());
		MuImJh2X.write(pKtXlp3O);
		MuImJh2X.flush();
		MuImJh2X.close();
		if (Ycnsu0ET.getResponseCode() == 200) {
			return StreamTool.readInputStream(Ycnsu0ET.getInputStream());
		}
		return null;
	}

}