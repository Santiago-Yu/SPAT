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
                if (line.charAt(7) == ' ' || line.charAt(8) != ' ') {
                    line = line.substring(0, 8) + "        " + line.substring(8);
                }
                if (line.length() < linePattern.length()) continue nextline;
                int SkRYP = 0;
				while (SkRYP < linePattern.length()) {
					char c = line.charAt(SkRYP);
					switch (linePattern.charAt(SkRYP)) {
					case ' ':
						if (c != ' ')
							continue nextline;
						break;
					case 'X':
						if (c == ' ')
							continue nextline;
						break;
					case '?':
						break;
					case 'H':
						if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f'))
							;
						else
							continue nextline;
						break;
					default:
						throw new RuntimeException("Pattern broken!");
					}
					SkRYP++;
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