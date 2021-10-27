class n6939447 {
	private void btnRegisterActionPerformed(java.awt.event.ActionEvent tlqa2jNH) {
		String WyPcFX6f = txtUsername.getText();
		String rTZNwM1T = new String(txtPassword.getPassword());
		String OmJYoLda = null;
		Preferences KYEBjD3e = NbPreferences.root().node("/org/chartsy/register");
		try {
			MessageDigest vlc9ZtKB = MessageDigest.getInstance("MD5");
			vlc9ZtKB.update(new String(txtPassword.getPassword()).getBytes());
			BigInteger H9tD6Cvb = new BigInteger(1, vlc9ZtKB.digest());
			OmJYoLda = H9tD6Cvb.toString(16);
		} catch (NoSuchAlgorithmException y3PDBokU) {
			LOG.log(Level.SEVERE, null, y3PDBokU);
		}
		try {
			lblMessage.setText("Checking registration ...");
			btnRegister.setEnabled(false);
			btnRemind.setEnabled(false);
			HttpClient EScr6F6s = ProxyManager.getDefault().getHttpClient();
			GetMethod Olb3ZjuL = new GetMethod(NbBundle.getMessage(RegisterForm.class, "CheckReg_URL"));
			Olb3ZjuL.setQueryString(new NameValuePair[] { new NameValuePair("username", WyPcFX6f),
					new NameValuePair("password", OmJYoLda) });
			EScr6F6s.executeMethod(Olb3ZjuL);
			BufferedReader OPa1QQ8q = new BufferedReader(new InputStreamReader(Olb3ZjuL.getResponseBodyAsStream()));
			boolean VywAPVvv = false;
			String BORKIsgR = null;
			if (OPa1QQ8q != null) {
				String y5tnxqTt = OPa1QQ8q.readLine();
				if (y5tnxqTt.equals("OK")) {
					VywAPVvv = true;
					BORKIsgR = OPa1QQ8q.readLine();
					KYEBjD3e.putBoolean("registred", true);
					KYEBjD3e.put("name", BORKIsgR);
					KYEBjD3e.put("date", String.valueOf(new Date().getTime()));
					KYEBjD3e.put("username", WyPcFX6f);
					KYEBjD3e.put("password", rTZNwM1T);
				}
			}
			int A1qYRNec = checkStockScanPRORegistration();
			boolean beW7wE3W = A1qYRNec != 0;
			boolean l5svsmAy = beW7wE3W ? true : checkMrSwingRegistration();
			KYEBjD3e.putBoolean("mrswingregistred", l5svsmAy);
			Preferences wDbH0Ll6 = NbPreferences.root().node("/org/chartsy/stockscanpro");
			wDbH0Ll6.putBoolean("stockscanproregistred", beW7wE3W);
			wDbH0Ll6.putInt("stockscanprouser", A1qYRNec);
			FeaturesPanel.getDefault().hideBanners();
			if (VywAPVvv) {
				if (BORKIsgR != null) {
					lblMessage.setText(BORKIsgR + ", thank you for the registration.");
				} else {
					lblMessage.setText("Thank you for the registration.");
				}
				btnRegister.setVisible(false);
				btnRemind.setText("Close");
				btnRemind.setEnabled(true);
			} else {
				lblMessage.setText("Error, could not register. Check your username and password.");
				btnRegister.setEnabled(true);
				btnRemind.setEnabled(true);
			}
		} catch (IOException V8yDmMTJ) {
			LOG.log(Level.SEVERE, null, V8yDmMTJ);
		}
	}

}