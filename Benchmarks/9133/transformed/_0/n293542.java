class n293542 {
	public stock(String mkmWMSnp) {
        try {
            URL LnGPpdxD = new URL("http://finance.yahoo.com/q?s=" + mkmWMSnp + "&d=v1");
            BufferedReader ZbwsLw5z = new BufferedReader(new InputStreamReader(LnGPpdxD.openStream()));
            String fbz8yrrL;
            StringBuffer XXkElMot = new StringBuffer(8192);
            while ((fbz8yrrL = ZbwsLw5z.readLine()) != null) {
                XXkElMot.append(fbz8yrrL);
            }
            LispInterpreter QwcIkScJ = InterpreterFactory.getInterpreter();
            QwcIkScJ.eval("(load \"nregex\")");
            String mIocae4n = QwcIkScJ.eval("(second (regex \"<b>([0-9][0-9]\\.[0-9][0-9])</b>\" \"" + cleanse(XXkElMot) + "\"))");
            System.out.println("Current quote: " + mIocae4n);
            QwcIkScJ.exit();
        } catch (Exception fbC4kaIo) {
            fbC4kaIo.printStackTrace();
        }
    }

}