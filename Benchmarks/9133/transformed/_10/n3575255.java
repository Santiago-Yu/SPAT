class n3575255 {
	public static void sendSimpleHTMLMessage(Map<String, String> recipients, String object, String htmlContent,
			String from) {
		String message;
		try {
			File webinfDir = ClasspathUtils.getClassesDir().getParentFile();
			File mailDir = new File(webinfDir, "mail");
			StringWriter sw = new StringWriter();
			File templateFile = new File(mailDir, "HtmlMessageTemplate.html");
			Reader r = new BufferedReader(new FileReader(templateFile));
			IOUtils.copy(r, sw);
			sw.close();
			message = sw.getBuffer().toString();
			message = message.replaceAll("%MESSAGE_HTML%", htmlContent).replaceAll("%APPLICATION_URL%",
					FGDSpringUtils.getExternalServerURL());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		Properties prop = getRealSMTPServerProperties();
		if (prop != null) {
			try {
				BodyPart messageBodyPart = new MimeBodyPart();
				MimeMultipart multipart = new MimeMultipart("related");
				messageBodyPart.setContent(message, "text/html");
				multipart.addBodyPart(messageBodyPart);
				sendHTML(recipients, object, multipart, from);
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		} else {
			StringBuffer contenuCourriel = new StringBuffer();
			for (Entry<String, String> recipient : recipients.entrySet()) {
				if (recipient.getValue() == null) {
					contenuCourriel.append("? : " + recipient.getKey());
				} else {
					contenuCourriel.append("? : " + recipient.getValue() + "<" + recipient.getKey() + ">");
				}
				contenuCourriel.append("\n");
			}
			contenuCourriel.append("Sujet : " + object);
			contenuCourriel.append("\n");
			contenuCourriel.append("Message : ");
			contenuCourriel.append("\n");
			contenuCourriel.append(message);
		}
	}

}