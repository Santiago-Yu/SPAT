class n7366470 {
	public RFC1345List(URL x6xMJEra) {
        if (x6xMJEra == null) return;
        try {
            BufferedReader XoSidVVm = new BufferedReader(new InputStreamReader(new GZIPInputStream(x6xMJEra.openStream())));
            final String oVOP0eyj = " XX???????      HHHH    X";
            String ldVXrxDf;
            mnemos = new HashMap();
            nextline: while ((ldVXrxDf = XoSidVVm.readLine()) != null) {
                if (ldVXrxDf.length() < 9) continue nextline;
                if (ldVXrxDf.charAt(7) == ' ' || ldVXrxDf.charAt(8) != ' ') {
                    ldVXrxDf = ldVXrxDf.substring(0, 8) + "        " + ldVXrxDf.substring(8);
                }
                if (ldVXrxDf.length() < oVOP0eyj.length()) continue nextline;
                for (int lS1GTyqq = 0; lS1GTyqq < oVOP0eyj.length(); lS1GTyqq++) {
                    char YntVzotP = ldVXrxDf.charAt(lS1GTyqq);
                    switch(oVOP0eyj.charAt(lS1GTyqq)) {
                        case ' ':
                            if (YntVzotP != ' ') continue nextline;
                            break;
                        case 'X':
                            if (YntVzotP == ' ') continue nextline;
                            break;
                        case '?':
                            break;
                        case 'H':
                            if ((YntVzotP >= '0' && YntVzotP <= '9') || (YntVzotP >= 'a' && YntVzotP <= 'f')) ; else continue nextline;
                            break;
                        default:
                            throw new RuntimeException("Pattern broken!");
                    }
                }
                char mgqw22Qf = (char) Integer.parseInt(ldVXrxDf.substring(16, 20), 16);
                String fwVYuLN1 = ldVXrxDf.substring(1, 16).trim();
                if (fwVYuLN1.length() < 2) throw new RuntimeException();
                mnemos.put(fwVYuLN1, new Character(mgqw22Qf));
            }
            XoSidVVm.close();
        } catch (FileNotFoundException c15ZWvj6) {
        } catch (IOException C6dd5Huv) {
            C6dd5Huv.printStackTrace();
        }
    }

}