class n13167991 {
	public void connectToUrl(String L1uTwqUt) {
		message = new StringBuffer("");
		try {
			URL H99V0wnn = new URL(L1uTwqUt);
			try {
				HttpsURLConnection ez1knYRx = (HttpsURLConnection) H99V0wnn.openConnection();
				ez1knYRx.setDoOutput(false);
				ez1knYRx.connect();
				message.append("<BR>\n Connection Code:[" + ez1knYRx.getResponseCode() + "]");
				message.append("<BR>\n Response Message:[" + ez1knYRx.getResponseMessage() + "]");
				InputStreamReader ryPNhXOs = new InputStreamReader(ez1knYRx.getInputStream());
				BufferedReader IU6M16wU = new BufferedReader(ryPNhXOs);
				fullStringBuffer = new StringBuffer("");
				String JZg7tnYf = IU6M16wU.readLine();
				while (JZg7tnYf != null) {
					fullStringBuffer.append(JZg7tnYf);
					JZg7tnYf = IU6M16wU.readLine();
				}
				IU6M16wU.close();
			} catch (IOException prOnN3jD) {
				message.append("<BR>\n [Error][IOException][" + prOnN3jD.getMessage() + "]");
			}
		} catch (MalformedURLException TNjVZQNW) {
			message.append("<BR>\n [Error][MalformedURLException][" + TNjVZQNW.getMessage() + "]");
		} catch (Exception E4bNHFBl) {
			message.append("<BR>\n [Error][Exception][" + E4bNHFBl.getMessage() + "]");
		}
	}

}