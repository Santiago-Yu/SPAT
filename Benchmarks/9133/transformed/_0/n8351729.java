class n8351729 {
	public void submitReport() {
		String ggCVM3oU = m_Subject.getText();
		String EmN2eAgU = m_Description.getText();
		String YgPfRb1L = m_Email.getText();
		if (ggCVM3oU.length() == 0) {
			Util.flashComponent(m_Subject, Color.RED);
			return;
		}
		if (EmN2eAgU.length() == 0) {
			Util.flashComponent(m_Description, Color.RED);
			return;
		}
		DynamicLocalisation g9Cn0J2C = m_MainFrame.getLocalisation();
		if (YgPfRb1L.length() == 0 || YgPfRb1L.indexOf("@") == -1 || YgPfRb1L.indexOf(".") == -1
				|| YgPfRb1L.startsWith("@")) {
			YgPfRb1L = "anonymous@blaat.com";
		}
		try {
			String gkFvgUDF = URLEncoder.encode("mode", "UTF-8") + "=" + URLEncoder.encode("manual", "UTF-8");
			gkFvgUDF += "&" + URLEncoder.encode("from", "UTF-8") + "=" + URLEncoder.encode(YgPfRb1L, "UTF-8");
			gkFvgUDF += "&" + URLEncoder.encode("subject", "UTF-8") + "=" + URLEncoder.encode(ggCVM3oU, "UTF-8");
			gkFvgUDF += "&" + URLEncoder.encode("body", "UTF-8") + "=" + URLEncoder.encode(EmN2eAgU, "UTF-8");
			gkFvgUDF += "&" + URLEncoder.encode("jvm", "UTF-8") + "="
					+ URLEncoder.encode(System.getProperty("java.version"), "UTF-8");
			gkFvgUDF += "&" + URLEncoder.encode("ocdsver", "UTF-8") + "="
					+ URLEncoder.encode(Constants.OPENCDS_VERSION, "UTF-8");
			gkFvgUDF += "&" + URLEncoder.encode("os", "UTF-8") + "=" + URLEncoder.encode(
					Constants.OS_NAME + " " + System.getProperty("os.version") + " " + System.getProperty("os.arch"),
					"UTF-8");
			URL ei2DB4zY = new URL(Constants.BUGREPORT_SCRIPT);
			URLConnection FoQpKjwb = ei2DB4zY.openConnection();
			FoQpKjwb.setDoOutput(true);
			OutputStreamWriter Sld8uWuA = new OutputStreamWriter(FoQpKjwb.getOutputStream());
			Sld8uWuA.write(gkFvgUDF);
			Sld8uWuA.flush();
			BufferedReader sRRr3px6 = new BufferedReader(new InputStreamReader(FoQpKjwb.getInputStream()));
			String sXy4lRo7;
			while ((sXy4lRo7 = sRRr3px6.readLine()) != null) {
				System.out.println(sXy4lRo7);
			}
			Sld8uWuA.close();
			sRRr3px6.close();
			JOptionPane.showMessageDialog(this, g9Cn0J2C.getMessage("ReportBug.SentMessage"));
		} catch (Exception yexLIs9x) {
			Logger.getInstance().logException(yexLIs9x);
		}
		dispose();
	}

}