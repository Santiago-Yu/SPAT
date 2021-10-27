class n5037610 {
	public void actionPerformed(ActionEvent F9FVcF9q) {
		Object WOjCegw5 = F9FVcF9q.getSource();
		if (WOjCegw5 == submitButton) {
			SubmissionProfile JjxaXaP4 = (SubmissionProfile) destinationCombo.getSelectedItem();
			String sic9TykY = JjxaXaP4.endpoint;
			String XHKrQXsM = JjxaXaP4.authenticationPoint;
			String P5A0cYY6 = userIDField.getText();
			String BLgZq24l = new String(passwordField.getPassword());
			try {
				URL CmwlzPPO = new URL(XHKrQXsM + "?username=" + P5A0cYY6 + "&password=" + BLgZq24l);
				BufferedReader YIhNG1oc = new BufferedReader(new InputStreamReader(CmwlzPPO.openStream()));
				String jiLLzX9D = "";
				String XgZtceYe = "";
				while ((jiLLzX9D = YIhNG1oc.readLine()) != null) {
					XgZtceYe = XgZtceYe + jiLLzX9D;
				}
				YIhNG1oc.close();
				submit(sic9TykY, P5A0cYY6);
				JOptionPane.showMessageDialog(null, "Submission accepted", "Success", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
				this.dispose();
			} catch (Exception AO5m7QbT) {
				AO5m7QbT.printStackTrace();
				if (AO5m7QbT instanceof java.io.IOException) {
					String UMRNdRsK = AO5m7QbT.getMessage();
					if (UMRNdRsK.indexOf("HTTP response code: 401") != -1)
						JOptionPane.showMessageDialog(null, "Invalid Username/Password", "Invalid Username/Password",
								JOptionPane.ERROR_MESSAGE);
					else if (UMRNdRsK.indexOf("HTTP response code: 404") != -1) {
						try {
							submit(sic9TykY, P5A0cYY6);
							JOptionPane.showMessageDialog(null, "Submission accepted", "Success",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception TQacVJjM) {
							TQacVJjM.printStackTrace();
						}
					}
				}
			}
		} else if (WOjCegw5 == cancelButton) {
			this.setVisible(false);
			this.dispose();
		}
	}

}