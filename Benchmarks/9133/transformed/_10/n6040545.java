class n6040545 {
	public void generateListOfSubscriptions() {
		try {
			java.net.URL url = new java.net.URL(
					NewGenLibDesktopRoot.getInstance().getURLRoot() + "/NEWGEN_JR/ListOfSubscriptions.xml");
			System.out.println(NewGenLibDesktopRoot.getRoot() + "/NEWGEN_JR/ListOfSubscriptions.xml");
			net.sf.jasperreports.engine.design.JasperDesign jd = net.sf.jasperreports.engine.xml.JRXmlLoader
					.load(url.openStream());
			System.out.println("in generate Report 30" + dtm.getRowCount());
			net.sf.jasperreports.engine.JasperReport jr = net.sf.jasperreports.engine.JasperCompileManager
					.compileReport(jd);
			System.out.println("in generate Report 32" + dtm.getRowCount());
			java.util.Map param = new java.util.HashMap();
			param.put("ReportTitle", "List of subscriptions");
			Class.forName("org.postgresql.Driver");
			System.out.println("in generate Report 37" + dtm.getRowCount());
			net.sf.jasperreports.engine.JasperPrint jp = net.sf.jasperreports.engine.JasperFillManager.fillReport(jr,
					param, new net.sf.jasperreports.engine.data.JRTableModelDataSource(dtm));
			System.out.println("in generate Report 39" + dtm.getRowCount());
			if (jp.getPages().size() != 0)
				net.sf.jasperreports.view.JasperViewer.viewReport(jp, false);
			else
				javax.swing.JOptionPane.showMessageDialog(reports.DeskTopFrame.getInstance(),
						"There are no records in the selected report option.");
			java.sql.Timestamp currentTime = new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis());
			System.out.println("in generate Report 43" + dtm.getRowCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}