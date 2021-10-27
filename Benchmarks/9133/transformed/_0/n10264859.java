class n10264859 {
	public GeocodeResponse getGKCoordinateFromAddress(SearchAddressRequest BdJ0zWS8) {
		GeocodeResponse cdTdlHde = null;
		String Ww3cKS7B = null;
		if (BdJ0zWS8.getAdressTextField() != null)
			Ww3cKS7B = BdJ0zWS8.getAdressTextField().getText();
		if (Ww3cKS7B == null || Ww3cKS7B.length() == 0)
			Ww3cKS7B = " ";
		String sJbqRmoI = "";
		sJbqRmoI = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"
				+ "<xls:XLS xmlns:xls=\"http://www.opengis.net/xls\" xmlns:sch=\"http://www.ascc.net/xml/schematron\" xmlns:gml=\"http://www.opengis.net/gml\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.opengis.net/xls \n"
				+ "http://gdi3d.giub.uni-bonn.de:8080/openls-lus/schemas/LocationUtilityService.xsd\" version=\"1.1\"> \n"
				+ "	<xls:RequestHeader srsName=\"EPSG:" + Navigator.getEpsg_code() + "\"/> \n"
				+ "	<xls:Request methodName=\"GeocodeRequest\" requestID=\"123456789\" version=\"1.1\"> \n"
				+ "		<xls:GeocodeRequest> \n" + "			<xls:Address countryCode=\"DE\"> \n"
				+ "				<xls:freeFormAddress>" + Ww3cKS7B + "</xls:freeFormAddress> \n"
				+ "			</xls:Address> \n" + "		</xls:GeocodeRequest> \n" + "	</xls:Request> \n"
				+ "</xls:XLS> \n";
		if (Navigator.isVerbose()) {
			System.out.println("OpenLSGeocoder postRequest " + sJbqRmoI);
		}
		String nMcp0nXp = "";
		try {
			System.out.println("contacting " + serviceEndPoint);
			URL eshTYAbx = new URL(serviceEndPoint);
			HttpURLConnection IjP5AnDP = (HttpURLConnection) eshTYAbx.openConnection();
			IjP5AnDP.setReadTimeout(Navigator.TIME_OUT);
			IjP5AnDP.setAllowUserInteraction(false);
			IjP5AnDP.setRequestMethod("POST");
			IjP5AnDP.setRequestProperty("Content-Type", "application/xml");
			IjP5AnDP.setDoOutput(true);
			IjP5AnDP.setDoInput(true);
			IjP5AnDP.setUseCaches(false);
			PrintWriter T6P4s5WJ = null;
			T6P4s5WJ = new java.io.PrintWriter(IjP5AnDP.getOutputStream());
			T6P4s5WJ.write(sJbqRmoI);
			T6P4s5WJ.flush();
			T6P4s5WJ.close();
			InputStream K3yQnhkH = IjP5AnDP.getInputStream();
			cdTdlHde = new GeocodeResponse();
			XLSDocument V2XqVbd3 = XLSDocument.Factory.parse(K3yQnhkH);
			XLSType xyyUOaaA = V2XqVbd3.getXLS();
			Node Lebi9F97 = xyyUOaaA.getDomNode();
			NodeList xeh1F8Eg = Lebi9F97.getChildNodes();
			for (int sKouPhgE = 0; sKouPhgE < xeh1F8Eg.getLength(); sKouPhgE++) {
				Node naawIkPo = xeh1F8Eg.item(sKouPhgE);
				NodeList SDnjiJTs = naawIkPo.getChildNodes();
				for (int H6Mh5Ob1 = 0; H6Mh5Ob1 < SDnjiJTs.getLength(); H6Mh5Ob1++) {
					Node l9yVRUpy = SDnjiJTs.item(H6Mh5Ob1);
					NodeList euaBN8an = l9yVRUpy.getChildNodes();
					for (int ME9AD2QS = 0; ME9AD2QS < euaBN8an.getLength(); ME9AD2QS++) {
						Node AvldQfOu = euaBN8an.item(ME9AD2QS);
						String KDg7n6cB = AvldQfOu.getNodeName();
						if (KDg7n6cB.equalsIgnoreCase("xls:GeocodeResponseList")) {
							net.opengis.xls.GeocodeResponseListDocument cCIjiJG0 = net.opengis.xls.GeocodeResponseListDocument.Factory
									.parse(AvldQfOu);
							net.opengis.xls.GeocodeResponseListType zKIo6Ude = cCIjiJG0.getGeocodeResponseList();
							cdTdlHde.setGeocodeResponseList(zKIo6Ude);
						}
					}
				}
			}
			K3yQnhkH.close();
		} catch (java.net.ConnectException gpcNQsAw) {
			JOptionPane.showMessageDialog(null, "no connection to geocoder", "Connection Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (SocketTimeoutException cMhyjtXf) {
			cMhyjtXf.printStackTrace();
			nMcp0nXp += "<p>Time Out Exception, Server is not responding</p>";
		} catch (IOException qmpwZDR5) {
			qmpwZDR5.printStackTrace();
			nMcp0nXp += "<p>IO Exception</p>";
		} catch (XmlException LhVEgu7L) {
			LhVEgu7L.printStackTrace();
			nMcp0nXp += "<p>Error occured during parsing the XML response</p>";
		}
		if (!nMcp0nXp.equals("")) {
			System.out.println("\nerrorMessage: " + nMcp0nXp + "\n\n");
			JLabel uhLew9Nd = new JLabel(
					"<html><head><style type=\"text/css\"><!--.Stil2 {font-size: 10px;font-weight: bold;}--></style></head><body><span class=\"Stil2\">Geocoder Error</span></body></html>");
			JLabel DEsBZ0Yl = new JLabel(
					"<html><head><style type=\"text/css\"><!--.Stil2 {font-size: 10px;font-weight: normal;}--></style></head><body><span class=\"Stil2\">"
							+ "<br>" + nMcp0nXp + "<br>"
							+ "<p>please check Java console. If problem persits, please report to system manager</p>"
							+ "</span></body></html>");
			Object[] QZ1XHtBU = { uhLew9Nd, DEsBZ0Yl };
			JOptionPane.showMessageDialog(null, QZ1XHtBU, "Error Message", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return cdTdlHde;
	}

}