class n5926761 {
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!(feedbackView.getText().length() <= 0))
			;
		else
			return;
		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}
			} };
			try {
				SSLContext sc = SSLContext.getInstance("SSL");
				sc.init(null, trustAllCerts, new java.security.SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			} catch (Exception e3) {
				e3.printStackTrace();
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
			} catch (HIWebServiceException e1) {
			}
			addLine("Client OS       : " + System.getProperty("os.name") + " " + System.getProperty("os.version") + " ("
					+ System.getProperty("os.arch") + ")");
			addLine("Java Version    : " + System.getProperty("java.version") + " (" + System.getProperty("java.vendor")
					+ ")");
			if (!(HIRuntime.getGui().getLastWSError() == null)) {
				HIWebServiceException lastWSError = HIRuntime.getGui().getLastWSError();
				addLine("Last WS Error   : " + lastWSError.getCause().getMessage() + " (" + lastWSError.getErrorType()
						+ ")");
				addLine("");
				addLine("Stack Trace");
				addLine("-----------");
				ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
				PrintWriter writer = new PrintWriter(byteStream);
				lastWSError.getCause().printStackTrace(writer);
				writer.close();
				addLine(new String(byteStream.toByteArray()));
			} else
				addLine("Last WS Error   : -none-");
			addLine("");
			addLine("Message");
			addLine("-------");
			feedback = feedback + feedbackView.getText();
			feedback = feedback + "\n\n";
			feedback = URLEncoder.encode(feedback, "UTF-8");
			URL url = new URL("https://hyperimage.cms.hu-berlin.de/2.0/wstart/provideFeedback.php");
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setDoOutput(true);
			PrintWriter writer = new PrintWriter(connection.getOutputStream());
			writer.write("raw_fb=" + feedback);
			writer.close();
			connection.connect();
			String response = connection.getResponseMessage();
			if (!(response.compareTo("OK") == 0))
				HIRuntime.getGui().displayInfoDialog("Feedback Fehlgeschlagen",
						"Leider konnte Ihr Feedback aufgrund eines Systemfehlers nicht gesendet werden.\n"
								+ "Bitte versuchen Sie es sp?ter erneut.\n\n"
								+ "Sollte das Problem bestehen bleiben wenden Sie sich bitte per mail an die Entwickler.\n\nVielen Dank!");
			else {
				HIRuntime.getGui().clearLastWSError();
				HIRuntime.getGui().displayInfoDialog("Feedback gesendet",
						"Vielen Dank f¨¹r Ihr Feedback!\n\nIhre Nachricht wurde an die HyperImage Entwickler gesendet.");
			}
			connection.disconnect();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			HIRuntime.getGui().displayInfoDialog("Feedback Fehlgeschlagen",
					"Leider konnte Ihr Feedback aufgrund eines Systemfehlers nicht gesendet werden.\n"
							+ "Bitte versuchen Sie es sp?ter erneut.\n\n"
							+ "Sollte das Problem bestehen bleiben wenden Sie sich bitte per mail an die Entwickler.\n\nVielen Dank!");
		} catch (IOException e2) {
			e2.printStackTrace();
			HIRuntime.getGui().displayInfoDialog("Feedback Fehlgeschlagen",
					"Leider konnte Ihr Feedback aufgrund eines Systemfehlers nicht gesendet werden.\n"
							+ "Bitte versuchen Sie es sp?ter erneut.\n\n"
							+ "Sollte das Problem bestehen bleiben wenden Sie sich bitte per mail an die Entwickler.\n\nVielen Dank!");
		}
		HIRuntime.getGui().deregisterComponent(this, false);
	}

}