class n7044153 {
	private static void sendExceptionToServer(String frG2zsAT, Throwable a5lpH9Rv, String QRAw4oeP, String ClY8ZCeW) {
		try {
			StringBuilder L7lm9Cqv = new StringBuilder();
			L7lm9Cqv.append(URLEncoder.encode("secret", "UTF-8"));
			L7lm9Cqv.append('=');
			L7lm9Cqv.append(URLEncoder.encode("badsecurity", "UTF-8"));
			L7lm9Cqv.append('&');
			L7lm9Cqv.append(URLEncoder.encode("version", "UTF-8"));
			L7lm9Cqv.append('=');
			L7lm9Cqv.append(URLEncoder.encode(BuildInfo.revisionNumber, "UTF-8"));
			L7lm9Cqv.append('&');
			L7lm9Cqv.append(URLEncoder.encode("os", "UTF-8"));
			L7lm9Cqv.append('=');
			L7lm9Cqv.append(
					URLEncoder.encode(System.getProperty("os.name") + " " + System.getProperty("os.version"), "UTF-8"));
			L7lm9Cqv.append('&');
			L7lm9Cqv.append(URLEncoder.encode("user", "UTF-8"));
			L7lm9Cqv.append('=');
			L7lm9Cqv.append(URLEncoder.encode(System.getProperty("user.name"), "UTF-8"));
			L7lm9Cqv.append('&');
			L7lm9Cqv.append(URLEncoder.encode("msg", "UTF-8"));
			L7lm9Cqv.append('=');
			L7lm9Cqv.append(URLEncoder.encode(a5lpH9Rv.getMessage(), "UTF-8"));
			ByteArrayOutputStream zIIVVXhN = new ByteArrayOutputStream();
			a5lpH9Rv.printStackTrace(new PrintStream(zIIVVXhN));
			L7lm9Cqv.append('&');
			L7lm9Cqv.append(URLEncoder.encode("trace", "UTF-8"));
			L7lm9Cqv.append('=');
			L7lm9Cqv.append(URLEncoder.encode(zIIVVXhN.toString(), "UTF-8"));
			if (QRAw4oeP != null) {
				L7lm9Cqv.append('&');
				L7lm9Cqv.append(URLEncoder.encode("config", "UTF-8"));
				L7lm9Cqv.append('=');
				L7lm9Cqv.append(URLEncoder.encode(QRAw4oeP, "UTF-8"));
			}
			if (ClY8ZCeW != null) {
				L7lm9Cqv.append('&');
				L7lm9Cqv.append(URLEncoder.encode("problem", "UTF-8"));
				L7lm9Cqv.append('=');
				L7lm9Cqv.append(URLEncoder.encode(ClY8ZCeW, "UTF-8"));
			}
			URL oIyNxKyI = new URL(errorServerURL);
			URLConnection bqpoT5aR = oIyNxKyI.openConnection();
			bqpoT5aR.setDoOutput(true);
			OutputStreamWriter hyoMrgpK = new OutputStreamWriter(bqpoT5aR.getOutputStream());
			hyoMrgpK.write(L7lm9Cqv.toString());
			hyoMrgpK.flush();
			BufferedReader JrEzkC7N = new BufferedReader(new InputStreamReader(bqpoT5aR.getInputStream()));
			String cxpldMCm = null;
			String afsTwZDj = null;
			while ((afsTwZDj = JrEzkC7N.readLine()) != null) {
				if (cxpldMCm == null)
					cxpldMCm = afsTwZDj;
				else
					System.out.println(afsTwZDj);
			}
			hyoMrgpK.close();
			JrEzkC7N.close();
			if (cxpldMCm.equals("success"))
				System.out.println("Exception sent to maRla development team");
			else
				System.out.println("Unable to send exception to development team: " + cxpldMCm);
		} catch (IOException DtHp9h8S) {
			System.out.println("Unable to send exception to development team: " + DtHp9h8S.getMessage());
		}
	}

}