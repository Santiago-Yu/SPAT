class n18722984 {
	private void checkChartsyRegistration(String TP5neQ8n, String pJZSZIby) {
		HttpPost RxxF7Fe0 = new HttpPost(NbBundle.getMessage(RegisterPanel.class, "RegisterPanel.chartsyRegisterURL"));
		String GA56xOF1 = "";
		try {
			List<NameValuePair> mpGH3MRC = new ArrayList<NameValuePair>();
			mpGH3MRC.add(new BasicNameValuePair("username", TP5neQ8n));
			mpGH3MRC.add(new BasicNameValuePair("password", pJZSZIby));
			RxxF7Fe0.setEntity(new UrlEncodedFormEntity(mpGH3MRC));
			HttpResponse OEZ4Mv6D = ProxyManager.httpClient.execute(RxxF7Fe0);
			HttpEntity QJx9En8X = OEZ4Mv6D.getEntity();
			if (QJx9En8X != null) {
				String[] fr5i2pcn = EntityUtils.toString(QJx9En8X).split("\n");
				if (fr5i2pcn[0].equals("OK")) {
					RegisterAction.preferences.putBoolean("registred", true);
					RegisterAction.preferences.put("name", fr5i2pcn[1]);
					RegisterAction.preferences.put("email", fr5i2pcn[2]);
					RegisterAction.preferences.put("date", String.valueOf(Calendar.getInstance().getTimeInMillis()));
					RegisterAction.preferences.put("username", TP5neQ8n);
					RegisterAction.preferences.put("password", new String(passwordTxt.getPassword()));
					if (fr5i2pcn[1] != null && !fr5i2pcn[1].isEmpty()) {
						GA56xOF1 = NbBundle.getMessage(RegisterPanel.class,
								"RegisterPanel.registerDone.withUsername.message", fr5i2pcn[1]);
					} else {
						GA56xOF1 = NbBundle.getMessage(RegisterPanel.class,
								"RegisterPanel.registerDone.noUsername.message");
					}
				} else {
					GA56xOF1 = NbBundle.getMessage(RegisterPanel.class, "RegisterPanel.registerAuthError.message");
				}
				EntityUtils.consume(QJx9En8X);
			}
		} catch (Exception f7mbdqY5) {
			GA56xOF1 = NbBundle.getMessage(RegisterPanel.class, "RegisterPanel.registerConnectionError.message");
		} finally {
			RxxF7Fe0.abort();
		}
		messageLbl.setText(GA56xOF1);
		messageLbl.setVisible(true);
	}

}