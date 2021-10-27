class n6853666 {
	public static void sendPostRequest() {
		String YnU1K618 = "text=Eschirichia coli";
		try {
			URL Cuc63Xsa = new URL("http://taxonfinder.ubio.org/analyze?");
			URLConnection I8aNkDPq = Cuc63Xsa.openConnection();
			I8aNkDPq.setDoOutput(true);
			OutputStreamWriter kE8GP8CE = new OutputStreamWriter(I8aNkDPq.getOutputStream());
			kE8GP8CE.write(YnU1K618);
			kE8GP8CE.flush();
			StringBuffer WxE7nB6W = new StringBuffer();
			BufferedReader ojNcwBon = new BufferedReader(new InputStreamReader(I8aNkDPq.getInputStream()));
			String iRGriDb0;
			while ((iRGriDb0 = ojNcwBon.readLine()) != null) {
				WxE7nB6W.append(iRGriDb0);
			}
			kE8GP8CE.close();
			ojNcwBon.close();
			System.out.println(WxE7nB6W.toString());
		} catch (MalformedURLException l6mTzehB) {
			l6mTzehB.printStackTrace();
		} catch (IOException RGtbcCJE) {
			RGtbcCJE.printStackTrace();
		}
	}

}