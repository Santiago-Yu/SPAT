class n20979133{
    public String report() {
        if (true) return "-";
        StringBuffer parameter = new StringBuffer("?");
        if (getRecord_ID() == 0) return "ID=0";
        if (getRecord_ID() == 1) {
            parameter.append("ISSUE=");
            HashMap htOut = get_HashMap();
            try {
                ByteArrayOutputStream bOut = new ByteArrayOutputStream();
                ObjectOutput oOut = new ObjectOutputStream(bOut);
                oOut.writeObject(htOut);
                oOut.flush();
                String hexString = Secure.convertToHexString(bOut.toByteArray());
                parameter.append(hexString);
            } catch (Exception e) {
                log.severe(e.getLocalizedMessage());
                return "New-" + e.getLocalizedMessage();
            }
        } else {
            try {
                parameter.append("RECORDID=").append(getRecord_ID());
                parameter.append("&DBADDRESS=").append(URLEncoder.encode(getDBAddress(), "UTF-8"));
                parameter.append("&COMMENTS=").append(URLEncoder.encode(getComments(), "UTF-8"));
            } catch (Exception e) {
                log.severe(e.getLocalizedMessage());
                return "Update-" + e.getLocalizedMessage();
            }
        }
        InputStreamReader in = null;
        String target = "http://dev1/wstore/issueReportServlet";
        try {
            StringBuffer urlString = new StringBuffer(target).append(parameter);
            URL url = new URL(urlString.toString());
            URLConnection uc = url.openConnection();
            in = new InputStreamReader(uc.getInputStream());
        } catch (Exception e) {
            String msg = "Cannot connect to http://" + target;
            if (e instanceof FileNotFoundException || e instanceof ConnectException) msg += "\nServer temporarily down - Please try again later"; else {
                msg += "\nCheck connection - " + e.getLocalizedMessage();
                log.log(Level.FINE, msg);
            }
            return msg;
        }
        return readResponse(in);
    }

}