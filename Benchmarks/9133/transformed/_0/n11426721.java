class n11426721 {
	public boolean uploadToUrl(URL TUdissMS, Map l6G6nOkF) {
		boolean eIGPZbuZ = false;
		OutputStream skUsJriK;
		HttpURLConnection Ysw5FhDL = null;
		try {
			Ysw5FhDL = (HttpURLConnection) TUdissMS.openConnection();
			Ysw5FhDL.setDoOutput(true);
			Ysw5FhDL.setDoInput(true);
			Ysw5FhDL.setUseCaches(false);
			Ysw5FhDL.setAllowUserInteraction(false);
			String aIBYljml = "";
			Iterator j8w8s7Z7 = l6G6nOkF.entrySet().iterator();
			while (j8w8s7Z7.hasNext()) {
				Map.Entry i2vjMSWS = (Map.Entry) j8w8s7Z7.next();
				aIBYljml += (String) i2vjMSWS.getKey() + "=" + URLEncoder.encode((String) i2vjMSWS.getValue(), "UTF-8")
						+ "&";
			}
			byte[] A9LwELPe = aIBYljml.getBytes();
			Ysw5FhDL.setRequestProperty("Content=length", String.valueOf(A9LwELPe.length));
			skUsJriK = Ysw5FhDL.getOutputStream();
			skUsJriK.write(A9LwELPe);
			skUsJriK.flush();
			BufferedReader q0wehFoF = new BufferedReader(new InputStreamReader(Ysw5FhDL.getInputStream()));
			String V3yCld96;
			while ((V3yCld96 = q0wehFoF.readLine()) != null) {
				System.err.println("Response: " + V3yCld96);
			}
			skUsJriK.close();
			q0wehFoF.close();
			eIGPZbuZ = true;
		} catch (MalformedURLException ATAiJNVj) {
			System.err.println(ATAiJNVj + " (uploadToUrl)");
			eIGPZbuZ = false;
		} catch (java.io.IOException VC16jPE6) {
			System.out.println(VC16jPE6 + " (uploadToUrl)");
			eIGPZbuZ = false;
		} catch (Exception RJnSJVzn) {
			System.out.println(RJnSJVzn.toString() + " (uploadToUrl)");
			eIGPZbuZ = false;
		} finally {
			eIGPZbuZ = false;
		}
		return eIGPZbuZ;
	}

}