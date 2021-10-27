class n3803023 {
	public static String callApi(String TBnrzvjh, String sgHWhuOo, String W7U5W4Eh) {
		String YXyrWmGq = SSOFilter.getLoginapp();
		String gAmqCRga = SSOUtil.addParameter(YXyrWmGq + "/api/" + TBnrzvjh, sgHWhuOo, W7U5W4Eh);
		gAmqCRga = SSOUtil.addParameter(gAmqCRga, "servicekey", SSOFilter.getServicekey());
		String KTr1u2T6 = "error";
		try {
			URL bWq6zG3v = new URL(gAmqCRga);
			BufferedReader kCZq5Hw5 = new BufferedReader(new InputStreamReader(bWq6zG3v.openStream()));
			String Tp5GIBDL;
			while ((Tp5GIBDL = kCZq5Hw5.readLine()) != null) {
				KTr1u2T6 = Tp5GIBDL.trim();
			}
			kCZq5Hw5.close();
		} catch (MalformedURLException QdGPZpeU) {
		} catch (IOException LlrTcis3) {
		}
		if ("error".equals(KTr1u2T6)) {
			return "error";
		} else {
			return KTr1u2T6;
		}
	}

}