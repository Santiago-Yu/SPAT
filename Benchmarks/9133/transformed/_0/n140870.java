class n140870 {
	public static boolean changeCredentials() {
		boolean Q2cZa1BF = false;
		boolean kGMLF674 = false;
		HashMap ZDFiQaUs = null;
		Debug.log("Main.changeCredentials", "show dialog for userinfo");
		ZDFiQaUs = getUserInfo();
		if ((Boolean) ZDFiQaUs.get("submit")) {
			try {
				MessageDigest ulrPZMyy = MessageDigest.getInstance("MD5");
				ulrPZMyy.update(ZDFiQaUs.get("password").toString().getBytes());
				String fH3WQRCV = new BigInteger(1, ulrPZMyy.digest()).toString(16);
				Debug.log("Main.changeCredentials", "validate credentials with the database");
				Q2cZa1BF = xmlRpcC.checkUser(ZDFiQaUs.get("username").toString(), fH3WQRCV);
				Debug.log("Main.changeCredentials", "write the credentials to file");
				xmlC.writeUserdata(userdataFile, ZDFiQaUs.get("username").toString(), fH3WQRCV);
				kGMLF674 = Q2cZa1BF;
				testVar = true;
			} catch (Exception wt2FLXIB) {
				System.out.println(wt2FLXIB.toString());
				if (wt2FLXIB.getMessage().toLowerCase().contains("unable")) {
					JOptionPane.showMessageDialog(null, "Database problem occured, please try again later", "Error",
							JOptionPane.ERROR_MESSAGE);
					Q2cZa1BF = true;
					testVar = false;
				} else {
					Q2cZa1BF = Boolean.parseBoolean(wt2FLXIB.getMessage());
					JOptionPane.showMessageDialog(null, "Invallid userdata, try again", "Invallid userdata",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			if (new File(userdataFile).exists()) {
				testVar = true;
				kGMLF674 = true;
			} else {
				testVar = false;
				JOptionPane.showMessageDialog(null,
						"No userdata was entered\nNo tests will be executed until you enter them ", "Warning",
						JOptionPane.ERROR_MESSAGE);
			}
			Q2cZa1BF = true;
		}
		while (!Q2cZa1BF) {
			Debug.log("Main.changeCredentials", "show dialog for userinfo");
			ZDFiQaUs = getUserInfo();
			if ((Boolean) ZDFiQaUs.get("submit")) {
				try {
					MessageDigest tSUMqOGY = MessageDigest.getInstance("MD5");
					tSUMqOGY.update(ZDFiQaUs.get("password").toString().getBytes());
					String yovd2FI6 = new BigInteger(1, tSUMqOGY.digest()).toString(16);
					Debug.log("Main.changeCredentials", "validate credentials with the database");
					Q2cZa1BF = xmlRpcC.checkUser(ZDFiQaUs.get("username").toString(), yovd2FI6);
					Debug.log("Main.changeCredentials", "write credentials to local xml file");
					xmlC.writeUserdata(userdataFile, ZDFiQaUs.get("username").toString(), yovd2FI6);
					kGMLF674 = Q2cZa1BF;
					testVar = true;
				} catch (Exception WzpwjUKg) {
					Debug.log("Main.changeCredentials", "credential validation failed");
					Q2cZa1BF = Boolean.parseBoolean(WzpwjUKg.getMessage());
					JOptionPane.showMessageDialog(null, "Invallid userdata, try again", "Invallid userdata",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				if (new File(userdataFile).exists()) {
					testVar = true;
					kGMLF674 = true;
				} else {
					testVar = false;
					JOptionPane.showMessageDialog(null,
							"No userdata was entered\nNo tests will be executed untill u enter them ", "Warning",
							JOptionPane.ERROR_MESSAGE);
				}
				Q2cZa1BF = true;
			}
		}
		return kGMLF674;
	}

}