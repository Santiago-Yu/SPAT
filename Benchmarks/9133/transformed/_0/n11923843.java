class n11923843 {
	public String getLastVersion() {
		try {
			String TVpg3z4A = icescrum2Properties.get("check.url").toString();
			Boolean ZLR2QaCV = new Boolean(icescrum2Properties.get("proxy.active").toString());
			Boolean ZQOSQKop = new Boolean(icescrum2Properties.get("proxy.auth.active").toString());
			URL RnQWZ0au = new URL(TVpg3z4A);
			if (ZLR2QaCV) {
				String cgQWfTGb = icescrum2Properties.get("proxy.url").toString();
				String rHHkRc3z = icescrum2Properties.get("proxy.port").toString();
				Properties rthypkU8 = System.getProperties();
				rthypkU8.setProperty("http.proxyHost", cgQWfTGb);
				rthypkU8.setProperty("http.proxyPort", rHHkRc3z);
			}
			URLConnection e5hRSoYP = RnQWZ0au.openConnection();
			if (ZQOSQKop) {
				String KkC1w179 = icescrum2Properties.get("proxy.auth.username").toString();
				String bi8NBA0x = icescrum2Properties.get("proxy.auth.password").toString();
				String Ohb9oRtW = KkC1w179 + ":" + bi8NBA0x;
				String EvqoU2iY = Base64.base64Encode(Ohb9oRtW);
				e5hRSoYP.setRequestProperty("Proxy-Authorization", "Basic " + EvqoU2iY);
			}
			e5hRSoYP.setConnectTimeout(Integer.parseInt(icescrum2Properties.get("check.timeout").toString()));
			InputStream S6s1WlkY = e5hRSoYP.getInputStream();
			StringWriter YHCRfLDl = new StringWriter();
			InputStreamReader m0O7CFty = new InputStreamReader(S6s1WlkY);
			BufferedReader I2RsmShz = new BufferedReader(m0O7CFty);
			String UC5hEwOm = "";
			while (null != (UC5hEwOm = I2RsmShz.readLine())) {
				YHCRfLDl.write(UC5hEwOm);
			}
			return YHCRfLDl.toString();
		} catch (IOException imn9Dl1a) {
		}
		return null;
	}

}