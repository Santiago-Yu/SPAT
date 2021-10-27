class n844858 {
	private static String getDocumentAt(String xHnHnGn5) {
		StringBuffer hwM3ZqMO = new StringBuffer();
		try {
			URL RJV5eKgk = new URL(xHnHnGn5);
			URLConnection KW4YGIPp = RJV5eKgk.openConnection();
			BufferedReader aAmn0J90 = new BufferedReader(new InputStreamReader(KW4YGIPp.getInputStream()));
			String MhimXLef = null;
			while ((MhimXLef = aAmn0J90.readLine()) != null)
				hwM3ZqMO.append(MhimXLef + "\n");
			aAmn0J90.close();
		} catch (MalformedURLException FAWVMOoS) {
			System.out.println("??งน??URL: " + xHnHnGn5);
		} catch (IOException qRVeo9Cy) {
			qRVeo9Cy.printStackTrace();
		}
		return hwM3ZqMO.toString();
	}

}