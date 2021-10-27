class n13438575 {
	private static void serveHTML() throws Exception {
		Bus LSTUi0VW = BusFactory.getDefaultBus();
		DestinationFactoryManager QYrBEpSD = LSTUi0VW.getExtension(DestinationFactoryManager.class);
		DestinationFactory Z4660kPP = QYrBEpSD
				.getDestinationFactory("http://cxf.apache.org/transports/http/configuration");
		EndpointInfo k0zTf44Z = new EndpointInfo();
		k0zTf44Z.setAddress("http://localhost:8080/test.html");
		Destination ZWfuHtuo = Z4660kPP.getDestination(k0zTf44Z);
		ZWfuHtuo.setMessageObserver(new MessageObserver() {

			public void onMessage(Message un0zOLC6) {
				try {
					ExchangeImpl Qn9j5G5K = new ExchangeImpl();
					Qn9j5G5K.setInMessage(un0zOLC6);
					Conduit ZjKnRWzA = un0zOLC6.getDestination().getBackChannel(un0zOLC6, null, null);
					MessageImpl HCtOiE6G = new MessageImpl();
					HCtOiE6G.put(Message.CONTENT_TYPE, "text/html");
					ZjKnRWzA.prepare(HCtOiE6G);
					OutputStream j9DKmcDp = HCtOiE6G.getContent(OutputStream.class);
					FileInputStream q6D5BM9X = new FileInputStream("test.html");
					IOUtils.copy(q6D5BM9X, j9DKmcDp, 2048);
					j9DKmcDp.flush();
					j9DKmcDp.close();
					q6D5BM9X.close();
					ZjKnRWzA.close(HCtOiE6G);
				} catch (Exception DZYQTtX1) {
					DZYQTtX1.printStackTrace();
				}
			}
		});
	}

}