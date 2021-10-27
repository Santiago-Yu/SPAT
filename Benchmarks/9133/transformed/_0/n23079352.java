class n23079352 {
	public static void main(String[] kFZFZeWf) {
		try {
			URL vTdpo0pi = new URL("http://localhost:8080/axis/services/Tripcom?wsdl");
			HttpURLConnection hQtVeiVm = (HttpURLConnection) vTdpo0pi.openConnection();
			hQtVeiVm.setRequestMethod("POST");
			hQtVeiVm.setDoOutput(true);
			hQtVeiVm.setDoInput(true);
			hQtVeiVm.setRequestProperty("Content-type", "text/xml; charset=utf-8");
			hQtVeiVm.setRequestProperty("SOAPAction", "http://tempuri.org/GetTime");
			String SoYLMX3F = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<soap:Envelope "
					+ " xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" + " <soap:Body>\n"
					+ "   <rdTest xmlns=\"http://tempuri.org/\"> \n" + "   <tns:rdTest message=\"tns:rdTest\"/>  \n"
					+ "   </rdTest>" + " </soap:Body>\n" + "</soap:Envelope>";
			byte[] T7qkK7aP = SoYLMX3F.getBytes();
			hQtVeiVm.setRequestProperty("Content-length", String.valueOf(T7qkK7aP.length));
			System.out.println("\nSOAP Aufruf:");
			System.out.println("Content-type:" + hQtVeiVm.getRequestProperty("Content-type"));
			System.out.println("Content-length:" + hQtVeiVm.getRequestProperty("Content-length"));
			System.out.println("SOAPAction:" + hQtVeiVm.getRequestProperty("SOAPAction"));
			System.out.println(SoYLMX3F);
			OutputStream gZ3k8TM2 = hQtVeiVm.getOutputStream();
			gZ3k8TM2.write(T7qkK7aP);
			gZ3k8TM2.close();
			BufferedReader b2E6BU1Y = new BufferedReader(new InputStreamReader(hQtVeiVm.getInputStream()));
			String ZpYHtsXk;
			System.out.println("\nServer Antwort:");
			while ((ZpYHtsXk = b2E6BU1Y.readLine()) != null)
				System.out.println(ZpYHtsXk);
			b2E6BU1Y.close();
		} catch (Exception zJu8GaWi) {
			System.out.println("FEHLER:" + zJu8GaWi);
		}
	}

}