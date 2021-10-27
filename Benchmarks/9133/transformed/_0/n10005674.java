class n10005674 {
	public String post() {
		if (content == null || content.equals(""))
			return "Type something to publish!!";
		OutputStreamWriter JzJm56ZC = null;
		BufferedReader PUp7nPQT = null;
		try {
			String fkHa77lr = URLEncoder.encode("api", "UTF-8") + "=" + URLEncoder.encode(apiKey, "UTF-8");
			fkHa77lr += "&" + URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(content, "UTF-8");
			fkHa77lr += "&" + URLEncoder.encode("description", "UTF-8") + "="
					+ URLEncoder.encode(descriptionTextArea.getText() + description_suffix, "UTF-8");
			fkHa77lr += "&" + URLEncoder.encode("expiry", "UTF-8") + "="
					+ URLEncoder.encode((String) expiryComboBox.getSelectedItem(), "UTF-8");
			fkHa77lr += "&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8");
			fkHa77lr += "&" + URLEncoder.encode("name", "UTF-8") + "="
					+ URLEncoder.encode(nameTextBox.getText(), "UTF-8");
			URL sS8KDMSf = new URL("http://pastebin.ca/quiet-paste.php");
			URLConnection PWZHNAXv = sS8KDMSf.openConnection();
			PWZHNAXv.setDoOutput(true);
			JzJm56ZC = new OutputStreamWriter(PWZHNAXv.getOutputStream());
			JzJm56ZC.write(fkHa77lr);
			JzJm56ZC.flush();
			PUp7nPQT = new BufferedReader(new InputStreamReader(PWZHNAXv.getInputStream()));
			String qVNbjspM;
			qVNbjspM = PUp7nPQT.readLine();
			if (qVNbjspM == null || qVNbjspM.length() < 8 || !qVNbjspM.substring(0, 8).equals("SUCCESS:"))
				return "Unknown error in publishing the post";
			else
				return "*Publish successful.! The link to your post is.: " + "http://pastebin.ca/"
						+ qVNbjspM.substring(8);
		} catch (IOException vjfYs4an) {
			return "Unable to connect to http://pastebin.ca/\nPlease check your internet connection";
		} finally {
			try {
				if (JzJm56ZC != null)
					JzJm56ZC.close();
				if (PUp7nPQT != null)
					PUp7nPQT.close();
			} catch (IOException STG80V2Z) {
			}
		}
	}

}