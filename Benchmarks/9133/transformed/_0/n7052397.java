class n7052397 {
	public ReqJsonContent(String Ygn9K2nw, String gMgdm6Qz, String hbZlwg9Q, String fep7sRb4, String oiGnyW0C) throws IOException {
        URL GU9BFVXx = new URL(gMgdm6Qz);
        URLConnection ZpB9lwru = GU9BFVXx.openConnection();
        ZpB9lwru.setRequestProperty("user-agent", Ygn9K2nw);
        ZpB9lwru.setRequestProperty("pathinfo", fep7sRb4);
        ZpB9lwru.setRequestProperty("domain", hbZlwg9Q);
        try {
            BufferedReader Ton10pgY = new BufferedReader(new InputStreamReader(ZpB9lwru.getInputStream(), "UTF8"));
            response = new StringBuffer();
            String aoAR2wM5 = "";
            while ((aoAR2wM5 = Ton10pgY.readLine()) != null) {
                response.append(aoAR2wM5);
            }
            Ton10pgY.close();
            jsonContectResult = response.toString();
        } catch (SocketTimeoutException hnLuGgrz) {
            log.severe(oiGnyW0C + "-> " + hnLuGgrz.getMessage());
            jsonContectResult = null;
        } catch (Exception R9aa8TLf) {
            log.severe(oiGnyW0C + "-> " + R9aa8TLf.getMessage());
            jsonContectResult = null;
        }
    }

}