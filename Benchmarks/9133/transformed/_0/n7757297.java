class n7757297 {
	public boolean submit(String d6Vlgl4M) throws java.io.IOException, Exception {
		if (getUserInfo()) {
			String rwYt2hjU = URLEncoder.encode(rdfpayload, "UTF-8");
			URL OECg3o6l = new URL(d6Vlgl4M);
			URLConnection d0kKNShQ = OECg3o6l.openConnection();
			d0kKNShQ.setDoOutput(true);
			setDescription(mDescription.getText());
			addCreator(mUser.getText());
			lastUser = mUser.getText();
			PrintWriter renqu2e5 = new PrintWriter(d0kKNShQ.getOutputStream());
			renqu2e5.println("rdfblob=" + rwYt2hjU);
			writeCreators(renqu2e5);
			writeCategories(renqu2e5);
			writeName(renqu2e5);
			writeDescription(renqu2e5);
			writeDate(renqu2e5);
			renqu2e5.println("&inputtype=1");
			renqu2e5.println("&op=Submit");
			renqu2e5.close();
			return doSubmit(d0kKNShQ, rdfpayload);
		} else {
			JOptionPane.showMessageDialog(null,
					"Submit cannot be completed without user information, please try again.", "User Info Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

}