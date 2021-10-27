class n13438575 {
	private static void serveHTML() throws Exception {
		Bus bus = BusFactory.getDefaultBus();
		DestinationFactoryManager dfm = bus.getExtension(DestinationFactoryManager.class);
		EndpointInfo ei = new EndpointInfo();
		DestinationFactory df = dfm.getDestinationFactory("http://cxf.apache.org/transports/http/configuration");
		ei.setAddress("http://localhost:8080/test.html");
		Destination d = df.getDestination(ei);
		d.setMessageObserver(new MessageObserver() {

			public void onMessage(Message message) {
				try {
					ExchangeImpl ex = new ExchangeImpl();
					ex.setInMessage(message);
					MessageImpl res = new MessageImpl();
					Conduit backChannel = message.getDestination().getBackChannel(message, null, null);
					res.put(Message.CONTENT_TYPE, "text/html");
					backChannel.prepare(res);
					FileInputStream is = new FileInputStream("test.html");
					OutputStream out = res.getContent(OutputStream.class);
					IOUtils.copy(is, out, 2048);
					out.flush();
					out.close();
					is.close();
					backChannel.close(res);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}