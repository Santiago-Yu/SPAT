class n3541458 {
	public static String post(String TcbtqhNN, String GeTscAJ0) {
		NoMuleRuntime.showDebug("POST : " + TcbtqhNN + "(" + GeTscAJ0 + ")");
		try {
			URL zPgh4f2U = new URL(TcbtqhNN);
			HttpURLConnection Ud1DHWzR = (HttpURLConnection) zPgh4f2U.openConnection();
			Ud1DHWzR.setRequestMethod("POST");
			Ud1DHWzR.setDoInput(true);
			Ud1DHWzR.setDoOutput(true);
			Ud1DHWzR.setUseCaches(true);
			Ud1DHWzR.setAllowUserInteraction(true);
			HttpURLConnection.setFollowRedirects(true);
			Ud1DHWzR.setInstanceFollowRedirects(true);
			Ud1DHWzR.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			DataOutputStream ymbdqntm = new DataOutputStream(Ud1DHWzR.getOutputStream());
			ymbdqntm.writeBytes(GeTscAJ0);
			ymbdqntm.flush();
			ymbdqntm.close();
			BufferedReader UXbFxwh3 = new BufferedReader(new InputStreamReader(Ud1DHWzR.getInputStream()));
			String xZ87Ugjw = "";
			StringBuffer WP9yCUrL = new StringBuffer();
			while ((xZ87Ugjw = UXbFxwh3.readLine()) != null) {
				WP9yCUrL.append(xZ87Ugjw);
			}
			UXbFxwh3.close();
			return WP9yCUrL.toString();
		} catch (MalformedURLException EV2sLZgK) {
			NoMuleRuntime.showError("Internal Error. Malformed URL.");
			EV2sLZgK.printStackTrace();
		} catch (IOException JXgf5opY) {
			System.out.println("Internal I/O Error.");
			JXgf5opY.printStackTrace();
		}
		return "";
	}

}