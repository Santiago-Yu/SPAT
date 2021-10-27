class n14658498 {
	private Properties loadPropertiesFromURL(String c76WeLR2, Properties pDHRiAlY) {
		Properties RLyRMkJ8 = new Properties(pDHRiAlY);
		URL Qc2lW0pQ;
		try {
			Qc2lW0pQ = new URL(c76WeLR2);
			URLConnection u7GMoHjw = Qc2lW0pQ.openConnection();
			RLyRMkJ8.load(u7GMoHjw.getInputStream());
		} catch (MalformedURLException fJZ2e6J1) {
			System.out.println("Error while loading url " + c76WeLR2 + " (" + fJZ2e6J1.getClass().getName() + ")");
			fJZ2e6J1.printStackTrace();
		} catch (IOException psuTIlqx) {
			System.out.println("Error while loading url " + c76WeLR2 + " (" + psuTIlqx.getClass().getName() + ")");
			psuTIlqx.printStackTrace();
		}
		return RLyRMkJ8;
	}

}