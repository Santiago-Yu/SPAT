class n15571479 {
	private void callbackWS(String xmlControl, String ws_results, long docId) {
		Service service;
		SimpleProvider config;
		Call call;
		Object ret;
		String method;
		Object[] parameter;
		URL url;
		String wsurl;
		Node actualNode;
		NodeList delegateNodes;
		InputSource xmlcontrolstream;
		try {
			xmlcontrolstream = new InputSource(new StringReader(xmlControl));
			delegateNodes = SimpleXMLParser.parseDocument(xmlcontrolstream, AgentBehaviour.XML_CALLBACK);
			actualNode = delegateNodes.item(0);
			wsurl = SimpleXMLParser.findChildEntry(actualNode, AgentBehaviour.XML_URL);
			method = SimpleXMLParser.findChildEntry(actualNode, AgentBehaviour.XML_METHOD);
			if (wsurl == null || method == null) {
				System.out.println("----- Did not get method or wsurl from the properties! -----");
				return;
			}
			url = new java.net.URL(wsurl);
			Vector v_param = new Vector();
			try {
				url.openConnection().connect();
			} catch (IOException ex) {
				System.out.println("----- Could not connect to the webservice! -----");
			}
			v_param.add(ws_results);
			v_param.add(new Long(docId));
			config = new SimpleProvider();
			parameter = v_param.toArray();
			config.deployTransport("http", new HTTPSender());
			service = new Service(config);
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(url);
			call.setOperationName(new QName("http://schemas.xmlsoap.org/soap/encoding/", method));
			try {
				ret = call.invoke(parameter);
				if (ret == null) {
					ret = new String("No response from callback function!");
				}
				System.out.println("Callback function returned: " + ret);
			} catch (RemoteException ex) {
				System.out.println("----- Could not invoke the method! -----");
			}
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

}