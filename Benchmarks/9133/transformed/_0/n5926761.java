class n5926761 {
	@Override
	public void actionPerformed(ActionEvent wOA5d6vy) {
		if (feedbackView.getText().length() <= 0)
			return;
		try {
			TrustManager[] dyMAFbWC = new TrustManager[] { new X509TrustManager() {

				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(java.security.cert.X509Certificate[] zKB5yEFd, String p6TJxgVK) {
				}

				public void checkServerTrusted(java.security.cert.X509Certificate[] PKfoZn5c, String FHcG783L) {
				}
			} };
			try {
				SSLContext l7D1qLSR = SSLContext.getInstance("SSL");
				l7D1qLSR.init(null, dyMAFbWC, new java.security.SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(l7D1qLSR.getSocketFactory());
			} catch (Exception bEw9jp9U) {
				bEw9jp9U.printStackTrace();
			}
			feedback = "";
			addLine("Type            : " + feedbackView.getType());
			addLine("User            : " + HIRuntime.getManager().getCurrentUser().getLastName() + ", "
					+ HIRuntime.getManager().getCurrentUser().getFirstName() + " ("
					+ HIRuntime.getManager().getCurrentUser().getUserName() + ") "
					+ HIRuntime.getManager().getCurrentUser().getEmail());
			addLine("Project         : P" + HIRuntime.getManager().getProject().getId() + " - "
					+ MetadataHelper.findValue(HIRuntime.getManager().getProject(),
							HIRuntime.getManager().getProject().getDefaultLanguage().getLanguageId()));
			addLine("Client Version  : " + HIRuntime.getClientVersion());
			addLine("Service URL     : " + HIRuntime.getManager().getServerURL());
			try {
				addLine("Service Version : " + HIRuntime.getManager().getVersionID());
			} catch (HIWebServiceException Bq8eYy5l) {
			}
			addLine("Client OS       : " + System.getProperty("os.name") + " " + System.getProperty("os.version") + " ("
					+ System.getProperty("os.arch") + ")");
			addLine("Java Version    : " + System.getProperty("java.version") + " (" + System.getProperty("java.vendor")
					+ ")");
			if (HIRuntime.getGui().getLastWSError() == null)
				addLine("Last WS Error   : -none-");
			else {
				HIWebServiceException t8cDOWpJ = HIRuntime.getGui().getLastWSError();
				addLine("Last WS Error   : " + t8cDOWpJ.getCause().getMessage() + " (" + t8cDOWpJ.getErrorType() + ")");
				addLine("");
				addLine("Stack Trace");
				addLine("-----------");
				ByteArrayOutputStream L9JOuGaJ = new ByteArrayOutputStream();
				PrintWriter IXPqbx4Q = new PrintWriter(L9JOuGaJ);
				t8cDOWpJ.getCause().printStackTrace(IXPqbx4Q);
				IXPqbx4Q.close();
				addLine(new String(L9JOuGaJ.toByteArray()));
			}
			addLine("");
			addLine("Message");
			addLine("-------");
			feedback = feedback + feedbackView.getText();
			feedback = feedback + "\n\n";
			feedback = URLEncoder.encode(feedback, "UTF-8");
			URL befzZZ4N = new URL("https://hyperimage.cms.hu-berlin.de/2.0/wstart/provideFeedback.php");
			HttpsURLConnection uTtEEiU8 = (HttpsURLConnection) befzZZ4N.openConnection();
			uTtEEiU8.setRequestMethod("POST");
			uTtEEiU8.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			uTtEEiU8.setDoOutput(true);
			PrintWriter HVQbnTBf = new PrintWriter(uTtEEiU8.getOutputStream());
			HVQbnTBf.write("raw_fb=" + feedback);
			HVQbnTBf.close();
			uTtEEiU8.connect();
			String NaeOzvIn = uTtEEiU8.getResponseMessage();
			if (NaeOzvIn.compareTo("OK") == 0) {
				HIRuntime.getGui().clearLastWSError();
				HIRuntime.getGui().displayInfoDialog("Feedback gesendet",
						"Vielen Dank f¨¹r Ihr Feedback!\n\nIhre Nachricht wurde an die HyperImage Entwickler gesendet.");
			} else
				HIRuntime.getGui().displayInfoDialog("Feedback Fehlgeschlagen",
						"Leider konnte Ihr Feedback aufgrund eines Systemfehlers nicht gesendet werden.\n"
								+ "Bitte versuchen Sie es sp?ter erneut.\n\n"
								+ "Sollte das Problem bestehen bleiben wenden Sie sich bitte per mail an die Entwickler.\n\nVielen Dank!");
			uTtEEiU8.disconnect();
		} catch (MalformedURLException LzoyII7w) {
			LzoyII7w.printStackTrace();
			HIRuntime.getGui().displayInfoDialog("Feedback Fehlgeschlagen",
					"Leider konnte Ihr Feedback aufgrund eines Systemfehlers nicht gesendet werden.\n"
							+ "Bitte versuchen Sie es sp?ter erneut.\n\n"
							+ "Sollte das Problem bestehen bleiben wenden Sie sich bitte per mail an die Entwickler.\n\nVielen Dank!");
		} catch (IOException HvVwhGju) {
			HvVwhGju.printStackTrace();
			HIRuntime.getGui().displayInfoDialog("Feedback Fehlgeschlagen",
					"Leider konnte Ihr Feedback aufgrund eines Systemfehlers nicht gesendet werden.\n"
							+ "Bitte versuchen Sie es sp?ter erneut.\n\n"
							+ "Sollte das Problem bestehen bleiben wenden Sie sich bitte per mail an die Entwickler.\n\nVielen Dank!");
		}
		HIRuntime.getGui().deregisterComponent(this, false);
	}

}