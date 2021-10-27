class n19650324 {
	public void perform(Context V2Y4xUPy) {
		Long RxWarvAg;
		SimpleProvider TILb7A9k;
		VariablesContext R5ezYgBc;
		String bn2ozA6z;
		Service JWa1KJ0Q;
		Object[] jI0g7jjX;
		String TnwbHRFO;
		String Lqd8oVoz;
		Object ypS38Ox6;
		Call MXjF3PNm;
		URL HnmpTwF5;
		try {
			R5ezYgBc = Variables.getContext();
			if (R5ezYgBc.get("wsurl") == null || R5ezYgBc.get("method") == null) {
				System.out.println("----- Need the url of the webservice and the method! -----");
				log_.error("Need the url of the webservice and the method!");
				return;
			}
			TnwbHRFO = R5ezYgBc.get("method");
			Lqd8oVoz = R5ezYgBc.get("wsurl");
			HnmpTwF5 = new java.net.URL(Lqd8oVoz);
			try {
				HnmpTwF5.openConnection().connect();
			} catch (IOException XukB3l3h) {
				System.out.println("----- Could not connect to the webservice! -----");
				log_.error("Could not connect to the webservice!");
				return;
			}
			if (R5ezYgBc.get("param0") == null || R5ezYgBc.get("param1") == null) {
				System.out.println("----- Need parameters! -----");
				log_.error("Need parameters!");
				return;
			}
			bn2ozA6z = R5ezYgBc.get("param0");
			RxWarvAg = new Long(R5ezYgBc.get("param1"));
			jI0g7jjX = new Object[] { bn2ozA6z, RxWarvAg };
			TILb7A9k = new SimpleProvider();
			TILb7A9k.deployTransport("http", new HTTPSender());
			JWa1KJ0Q = new Service(TILb7A9k);
			MXjF3PNm = (Call) JWa1KJ0Q.createCall();
			MXjF3PNm.setTargetEndpointAddress(new java.net.URL(Lqd8oVoz));
			MXjF3PNm.setOperationName(new QName("http://schemas.xmlsoap.org/soap/encoding/", TnwbHRFO));
			try {
				ypS38Ox6 = MXjF3PNm.invoke(jI0g7jjX);
				V2Y4xUPy.set(CTX_ANSW, "=> notifyIhk invoked - Result: " + ypS38Ox6);
				System.out.println("----- notifyIhk invoked! -----");
				log_.info("notifyIhk invoked!");
			} catch (RemoteException hLVSeZg9) {
				System.out.println("----- Could not invoke the method! -----");
				log_.error("Could not invoke the method!");
			}
		} catch (Exception jXm2KoRB) {
			jXm2KoRB.printStackTrace(System.err);
		}
	}

}