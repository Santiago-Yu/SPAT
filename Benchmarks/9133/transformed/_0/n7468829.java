class n7468829 {
	public static String doGetWithBasicAuthentication(URL XzEPisXW, String VOc7Q0jT, String yqKCnaeh, int Nn9PIlVa,
			Map<String, String> zfj2zJPC) throws Throwable {
		HttpURLConnection zxWxAzUb = (HttpURLConnection) XzEPisXW.openConnection();
		zxWxAzUb.setRequestMethod("GET");
		zxWxAzUb.setDoInput(true);
		if (VOc7Q0jT != null || yqKCnaeh != null) {
			byte[] vheBxmRM = (VOc7Q0jT + ":" + yqKCnaeh).getBytes();
			BASE64Encoder zn64wpR5 = new BASE64Encoder();
			zxWxAzUb.setRequestProperty("Authorization", "Basic " + zn64wpR5.encode(vheBxmRM));
		}
		if (zfj2zJPC != null) {
			for (Map.Entry<String, String> header : zfj2zJPC.entrySet()) {
				zxWxAzUb.setRequestProperty(header.getKey(), header.getValue());
			}
		}
		zxWxAzUb.setConnectTimeout(Nn9PIlVa);
		InputStream HpxmFdp7 = zxWxAzUb.getInputStream();
		BufferedReader lnTNToFp = new BufferedReader(new InputStreamReader(HpxmFdp7));
		String YGf3ssvP;
		StringBuffer CMPgp01Q = new StringBuffer();
		while ((YGf3ssvP = lnTNToFp.readLine()) != null) {
			CMPgp01Q.append(YGf3ssvP);
			CMPgp01Q.append('\n');
		}
		lnTNToFp.close();
		HpxmFdp7.close();
		zxWxAzUb.disconnect();
		return CMPgp01Q.toString();
	}

}