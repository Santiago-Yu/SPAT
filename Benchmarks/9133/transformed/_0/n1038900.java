class n1038900 {
	public static SOAPMessage call(SOAPMessage oC4stHiz, URL SvlHVePL) throws IOException, SOAPException {
		URLConnection xzPILfC9 = SvlHVePL.openConnection();
		xzPILfC9.setDoOutput(true);
		xzPILfC9.setDoInput(true);
		xzPILfC9.connect();
		oC4stHiz.writeTo(xzPILfC9.getOutputStream());
		MessageFactory crPXGnoz = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
		return crPXGnoz.createMessage(null, xzPILfC9.getInputStream());
	}

}