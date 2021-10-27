class n347631 {
	private static String getDocumentAt(String WwIl52A0) {
		StringBuffer PbyNLgP9 = new StringBuffer();
		try {
			URL QkHVbwaL = new URL(WwIl52A0);
			URLConnection VcWEyBHx = QkHVbwaL.openConnection();
			BufferedReader XaEpYSm4 = new BufferedReader(new InputStreamReader(VcWEyBHx.getInputStream()));
			String KLbF4kGe = null;
			while ((KLbF4kGe = XaEpYSm4.readLine()) != null)
				PbyNLgP9.append(KLbF4kGe + "\n");
			XaEpYSm4.close();
		} catch (MalformedURLException reZzlAIm) {
			System.out.println("??งน??URL: " + WwIl52A0);
		} catch (IOException Blk7CKW0) {
			Blk7CKW0.printStackTrace();
		}
		return PbyNLgP9.toString();
	}

}