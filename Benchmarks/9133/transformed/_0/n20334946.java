class n20334946 {
	public static String doPost(String h54iOfhg, String YxvFbbqi) {
		if (YxvFbbqi == null) {
			YxvFbbqi = "";
		}
		try {
			URLConnection xAUa2h3u = new URL(h54iOfhg).openConnection();
			xAUa2h3u.setDoInput(true);
			xAUa2h3u.setDoOutput(true);
			xAUa2h3u.setUseCaches(false);
			xAUa2h3u.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			DataOutputStream xE9vf6LF = new DataOutputStream(xAUa2h3u.getOutputStream());
			xE9vf6LF.writeBytes(YxvFbbqi);
			xE9vf6LF.flush();
			xE9vf6LF.close();
			BufferedReader MMKGVGa7 = new BufferedReader(new InputStreamReader(xAUa2h3u.getInputStream()));
			String rwZDr0wl;
			StringBuffer ZMqAhjQp = new StringBuffer();
			while ((rwZDr0wl = MMKGVGa7.readLine()) != null) {
				ZMqAhjQp.append(rwZDr0wl);
				ZMqAhjQp.append("\n");
			}
			return ZMqAhjQp.toString();
		} catch (IOException OP3b0nrg) {
			;
		} catch (ClassCastException j3vJUhxc) {
			j3vJUhxc.printStackTrace();
		}
		return null;
	}

}