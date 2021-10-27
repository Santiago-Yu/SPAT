class n1141235{
    public static void main(String[] args) {
        String u = "http://portal.acm.org/results.cfm?query=%28Author%3A%22" + "Boehm%2C+Barry" + "%22%29&srt=score%20dsc&short=0&source_disp=&since_month=&since_year=&before_month=&before_year=&coll=ACM&dl=ACM&termshow=matchboolean&range_query=&CFID=22704101&CFTOKEN=37827144&start=1";
        URL url = null;
        AcmSearchresultPageParser_2011Jan cb = new AcmSearchresultPageParser_2011Jan();
        try {
            url = new URL(u);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setUseCaches(false);
            InputStream is = uc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            ParserDelegator pd = new ParserDelegator();
            pd.parse(br, cb, true);
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("all doc num= " + cb.getAllDocNum());
        for (int i = 0; i < cb.getEachResultStartPositions().size(); i++) {
            HashMap<String, Integer> m = cb.getEachResultStartPositions().get(i);
            System.out.println(i + "pos= " + m);
        }
    }

}