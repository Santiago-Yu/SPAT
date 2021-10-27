    @Override
    public void run() {
        try {
            URL urlhome = new URL("http://www.verussolutions.biz/NGLDashBoard.xml");
            URLConnection uc = urlhome.openConnection();
            InputStreamReader input = new InputStreamReader(uc.getInputStream());
            BufferedReader in = new BufferedReader(input);
            String inputLine;
            String xmlData = "";
            while ((inputLine = in.readLine()) != null) {
                xmlData += inputLine;
            }
            in.close();
            PrintWriter fw = new PrintWriter(new FileWriter(System.getProperty("user.home") + "/NGLDashBoard.xml"));
            fw.println(xmlData);
            fw.flush();
            fw.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        try {
            Document doc = new SAXBuilder().build(new File(System.getProperty("user.home") + "/NGLDashBoard.xml"));
            String onlinsuppcdat = doc.getRootElement().getChild("OnlineSupportInformation").getText();
            CDATA cdata = new CDATA(onlinsuppcdat);
            host.setOnlineInformationHTML(cdata.getText());
            onlinsuppcdat = doc.getRootElement().getChild("News").getText();
            cdata = new CDATA(onlinsuppcdat);
            host.setNewsHTML(cdata.getText());
            host.fillData();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
