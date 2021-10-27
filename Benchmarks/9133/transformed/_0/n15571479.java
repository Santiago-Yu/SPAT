class n15571479 {
	private void callbackWS(String sdiIVs1X, String OhlcVqkV, long wB5g1OuS) {
		SimpleProvider MdV9hlpm;
		Service M0oKVS0A;
		Object OKzy8eE1;
		Call scWrEY6B;
		Object[] rLpYYoB6;
		String o3QVW8NS;
		String x89s4ckq;
		URL yVymsLrV;
		NodeList skctt5fV;
		Node Q52phFCg;
		InputSource UYDsGh4z;
		try {
			UYDsGh4z = new InputSource(new StringReader(sdiIVs1X));
			skctt5fV = SimpleXMLParser.parseDocument(UYDsGh4z, AgentBehaviour.XML_CALLBACK);
			Q52phFCg = skctt5fV.item(0);
			x89s4ckq = SimpleXMLParser.findChildEntry(Q52phFCg, AgentBehaviour.XML_URL);
			o3QVW8NS = SimpleXMLParser.findChildEntry(Q52phFCg, AgentBehaviour.XML_METHOD);
			if (x89s4ckq == null || o3QVW8NS == null) {
				System.out.println("----- Did not get method or wsurl from the properties! -----");
				return;
			}
			yVymsLrV = new java.net.URL(x89s4ckq);
			try {
				yVymsLrV.openConnection().connect();
			} catch (IOException HZ2rKaBL) {
				System.out.println("----- Could not connect to the webservice! -----");
			}
			Vector U4kEKJAi = new Vector();
			U4kEKJAi.add(OhlcVqkV);
			U4kEKJAi.add(new Long(wB5g1OuS));
			rLpYYoB6 = U4kEKJAi.toArray();
			MdV9hlpm = new SimpleProvider();
			MdV9hlpm.deployTransport("http", new HTTPSender());
			M0oKVS0A = new Service(MdV9hlpm);
			scWrEY6B = (Call) M0oKVS0A.createCall();
			scWrEY6B.setTargetEndpointAddress(yVymsLrV);
			scWrEY6B.setOperationName(new QName("http://schemas.xmlsoap.org/soap/encoding/", o3QVW8NS));
			try {
				OKzy8eE1 = scWrEY6B.invoke(rLpYYoB6);
				if (OKzy8eE1 == null) {
					OKzy8eE1 = new String("No response from callback function!");
				}
				System.out.println("Callback function returned: " + OKzy8eE1);
			} catch (RemoteException bqSzSbyT) {
				System.out.println("----- Could not invoke the method! -----");
			}
		} catch (Exception KhrnQ26r) {
			KhrnQ26r.printStackTrace(System.err);
		}
	}

}