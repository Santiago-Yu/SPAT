class n23079352 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/axis/services/Tripcom?wsdl");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-type", "text/xml; charset=utf-8");
			connection.setRequestProperty("SOAPAction", "http://tempuri.org/GetTime");
			String msg = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<soap:Envelope "
					+ " xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" + " <soap:Body>\n"
					+ "   <rdTest xmlns=\"http://tempuri.org/\"> \n" + "   <tns:rdTest message=\"tns:rdTest\"/>  \n"
					+ "   </rdTest>" + " </soap:Body>\n" + "</soap:Envelope>";
			byte[] bytes = msg.getBytes();
			connection.setRequestProperty("Content-length", String.valueOf(bytes.length));
			System.out.println("\nSOAP Aufruf:");
			System.out.println("Content-type:" + connection.getRequestProperty("Content-type"));
			System.out.println("Content-length:" + connection.getRequestProperty("Content-length"));
			System.out.println("SOAPAction:" + connection.getRequestProperty("SOAPAction"));
			System.out.println(msg);
			OutputStream out = connection.getOutputStream();
			out.write(bytes);
			out.close();
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			System.out.println("\nServer Antwort:");
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
		} catch (Exception e) {
			System.out.println("FEHLER:" + e);
		}
	}

}