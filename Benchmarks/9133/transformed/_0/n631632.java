class n631632 {
	@Override
	public void actionPerformed(ActionEvent SDmMzUy8) {
		if (SDmMzUy8.getSource() == btnChange) {
			Error.log(7002, "Bot?o alterar pressionado por " + login + ".");
			if (new String(passwordUser1.getPassword()).compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Campo senha requerido");
				passwordUser1.setFocusable(true);
				return;
			}
			String frEy6p9U = new String(passwordUser1.getPassword());
			String tUqkNnjH = new String(passwordUser2.getPassword());
			if (frEy6p9U.compareTo(tUqkNnjH) != 0) {
				JOptionPane.showMessageDialog(null, "Senhas n?o casam");
				passwordUser1.setText("");
				passwordUser2.setText("");
				passwordUser1.setFocusable(true);
				return;
			}
			char DktIBTSO = passwordUser1.getPassword()[0];
			int L8Qr6Ne9 = 1;
			for (L8Qr6Ne9 = 1; L8Qr6Ne9 < frEy6p9U.length(); L8Qr6Ne9++) {
				if (passwordUser1.getPassword()[L8Qr6Ne9] != DktIBTSO) {
					break;
				}
				DktIBTSO = passwordUser1.getPassword()[L8Qr6Ne9];
			}
			if (L8Qr6Ne9 == frEy6p9U.length()) {
				JOptionPane.showMessageDialog(null, "Senha fraca");
				return;
			}
			if (frEy6p9U.length() < 6) {
				JOptionPane.showMessageDialog(null, "Senha deve ter mais que 6 digitos");
				return;
			}
			if (numPasswordOneUseUser.getText().compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Campo n?mero de senhas de uso ?nico requerido");
				return;
			}
			if (!(Integer.parseInt(numPasswordOneUseUser.getText()) > 0
					&& Integer.parseInt(numPasswordOneUseUser.getText()) < 41)) {
				JOptionPane.showMessageDialog(null, "N?mero de senhas de uso ?nico entre 1 e 40");
				return;
			}
			String Mo2snwwj = "";
			try {
				MessageDigest ywh7hvwF = MessageDigest.getInstance("SHA1");
				ywh7hvwF.update(frEy6p9U.getBytes());
				BigInteger wusPnB8h = new BigInteger(1, ywh7hvwF.digest());
				Mo2snwwj = wusPnB8h.toString(16);
			} catch (NoSuchAlgorithmException yTAsNIJk) {
				yTAsNIJk.printStackTrace();
			}
			Statement aKBR8D2N;
			String XkCwQifT;
			XkCwQifT = "update Usuarios set password = '" + Mo2snwwj + "' where login='" + login + "'";
			try {
				theConn = DatabaseConnection.getConnection();
				aKBR8D2N = theConn.createStatement();
				aKBR8D2N.executeUpdate(XkCwQifT);
				aKBR8D2N.close();
			} catch (Exception tY8I6zp0) {
				tY8I6zp0.printStackTrace();
			} finally {
				try {
					if (theConn != null)
						theConn.close();
				} catch (Exception WVNB0Xy0) {
				}
			}
			XkCwQifT = "delete from Senhas_De_Unica_Vez where login='" + login + "'";
			try {
				theConn = DatabaseConnection.getConnection();
				aKBR8D2N = theConn.createStatement();
				aKBR8D2N.executeUpdate(XkCwQifT);
				aKBR8D2N.close();
			} catch (Exception oXedyQOV) {
				oXedyQOV.printStackTrace();
			} finally {
				try {
					if (theConn != null)
						theConn.close();
				} catch (Exception xyDrqf7p) {
				}
			}
			Random Gl2ZnOly = new Random();
			int D9ibdl4n;
			Vector<Integer> cU1VzDv8 = new Vector<Integer>();
			for (int s9KpahrU = 0; s9KpahrU < Integer.parseInt(numPasswordOneUseUser.getText()); s9KpahrU++) {
				D9ibdl4n = Gl2ZnOly.nextInt() % 10000;
				if (D9ibdl4n < 0)
					D9ibdl4n = D9ibdl4n * (-1);
				cU1VzDv8.add(D9ibdl4n);
			}
			try {
				BufferedWriter DrVJDJ9R = new BufferedWriter(new FileWriter(login + ".txt", false));
				for (int Ztcn8WJu = 0; Ztcn8WJu < Integer.parseInt(numPasswordOneUseUser.getText()); Ztcn8WJu++) {
					DrVJDJ9R.append("" + Ztcn8WJu + " " + cU1VzDv8.get(Ztcn8WJu) + "\n");
				}
				DrVJDJ9R.close();
				try {
					for (int wt7v35Z7 = 0; wt7v35Z7 < Integer.parseInt(numPasswordOneUseUser.getText()); wt7v35Z7++) {
						MessageDigest TVfBfupG = MessageDigest.getInstance("SHA1");
						TVfBfupG.update(cU1VzDv8.get(wt7v35Z7).toString().getBytes());
						BigInteger HFzqxKEv = new BigInteger(1, TVfBfupG.digest());
						String LjeKMetI = HFzqxKEv.toString(16);
						XkCwQifT = "insert into Senhas_De_Unica_Vez (login,key,password) values " + "('" + login + "',"
								+ wt7v35Z7 + ",'" + LjeKMetI + "')";
						try {
							theConn = DatabaseConnection.getConnection();
							aKBR8D2N = theConn.createStatement();
							aKBR8D2N.executeUpdate(XkCwQifT);
							aKBR8D2N.close();
						} catch (Exception l94ayV6o) {
							l94ayV6o.printStackTrace();
						} finally {
							try {
								if (theConn != null)
									theConn.close();
							} catch (Exception oUayAXBx) {
							}
						}
					}
				} catch (NoSuchAlgorithmException sfmkl7sQ) {
					sfmkl7sQ.printStackTrace();
				}
			} catch (IOException mY1VVAgr) {
				mY1VVAgr.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Usu?rio " + login + " foi alterado com sucesso.");
			dispose();
		}
		if (SDmMzUy8.getSource() == btnCancel) {
			Error.log(7003, "Bot?o voltar de alterar para o menu principal pressionado por " + login + ".");
			dispose();
		}
	}

}