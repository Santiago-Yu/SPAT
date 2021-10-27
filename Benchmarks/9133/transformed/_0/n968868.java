class n968868 {
	public Document getDocument(String NPJOa0ky) {
		Document tzT0BLvj = null;
		URLConnection PeguRIxb = null;
		InputStream er1uleOt = null;
		try {
			SAXBuilder cuyyBZaa = new SAXBuilder();
			if (Osmolt.debug) {
				outputInterface.printDebugMessage("ProcessOSM", "url: " + NPJOa0ky);
				er1uleOt = new FileInputStream(new File(System.getProperty("user.home") + "/data.osm"));
				outputInterface.processSetStatus("getting data from " + System.getProperty("user.home") + "/data.osm");
			} else {
				URL SMTQJOba = new URL(NPJOa0ky);
				outputInterface.printDebugMessage("ProcessOSM", "url: " + NPJOa0ky);
				outputInterface.processSetStatus("connecting Server");
				PeguRIxb = SMTQJOba.openConnection();
				outputInterface.processSetStatus("loading Data");
				er1uleOt = PeguRIxb.getInputStream();
			}
			tzT0BLvj = cuyyBZaa.build(er1uleOt);
		} catch (java.net.UnknownHostException cZVc6GUR) {
			outputInterface.printError("Unknown Host: " + NPJOa0ky);
		} catch (java.net.SocketTimeoutException CFtJc10F) {
			outputInterface.printError("Timeout: Server does not response");
		} catch (java.net.ConnectException U8Qjezrn) {
			outputInterface.printError("Error Server response: " + U8Qjezrn.getMessage());
		} catch (java.net.SocketException khFgIMlN) {
			outputInterface.printError("Error Server response: " + khFgIMlN.getMessage());
		} catch (JDOMException YJKL7nAl) {
			outputInterface.printError(YJKL7nAl.getMessage());
			YJKL7nAl.printStackTrace();
		} catch (IOException oiCeeJJ6) {
			outputInterface.printError(oiCeeJJ6.getMessage());
			oiCeeJJ6.printStackTrace();
		} catch (Exception EDsXfvy0) {
			outputInterface.printError(EDsXfvy0.getMessage());
			EDsXfvy0.printStackTrace();
		} finally {
			try {
				if (er1uleOt != null) {
					er1uleOt.close();
				}
			} catch (IOException dU2UZFnW) {
			}
		}
		return tzT0BLvj;
	}

}