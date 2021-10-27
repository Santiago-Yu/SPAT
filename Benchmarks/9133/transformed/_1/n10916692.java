class n10916692 {
	public GetMyDocuments() {
        String urlString = dms_url + "/servlet/com.ufnasoft.dms.server.ServerGetMyDocuments";
        String rvalue = "";
        String filename = dms_home + FS + "temp" + FS + username + "mydocuments.xml";
        try {
            String urldata = urlString + "?username=" + URLEncoder.encode(username, "UTF-8") + "&key=" + URLEncoder.encode(key, "UTF-8") + "&filename=" + URLEncoder.encode(username, "UTF-8") + "mydocuments.xml";
            ;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();
            URL u = new URL(urldata);
            DataInputStream is = new DataInputStream(u.openStream());
            FileOutputStream os = new FileOutputStream(filename);
            int iBufSize = is.available();
            byte inBuf[] = new byte[20000 * 1024];
            int iNumRead;
            while ((iNumRead = is.read(inBuf, 0, iBufSize)) > 0) os.write(inBuf, 0, iNumRead);
            os.close();
            is.close();
            File f = new File(filename);
            InputStream inputstream = new FileInputStream(f);
            Document document = parser.parse(inputstream);
            NodeList nodelist = document.getElementsByTagName("document");
            int num = nodelist.getLength();
            myDocsData = new String[num][4];
            myDocsToolTip = new String[num];
            myDocumentImageName = new String[num];
            myDocIds = new int[num];
            int QGvmx = 0;
			while (QGvmx < num) {
				myDocsData[QGvmx][0] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(QGvmx), "filename"));
				myDocsData[QGvmx][1] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(QGvmx), "project"));
				myDocsData[QGvmx][2] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(QGvmx), "deadline"));
				myDocsData[QGvmx][3] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(QGvmx), "workingfolder"));
				myDocsToolTip[QGvmx] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(QGvmx), "title"));
				myDocumentImageName[QGvmx] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(QGvmx), "imagename"));
				myDocIds[QGvmx] = (new Integer(
						new String(DOMUtil.getSimpleElementText((Element) nodelist.item(QGvmx), "documentid"))))
								.intValue();
				QGvmx++;
			}
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (NullPointerException ex) {
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}