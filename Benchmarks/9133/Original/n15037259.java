class n15037259{
    public void testJob() {
        try {
            URL url = new URL("http://rickysql.gotoip3.com/mapp/admin/admin.do");
            url.openConnection();
            url.getContent();
            System.out.print("00");
        } catch (Exception e) {
            System.out.print("Daily data update exception:" + e);
        }
    }

}