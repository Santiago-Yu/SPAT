class n10332951{
    public static void loginSkyDrive() throws Exception {
        System.out.println("login ");
        u = new URL(loginurl);
        uc = (HttpURLConnection) u.openConnection();
        uc.setRequestProperty("Cookie", msprcookie + ";" + mspokcookie);
        uc.setDoOutput(true);
        uc.setRequestMethod("POST");
        uc.setInstanceFollowRedirects(false);
        pw = new PrintWriter(new OutputStreamWriter(uc.getOutputStream()), true);
        pw.print("login=dinesh007007%40hotmail.com&passwd=&SI=Sign+in&type=11&LoginOptions=3&NewUser=1&MEST=&PPSX=Passpor&PPFT=" + ppft + "&PwdPad=&sso=&i1=&i2=1&i3=10524&i4=&i12=1&i13=&i14=437&i15=624&i16=3438");
        pw.flush();
        pw.close();
        System.out.println(uc.getResponseCode());
        Map<String, List<String>> headerFields = uc.getHeaderFields();
        if (headerFields.containsKey("Set-Cookie")) {
            List<String> header = headerFields.get("Set-Cookie");
            for (int i = 0; i < header.size(); i++) {
                tmp = header.get(i);
                System.out.println(tmp);
            }
        }
        location = uc.getHeaderField("Location");
        System.out.println("Location : " + location);
        System.out.println("going to open paaport page");
        DefaultHttpClient d = new DefaultHttpClient();
        HttpGet hg = new HttpGet("https://skydrive.live.com");
        hg.setHeader("Cookie", msprcookie + ";" + mspokcookie);
        HttpResponse execute = d.execute(hg);
        HttpEntity entity = execute.getEntity();
        System.out.println(EntityUtils.toString(entity));
        System.out.println(execute.getStatusLine());
        Header[] allHeaders = execute.getAllHeaders();
        for (int i = 0; i < allHeaders.length; i++) {
            System.out.println(allHeaders[i].getName() + " : " + allHeaders[i].getValue());
        }
    }

}