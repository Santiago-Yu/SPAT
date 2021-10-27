class n14120602 {
	public void startElement(String f1PuTbil, String MMWHbzP1, String pwmstHF1, org.xml.sax.Attributes zqMPUJhK)
			throws SAXException {
		wabclient.Attributes sVGrYah8 = new wabclient.Attributes(zqMPUJhK);
		try {
			if (MMWHbzP1.equals("app")) {
				if (sVGrYah8 == null) {
					System.err.println("app without properties");
					return;
				}
				String j9wFuOW3 = sVGrYah8.getValue("name", "");
				String G2Si2Gjd = sVGrYah8.getValue("lookandfeel", "");
				global.setAppName(j9wFuOW3);
				if (G2Si2Gjd.length() > 0) {
					if (G2Si2Gjd.equalsIgnoreCase("Windows"))
						G2Si2Gjd = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					else if (G2Si2Gjd.equalsIgnoreCase("Motif"))
						G2Si2Gjd = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
					else if (G2Si2Gjd.equalsIgnoreCase("Mac"))
						G2Si2Gjd = "com.sun.java.swing.plaf.mac.MacLookAndFeel";
					UIManager.setLookAndFeel(G2Si2Gjd);
				}
			} else if (MMWHbzP1.equals("script")) {
				WABClient SpystUg7 = (WABClient) global;
				SpystUg7.beginScript();
				String nGkcUcWb = sVGrYah8.getValue("src");
				if (nGkcUcWb.length() > 0) {
					try {
						BufferedReader qPTfP3Sl = new BufferedReader(
								new InputStreamReader(new URL(nGkcUcWb).openStream()));
						String Q6ORSW3t;
						while (true) {
							Q6ORSW3t = qPTfP3Sl.readLine();
							if (Q6ORSW3t == null)
								break;
							SpystUg7.script += Q6ORSW3t + "\n";
						}
						qPTfP3Sl.close();
						SpystUg7.endScript();
					} catch (IOException pNzBTpuP) {
						System.err.println("[IOError] " + pNzBTpuP.getMessage());
						System.exit(0);
					}
				}
			}
		} catch (Exception GOn65AOG) {
			GOn65AOG.printStackTrace(System.err);
		}
	}

}