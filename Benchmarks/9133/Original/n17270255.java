class n17270255{
    @SuppressWarnings("static-access")
    public void run() {
        valuesRow = new String[this.getMaxCounter()];
        for (int i = 0; i < this.getMaxCounter(); i++) {
            InputStream is = null;
            try {
                String surl = "http://download.finance.yahoo.com/d/quotes.csv?s=^GDAXI&f=sl1d1t1c1ohgv&e=.csv";
                URL url = new URL(surl);
                is = url.openStream();
                BufferedReader dis = new BufferedReader(new InputStreamReader(is));
                String s = dis.readLine();
                System.out.println(s);
                valuesRow[i] = s;
                is.close();
            } catch (MalformedURLException mue) {
                System.out.println("Ouch - a MalformedURLException happened.");
                mue.printStackTrace();
                System.exit(1);
            } catch (IOException ioe) {
                System.out.println("Oops- an IOException happened.");
                ioe.printStackTrace();
                System.exit(1);
            }
            try {
                Thread.currentThread().sleep(this.getTsleep());
            } catch (InterruptedException e) {
            }
        }
        System.out.println("valuesRow.length=" + valuesRow.length);
    }

}