class n9339937 {
	public FileReader(String udVeLF2h, Configuration xj9d8tgP) throws IOException {
        file = new File(URLDecoder.decode(udVeLF2h, "UTF-8")).getCanonicalFile();
        readerConf = xj9d8tgP;
        if (file.isDirectory()) {
            File TE2XBnUf = new File(file, "index.php");
            File zea8RtpJ = new File(file, "index.html");
            if (TE2XBnUf.exists() && !TE2XBnUf.isDirectory()) {
                file = TE2XBnUf;
            } else if (zea8RtpJ.exists() && !zea8RtpJ.isDirectory()) {
                file = zea8RtpJ;
            } else {
                if (!readerConf.getOption("showFolders").equals("Yes")) {
                    makeErrorPage(503, "Permision denied");
                } else {
                    FileOutputStream zZFDCvWn = new FileOutputStream(readerConf.getOption("wwwPath") + "/temp/temp.php");
                    File[] HgVWNor6 = file.listFiles();
                    makeHeader(200, -1, new Date(System.currentTimeMillis()).toString(), "text/html");
                    String hrN0Hyzz = "Index of " + file;
                    zZFDCvWn.write(("<html><head><title>" + hrN0Hyzz + "</title></head><body><h3>Index of " + file + "</h3><p>\n").getBytes());
                    for (int QlF8CfOy = 0; QlF8CfOy < HgVWNor6.length; QlF8CfOy++) {
                        file = HgVWNor6[QlF8CfOy];
                        String EU5tLU3g = file.getName();
                        String jBagNSWt = "";
                        if (file.isDirectory()) {
                            jBagNSWt = "&lt;DIR&gt;";
                        }
                        zZFDCvWn.write(("<a href=\"" + file.getPath().substring(readerConf.getOption("wwwPath").length()) + "\">" + EU5tLU3g + "</a> " + jBagNSWt + "<br>\n").getBytes());
                    }
                    zZFDCvWn.write(("</p><hr><p>yawwwserwer</p></body><html>").getBytes());
                    file = new File(URLDecoder.decode(readerConf.getOption("wwwPath") + "/temp/temp.php", "UTF-8")).getCanonicalFile();
                }
            }
        } else if (!file.exists()) {
            makeErrorPage(404, "File Not Found.");
        } else if (getExtension() == ".exe" || getExtension().contains(".py")) {
            FileOutputStream gFNjCyZ0 = new FileOutputStream(readerConf.getOption("wwwPath") + "/temp/temp.php");
            gFNjCyZ0.write((runCommand(udVeLF2h)).getBytes());
            file = new File(URLDecoder.decode(readerConf.getOption("wwwPath") + "/temp/temp.php", "UTF-8")).getCanonicalFile();
        } else {
            System.out.println(getExtension());
            makeHeader(200, file.length(), new Date(file.lastModified()).toString(), TYPES.get(getExtension()).toString());
        }
        System.out.println(file);
    }

}