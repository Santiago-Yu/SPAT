class n8212984 {
	private void readCard() {
		try {
			final String QcdYq1pO = createURLStringExistRESTGetXQuery("//scheda[cata = \"" + cata + "\"]");
			InputStream XVtd4JvA = new URL(QcdYq1pO).openStream();
			uiSchedaXml.read(XVtd4JvA);
			XVtd4JvA.close();
		} catch (MalformedURLException WGtA5WQd) {
			System.out.println(WGtA5WQd);
		} catch (IOException kpfrtmEm) {
			System.out.println(kpfrtmEm);
		}
	}

}