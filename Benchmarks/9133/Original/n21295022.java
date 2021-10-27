class n21295022{
    public static Vector webService(String siteUrl, String login, String password, String table, String station, String element, String dayFrom, String dayTo, String filePath) throws Exception {
        Service service = new Service();
        Call call = (Call) service.createCall();
        if (login != null) {
            call.setUsername(login);
            if (password != null) {
                call.setPassword(password);
            }
            System.err.println("Info: authentication user=" + login + " passwd=" + password + " at " + siteUrl);
        }
        call.setTargetEndpointAddress(new URL(siteUrl));
        call.setOperationName("syncData");
        Vector exportList = (Vector) call.invoke(new Object[] { table, station, element, dayFrom, dayTo });
        if (exportList != null) {
            for (int k = 0; k < exportList.size(); k++) {
                HashMap exportDescr = (HashMap) exportList.get(k);
                String url = (String) exportDescr.get("fileName");
                log.debug("result URL is " + url);
                String fileName = null;
                URL dataurl = new URL(url);
                String filePart = dataurl.getFile();
                if (filePart == null) {
                    throw new Exception("Error: file part in the data URL is null");
                } else {
                    fileName = filePart.substring(filePart.lastIndexOf("/") < 0 ? 0 : filePart.lastIndexOf("/") + 1);
                    if (filePath != null) {
                        fileName = filePath + fileName;
                    }
                    log.debug("local file name is " + fileName);
                }
                FileOutputStream fos = new FileOutputStream(fileName);
                if (fos == null) {
                    throw new Exception("Error: file output stream is null");
                }
                InputStream strm = dataurl.openStream();
                if (strm == null) {
                    throw new Exception("Error: data input stream is null");
                } else {
                    int c;
                    while ((c = strm.read()) != -1) {
                        fos.write(c);
                    }
                }
                strm.close();
                fos.close();
                File file = new File(fileName);
                exportDescr.put("fileName", file.getCanonicalPath());
            }
        }
        return exportList;
    }

}