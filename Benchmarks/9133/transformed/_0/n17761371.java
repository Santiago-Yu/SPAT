class n17761371 {
	private void sendActionPerformed(java.awt.event.ActionEvent vTyOvxZe) {
		if (name.getText().length() < 3) {
			JOptionPane.showMessageDialog(comment, "Too short name (at least 3)");
			return;
		}
		if (comment.getText().length() < 10) {
			JOptionPane.showMessageDialog(comment, "Too short comment (at least 10)");
			return;
		}
		Thread wEe1CS0e = new Thread(new Runnable() {

			public void run() {
				try {
					String xUfX2ixp = URLEncoder.encode("send_id", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");
					xUfX2ixp += "&" + URLEncoder.encode("author", "UTF-8") + "="
							+ URLEncoder.encode(name.getText(), "UTF-8");
					xUfX2ixp += "&" + URLEncoder.encode("location", "UTF-8") + "="
							+ URLEncoder.encode(System.getProperty("user.language"), "UTF-8");
					xUfX2ixp += "&" + URLEncoder.encode("contact", "UTF-8") + "="
							+ URLEncoder.encode(email.getText(), "UTF-8");
					xUfX2ixp += "&" + URLEncoder.encode("content", "UTF-8") + "="
							+ URLEncoder.encode(comment.getText(), "UTF-8");
					xUfX2ixp += "&" + URLEncoder.encode("rate", "UTF-8") + "="
							+ URLEncoder.encode(rate.getSelectedItem().toString(), "UTF-8");
					System.out.println(xUfX2ixp);
					URL hgW3EU38 = new URL("http://javablock.sourceforge.net/book/index.php");
					URLConnection jJPdft0P = hgW3EU38.openConnection();
					jJPdft0P.setDoOutput(true);
					OutputStreamWriter jzq6ecbB = new OutputStreamWriter(jJPdft0P.getOutputStream());
					jzq6ecbB.write(xUfX2ixp);
					jzq6ecbB.flush();
					BufferedReader lhdrHqv7 = new BufferedReader(new InputStreamReader(jJPdft0P.getInputStream()));
					String yvfawITL = lhdrHqv7.readLine();
					JPanel aFdS3T97 = new JPanel();
					aFdS3T97.add(new JLabel("Comment added"));
					aFdS3T97.add(new JTextArea("visit: http://javablock.sourceforge.net/"));
					JOptionPane.showMessageDialog(null, new JLabel("Comment sended correctly!"));
					jzq6ecbB.close();
					lhdrHqv7.close();
					hide();
				} catch (IOException vyLhCr0N) {
					Logger.getLogger(guestBook.class.getName()).log(Level.SEVERE, null, vyLhCr0N);
				}
			}
		});
		wEe1CS0e.start();
	}

}