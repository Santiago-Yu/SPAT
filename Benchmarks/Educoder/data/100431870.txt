    public void test() {
        try {
            String query = "* <http://xmlns.com/foaf/0.1/workplaceHomepage> <http://www.deri.ie/>" + "* <http://xmlns.com/foaf/0.1/knows> *";
            String url = "http://sindice.com/api/v2/search?qt=advanced&q=" + URLEncoder.encode(query, "utf-8") + "&qt=advanced";
            URL urlObj = new URL(url);
            URLConnection con = urlObj.openConnection();
            if (con != null) {
                Model model = ModelFactory.createDefaultModel();
                model.read(con.getInputStream(), null);
            }
            System.out.println(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
