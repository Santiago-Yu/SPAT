class n17808807 {
	static String doHttp(String PxJIxTHp, String YcXfnJfE) {
		String h5yzdGgW = null;
		StringBuffer pVK0KIDZ = new StringBuffer();
		pVK0KIDZ.append("bsh.client=Remote");
		pVK0KIDZ.append("&bsh.script=");
		pVK0KIDZ.append(URLEncoder.encode(YcXfnJfE));
		String HupUORNI = pVK0KIDZ.toString();
		try {
			URL W5AMoTB1 = new URL(PxJIxTHp);
			HttpURLConnection n32YqiQf = (HttpURLConnection) W5AMoTB1.openConnection();
			n32YqiQf.setRequestMethod("POST");
			n32YqiQf.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			n32YqiQf.setDoOutput(true);
			n32YqiQf.setDoInput(true);
			PrintWriter IzYqxLZo = new PrintWriter(new OutputStreamWriter(n32YqiQf.getOutputStream(), "8859_1"), true);
			IzYqxLZo.print(HupUORNI);
			IzYqxLZo.flush();
			int pAQc1aX5 = n32YqiQf.getResponseCode();
			if (pAQc1aX5 != HttpURLConnection.HTTP_OK)
				System.out.println("Error, HTTP response: " + pAQc1aX5);
			h5yzdGgW = n32YqiQf.getHeaderField("Bsh-Return");
			BufferedReader iLf28UAI = new BufferedReader(new InputStreamReader(n32YqiQf.getInputStream()));
			String XO1BKtJU;
			while ((XO1BKtJU = iLf28UAI.readLine()) != null)
				System.out.println(XO1BKtJU);
			System.out.println("Return Value: " + h5yzdGgW);
		} catch (MalformedURLException nGS5f0EP) {
			System.out.println(nGS5f0EP);
		} catch (IOException SAyVPH7u) {
			System.out.println(SAyVPH7u);
		}
		return h5yzdGgW;
	}

}