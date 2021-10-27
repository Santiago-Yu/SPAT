class n6829523 {
	public String getHtmlCode(String YSwxpdIP) {
		StringBuffer pOSLD5jL = new StringBuffer();
		BufferedReader D7GXbf54 = null;
		try {
			URL JxFjcidq = new URL((YSwxpdIP));
			URLConnection ZFa9l8ib = JxFjcidq.openConnection();
			D7GXbf54 = new BufferedReader(new InputStreamReader(ZFa9l8ib.getInputStream(), "ISO-8859-1"));
			String VKfE2IVG = null;
			while ((VKfE2IVG = D7GXbf54.readLine()) != null) {
				pOSLD5jL.append(VKfE2IVG + "\r\n");
			}
			D7GXbf54.close();
		} catch (MalformedURLException a6v3lqr2) {
			System.out.println("Unable to connect to URL: " + YSwxpdIP);
		} catch (IOException P6QX43li) {
			System.out.println("IOException when connecting to URL: " + YSwxpdIP);
		} finally {
			if (D7GXbf54 != null) {
				try {
					D7GXbf54.close();
				} catch (Exception qrHE3wBM) {
					System.out.println("Exception throws at finally close reader when connecting to URL: " + YSwxpdIP);
				}
			}
		}
		return pOSLD5jL.toString();
	}

}