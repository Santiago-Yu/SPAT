class n23119494 {
	@Override
	public void handle(HttpExchange ts8XZ0ho) throws IOException {
		Headers yyeAcLDs = ts8XZ0ho.getRequestHeaders();
		Headers We7D8dAM = ts8XZ0ho.getResponseHeaders();
		We7D8dAM.add("Content-Type", "text/plain");
		ts8XZ0ho.sendResponseHeaders(200, 0);
		PrintWriter GscKONUc = new PrintWriter(System.err);
		PrintWriter ZfaKG1Zz = new PrintWriter(ts8XZ0ho.getResponseBody());
		PrintWriter RJFKmxZP = new PrintWriter(new YWriter(ZfaKG1Zz, GscKONUc));
		RJFKmxZP.println("### " + new Date() + " ###");
		RJFKmxZP.println("Method: " + ts8XZ0ho.getRequestMethod());
		RJFKmxZP.println("Protocol: " + ts8XZ0ho.getProtocol());
		RJFKmxZP.println("RemoteAddress.HostName: " + ts8XZ0ho.getRemoteAddress().getHostName());
		for (String awVEEuFC : yyeAcLDs.keySet()) {
			RJFKmxZP.println("* \"" + awVEEuFC + "\"");
			for (String Sl8gxQQ2 : yyeAcLDs.get(awVEEuFC)) {
				RJFKmxZP.println("\t" + Sl8gxQQ2);
			}
		}
		InputStream U94arVlx = ts8XZ0ho.getRequestBody();
		if (U94arVlx != null) {
			RJFKmxZP.println();
			IOUtils.copyTo(new InputStreamReader(U94arVlx), RJFKmxZP);
			U94arVlx.close();
		}
		RJFKmxZP.flush();
		RJFKmxZP.close();
	}

}