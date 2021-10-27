class n631632 {
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnChange) {
			Error.log(7002, "Bot?o alterar pressionado por " + login + ".");
			if (new String(passwordUser1.getPassword()).compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Campo senha requerido");
				passwordUser1.setFocusable(true);
				return;
			}
			String password1 = new String(passwordUser1.getPassword());
			String password2 = new String(passwordUser2.getPassword());
			if (password1.compareTo(password2) != 0) {
				JOptionPane.showMessageDialog(null, "Senhas n?o casam");
				passwordUser1.setText("");
				passwordUser2.setText("");
				passwordUser1.setFocusable(true);
				return;
			}
			int j = 1;
			char c = passwordUser1.getPassword()[0];
			for (j = 1; j < password1.length(); j++) {
				if (passwordUser1.getPassword()[j] != c) {
					break;
				}
				c = passwordUser1.getPassword()[j];
			}
			if (j == password1.length()) {
				JOptionPane.showMessageDialog(null, "Senha fraca");
				return;
			}
			if (password1.length() < 6) {
				JOptionPane.showMessageDialog(null, "Senha deve ter mais que 6 digitos");
				return;
			}
			if (numPasswordOneUseUser.getText().compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Campo n?mero de senhas de uso ?nico requerido");
				return;
			}
			String outputDigest = "";
			if (!(Integer.parseInt(numPasswordOneUseUser.getText()) > 0
					&& Integer.parseInt(numPasswordOneUseUser.getText()) < 41)) {
				JOptionPane.showMessageDialog(null, "N?mero de senhas de uso ?nico entre 1 e 40");
				return;
			}
			Statement stmt;
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
				messageDigest.update(password1.getBytes());
				BigInteger bigInt = new BigInteger(1, messageDigest.digest());
				outputDigest = bigInt.toString(16);
			} catch (NoSuchAlgorithmException exception) {
				exception.printStackTrace();
			}
			String sql;
			sql = "update Usuarios set password = '" + outputDigest + "' where login='" + login + "'";
			try {
				theConn = DatabaseConnection.getConnection();
				stmt = theConn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			} finally {
				try {
					if (theConn != null)
						theConn.close();
				} catch (Exception exception) {
				}
			}
			sql = "delete from Senhas_De_Unica_Vez where login='" + login + "'";
			Random rn = new Random();
			try {
				theConn = DatabaseConnection.getConnection();
				stmt = theConn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			} finally {
				try {
					if (theConn != null)
						theConn.close();
				} catch (Exception exception) {
				}
			}
			Vector<Integer> passwordVector = new Vector<Integer>();
			int r;
			for (int i = 0; i < Integer.parseInt(numPasswordOneUseUser.getText()); i++) {
				r = rn.nextInt() % 10000;
				if (r < 0)
					r = r * (-1);
				passwordVector.add(r);
			}
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(login + ".txt", false));
				for (int i = 0; i < Integer.parseInt(numPasswordOneUseUser.getText()); i++) {
					out.append("" + i + " " + passwordVector.get(i) + "\n");
				}
				out.close();
				try {
					for (int i = 0; i < Integer.parseInt(numPasswordOneUseUser.getText()); i++) {
						MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
						messageDigest.update(passwordVector.get(i).toString().getBytes());
						BigInteger bigInt = new BigInteger(1, messageDigest.digest());
						String digest = bigInt.toString(16);
						sql = "insert into Senhas_De_Unica_Vez (login,key,password) values " + "('" + login + "'," + i
								+ ",'" + digest + "')";
						try {
							theConn = DatabaseConnection.getConnection();
							stmt = theConn.createStatement();
							stmt.executeUpdate(sql);
							stmt.close();
						} catch (Exception exception) {
							exception.printStackTrace();
						} finally {
							try {
								if (theConn != null)
									theConn.close();
							} catch (Exception exception) {
							}
						}
					}
				} catch (NoSuchAlgorithmException exception) {
					exception.printStackTrace();
				}
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Usu?rio " + login + " foi alterado com sucesso.");
			dispose();
		}
		if (event.getSource() == btnCancel) {
			Error.log(7003, "Bot?o voltar de alterar para o menu principal pressionado por " + login + ".");
			dispose();
		}
	}

}