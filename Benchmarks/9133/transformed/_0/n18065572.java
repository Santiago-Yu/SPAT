class n18065572 {
	public static String executePost(String rVbRq3L1, String yL3TEo4K) {
		StringBuffer tX1CPMOH = new StringBuffer();
		try {
			Authentication.doIt();
			URL likbZKGX = new URL(rVbRq3L1);
			System.out.println("Host: " + likbZKGX.getHost());
			HttpURLConnection PdanYZ8M = (HttpURLConnection) likbZKGX.openConnection();
			System.out.println("got connection ");
			PdanYZ8M.setDoOutput(true);
			PdanYZ8M.setDoInput(true);
			PdanYZ8M.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			PdanYZ8M.setRequestProperty("Content-Length", "" + yL3TEo4K.length());
			PdanYZ8M.setRequestProperty("SOAPAction", "\"http://niki-bt.act.cmis.csiro.org/SMSService/SendText\"");
			PdanYZ8M.setRequestMethod("POST");
			PrintWriter DkhAGnwC = new PrintWriter(PdanYZ8M.getOutputStream());
			DkhAGnwC.print(yL3TEo4K);
			DkhAGnwC.flush();
			BufferedReader QlFr13iY = new BufferedReader(new InputStreamReader(PdanYZ8M.getInputStream()));
			String vnfm5umj;
			while ((vnfm5umj = QlFr13iY.readLine()) != null) {
				tX1CPMOH.append(vnfm5umj);
			}
			QlFr13iY.close();
			DkhAGnwC.close();
			PdanYZ8M.disconnect();
		} catch (MalformedURLException dowq95g2) {
			dowq95g2.printStackTrace();
		} catch (IOException ECZCFhiw) {
			ECZCFhiw.printStackTrace();
		}
		String peEJAyLi = tX1CPMOH.toString();
		if (peEJAyLi != null) {
			int pj81FBCd = peEJAyLi.indexOf('>');
			int PDRNnY97 = peEJAyLi.lastIndexOf('<');
			if (pj81FBCd != -1 && PDRNnY97 != -1) {
				return peEJAyLi.substring(pj81FBCd + 1, PDRNnY97);
			}
		}
		return null;
	}

}