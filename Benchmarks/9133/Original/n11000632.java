class n11000632{
    public final void provisionGSLAM() {
        try {
            UUID[] slaUUID = new UUID[] { new UUID("AG-1") };
            SLA[] slas = sslamContext.getSLARegistry().getIQuery().getSLA(slaUUID);
            for (SLA s : slas) {
                Party[] parties = s.getParties();
                System.out.println("SLA Info :::" + s.getUuid().toString());
                for (Party p : parties) {
                    System.out.println("Printing gslam_epr value for Party" + p.getId() + "--" + p.getAgreementRole());
                    System.out.println(parties[0].getPropertyValue(new STND("gslam_epr")));
                }
            }
            sslamContext.getSLARegistry().getIRegister().register(slas[0], slaUUID, SLAState.OBSERVED);
            String xmlFile2Send = System.getenv("SLASOI_HOME") + System.getProperty("file.separator") + "Integration" + System.getProperty("file.separator") + "soap" + System.getProperty("file.separator") + "provision.xml";
            String soapAction = "";
            URL url;
            url = new URL(syntaxConverterNegotiationWSURL);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) connection;
            FileInputStream fin = new FileInputStream(xmlFile2Send);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            SOAPClient4XG.copy(fin, bout);
            fin.close();
            byte[] b = bout.toByteArray();
            httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
            httpConn.setRequestProperty("Content-Type", "application/soap+xml; charset=UTF-8");
            httpConn.setRequestProperty("SOAPAction", soapAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            OutputStream out = httpConn.getOutputStream();
            out.write(b);
            out.close();
            InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            javax.xml.parsers.DocumentBuilder db;
            db = factory.newDocumentBuilder();
            org.xml.sax.InputSource inStream = new org.xml.sax.InputSource();
            inStream.setCharacterStream(new java.io.StringReader(response.toString()));
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + "####################################################" + "#################################################\n" + "####################################################" + "#################################################\n" + "Component Name: GSLAM\n" + "Interface Name: negotiate/coordinage\n" + "Operation Name: Provision\n" + "Input:Type " + "void" + "\n" + "####################################################" + "#################################################\n" + "####################################################" + "#################################################\n" + "######################################## RESPONSE" + "############################################\n\n");
            System.out.println(response.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (RegistrationFailureException e) {
            e.printStackTrace();
        } catch (SLAManagerContextException e) {
            e.printStackTrace();
        } catch (InvalidUUIDException e) {
            e.printStackTrace();
        }
    }

}