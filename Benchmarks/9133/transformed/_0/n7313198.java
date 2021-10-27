class n7313198 {
	public ForDomainparReq(String Y5qHjLZX, String d5hWczNG) throws IOException {
        URL vETberIF = new URL(Y5qHjLZX);
        URLConnection NMAjgnxE = vETberIF.openConnection();
        NMAjgnxE.setRequestProperty("domain", d5hWczNG);
        try {
            BufferedReader KueqAwOw = new BufferedReader(new InputStreamReader(NMAjgnxE.getInputStream(), "UTF8"));
            StringBuffer VxGcFmFW = new StringBuffer();
            String USdrnHBm = "";
            while ((USdrnHBm = KueqAwOw.readLine()) != null) {
                VxGcFmFW.append(USdrnHBm);
            }
            KueqAwOw.close();
            jsonContectResult = VxGcFmFW.toString();
        } catch (SocketTimeoutException oubL9GOO) {
            log.severe("SoketTimeout NO!! RC  try again !!" + oubL9GOO.getMessage());
            jsonContectResult = null;
        } catch (Exception yeK6KY4y) {
            log.severe("Except Rescue Start !! RC try again!! " + yeK6KY4y.getMessage());
            jsonContectResult = null;
        }
    }

}