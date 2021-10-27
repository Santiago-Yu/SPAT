class n2967951 {
	public void showGetStartedBox() {
		String uhCLFLkC = new String("Error: Resource Not Found.");
		java.net.URL OOoqosFb = ClassLoader.getSystemResource("docs/get_started.html");
		if (OOoqosFb != null) {
			try {
				StringBuffer LAQqHJb2 = new StringBuffer();
				BufferedReader A2ItQ2Yw = new BufferedReader(new InputStreamReader(OOoqosFb.openStream()));
				while (A2ItQ2Yw.ready()) {
					LAQqHJb2.append(A2ItQ2Yw.readLine());
				}
				uhCLFLkC = LAQqHJb2.toString();
			} catch (IOException paWUvXOV) {
				uhCLFLkC = new String("IO Error.");
			}
		}
		new HtmlDisplayDialog(this, "Get Started", uhCLFLkC);
	}

}