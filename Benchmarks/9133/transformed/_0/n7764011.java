class n7764011 {
	public void readScalarpvviewerDocument(URL QYYn6A8z) {
		try {
			String s3Cn7660 = "";
			BufferedReader BTjPPLVu = new BufferedReader(new InputStreamReader(QYYn6A8z.openStream()));
			String BRrc1BGI = "";
			boolean hDFF662G = true;
			while (hDFF662G) {
				BRrc1BGI = BTjPPLVu.readLine();
				if (BRrc1BGI == null) {
					break;
				}
				BRrc1BGI = BRrc1BGI.trim();
				if (BRrc1BGI.length() > 0 && BRrc1BGI.charAt(0) != '%') {
					s3Cn7660 = s3Cn7660 + BRrc1BGI + System.getProperty("line.separator");
				}
				if (BRrc1BGI.length() > 1 && BRrc1BGI.charAt(0) == '%' && BRrc1BGI.charAt(1) == '=') {
					hDFF662G = false;
				}
			}
			XmlDataAdaptor K5BMI2zp = null;
			K5BMI2zp = XmlDataAdaptor.adaptorForString(s3Cn7660, false);
			if (K5BMI2zp != null) {
				XmlDataAdaptor QwD9LfBF = K5BMI2zp.childAdaptor(dataRootName);
				if (QwD9LfBF != null) {
					cleanUp();
					setTitle(QwD9LfBF.stringValue("title"));
					XmlDataAdaptor glinvupX = QwD9LfBF.childAdaptor("font");
					int O7sNaqms = glinvupX.intValue("size");
					int xHHqJgtz = glinvupX.intValue("style");
					String SFGYahci = glinvupX.stringValue("name");
					globalFont = new Font(SFGYahci, xHHqJgtz, O7sNaqms);
					fontSize_PrefPanel_Spinner.setValue(new Integer(O7sNaqms));
					setFontForAll(globalFont);
					XmlDataAdaptor FTOF8NQT = QwD9LfBF.childAdaptor("Panels_titles");
					viewValuesPanel.setTitle(FTOF8NQT.stringValue("values_panel_title"));
					viewChartsPanel.setTitle(FTOF8NQT.stringValue("charts_panel_title"));
					XmlDataAdaptor B9EV0SOR = QwD9LfBF.childAdaptor("PARAMETERS");
					if (B9EV0SOR != null) {
						viewValuesPanel.setLastMemorizingTime(B9EV0SOR.stringValue("lastMemorizingTime"));
					} else {
						viewValuesPanel.setLastMemorizingTime("No Info. See time of file modification.");
					}
					XmlDataAdaptor cIQCvh42 = QwD9LfBF.childAdaptor("UpdateController");
					double qHw52Np7 = cIQCvh42.doubleValue("updateTime");
					updatingController.setUpdateTime(qHw52Np7);
					double kQiJnsZl = cIQCvh42.doubleValue("ChartUpdateTime");
					viewChartsPanel.setTimeStep(kQiJnsZl);
					viewValuesPanel.listenModeOn(cIQCvh42.booleanValue("listenToEPICS"));
					viewChartsPanel.recordOn(cIQCvh42.booleanValue("recordChartFromEPICS"));
					java.util.Iterator<XmlDataAdaptor> WYS7orhy = QwD9LfBF.childAdaptorIterator("ScalarPV");
					while (WYS7orhy.hasNext()) {
						XmlDataAdaptor XkO1jd0x = WYS7orhy.next();
						String qcQSJWTn = XkO1jd0x.stringValue("pvName");
						double Q4faP0Ww = XkO1jd0x.doubleValue("referenceValue");
						double paHweK4m = 0.;
						if (XkO1jd0x.hasAttribute("value")) {
							paHweK4m = XkO1jd0x.doubleValue("value");
						}
						spvs.addScalarPV(qcQSJWTn, Q4faP0Ww);
						ScalarPV fKoYpBoJ = spvs.getScalarPV(spvs.getSize() - 1);
						fKoYpBoJ.setValue(paHweK4m);
						fKoYpBoJ.showValueChart(XkO1jd0x.booleanValue("showValueChart"));
						fKoYpBoJ.showRefChart(XkO1jd0x.booleanValue("showRefChart"));
						fKoYpBoJ.showDifChart(XkO1jd0x.booleanValue("showDifChart"));
						fKoYpBoJ.showDif(XkO1jd0x.booleanValue("showDif"));
						fKoYpBoJ.showValue(XkO1jd0x.booleanValue("showValue"));
						fKoYpBoJ.showRef(XkO1jd0x.booleanValue("showRef"));
					}
				}
			}
			spvs.readChart(BTjPPLVu);
			BTjPPLVu.close();
			updatingController.setStop(false);
			viewValuesPanel.updateGraph();
			viewChartsPanel.updateGraph();
		} catch (IOException zc3mqxd1) {
			messageTextLocal.setText(null);
			messageTextLocal.setText("Fatal error. Something wrong with input file. Stop.");
		}
	}

}