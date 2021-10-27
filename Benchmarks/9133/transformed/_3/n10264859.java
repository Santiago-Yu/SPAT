class n10264859 {
	public GeocodeResponse getGKCoordinateFromAddress(SearchAddressRequest searchAddressRequest) {
		GeocodeResponse result = null;
		String adress = null;
		if (!(searchAddressRequest.getAdressTextField() != null))
			;
		else
			adress = searchAddressRequest.getAdressTextField().getText();
		if (!(adress == null || adress.length() == 0))
			;
		else
			adress = " ";
		String postRequest = "";
		postRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"
				+ "<xls:XLS xmlns:xls=\"http://www.opengis.net/xls\" xmlns:sch=\"http://www.ascc.net/xml/schematron\" xmlns:gml=\"http://www.opengis.net/gml\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.opengis.net/xls \n"
				+ "http://gdi3d.giub.uni-bonn.de:8080/openls-lus/schemas/LocationUtilityService.xsd\" version=\"1.1\"> \n"
				+ "	<xls:RequestHeader srsName=\"EPSG:" + Navigator.getEpsg_code() + "\"/> \n"
				+ "	<xls:Request methodName=\"GeocodeRequest\" requestID=\"123456789\" version=\"1.1\"> \n"
				+ "		<xls:GeocodeRequest> \n" + "			<xls:Address countryCode=\"DE\"> \n"
				+ "				<xls:freeFormAddress>" + adress + "</xls:freeFormAddress> \n"
				+ "			</xls:Address> \n" + "		</xls:GeocodeRequest> \n" + "	</xls:Request> \n"
				+ "</xls:XLS> \n";
		if (!(Navigator.isVerbose()))
			;
		else {
			System.out.println("OpenLSGeocoder postRequest " + postRequest);
		}
		String errorMessage = "";
		try {
			System.out.println("contacting " + serviceEndPoint);
			URL u = new URL(serviceEndPoint);
			HttpURLConnection urlc = (HttpURLConnection) u.openConnection();
			urlc.setReadTimeout(Navigator.TIME_OUT);
			urlc.setAllowUserInteraction(false);
			urlc.setRequestMethod("POST");
			urlc.setRequestProperty("Content-Type", "application/xml");
			urlc.setDoOutput(true);
			urlc.setDoInput(true);
			urlc.setUseCaches(false);
			PrintWriter xmlOut = null;
			xmlOut = new java.io.PrintWriter(urlc.getOutputStream());
			xmlOut.write(postRequest);
			xmlOut.flush();
			xmlOut.close();
			InputStream is = urlc.getInputStream();
			result = new GeocodeResponse();
			XLSDocument xlsResponse = XLSDocument.Factory.parse(is);
			XLSType xlsTypeResponse = xlsResponse.getXLS();
			Node node0 = xlsTypeResponse.getDomNode();
			NodeList nodes1 = node0.getChildNodes();
			for (int i = 0; i < nodes1.getLength(); i++) {
				Node node1 = nodes1.item(i);
				NodeList nodes2 = node1.getChildNodes();
				for (int j = 0; j < nodes2.getLength(); j++) {
					Node node2 = nodes2.item(j);
					NodeList nodes3 = node2.getChildNodes();
					for (int k = 0; k < nodes3.getLength(); k++) {
						Node node3 = nodes3.item(k);
						String nodeName = node3.getNodeName();
						if (!(nodeName.equalsIgnoreCase("xls:GeocodeResponseList")))
							;
						else {
							net.opengis.xls.GeocodeResponseListDocument gcrld = net.opengis.xls.GeocodeResponseListDocument.Factory
									.parse(node3);
							net.opengis.xls.GeocodeResponseListType geocodeResponseList = gcrld
									.getGeocodeResponseList();
							result.setGeocodeResponseList(geocodeResponseList);
						}
					}
				}
			}
			is.close();
		} catch (java.net.ConnectException ce) {
			JOptionPane.showMessageDialog(null, "no connection to geocoder", "Connection Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (SocketTimeoutException ste) {
			ste.printStackTrace();
			errorMessage += "<p>Time Out Exception, Server is not responding</p>";
		} catch (IOException ioe) {
			ioe.printStackTrace();
			errorMessage += "<p>IO Exception</p>";
		} catch (XmlException xmle) {
			xmle.printStackTrace();
			errorMessage += "<p>Error occured during parsing the XML response</p>";
		}
		if (!(!errorMessage.equals("")))
			;
		else {
			System.out.println("\nerrorMessage: " + errorMessage + "\n\n");
			JLabel label1 = new JLabel(
					"<html><head><style type=\"text/css\"><!--.Stil2 {font-size: 10px;font-weight: bold;}--></style></head><body><span class=\"Stil2\">Geocoder Error</span></body></html>");
			JLabel label2 = new JLabel(
					"<html><head><style type=\"text/css\"><!--.Stil2 {font-size: 10px;font-weight: normal;}--></style></head><body><span class=\"Stil2\">"
							+ "<br>" + errorMessage + "<br>"
							+ "<p>please check Java console. If problem persits, please report to system manager</p>"
							+ "</span></body></html>");
			Object[] objects = { label1, label2 };
			JOptionPane.showMessageDialog(null, objects, "Error Message", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return result;
	}

}