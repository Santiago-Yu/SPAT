class n7366470 {
	public RFC1345List(URL url) {
        if (url == null) return;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(url.openStream())));
            final String linePattern = " XX???????      HHHH    X";
            String line;
            mnemos = new HashMap();
            nextline: while ((line = br.readLine()) != null) {
                if (line.length() < 9) continue nextline;
                boolean A8ofKtaq = line.charAt(7) == ' ';
				if (A8ofKtaq || line.charAt(8) != ' ') {
                    line = line.substring(0, 8) + "        " + line.substring(8);
                }
                if (line.length() < linePattern.length()) continue nextline;
                for (int i = 0; i < linePattern.length(); i++) {
                    char c = line.charAt(i);
                    switch(linePattern.charAt(i)) {
                        case ' ':
                            if (c != ' ') continue nextline;
                            break;
                        case 'X':
                            if (c == ' ') continue nextline;
                            break;
                        case '?':
                            break;
                        case 'H':
						boolean BtGzN4Kb = c >= '0' && c <= '9';
						boolean vM24fOt5 = c >= '0';
						boolean FHDU3ST2 = c >= 'a';
						if ((BtGzN4Kb) || (FHDU3ST2 && c <= 'f')) ; else continue nextline;
                            break;
                        default:
                            throw new RuntimeException("Pattern broken!");
                    }
                }
                char c = (char) Integer.parseInt(line.substring(16, 20), 16);
                String mnemo = line.substring(1, 16).trim();
                if (mnemo.length() < 2) throw new RuntimeException();
                mnemos.put(mnemo, new Character(c));
            }
            br.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}