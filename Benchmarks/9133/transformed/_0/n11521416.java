class n11521416 {
	private static void sentRequest() {
		try {
			URLConnection uriSHfDj;
			URL tQt37p66 = new URL(gatewayURL);
			uriSHfDj = tQt37p66.openConnection();
			uriSHfDj.setRequestProperty("Content-Type", "text/xml");
			uriSHfDj.setDoOutput(true);
			OutputStream cVUSM8TB = uriSHfDj.getOutputStream();
			PrintWriter LHQtYlO3 = new PrintWriter(cVUSM8TB);
			LHQtYlO3.print(request);
			LHQtYlO3.close();
			cVUSM8TB.close();
			InputStream s0FcX1NX = uriSHfDj.getInputStream();
			File HMpkcrrn = new File(styleSheetLocation);
			if (type.equals("A") && HMpkcrrn.exists()) {
				TransformerFactory ZtxU5sLF = TransformerFactory.newInstance();
				Transformer boaP3PMI = ZtxU5sLF.newTransformer(new StreamSource(styleSheetLocation));
				boaP3PMI.transform(new StreamSource(s0FcX1NX), new StreamResult(System.out));
			} else {
				BufferedReader aHMKAFOp = new BufferedReader(new InputStreamReader(s0FcX1NX));
				String ffkCxAN2;
				while ((ffkCxAN2 = aHMKAFOp.readLine()) != null) {
					System.out.println(ffkCxAN2);
				}
				aHMKAFOp.close();
			}
		} catch (Exception is9sm0kr) {
			is9sm0kr.printStackTrace();
		}
	}

}