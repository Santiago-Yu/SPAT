class n750310 {
	public static boolean changeCredentials() {
		boolean WnzTVfK1 = false;
		boolean fEu64Qye = false;
		HashMap G1M2GNVA = null;
		Debug.log("Main.changeCredentials", "show dialog for userinfo");
		G1M2GNVA = getUserInfo();
		if ((Boolean) G1M2GNVA.get("submit")) {
			try {
				MessageDigest r6xLqpBM = MessageDigest.getInstance("MD5");
				r6xLqpBM.update(G1M2GNVA.get("password").toString().getBytes());
				String uT0ZUnhC = new BigInteger(1, r6xLqpBM.digest()).toString(16);
				Debug.log("Main.changeCredentials", "validate credentials with the database");
				WnzTVfK1 = xmlRpcC.checkUser(G1M2GNVA.get("username").toString(), uT0ZUnhC);
				Debug.log("Main.changeCredentials", "write the credentials to file");
				xmlC.writeUserdata(userdataFile, G1M2GNVA.get("username").toString(), uT0ZUnhC);
				fEu64Qye = WnzTVfK1;
				testVar = true;
			} catch (Exception lvM2owRM) {
				System.out.println(lvM2owRM.toString());
				if (lvM2owRM.getMessage().toLowerCase().contains("unable")) {
					JOptionPane.showMessageDialog(null, "Database problem occured, please try again later", "Error",
							JOptionPane.ERROR_MESSAGE);
					WnzTVfK1 = true;
					testVar = false;
				} else {
					WnzTVfK1 = Boolean.parseBoolean(lvM2owRM.getMessage());
					JOptionPane.showMessageDialog(null, "Invallid userdata, try again", "Invallid userdata",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			if (new File(userdataFile).exists()) {
				testVar = true;
				fEu64Qye = true;
			} else {
				testVar = false;
				JOptionPane.showMessageDialog(null,
						"No userdata was entered\nNo tests will be executed until you enter them ", "Warning",
						JOptionPane.ERROR_MESSAGE);
			}
			WnzTVfK1 = true;
		}
		while (!WnzTVfK1) {
			Debug.log("Main.changeCredentials", "show dialog for userinfo");
			G1M2GNVA = getUserInfo();
			if ((Boolean) G1M2GNVA.get("submit")) {
				try {
					MessageDigest QRiQYERf = MessageDigest.getInstance("MD5");
					QRiQYERf.update(G1M2GNVA.get("password").toString().getBytes());
					String dW06563g = new BigInteger(1, QRiQYERf.digest()).toString(16);
					Debug.log("Main.changeCredentials", "validate credentials with the database");
					WnzTVfK1 = xmlRpcC.checkUser(G1M2GNVA.get("username").toString(), dW06563g);
					Debug.log("Main.changeCredentials", "write credentials to local xml file");
					xmlC.writeUserdata(userdataFile, G1M2GNVA.get("username").toString(), dW06563g);
					fEu64Qye = WnzTVfK1;
					testVar = true;
				} catch (Exception kjvhZy4i) {
					Debug.log("Main.changeCredentials", "credential validation failed");
					WnzTVfK1 = Boolean.parseBoolean(kjvhZy4i.getMessage());
					JOptionPane.showMessageDialog(null, "Invallid userdata, try again", "Invallid userdata",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				if (new File(userdataFile).exists()) {
					testVar = true;
					fEu64Qye = true;
				} else {
					testVar = false;
					JOptionPane.showMessageDialog(null,
							"No userdata was entered\nNo tests will be executed untill u enter them ", "Warning",
							JOptionPane.ERROR_MESSAGE);
				}
				WnzTVfK1 = true;
			}
		}
		return fEu64Qye;
	}

}