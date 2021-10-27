class n592597 {
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegister) {
			Error.log(6002, "Bot?o cadastrar pressionado por " + login + ".");
			if (nameUser.getText().compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Campo nome requerido");
				nameUser.setFocusable(true);
				return;
			}
			String group = "";
			if (loginUser.getText().compareTo("") == 0) {
				JOptionPane.showMessageDialog(null, "Campo login requerido");
				loginUser.setFocusable(true);
				return;
			}
			if (groupUser.getSelectedIndex() == 0)
				group = "admin";
			else if (groupUser.getSelectedIndex() == 1)
				group = "user";
			else {
				JOptionPane.showMessageDialog(null, "Campo grupo n?o selecionado");
				return;
			}
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
			int i = 1;
			char c = passwordUser1.getPassword()[0];
			for (i = 1; i < password1.length(); i++) {
				if (passwordUser1.getPassword()[i] != c) {
					break;
				}
				c = passwordUser1.getPassword()[i];
			}
			if (i == password1.length()) {
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
			ResultSet rs;
			if (!(Integer.parseInt(numPasswordOneUseUser.getText()) > 0
					&& Integer.parseInt(numPasswordOneUseUser.getText()) < 41)) {
				JOptionPane.showMessageDialog(null, "N?mero de senhas de uso ?nico entre 1 e 40");
				return;
			}
			String sql;
			Statement stmt;
			sql = "select login from Usuarios where login='" + loginUser.getText() + "'";
			String result = "";
			try {
				theConn = DatabaseConnection.getConnection();
				stmt = theConn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					result = rs.getString("login");
				}
				rs.close();
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
			String outputDigest = "";
			if (result.compareTo("") != 0) {
				JOptionPane.showMessageDialog(null, "Login " + result + " j? existe");
				loginUser.setText("");
				loginUser.setFocusable(true);
				return;
			}
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
				messageDigest.update(password1.getBytes());
				BigInteger bigInt = new BigInteger(1, messageDigest.digest());
				outputDigest = bigInt.toString(16);
			} catch (NoSuchAlgorithmException exception) {
				exception.printStackTrace();
			}
			sql = "insert into Usuarios (login,password,tries_personal,tries_one_use," + "grupo,description) values "
					+ "('" + loginUser.getText() + "','" + outputDigest + "',0,0,'" + group + "','" + nameUser.getText()
					+ "')";
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
			for (i = 0; i < Integer.parseInt(numPasswordOneUseUser.getText()); i++) {
				r = rn.nextInt() % 10000;
				if (r < 0)
					r = r * (-1);
				passwordVector.add(r);
			}
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(loginUser.getText() + ".txt", false));
				for (i = 0; i < Integer.parseInt(numPasswordOneUseUser.getText()); i++) {
					out.append("" + i + " " + passwordVector.get(i) + "\n");
				}
				out.close();
				try {
					for (i = 0; i < Integer.parseInt(numPasswordOneUseUser.getText()); i++) {
						MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
						messageDigest.update(passwordVector.get(i).toString().getBytes());
						BigInteger bigInt = new BigInteger(1, messageDigest.digest());
						String digest = bigInt.toString(16);
						sql = "insert into Senhas_De_Unica_Vez (login,key,password) values " + "('"
								+ loginUser.getText() + "'," + i + ",'" + digest + "')";
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
			JOptionPane.showMessageDialog(null, "Usu?rio " + loginUser.getText() + " foi cadastrado com sucesso.");
			dispose();
		}
		if (e.getSource() == btnCancel) {
			Error.log(6003, "Bot?o voltar de cadastrar para o menu principal pressionado por " + login + ".");
			dispose();
		}
	}

}