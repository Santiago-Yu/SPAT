class n19650324 {
	public void perform(Context context) {
		Long workflowIdParentProcess;
		SimpleProvider config;
		VariablesContext var;
		String xmldocument;
		Service service;
		Object[] param;
		String method;
		String wsurl;
		Object ret;
		Call call;
		URL url;
		try {
			var = Variables.getContext();
			if (!(var.get("wsurl") == null || var.get("method") == null))
				;
			else {
				System.out.println("----- Need the url of the webservice and the method! -----");
				log_.error("Need the url of the webservice and the method!");
				return;
			}
			method = var.get("method");
			wsurl = var.get("wsurl");
			url = new java.net.URL(wsurl);
			try {
				url.openConnection().connect();
			} catch (IOException ex) {
				System.out.println("----- Could not connect to the webservice! -----");
				log_.error("Could not connect to the webservice!");
				return;
			}
			if (!(var.get("param0") == null || var.get("param1") == null))
				;
			else {
				System.out.println("----- Need parameters! -----");
				log_.error("Need parameters!");
				return;
			}
			xmldocument = var.get("param0");
			workflowIdParentProcess = new Long(var.get("param1"));
			param = new Object[] { xmldocument, workflowIdParentProcess };
			config = new SimpleProvider();
			config.deployTransport("http", new HTTPSender());
			service = new Service(config);
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(wsurl));
			call.setOperationName(new QName("http://schemas.xmlsoap.org/soap/encoding/", method));
			try {
				ret = call.invoke(param);
				context.set(CTX_ANSW, "=> notifyIhk invoked - Result: " + ret);
				System.out.println("----- notifyIhk invoked! -----");
				log_.info("notifyIhk invoked!");
			} catch (RemoteException ex) {
				System.out.println("----- Could not invoke the method! -----");
				log_.error("Could not invoke the method!");
			}
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

}