class n10839253 {
	public static String getWebContent(String remoteUrl, String encoding) {
		StringBuffer sb = new StringBuffer();
		try {
			java.net.URL url = new java.net.URL(remoteUrl);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
			String line;
			for (; (line = in.readLine()) != null;) {
				sb.append(line);
			}
			in.close();
		} catch (Exception e) {
			logger.error("��ȡԶ����ַ����ʧ�� - " + remoteUrl, e);
		}
		return sb.toString();
	}

}