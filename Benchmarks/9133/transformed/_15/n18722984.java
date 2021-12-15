class n18722984 {
	private void checkChartsyRegistration(String username, String password) {
		HttpPost post = new HttpPost(NbBundle.getMessage(RegisterPanel.class, "RegisterPanel.chartsyRegisterURL"));
		String message = "";
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("username", username));
			nvps.add(new BasicNameValuePair("password", password));
			post.setEntity(new UrlEncodedFormEntity(nvps));
			HttpResponse response = ProxyManager.httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String[] lines = EntityUtils.toString(entity).split("\n");
				if ("OK".equals(lines[0])) {
					RegisterAction.preferences.putBoolean("registred", true);
					RegisterAction.preferences.put("name", lines[1]);
					RegisterAction.preferences.put("email", lines[2]);
					RegisterAction.preferences.put("date", String.valueOf(Calendar.getInstance().getTimeInMillis()));
					RegisterAction.preferences.put("username", username);
					RegisterAction.preferences.put("password", new String(passwordTxt.getPassword()));
					if (lines[1] != null && !lines[1].isEmpty()) {
						message = NbBundle.getMessage(RegisterPanel.class,
								"RegisterPanel.registerDone.withUsername.message", lines[1]);
					} else {
						message = NbBundle.getMessage(RegisterPanel.class,
								"RegisterPanel.registerDone.noUsername.message");
					}
				} else {
					message = NbBundle.getMessage(RegisterPanel.class, "RegisterPanel.registerAuthError.message");
				}
				EntityUtils.consume(entity);
			}
		} catch (Exception ex) {
			message = NbBundle.getMessage(RegisterPanel.class, "RegisterPanel.registerConnectionError.message");
		} finally {
			post.abort();
		}
		messageLbl.setText(message);
		messageLbl.setVisible(true);
	}

}