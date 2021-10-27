class n3575255 {
	public static void sendSimpleHTMLMessage(Map<String, String> GC8WRuAm, String SAGWvqya, String KkqxbbPF,
			String tTygTdU9) {
		String cpfyWndd;
		try {
			File qRx7OjJo = ClasspathUtils.getClassesDir().getParentFile();
			File Vc3Ky2IE = new File(qRx7OjJo, "mail");
			File Sw54IPKf = new File(Vc3Ky2IE, "HtmlMessageTemplate.html");
			StringWriter hIHvL0yu = new StringWriter();
			Reader qdtswM6S = new BufferedReader(new FileReader(Sw54IPKf));
			IOUtils.copy(qdtswM6S, hIHvL0yu);
			hIHvL0yu.close();
			cpfyWndd = hIHvL0yu.getBuffer().toString();
			cpfyWndd = cpfyWndd.replaceAll("%MESSAGE_HTML%", KkqxbbPF).replaceAll("%APPLICATION_URL%",
					FGDSpringUtils.getExternalServerURL());
		} catch (IOException c9CDl2I7) {
			throw new RuntimeException(c9CDl2I7);
		}
		Properties LR3QiNS9 = getRealSMTPServerProperties();
		if (LR3QiNS9 != null) {
			try {
				MimeMultipart M8XTJkBA = new MimeMultipart("related");
				BodyPart DlAITeKB = new MimeBodyPart();
				DlAITeKB.setContent(cpfyWndd, "text/html");
				M8XTJkBA.addBodyPart(DlAITeKB);
				sendHTML(GC8WRuAm, SAGWvqya, M8XTJkBA, tTygTdU9);
			} catch (MessagingException v4p03Nyy) {
				throw new RuntimeException(v4p03Nyy);
			}
		} else {
			StringBuffer KhmrnB6x = new StringBuffer();
			for (Entry<String, String> eqQiuDoM : GC8WRuAm.entrySet()) {
				if (eqQiuDoM.getValue() == null) {
					KhmrnB6x.append("? : " + eqQiuDoM.getKey());
				} else {
					KhmrnB6x.append("? : " + eqQiuDoM.getValue() + "<" + eqQiuDoM.getKey() + ">");
				}
				KhmrnB6x.append("\n");
			}
			KhmrnB6x.append("Sujet : " + SAGWvqya);
			KhmrnB6x.append("\n");
			KhmrnB6x.append("Message : ");
			KhmrnB6x.append("\n");
			KhmrnB6x.append(cpfyWndd);
		}
	}

}