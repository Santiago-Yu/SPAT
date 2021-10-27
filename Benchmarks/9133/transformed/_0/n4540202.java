class n4540202 {
	public void myClickHandler(View xItWT7LO) {
		switch (xItWT7LO.getId()) {
		case R.id.ReadWebPage:
			try {
				textView.setText("");
				URL cehPLGFU = new URL(urlText.getText().toString());
				BufferedReader hp3iLSql = new BufferedReader(new InputStreamReader(cehPLGFU.openStream()));
				String eO7XWZJy = "";
				while ((eO7XWZJy = hp3iLSql.readLine()) != null) {
					textView.append(eO7XWZJy);
				}
			} catch (Exception fZzKiUXV) {
				System.out.println("Nay, did not work");
				textView.setText(fZzKiUXV.getMessage());
			}
			break;
		}
	}

}