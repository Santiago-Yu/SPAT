class n4898682 {
	public void run() {
		try {
			String qhr6rkGN = (new StringBuilder()).append("fName=").append(URLEncoder.encode("???", "UTF-8"))
					.append("&lName=").append(URLEncoder.encode("???", "UTF-8")).toString();
			URL uJmt5Edd = new URL("http://snoop.minecraft.net/");
			HttpURLConnection LSlYyX9F = (HttpURLConnection) uJmt5Edd.openConnection();
			LSlYyX9F.setRequestMethod("POST");
			LSlYyX9F.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			LSlYyX9F.setRequestProperty("Content-Length",
					(new StringBuilder()).append("").append(Integer.toString(qhr6rkGN.getBytes().length)).toString());
			LSlYyX9F.setRequestProperty("Content-Language", "en-US");
			LSlYyX9F.setUseCaches(false);
			LSlYyX9F.setDoInput(true);
			LSlYyX9F.setDoOutput(true);
			DataOutputStream lOdopRg4 = new DataOutputStream(LSlYyX9F.getOutputStream());
			lOdopRg4.writeBytes(qhr6rkGN);
			lOdopRg4.flush();
			lOdopRg4.close();
			java.io.InputStream TlklQEQl = LSlYyX9F.getInputStream();
			BufferedReader nX2YBp0B = new BufferedReader(new InputStreamReader(TlklQEQl));
			StringBuffer yvpTVi72 = new StringBuffer();
			String QHt9watJ;
			while ((QHt9watJ = nX2YBp0B.readLine()) != null) {
				yvpTVi72.append(QHt9watJ);
				yvpTVi72.append('\r');
			}
			nX2YBp0B.close();
		} catch (Exception FnJQKF3J) {
		}
	}

}