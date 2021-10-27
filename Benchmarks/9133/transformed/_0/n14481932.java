class n14481932 {
	public static String upload_file(String t6MSN3TQ, String x3fSZvts, String eElLjHOL) {
		String gwqWsoGw = "If you see this message, there is some problem inside the function:upload_file()";
		String tQbzuvEs = x3fSZvts;
		String cDQebIG0 = "https://s2.cloud.cm/rpc/json/?session_id=" + t6MSN3TQ + "&c=Storage&m=upload_file&tag="
				+ eElLjHOL;
		String zwhh8b42 = "\r\n";
		String iFxw7Vq0 = "--";
		String L0aoqJV8 = "******";
		try {
			URL Am6Dm1ih = new URL(cDQebIG0);
			HttpURLConnection Fkq0tpV9 = (HttpURLConnection) Am6Dm1ih.openConnection();
			Fkq0tpV9.setDoInput(true);
			Fkq0tpV9.setDoOutput(true);
			Fkq0tpV9.setUseCaches(false);
			Fkq0tpV9.setRequestMethod("POST");
			Fkq0tpV9.setRequestProperty("Connection", "Keep-Alive");
			Fkq0tpV9.setRequestProperty("Charset", "UTF-8");
			Fkq0tpV9.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + L0aoqJV8);
			DataOutputStream FwH0wwtm = new DataOutputStream(Fkq0tpV9.getOutputStream());
			FwH0wwtm.writeBytes(iFxw7Vq0 + L0aoqJV8 + zwhh8b42);
			FwH0wwtm.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\""
					+ tQbzuvEs.substring(tQbzuvEs.lastIndexOf("/") + 1) + "\"" + zwhh8b42);
			FwH0wwtm.writeBytes(zwhh8b42);
			FileInputStream ABlMxxen = new FileInputStream(tQbzuvEs);
			byte[] sgFlKAjp = new byte[8192];
			int m6jv3ito = 0;
			while ((m6jv3ito = ABlMxxen.read(sgFlKAjp)) != -1) {
				FwH0wwtm.write(sgFlKAjp, 0, m6jv3ito);
			}
			ABlMxxen.close();
			FwH0wwtm.writeBytes(zwhh8b42);
			FwH0wwtm.writeBytes(iFxw7Vq0 + L0aoqJV8 + iFxw7Vq0 + zwhh8b42);
			FwH0wwtm.flush();
			InputStream TEC1Fex8 = Fkq0tpV9.getInputStream();
			InputStreamReader ASjEFcNv = new InputStreamReader(TEC1Fex8, "utf-8");
			BufferedReader cSD8Wiz8 = new BufferedReader(ASjEFcNv);
			gwqWsoGw = cSD8Wiz8.readLine();
			FwH0wwtm.close();
			TEC1Fex8.close();
			return gwqWsoGw;
		} catch (Exception WZGv7qy4) {
			WZGv7qy4.printStackTrace();
		}
		return gwqWsoGw;
	}

}