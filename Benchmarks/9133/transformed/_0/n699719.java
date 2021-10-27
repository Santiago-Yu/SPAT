class n699719 {
	@Override
	public void actionPerformed(ActionEvent oWCKy4gQ) {
		if (oWCKy4gQ.getSource() == btnClear) {
			passwordField.setText("");
		}
		for (int FQmcIj3E = 0; FQmcIj3E < 10; FQmcIj3E++) {
			if (oWCKy4gQ.getSource() == btnNumber[FQmcIj3E]) {
				String GIkHbsOS = new String((passwordField.getPassword()));
				passwordField.setText(GIkHbsOS + FQmcIj3E);
			}
		}
		if (oWCKy4gQ.getSource() == btnOK) {
			String cDWcXk1u = new String((passwordField.getPassword()));
			ResultSet uMBIRrAl;
			Statement NJAergrk;
			String rxbcbnAn;
			String iNZBofNP = "";
			boolean KNSk2KCX = false;
			rxbcbnAn = "select password from Senhas_De_Unica_Vez where login='" + login + "'" + " and key=" + key + " ";
			try {
				theConn = DatabaseConnection.getConnection();
				NJAergrk = theConn.createStatement();
				uMBIRrAl = NJAergrk.executeQuery(rxbcbnAn);
				while (uMBIRrAl.next()) {
					iNZBofNP = uMBIRrAl.getString("password");
				}
				uMBIRrAl.close();
				NJAergrk.close();
				try {
					MessageDigest UJaxkObV = MessageDigest.getInstance("SHA1");
					UJaxkObV.update(cDWcXk1u.getBytes());
					BigInteger opRjTRsA = new BigInteger(1, UJaxkObV.digest());
					String BBmq4d8I = opRjTRsA.toString(16);
					if (BBmq4d8I.compareTo(iNZBofNP) == 0)
						KNSk2KCX = true;
					else
						KNSk2KCX = false;
				} catch (NoSuchAlgorithmException OZzg9e6q) {
					OZzg9e6q.printStackTrace();
				}
			} catch (Exception xj2jzTnd) {
				xj2jzTnd.printStackTrace();
			} finally {
				try {
					if (theConn != null)
						theConn.close();
				} catch (Exception kHjRlmfu) {
				}
			}
			if (KNSk2KCX == true) {
				JOptionPane.showMessageDialog(null, "senha correta!");
				rxbcbnAn = "delete from Senhas_De_Unica_Vez where login='" + login + "'" + " and key=" + key + " ";
				try {
					theConn = DatabaseConnection.getConnection();
					NJAergrk = theConn.createStatement();
					NJAergrk.executeUpdate(rxbcbnAn);
					NJAergrk.close();
				} catch (Exception GiTvh0Td) {
					GiTvh0Td.printStackTrace();
				} finally {
					try {
						if (theConn != null)
							theConn.close();
					} catch (Exception wofazPF9) {
					}
				}
				setVisible(false);
				setTries(0);
				Error.log(4003, "Senha de uso ?nico verificada positivamente.");
				Error.log(4002, "Autentica??o etapa 3 encerrada.");
				ManagerWindow FLfivnMz = new ManagerWindow(login);
				FLfivnMz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			} else {
				JOptionPane.showMessageDialog(null, "senha incorreta!");
				int FN38wIAe = getTries();
				if (FN38wIAe == 0) {
					Error.log(4004, "Primeiro erro da senha de uso ?nico contabilizado.");
				} else if (FN38wIAe == 1) {
					Error.log(4005, "Segundo erro da senha de uso ?nico contabilizado.");
				} else if (FN38wIAe == 2) {
					Error.log(4006, "Terceiro erro da senha de uso ?nico contabilizado.");
					Error.log(4007, "Acesso do usuario " + login + " bloqueado pela autentica??o etapa 3.");
					Error.log(4002, "Autentica??o etapa 3 encerrada.");
					Error.log(1002, "Sistema encerrado.");
					setTries(++FN38wIAe);
					System.exit(1);
				}
				setTries(++FN38wIAe);
			}
		}
	}

}