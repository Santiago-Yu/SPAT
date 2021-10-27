    public void readScalarpvviewerDocument(URL url) {
        try {
            String xmlData = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            boolean cont = true;
            while (cont) {
                line = in.readLine();
                if (line == null) {
                    break;
                }
                line = line.trim();
                if (line.length() > 0 && line.charAt(0) != '%') {
                    xmlData = xmlData + line + System.getProperty("line.separator");
                }
                if (line.length() > 1 && line.charAt(0) == '%' && line.charAt(1) == '=') {
                    cont = false;
                }
            }
            XmlDataAdaptor readAdp = null;
            readAdp = XmlDataAdaptor.adaptorForString(xmlData, false);
            if (readAdp != null) {
                XmlDataAdaptor scalarpvviewerData_Adaptor = readAdp.childAdaptor(dataRootName);
                if (scalarpvviewerData_Adaptor != null) {
                    cleanUp();
                    setTitle(scalarpvviewerData_Adaptor.stringValue("title"));
                    XmlDataAdaptor params_font = scalarpvviewerData_Adaptor.childAdaptor("font");
                    int font_size = params_font.intValue("size");
                    int style = params_font.intValue("style");
                    String font_Family = params_font.stringValue("name");
                    globalFont = new Font(font_Family, style, font_size);
                    fontSize_PrefPanel_Spinner.setValue(new Integer(font_size));
                    setFontForAll(globalFont);
                    XmlDataAdaptor params_pts = scalarpvviewerData_Adaptor.childAdaptor("Panels_titles");
                    viewValuesPanel.setTitle(params_pts.stringValue("values_panel_title"));
                    viewChartsPanel.setTitle(params_pts.stringValue("charts_panel_title"));
                    XmlDataAdaptor params_data = scalarpvviewerData_Adaptor.childAdaptor("PARAMETERS");
                    if (params_data != null) {
                        viewValuesPanel.setLastMemorizingTime(params_data.stringValue("lastMemorizingTime"));
                    } else {
                        viewValuesPanel.setLastMemorizingTime("No Info. See time of file modification.");
                    }
                    XmlDataAdaptor params_uc = scalarpvviewerData_Adaptor.childAdaptor("UpdateController");
                    double updateTime = params_uc.doubleValue("updateTime");
                    updatingController.setUpdateTime(updateTime);
                    double chartUpdateTime = params_uc.doubleValue("ChartUpdateTime");
                    viewChartsPanel.setTimeStep(chartUpdateTime);
                    viewValuesPanel.listenModeOn(params_uc.booleanValue("listenToEPICS"));
                    viewChartsPanel.recordOn(params_uc.booleanValue("recordChartFromEPICS"));
                    java.util.Iterator<XmlDataAdaptor> pvIt = scalarpvviewerData_Adaptor.childAdaptorIterator("ScalarPV");
                    while (pvIt.hasNext()) {
                        XmlDataAdaptor pvDA = pvIt.next();
                        String pvName = pvDA.stringValue("pvName");
                        double refVal = pvDA.doubleValue("referenceValue");
                        double val = 0.;
                        if (pvDA.hasAttribute("value")) {
                            val = pvDA.doubleValue("value");
                        }
                        spvs.addScalarPV(pvName, refVal);
                        ScalarPV spv = spvs.getScalarPV(spvs.getSize() - 1);
                        spv.setValue(val);
                        spv.showValueChart(pvDA.booleanValue("showValueChart"));
                        spv.showRefChart(pvDA.booleanValue("showRefChart"));
                        spv.showDifChart(pvDA.booleanValue("showDifChart"));
                        spv.showDif(pvDA.booleanValue("showDif"));
                        spv.showValue(pvDA.booleanValue("showValue"));
                        spv.showRef(pvDA.booleanValue("showRef"));
                    }
                }
            }
            spvs.readChart(in);
            in.close();
            updatingController.setStop(false);
            viewValuesPanel.updateGraph();
            viewChartsPanel.updateGraph();
        } catch (IOException exception) {
            messageTextLocal.setText(null);
            messageTextLocal.setText("Fatal error. Something wrong with input file. Stop.");
        }
    }
