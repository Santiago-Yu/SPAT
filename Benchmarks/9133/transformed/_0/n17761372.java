class n17761372 {
	public void run() {
		try {
			String CWvH80Ew = URLEncoder.encode("send_id", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");
			CWvH80Ew += "&" + URLEncoder.encode("author", "UTF-8") + "=" + URLEncoder.encode(name.getText(), "UTF-8");
			CWvH80Ew += "&" + URLEncoder.encode("location", "UTF-8") + "="
					+ URLEncoder.encode(System.getProperty("user.language"), "UTF-8");
			CWvH80Ew += "&" + URLEncoder.encode("contact", "UTF-8") + "=" + URLEncoder.encode(email.getText(), "UTF-8");
			CWvH80Ew += "&" + URLEncoder.encode("content", "UTF-8") + "="
					+ URLEncoder.encode(comment.getText(), "UTF-8");
			CWvH80Ew += "&" + URLEncoder.encode("rate", "UTF-8") + "="
					+ URLEncoder.encode(rate.getSelectedItem().toString(), "UTF-8");
			System.out.println(CWvH80Ew);
			URL qdvElOba = new URL("http://javablock.sourceforge.net/book/index.php");
			URLConnection hAHwaxgZ = qdvElOba.openConnection();
			hAHwaxgZ.setDoOutput(true);
			OutputStreamWriter Yx8GEj7V = new OutputStreamWriter(hAHwaxgZ.getOutputStream());
			Yx8GEj7V.write(CWvH80Ew);
			Yx8GEj7V.flush();
			BufferedReader Nsn0bB31 = new BufferedReader(new InputStreamReader(hAHwaxgZ.getInputStream()));
			String Pv4UOqYl = Nsn0bB31.readLine();
			JPanel V2vEOF8l = new JPanel();
			V2vEOF8l.add(new JLabel("Comment added"));
			V2vEOF8l.add(new JTextArea("visit: http://javablock.sourceforge.net/"));
			JOptionPane.showMessageDialog(null, new JLabel("Comment sended correctly!"));
			Yx8GEj7V.close();
			Nsn0bB31.close();
			hide();
		} catch (IOException MyKK5qbd) {
			Logger.getLogger(guestBook.class.getName()).log(Level.SEVERE, null, MyKK5qbd);
		}
	}

}