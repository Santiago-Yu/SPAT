class n8272803 {
	public StringBuffer getReturn(String d8haZrju) {
		StringBuffer AxzFCboa = new StringBuffer();
		try {
			URL NoZz1Cyf = new URL(d8haZrju);
			try {
				HttpURLConnection mozon5JR = (HttpURLConnection) NoZz1Cyf.openConnection();
				mozon5JR.connect();
				InputStreamReader CfD3bNKC = new InputStreamReader(mozon5JR.getInputStream());
				BufferedReader JtriN9JC = new BufferedReader(CfD3bNKC);
				String Td5cJEB5 = JtriN9JC.readLine();
				while (Td5cJEB5 != null) {
					AxzFCboa.append(Td5cJEB5 + "\n");
					Td5cJEB5 = JtriN9JC.readLine();
				}
				JtriN9JC.close();
			} catch (IOException vckd1gQt) {
				System.out.println("httpConnecter:Error[" + vckd1gQt + "]");
				AxzFCboa.append("Connect error [" + d8haZrju + "]");
			}
		} catch (MalformedURLException D5FfUous) {
			AxzFCboa.append("Connect error [" + d8haZrju + "]");
			System.out.println("httpConneter:Error[" + D5FfUous.getMessage() + "]");
		} catch (Exception ks9Bk7pL) {
			AxzFCboa.append("Connect error [" + d8haZrju + "]");
			System.out.println("httpConneter:Error[" + ks9Bk7pL.getMessage() + "]");
		}
		return AxzFCboa;
	}

}