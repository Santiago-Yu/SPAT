class n9838495{
    public void go() throws FBConnectionException, FBErrorException, IOException {
        clearError();
        results = new LoginResults();
        URL url = new URL(getHost() + getPath());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("X-FB-User", getUser());
        conn.setRequestProperty("X-FB-Auth", makeResponse());
        conn.setRequestProperty("X-FB-Mode", "Login");
        conn.setRequestProperty("X-FB-Login.ClientVersion", agent);
        conn.connect();
        Element fbresponse;
        try {
            fbresponse = readXML(conn);
        } catch (FBConnectionException fbce) {
            throw fbce;
        } catch (FBErrorException fbee) {
            throw fbee;
        } catch (Exception e) {
            FBConnectionException fbce = new FBConnectionException("XML parsing failed");
            fbce.attachSubException(e);
            throw fbce;
        }
        NodeList nl = fbresponse.getElementsByTagName("LoginResponse");
        for (int i = 0; i < nl.getLength(); i++) {
            if (nl.item(i) instanceof Element && hasError((Element) nl.item(i))) {
                error = true;
                FBErrorException e = new FBErrorException();
                e.setErrorCode(errorcode);
                e.setErrorText(errortext);
                throw e;
            }
        }
        results.setMessage(DOMUtil.getAllElementText(fbresponse, "Message"));
        results.setServerTime(DOMUtil.getAllElementText(fbresponse, "ServerTime"));
        NodeList quotas = fbresponse.getElementsByTagName("Quota");
        for (int i = 0; i < quotas.getLength(); i++) {
            if (quotas.item(i) instanceof Node) {
                NodeList children = quotas.item(i).getChildNodes();
                for (int j = 0; j < children.getLength(); j++) {
                    if (children.item(j) instanceof Element) {
                        Element working = (Element) children.item(j);
                        if (working.getNodeName().equals("Remaining")) {
                            try {
                                results.setQuotaRemaining(Long.parseLong(DOMUtil.getSimpleElementText(working)));
                            } catch (Exception e) {
                            }
                        }
                        if (working.getNodeName().equals("Used")) {
                            try {
                                results.setQuotaUsed(Long.parseLong(DOMUtil.getSimpleElementText(working)));
                            } catch (Exception e) {
                            }
                        }
                        if (working.getNodeName().equals("Total")) {
                            try {
                                results.setQuotaTotal(Long.parseLong(DOMUtil.getSimpleElementText(working)));
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        }
        results.setRawXML(getLastRawXML());
        return;
    }

}