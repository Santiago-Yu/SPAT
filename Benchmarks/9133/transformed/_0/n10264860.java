class n10264860 {
	public AddressType[] getAdressFromCRSCoordinate(Point3d Xd2aEq9k) {
		AddressType[] Y1J1Fr3G = null;
		String BWGOQm0R = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n"
				+ "<xls:XLS xmlns:xls=\"http://www.opengis.net/xls\" xmlns:sch=\"http://www.ascc.net/xml/schematron\" xmlns:gml=\"http://www.opengis.net/gml\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.opengis.net/xls \n"
				+ "	http://gdi3d.giub.uni-bonn.de/lus/schemas/LocationUtilityService.xsd\" version=\"1.1\"> \n"
				+ "	<xls:RequestHeader srsName=\"EPSG:" + Navigator.getEpsg_code() + "\"/> \n"
				+ "	<xls:Request methodName=\"ReverseGeocodeRequest\" requestID=\"123456789\" version=\"1.1\"> \n"
				+ "		<xls:ReverseGeocodeRequest> \n" + "			<xls:Position> \n"
				+ "				<gml:Point srsName=\"" + Navigator.getEpsg_code() + "\"> \n"
				+ "					<gml:pos>" + Xd2aEq9k.x + " " + Xd2aEq9k.y + "</gml:pos> \n"
				+ "				</gml:Point> \n" + "			</xls:Position> \n"
				+ "			<xls:ReverseGeocodePreference>StreetAddress</xls:ReverseGeocodePreference> \n"
				+ "		</xls:ReverseGeocodeRequest> \n" + "	</xls:Request> \n" + "</xls:XLS> \n";
		try {
			if (Navigator.isVerbose()) {
				System.out.println("contacting " + serviceEndPoint + ":\n" + BWGOQm0R);
			}
			URL s5MMqUDo = new URL(serviceEndPoint);
			HttpURLConnection AGzeCqTq = (HttpURLConnection) s5MMqUDo.openConnection();
			AGzeCqTq.setReadTimeout(Navigator.TIME_OUT);
			AGzeCqTq.setAllowUserInteraction(false);
			AGzeCqTq.setRequestMethod("POST");
			AGzeCqTq.setRequestProperty("Content-Type", "application/xml");
			AGzeCqTq.setDoOutput(true);
			AGzeCqTq.setDoInput(true);
			AGzeCqTq.setUseCaches(false);
			PrintWriter Q26Wg5Y8 = null;
			Q26Wg5Y8 = new java.io.PrintWriter(AGzeCqTq.getOutputStream());
			Q26Wg5Y8.write(BWGOQm0R);
			Q26Wg5Y8.flush();
			Q26Wg5Y8.close();
			InputStream NmomY7yX = AGzeCqTq.getInputStream();
			XLSDocument FsgxQuCC = XLSDocument.Factory.parse(NmomY7yX);
			NmomY7yX.close();
			XLSType w0HWhcAV = FsgxQuCC.getXLS();
			AbstractBodyType ZvtODTuf[] = w0HWhcAV.getBodyArray();
			ResponseType NFmho53l = (ResponseType) ZvtODTuf[0].changeType(ResponseType.type);
			AbstractResponseParametersType Uo6ZpBTX = NFmho53l.getResponseParameters();
			if (Uo6ZpBTX == null) {
				return null;
			}
			ReverseGeocodeResponseType fTYxSNwP = (ReverseGeocodeResponseType) Uo6ZpBTX
					.changeType(ReverseGeocodeResponseType.type);
			net.opengis.xls.ReverseGeocodedLocationType[] CeOTLDAp = fTYxSNwP.getReverseGeocodedLocationArray();
			int AsnXY6Fd = CeOTLDAp.length;
			if (AsnXY6Fd > 2) {
				return null;
			}
			Y1J1Fr3G = new AddressType[AsnXY6Fd];
			for (int A2UuqXsO = 0; A2UuqXsO < AsnXY6Fd; A2UuqXsO++) {
				String ed4H4CeH = "<b>";
				net.opengis.xls.ReverseGeocodedLocationType ib6B2SD3 = CeOTLDAp[A2UuqXsO];
				Y1J1Fr3G[A2UuqXsO] = ib6B2SD3.getAddress();
			}
		} catch (java.net.ConnectException GzmiOW11) {
			JOptionPane.showMessageDialog(null, "no connection to reverse geocoder", "Connection Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception MPXatAv6) {
			MPXatAv6.printStackTrace();
		}
		return Y1J1Fr3G;
	}

}