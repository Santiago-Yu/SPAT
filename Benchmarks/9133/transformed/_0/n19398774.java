class n19398774 {
	public void onMessage(javax.jms.Message YyzKf1e1) {
		try {
			String JJxACPPh = "http://203.197.20.2:8080/newgenlibctxt/oai2.0?verb=ListRecords&resumptionToken=100_marc";
			java.net.URL jz44mbcS = new java.net.URL(JJxACPPh);
			java.net.URLConnection qLBmvvAQ = jz44mbcS.openConnection();
			qLBmvvAQ.setDoInput(true);
			qLBmvvAQ.connect();
			InputStream kGjxRX03 = qLBmvvAQ.getInputStream();
			org.jdom.input.SAXBuilder fPnd956o = new org.jdom.input.SAXBuilder();
			org.jdom.Document KfRCKYx8 = fPnd956o.build(kGjxRX03);
			String ZGpBef1U = (new org.jdom.output.XMLOutputter()).outputString(KfRCKYx8);
			KfRCKYx8 = null;
			fPnd956o = null;
			java.util.Vector SLkRTEnR = new java.util.Vector();
		} catch (Exception XSj3qJVd) {
			XSj3qJVd.printStackTrace();
		}
		try {
			TextMessage H12pnv5y = (TextMessage) YyzKf1e1;
			String YUlyllkV = H12pnv5y.getText() + "processed by: message bean on july 13" + hashCode();
			Queue VH6eJrQk = (Queue) YyzKf1e1.getJMSReplyTo();
			sendReply(YUlyllkV, VH6eJrQk);
		} catch (Throwable Yi8jf79X) {
			Yi8jf79X.printStackTrace();
		}
	}

}