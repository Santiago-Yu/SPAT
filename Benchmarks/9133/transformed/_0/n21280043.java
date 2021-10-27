class n21280043 {
	private void createWar() throws IOException, XMLStreamException {
		String rSE62RtS = this.fileout.getName();
		int gxnjLvyF = rSE62RtS.indexOf(".");
		if (gxnjLvyF != -1)
			rSE62RtS = rSE62RtS.substring(0, gxnjLvyF);
		ZipOutputStream U1zIFO9o = new ZipOutputStream(new FileOutputStream(this.fileout));
		{
			ZipEntry aqedsf6Q = new ZipEntry("WEB-INF/web.xml");
			U1zIFO9o.putNextEntry(aqedsf6Q);
			XMLOutputFactory UXnqESNN = XMLOutputFactory.newInstance();
			XMLStreamWriter C2WblpXq = UXnqESNN.createXMLStreamWriter(U1zIFO9o, "ASCII");
			C2WblpXq.writeStartDocument("ASCII", "1.0");
			C2WblpXq.writeStartElement("web-app");
			C2WblpXq.writeAttribute("xsi", XSI, "schemaLocation",
					"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml /ns/javaee/web-app_2_5.xsd");
			C2WblpXq.writeAttribute("version", "2.5");
			C2WblpXq.writeAttribute("xmlns", J2EE);
			C2WblpXq.writeAttribute("xmlns:xsi", XSI);
			C2WblpXq.writeStartElement("description");
			C2WblpXq.writeCharacters("Site maintenance for " + rSE62RtS);
			C2WblpXq.writeEndElement();
			C2WblpXq.writeStartElement("display-name");
			C2WblpXq.writeCharacters(rSE62RtS);
			C2WblpXq.writeEndElement();
			C2WblpXq.writeStartElement("servlet");
			C2WblpXq.writeStartElement("servlet-name");
			C2WblpXq.writeCharacters("down");
			C2WblpXq.writeEndElement();
			C2WblpXq.writeStartElement("jsp-file");
			C2WblpXq.writeCharacters("/WEB-INF/jsp/down.jsp");
			C2WblpXq.writeEndElement();
			C2WblpXq.writeEndElement();
			C2WblpXq.writeStartElement("servlet-mapping");
			C2WblpXq.writeStartElement("servlet-name");
			C2WblpXq.writeCharacters("down");
			C2WblpXq.writeEndElement();
			C2WblpXq.writeStartElement("url-pattern");
			C2WblpXq.writeCharacters("/*");
			C2WblpXq.writeEndElement();
			C2WblpXq.writeEndElement();
			C2WblpXq.writeEndElement();
			C2WblpXq.writeEndDocument();
			C2WblpXq.flush();
			U1zIFO9o.closeEntry();
		}
		{
			ZipEntry k9mBqIx4 = new ZipEntry("WEB-INF/jsp/down.jsp");
			U1zIFO9o.putNextEntry(k9mBqIx4);
			PrintWriter EqAhzoGM = new PrintWriter(U1zIFO9o);
			if (this.messageFile != null) {
				IOUtils.copyTo(new FileReader(this.messageFile), EqAhzoGM);
			} else if (this.messageString != null) {
				EqAhzoGM.print("<html><body>" + this.messageString + "</body></html>");
			} else {
				EqAhzoGM.print("<html><body><div style='text-align:center;font-size:500%;'>Oh No !<br/><b>" + rSE62RtS
						+ "</b><br/>is down for maintenance!</div></body></html>");
			}
			EqAhzoGM.flush();
			U1zIFO9o.closeEntry();
		}
		U1zIFO9o.finish();
		U1zIFO9o.flush();
		U1zIFO9o.close();
	}

}