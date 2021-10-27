class n17721652 {
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			email.setText("");
			name.setText("");
			category.setSelectedIndex(0);
			subject.setText("");
			message.setText("");
			setVisible(false);
		} else {
			StringBuffer errors = new StringBuffer();
			if (email.getText().trim().equals(""))
				errors.append("El campo 'Email' es obligatorio<br/>");
			if (name.getText().trim().equals(""))
				errors.append("El campo 'Nombre' es obligatorio<br/>");
			if (subject.getText().trim().equals(""))
				errors.append("El campo 'T?tulo' es obligatorio<br/>");
			if (message.getText().trim().equals(""))
				errors.append("No hay conrtenido en el mensaje<br/>");
			if (errors.length() > 0) {
				JOptionPane.showMessageDialog(this, "<html><b>Error</b><br/>" + errors.toString() + "</html>", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					StringBuffer params = new StringBuffer();
					params.append("name=").append(URLEncoder.encode(name.getText(), "UTF-8")).append("&category=")
							.append(URLEncoder.encode((String) category.getSelectedItem(), "UTF-8")).append("&title=")
							.append(URLEncoder.encode(subject.getText(), "UTF-8")).append("&email=")
							.append(URLEncoder.encode(email.getText(), "UTF-8")).append("&id=")
							.append(URLEncoder.encode(MainWindow.getUserPreferences().getUniqueId() + "", "UTF-8"))
							.append("&body=").append(URLEncoder.encode(message.getText(), "UTF-8"));
					URL url = new URL("http://www.cronopista.com/diccionario2/sendMessage.php");
					URLConnection connection = url.openConnection();
					Utils.setupProxy(connection);
					connection.setDoOutput(true);
					OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
					out.write(params.toString());
					out.close();
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String decodedString;
					for (; (decodedString = in.readLine()) != null;) {
						System.out.println(decodedString);
					}
					in.close();
					email.setText("");
					name.setText("");
					category.setSelectedIndex(0);
					subject.setText("");
					message.setText("");
					setVisible(false);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this,
							"<html><b>Error</b><br/>Ha ocurrido un error enviando tu mensaje.<br/>"
									+ "Por favor, int?ntalo m?s tarde o ponte en contacto conmigo a trav?s de www.cronopista.com</html>",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}