class n21760015 {
	public static String httpUrlConnection_post(String NxpnifPW, String nIXFiQOQ) {
		System.out.println("httpUrlConnection_post");
		URL HWsXBpuw;
		HttpURLConnection uiv6EDMS = null;
		try {
			HWsXBpuw = new URL(NxpnifPW);
			uiv6EDMS = (HttpURLConnection) HWsXBpuw.openConnection();
			uiv6EDMS.setRequestMethod("POST");
			uiv6EDMS.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			uiv6EDMS.setRequestProperty("Content-Length", "" + Integer.toString(nIXFiQOQ.getBytes().length));
			uiv6EDMS.setRequestProperty("Content-Language", "en-US");
			uiv6EDMS.setUseCaches(false);
			uiv6EDMS.setConnectTimeout(5000);
			uiv6EDMS.setReadTimeout(5000);
			uiv6EDMS.setDoInput(true);
			uiv6EDMS.setDoOutput(true);
			DataOutputStream jvpJmtlF = new DataOutputStream(uiv6EDMS.getOutputStream());
			jvpJmtlF.writeBytes(nIXFiQOQ);
			jvpJmtlF.flush();
			jvpJmtlF.close();
			InputStream HH59lbek = uiv6EDMS.getInputStream();
			BufferedReader krUzsmyw = new BufferedReader(new InputStreamReader(HH59lbek));
			String CrERCicT;
			StringBuilder kKJujrpN = new StringBuilder();
			while ((CrERCicT = krUzsmyw.readLine()) != null) {
				kKJujrpN.append(CrERCicT);
				kKJujrpN.append('\r');
			}
			krUzsmyw.close();
			return kKJujrpN.toString();
		} catch (Exception YPIx5USv) {
			System.out.print(YPIx5USv);
			return null;
		} finally {
			if (uiv6EDMS != null) {
				uiv6EDMS.disconnect();
			}
		}
	}

}