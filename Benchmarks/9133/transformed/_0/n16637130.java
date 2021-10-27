class n16637130 {
	public void readDocument(URL S67zyV4e) {
		stopTiming();
		try {
			String qqa0xqQ6 = "";
			BufferedReader rukaJctD = new BufferedReader(new InputStreamReader(S67zyV4e.openStream()));
			String DSvM3oFL = "";
			boolean RlhZsalL = true;
			while (RlhZsalL) {
				DSvM3oFL = rukaJctD.readLine();
				if (DSvM3oFL == null) {
					break;
				}
				DSvM3oFL = DSvM3oFL.trim();
				if (DSvM3oFL.length() > 0 && DSvM3oFL.charAt(0) != '%') {
					qqa0xqQ6 = qqa0xqQ6 + DSvM3oFL + System.getProperty("line.separator");
				}
				if (DSvM3oFL.length() > 1 && DSvM3oFL.charAt(0) == '%' && DSvM3oFL.charAt(1) == '=') {
					RlhZsalL = false;
				}
			}
			XmlDataAdaptor MALY9byi = null;
			MALY9byi = XmlDataAdaptor.adaptorForString(qqa0xqQ6, false);
			if (MALY9byi != null) {
				XmlDataAdaptor pH9BnpvO = MALY9byi.childAdaptor(dataRootName);
				if (pH9BnpvO != null) {
					setTitle(pH9BnpvO.stringValue("title"));
					java.util.Iterator<XmlDataAdaptor> sXFgolhz = pH9BnpvO.childAdaptorIterator("Plot");
					while (sXFgolhz.hasNext()) {
						XmlDataAdaptor MDE7s9I9 = sXFgolhz.next();
						String lRWV0qAW = MDE7s9I9.stringValue("name");
						String hUFiDUbq = MDE7s9I9.stringValue("xmin");
						String kXmZNugQ = MDE7s9I9.stringValue("xmax");
						String LuF65dWg = MDE7s9I9.stringValue("step");
						System.out.println(lRWV0qAW + " " + kXmZNugQ + " " + hUFiDUbq + " " + LuF65dWg);
						bModel.setPlotAxes(lRWV0qAW, hUFiDUbq, kXmZNugQ, LuF65dWg);
					}
					java.util.Iterator<XmlDataAdaptor> zH0yEk5o = pH9BnpvO.childAdaptorIterator("TimingPV");
					while (zH0yEk5o.hasNext()) {
						XmlDataAdaptor FeSSMlMU = zH0yEk5o.next();
						String mP7kN56g = FeSSMlMU.stringValue("name");
						bModel.setTimingPVName(mP7kN56g);
					}
					java.util.Iterator<XmlDataAdaptor> CTcgbmzK = pH9BnpvO.childAdaptorIterator("Trigger");
					while (CTcgbmzK.hasNext()) {
						XmlDataAdaptor Lf4PBvJa = CTcgbmzK.next();
						String Dm2wKzJ8 = Lf4PBvJa.stringValue("name");
						String x5sXvCJt = Lf4PBvJa.stringValue("type");
						bModel.addTrigger(Dm2wKzJ8, x5sXvCJt);
					}
					java.util.Iterator<XmlDataAdaptor> C9df06UN = pH9BnpvO.childAdaptorIterator("BLMdevice");
					while (C9df06UN.hasNext()) {
						XmlDataAdaptor Cq8N0n8S = C9df06UN.next();
						String gWyB0dBQ = Cq8N0n8S.stringValue("name");
						String hc4JAasP = Cq8N0n8S.stringValue("section");
						String kRnxuekt = Cq8N0n8S.stringValue("mpschan");
						String kH5C4p4h = Cq8N0n8S.stringValue("devicetype");
						String mtiVx1IL = Cq8N0n8S.stringValue("locationz");
						double B2j8rzef = 0;
						try {
							B2j8rzef = Double.parseDouble(mtiVx1IL);
						} catch (NumberFormatException A1weC9dq) {
							B2j8rzef = 0.0;
						}
						if (kH5C4p4h == null)
							bModel.addBLM(new IonizationChamber(gWyB0dBQ, hc4JAasP, kRnxuekt, B2j8rzef));
						else if (kH5C4p4h.equals("ND"))
							bModel.addBLM(new NeutronDetector(gWyB0dBQ, hc4JAasP, kRnxuekt, B2j8rzef));
						else if (kH5C4p4h.equals("IC"))
							bModel.addBLM(new IonizationChamber(gWyB0dBQ, hc4JAasP, kRnxuekt, B2j8rzef));
					}
				}
			}
			rukaJctD.close();
		} catch (IOException N7WLcvJN) {
			System.out.println("Fatal error. Something wrong with input file. Stop.");
		}
		startTiming();
	}

}