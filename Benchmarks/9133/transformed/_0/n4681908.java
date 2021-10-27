class n4681908 {
	private void callbackWS(String xcSaUMfR, String rulkDYfy, long isRJubmJ) {
		SimpleProvider L3FObeed;
		Service YisjA5BA;
		Object fU9nyP78;
		Call VaXIU802;
		Object[] tI7Tqnxu;
		String RKRWIXMj;
		String ULQUAUq3;
		URL JUNSEmDa;
		NodeList QLZ69Emg;
		Node OKYjwMzq;
		InputSource jj7hjM7X;
		try {
			jj7hjM7X = new InputSource(new StringReader(xcSaUMfR));
			QLZ69Emg = SimpleXMLParser.parseDocument(jj7hjM7X, AgentBehaviour.XML_CALLBACK);
			OKYjwMzq = QLZ69Emg.item(0);
			ULQUAUq3 = SimpleXMLParser.findChildEntry(OKYjwMzq, AgentBehaviour.XML_URL);
			RKRWIXMj = SimpleXMLParser.findChildEntry(OKYjwMzq, AgentBehaviour.XML_METHOD);
			if (ULQUAUq3 == null || RKRWIXMj == null) {
				System.out.println("----- Did not get method or wsurl from the properties! -----");
				return;
			}
			JUNSEmDa = new java.net.URL(ULQUAUq3);
			try {
				JUNSEmDa.openConnection().connect();
			} catch (IOException U4QZxego) {
				System.out.println("----- Could not connect to the webservice! -----");
			}
			Vector QhHC6cid = new Vector();
			QhHC6cid.add(rulkDYfy);
			QhHC6cid.add(new Long(isRJubmJ));
			tI7Tqnxu = QhHC6cid.toArray();
			L3FObeed = new SimpleProvider();
			L3FObeed.deployTransport("http", new HTTPSender());
			YisjA5BA = new Service(L3FObeed);
			VaXIU802 = (Call) YisjA5BA.createCall();
			VaXIU802.setTargetEndpointAddress(JUNSEmDa);
			VaXIU802.setOperationName(new QName("http://schemas.xmlsoap.org/soap/encoding/", RKRWIXMj));
			try {
				fU9nyP78 = VaXIU802.invoke(tI7Tqnxu);
				if (fU9nyP78 == null) {
					fU9nyP78 = new String("No response from callback function!");
				}
				System.out.println("Callback function returned: " + fU9nyP78);
			} catch (RemoteException VlLNBdhn) {
				System.out.println("----- Could not invoke the method! -----");
			}
		} catch (Exception GE1kNVmY) {
			GE1kNVmY.printStackTrace(System.err);
		}
	}

}