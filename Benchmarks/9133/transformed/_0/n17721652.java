class n17721652 {
	public void actionPerformed(ActionEvent ZklfeFCe) {
		if (ZklfeFCe.getSource() == cancel) {
			email.setText("");
			name.setText("");
			category.setSelectedIndex(0);
			subject.setText("");
			message.setText("");
			setVisible(false);
		} else {
			StringBuffer hN7WQEUM = new StringBuffer();
			if (email.getText().trim().equals(""))
				hN7WQEUM.append("El campo 'Email' es obligatorio<br/>");
			if (name.getText().trim().equals(""))
				hN7WQEUM.append("El campo 'Nombre' es obligatorio<br/>");
			if (subject.getText().trim().equals(""))
				hN7WQEUM.append("El campo 'T?tulo' es obligatorio<br/>");
			if (message.getText().trim().equals(""))
				hN7WQEUM.append("No hay conrtenido en el mensaje<br/>");
			if (hN7WQEUM.length() > 0) {
				JOptionPane.showMessageDialog(this, "<html><b>Error</b><br/>" + hN7WQEUM.toString() + "</html>",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					StringBuffer p6YgwoPg = new StringBuffer();
					p6YgwoPg.append("name=").append(URLEncoder.encode(name.getText(), "UTF-8")).append("&category=")
							.append(URLEncoder.encode((String) category.getSelectedItem(), "UTF-8")).append("&title=")
							.append(URLEncoder.encode(subject.getText(), "UTF-8")).append("&email=")
							.append(URLEncoder.encode(email.getText(), "UTF-8")).append("&id=")
							.append(URLEncoder.encode(MainWindow.getUserPreferences().getUniqueId() + "", "UTF-8"))
							.append("&body=").append(URLEncoder.encode(message.getText(), "UTF-8"));
					URL JSOqh2XD = new URL("http://www.cronopista.com/diccionario2/sendMessage.php");
					URLConnection qL2ptJav = JSOqh2XD.openConnection();
					Utils.setupProxy(qL2ptJav);
					qL2ptJav.setDoOutput(true);
					OutputStreamWriter FGZ1rwwQ = new OutputStreamWriter(qL2ptJav.getOutputStream());
					FGZ1rwwQ.write(p6YgwoPg.toString());
					FGZ1rwwQ.close();
					BufferedReader P1VBFfQH = new BufferedReader(new InputStreamReader(qL2ptJav.getInputStream()));
					String J2Vp1O2v;
					while ((J2Vp1O2v = P1VBFfQH.readLine()) != null) {
						System.out.println(J2Vp1O2v);
					}
					P1VBFfQH.close();
					email.setText("");
					name.setText("");
					category.setSelectedIndex(0);
					subject.setText("");
					message.setText("");
					setVisible(false);
				} catch (Exception d9UqVJL9) {
					JOptionPane.showMessageDialog(this,
							"<html><b>Error</b><br/>Ha ocurrido un error enviando tu mensaje.<br/>"
									+ "Por favor, int?ntalo m?s tarde o ponte en contacto conmigo a trav?s de www.cronopista.com</html>",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}