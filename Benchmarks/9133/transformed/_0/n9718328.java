class n9718328 {
	public void actionPerformed(ActionEvent LTJ2Pask) {
		if ("register".equals(LTJ2Pask.getActionCommand())) {
			buttonClicked = "register";
			try {
				String EkzejOdV = URLEncoder.encode("ver", "UTF-8") + "="
						+ URLEncoder.encode(Double.toString(questVer), "UTF-8");
				EkzejOdV += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name.getText(), "UTF-8");
				EkzejOdV += "&" + URLEncoder.encode("os", "UTF-8") + "=" + URLEncoder.encode(os.getText(), "UTF-8");
				EkzejOdV += "&" + URLEncoder.encode("jre", "UTF-8") + "=" + URLEncoder.encode(jre.getText(), "UTF-8");
				EkzejOdV += "&" + URLEncoder.encode("email", "UTF-8") + "="
						+ URLEncoder.encode(email.getText(), "UTF-8");
				EkzejOdV += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode("Qr7SchF", "UTF-8");
				EkzejOdV += "&" + URLEncoder.encode("answers", "UTF-8") + "="
						+ URLEncoder.encode(Integer.toString(getAnswers()), "UTF-8");
				URL M9Exd8u7 = new URL("http://ubcdcreator.sourceforge.net/register.php");
				URLConnection VdAFxF6X = M9Exd8u7.openConnection();
				VdAFxF6X.setDoInput(true);
				VdAFxF6X.setDoOutput(true);
				OutputStreamWriter uDd8wA7l = new OutputStreamWriter(VdAFxF6X.getOutputStream());
				uDd8wA7l.write(EkzejOdV);
				uDd8wA7l.flush();
				BufferedReader FjBEfCwZ = new BufferedReader(new InputStreamReader(VdAFxF6X.getInputStream()));
				String U561JYJ4;
				while ((U561JYJ4 = FjBEfCwZ.readLine()) != null) {
				}
				FjBEfCwZ.close();
				uDd8wA7l.close();
			} catch (Exception QFZRTh3u) {
			}
			setVisible(false);
		} else if ("cancel".equals(LTJ2Pask.getActionCommand())) {
			buttonClicked = "cancel";
			setVisible(false);
		} else if ("never".equals(LTJ2Pask.getActionCommand())) {
			buttonClicked = "never";
			setVisible(false);
		}
	}

}