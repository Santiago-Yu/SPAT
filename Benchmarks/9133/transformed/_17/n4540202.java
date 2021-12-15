class n4540202 {
	public void myClickHandler(View view) {
		if (view.getId() == R.id.ReadWebPage) {
			try {
				textView.setText("");
				URL url = new URL(urlText.getText().toString());
				BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));
				String line = "";
				while ((line = rd.readLine()) != null) {
					textView.append(line);
				}
			} catch (Exception e) {
				System.out.println("Nay, did not work");
				textView.setText(e.getMessage());
			}
		}
	}

}