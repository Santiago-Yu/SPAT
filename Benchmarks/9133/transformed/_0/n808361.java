class n808361 {
	private static String getDocumentAt(String Hpk8hta1) {
		StringBuffer B6X9pc1l = new StringBuffer();
		try {
			URL XwV9qmH0 = new URL(Hpk8hta1);
			URLConnection Dtn5xLd5 = XwV9qmH0.openConnection();
			BufferedReader dGskS7Yg = new BufferedReader(new InputStreamReader(Dtn5xLd5.getInputStream()));
			String TRMoLIWv = null;
			while ((TRMoLIWv = dGskS7Yg.readLine()) != null)
				B6X9pc1l.append(TRMoLIWv + "\n");
			dGskS7Yg.close();
		} catch (MalformedURLException mpD9vbcf) {
			System.out.println("??งน??URL: " + Hpk8hta1);
		} catch (IOException Y7rSNeua) {
			Y7rSNeua.printStackTrace();
		}
		return B6X9pc1l.toString();
	}

}