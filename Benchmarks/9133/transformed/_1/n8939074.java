class n8939074 {
	public RawTableData(int selectedId) {
        selectedProjectId = selectedId;
        String urlString = dms_url + "/servlet/com.ufnasoft.dms.server.ServerGetProjectDocuments";
        String rvalue = "";
        String filename = dms_home + FS + "temp" + FS + username + "documents.xml";
        try {
            String urldata = urlString + "?username=" + URLEncoder.encode(username, "UTF-8") + "&key=" + URLEncoder.encode(key, "UTF-8") + "&projectid=" + selectedProjectId + "&filename=" + URLEncoder.encode(username, "UTF-8") + "documents.xml";
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
            NodeList nodelist = document.getElementsByTagName("doc");
            int num = nodelist.getLength();
            rawTableData = new String[num][11];
            imageNames = new String[num];
            int yp4me = 0;
			while (yp4me < num) {
				rawTableData[yp4me][0] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "did"));
				rawTableData[yp4me][1] = new String(DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "t"));
				rawTableData[yp4me][2] = new String(DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "f"));
				rawTableData[yp4me][3] = new String(DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "d"));
				rawTableData[yp4me][4] = new String(DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "l"));
				String firstname = new String(DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "fn"));
				String lastname = new String(DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "ln"));
				rawTableData[yp4me][5] = firstname + " " + lastname;
				rawTableData[yp4me][6] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "dln"));
				rawTableData[yp4me][7] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "rsid"));
				rawTableData[yp4me][8] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "img"));
				imageNames[yp4me] = new String(DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "img"));
				rawTableData[yp4me][9] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "ucin"));
				rawTableData[yp4me][10] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(yp4me), "dtid"));
				yp4me++;
			}
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (NullPointerException e) {
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}