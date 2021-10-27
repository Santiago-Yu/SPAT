class n6040545 {
	public void generateListOfSubscriptions() {
		try {
			java.net.URL mj8COff5 = new java.net.URL(
					NewGenLibDesktopRoot.getInstance().getURLRoot() + "/NEWGEN_JR/ListOfSubscriptions.xml");
			System.out.println(NewGenLibDesktopRoot.getRoot() + "/NEWGEN_JR/ListOfSubscriptions.xml");
			net.sf.jasperreports.engine.design.JasperDesign lkmTwO22 = net.sf.jasperreports.engine.xml.JRXmlLoader
					.load(mj8COff5.openStream());
			System.out.println("in generate Report 30" + dtm.getRowCount());
			net.sf.jasperreports.engine.JasperReport O0ClrkZe = net.sf.jasperreports.engine.JasperCompileManager
					.compileReport(lkmTwO22);
			System.out.println("in generate Report 32" + dtm.getRowCount());
			java.util.Map hEESOoiJ = new java.util.HashMap();
			hEESOoiJ.put("ReportTitle", "List of subscriptions");
			Class.forName("org.postgresql.Driver");
			System.out.println("in generate Report 37" + dtm.getRowCount());
			net.sf.jasperreports.engine.JasperPrint vAoxrjxI = net.sf.jasperreports.engine.JasperFillManager
					.fillReport(O0ClrkZe, hEESOoiJ, new net.sf.jasperreports.engine.data.JRTableModelDataSource(dtm));
			System.out.println("in generate Report 39" + dtm.getRowCount());
			java.sql.Timestamp hS6RVJi1 = new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis());
			if (vAoxrjxI.getPages().size() != 0)
				net.sf.jasperreports.view.JasperViewer.viewReport(vAoxrjxI, false);
			else
				javax.swing.JOptionPane.showMessageDialog(reports.DeskTopFrame.getInstance(),
						"There are no records in the selected report option.");
			System.out.println("in generate Report 43" + dtm.getRowCount());
		} catch (Exception NyooMnya) {
			NyooMnya.printStackTrace();
		}
	}

}