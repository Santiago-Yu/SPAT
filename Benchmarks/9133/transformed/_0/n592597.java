class n592597 {
	@Override
	public void actionPerformed(ActionEvent ghVEMK1w) {
		if (ghVEMK1w.getSource() == btnRegister) {
			Error.log(6002, "Bot?o cadastrar pressionado por " + login + ".");
			if (nameUser.getText().compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Campo nome requerido");
				nameUser.setFocusable(true);
				return;
			}
			if (loginUser.getText().compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Campo login requerido");
				loginUser.setFocusable(true);
				return;
			}
			String eDvCqQmm = "";
			if (groupUser.getSelectedIndex() == 0)
				eDvCqQmm = "admin";
			else if (groupUser.getSelectedIndex() == 1)
				eDvCqQmm = "user";
			else {
				JOptionPane.showMessageDialog(null, "Campo grupo n?o selecionado");
				return;
			}
			if (new String(passwordUser1.getPassword()).compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Campo senha requerido");
				passwordUser1.setFocusable(true);
				return;
			}
			String QGuDw0c3 = new String(passwordUser1.getPassword());
			String yLQOTtQY = new String(passwordUser2.getPassword());
			if (QGuDw0c3.compareTo(yLQOTtQY) != 0) {
				JOptionPane.showMessageDialog(null, "Senhas n?o casam");
				passwordUser1.setText("");
				passwordUser2.setText("");
				passwordUser1.setFocusable(true);
				return;
			}
			char QqddZ8or = passwordUser1.getPassword()[0];
			int NeiDT1do = 1;
			for (NeiDT1do = 1; NeiDT1do < QGuDw0c3.length(); NeiDT1do++) {
				if (passwordUser1.getPassword()[NeiDT1do] != QqddZ8or) {
					break;
				}
				QqddZ8or = passwordUser1.getPassword()[NeiDT1do];
			}
			if (NeiDT1do == QGuDw0c3.length()) {
				JOptionPane.showMessageDialog(null, "Senha fraca");
				return;
			}
			if (QGuDw0c3.length() < 6) {
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
			ResultSet cLjqFeNS;
			Statement KU6eAm8G;
			String DgaBTbhf;
			String LaXQdiWF = "";
			DgaBTbhf = "select login from Usuarios where login='" + loginUser.getText() + "'";
			try {
				theConn = DatabaseConnection.getConnection();
				KU6eAm8G = theConn.createStatement();
				cLjqFeNS = KU6eAm8G.executeQuery(DgaBTbhf);
				while (cLjqFeNS.next()) {
					LaXQdiWF = cLjqFeNS.getString("login");
				}
				cLjqFeNS.close();
				KU6eAm8G.close();
			} catch (Exception mt4CLytL) {
				mt4CLytL.printStackTrace();
			} finally {
				try {
					if (theConn != null)
						theConn.close();
				} catch (Exception a2ykN3gD) {
				}
			}
			if (LaXQdiWF.compareTo("") != 0) {
				JOptionPane.showMessageDialog(null, "Login " + LaXQdiWF + " j? existe");
				loginUser.setText("");
				loginUser.setFocusable(true);
				return;
			}
			String HQ8KpJjG = "";
			try {
				MessageDigest f9CAhWp4 = MessageDigest.getInstance("SHA1");
				f9CAhWp4.update(QGuDw0c3.getBytes());
				BigInteger Wi83Apij = new BigInteger(1, f9CAhWp4.digest());
				HQ8KpJjG = Wi83Apij.toString(16);
			} catch (NoSuchAlgorithmException i4BP900G) {
				i4BP900G.printStackTrace();
			}
			DgaBTbhf = "insert into Usuarios (login,password,tries_personal,tries_one_use,"
					+ "grupo,description) values " + "('" + loginUser.getText() + "','" + HQ8KpJjG + "',0,0,'"
					+ eDvCqQmm + "','" + nameUser.getText() + "')";
			try {
				theConn = DatabaseConnection.getConnection();
				KU6eAm8G = theConn.createStatement();
				KU6eAm8G.executeUpdate(DgaBTbhf);
				KU6eAm8G.close();
			} catch (Exception XEmlcDN8) {
				XEmlcDN8.printStackTrace();
			} finally {
				try {
					if (theConn != null)
						theConn.close();
				} catch (Exception TtLvwKnN) {
				}
			}
			Random UvbvihFY = new Random();
			int Yq6LUPqT;
			Vector<Integer> qlHYsULY = new Vector<Integer>();
			for (NeiDT1do = 0; NeiDT1do < Integer.parseInt(numPasswordOneUseUser.getText()); NeiDT1do++) {
				Yq6LUPqT = UvbvihFY.nextInt() % 10000;
				if (Yq6LUPqT < 0)
					Yq6LUPqT = Yq6LUPqT * (-1);
				qlHYsULY.add(Yq6LUPqT);
			}
			try {
				BufferedWriter M8o7KVNE = new BufferedWriter(new FileWriter(loginUser.getText() + ".txt", false));
				for (NeiDT1do = 0; NeiDT1do < Integer.parseInt(numPasswordOneUseUser.getText()); NeiDT1do++) {
					M8o7KVNE.append("" + NeiDT1do + " " + qlHYsULY.get(NeiDT1do) + "\n");
				}
				M8o7KVNE.close();
				try {
					for (NeiDT1do = 0; NeiDT1do < Integer.parseInt(numPasswordOneUseUser.getText()); NeiDT1do++) {
						MessageDigest EWYGGkDZ = MessageDigest.getInstance("SHA1");
						EWYGGkDZ.update(qlHYsULY.get(NeiDT1do).toString().getBytes());
						BigInteger RRIZIBcF = new BigInteger(1, EWYGGkDZ.digest());
						String p7TFnIaR = RRIZIBcF.toString(16);
						DgaBTbhf = "insert into Senhas_De_Unica_Vez (login,key,password) values " + "('"
								+ loginUser.getText() + "'," + NeiDT1do + ",'" + p7TFnIaR + "')";
						try {
							theConn = DatabaseConnection.getConnection();
							KU6eAm8G = theConn.createStatement();
							KU6eAm8G.executeUpdate(DgaBTbhf);
							KU6eAm8G.close();
						} catch (Exception E51GK4u2) {
							E51GK4u2.printStackTrace();
						} finally {
							try {
								if (theConn != null)
									theConn.close();
							} catch (Exception RWvYvtp2) {
							}
						}
					}
				} catch (NoSuchAlgorithmException ndzFE5em) {
					ndzFE5em.printStackTrace();
				}
			} catch (IOException Wnlrh4j9) {
				Wnlrh4j9.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Usu?rio " + loginUser.getText() + " foi cadastrado com sucesso.");
			dispose();
		}
		if (ghVEMK1w.getSource() == btnCancel) {
			Error.log(6003, "Bot?o voltar de cadastrar para o menu principal pressionado por " + login + ".");
			dispose();
		}
	}

}