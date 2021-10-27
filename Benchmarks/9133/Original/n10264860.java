class n10264860{
    public AddressType[] getAdressFromCRSCoordinate(Point3d crs_position) {
        AddressType[] result = null;
        String postRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" + "<xls:XLS xmlns:xls=\"http://www.opengis.net/xls\" xmlns:sch=\"http://www.ascc.net/xml/schematron\" xmlns:gml=\"http://www.opengis.net/gml\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.opengis.net/xls \n" + "	http://gdi3d.giub.uni-bonn.de/lus/schemas/LocationUtilityService.xsd\" version=\"1.1\"> \n" + "	<xls:RequestHeader srsName=\"EPSG:" + Navigator.getEpsg_code() + "\"/> \n" + "	<xls:Request methodName=\"ReverseGeocodeRequest\" requestID=\"123456789\" version=\"1.1\"> \n" + "		<xls:ReverseGeocodeRequest> \n" + "			<xls:Position> \n" + "				<gml:Point srsName=\"" + Navigator.getEpsg_code() + "\"> \n" + "					<gml:pos>" + crs_position.x + " " + crs_position.y + "</gml:pos> \n" + "				</gml:Point> \n" + "			</xls:Position> \n" + "			<xls:ReverseGeocodePreference>StreetAddress</xls:ReverseGeocodePreference> \n" + "		</xls:ReverseGeocodeRequest> \n" + "	</xls:Request> \n" + "</xls:XLS> \n";
        try {
            if (Navigator.isVerbose()) {
                System.out.println("contacting " + serviceEndPoint + ":\n" + postRequest);
            }
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
            XLSDocument xlsResponse = XLSDocument.Factory.parse(is);
            is.close();
            XLSType xlsTypeResponse = xlsResponse.getXLS();
            AbstractBodyType abBodyResponse[] = xlsTypeResponse.getBodyArray();
            ResponseType response = (ResponseType) abBodyResponse[0].changeType(ResponseType.type);
            AbstractResponseParametersType respParam = response.getResponseParameters();
            if (respParam == null) {
                return null;
            }
            ReverseGeocodeResponseType drResp = (ReverseGeocodeResponseType) respParam.changeType(ReverseGeocodeResponseType.type);
            net.opengis.xls.ReverseGeocodedLocationType[] types = drResp.getReverseGeocodedLocationArray();
            int num = types.length;
            if (num > 2) {
                return null;
            }
            result = new AddressType[num];
            for (int i = 0; i < num; i++) {
                String addressDescription = "<b>";
                net.opengis.xls.ReverseGeocodedLocationType type = types[i];
                result[i] = type.getAddress();
            }
        } catch (java.net.ConnectException ce) {
            JOptionPane.showMessageDialog(null, "no connection to reverse geocoder", "Connection Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}