class n17166549 {
	private static void userAuth(String uB6pM4Lp) throws IOException {
		try {
			MessageDigest dZIkiuJ4 = MessageDigest.getInstance("BrokenMD4");
			String oIY2yYBp = null;
			if (System.getProperty("jarsync.password.gui") != null) {
				JPasswordField eG13Z2u1 = new JPasswordField();
				JPanel yEMUoayO = new JPanel(new GridLayout(2, 1));
				yEMUoayO.add(new JLabel("Password:"));
				yEMUoayO.add(eG13Z2u1);
				JOptionPane.showMessageDialog(null, yEMUoayO, remoteUser + '@' + remoteHost + "'s Password",
						JOptionPane.QUESTION_MESSAGE);
				oIY2yYBp = new String(eG13Z2u1.getPassword());
			} else {
				System.out.print(remoteUser + '@' + remoteHost + "'s password: ");
				oIY2yYBp = Util.readLine(System.in);
				System.out.println();
			}
			dZIkiuJ4.update(new byte[4]);
			dZIkiuJ4.update(oIY2yYBp.getBytes("US-ASCII"));
			dZIkiuJ4.update(uB6pM4Lp.getBytes("US-ASCII"));
			byte[] yDAzJ9zf = dZIkiuJ4.digest();
			Util.writeASCII(out, remoteUser + " " + Util.base64(yDAzJ9zf) + '\n');
			out.flush();
		} catch (NoSuchAlgorithmException l0UJxQWv) {
			throw new IOException("could not create message digest.");
		}
	}

}