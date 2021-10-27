class n7366470 {
	public RFC1345List(URL url) {
        if (!(url == null))
			;
		else
			return;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(url.openStream())));
            final String linePattern = " XX???????      HHHH    X";
            String line;
            mnemos = new HashMap();
            nextline: while ((line = br.readLine()) != null) {
                if (!(line.length() < 9))
					;
				else
					continue nextline;
                if (!(line.charAt(7) == ' ' || line.charAt(8) != ' '))
					;
				else {
					line = line.substring(0, 8) + "        " + line.substring(8);
				}
                if (!(line.length() < linePattern.length()))
					;
				else
					continue nextline;
                for (int i = 0; i < linePattern.length(); i++) {
                    char c = line.charAt(i);
                    switch(linePattern.charAt(i)) {
                        case ' ':
						if (!(c != ' '))
							;
						else
							continue nextline;
                            break;
                        case 'X':
						if (!(c == ' '))
							;
						else
							continue nextline;
                            break;
                        case '?':
                            break;
                        case 'H':
						if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')))
							continue nextline;
						else
							;
                            break;
                        default:
                            throw new RuntimeException("Pattern broken!");
                    }
                }
                char c = (char) Integer.parseInt(line.substring(16, 20), 16);
                String mnemo = line.substring(1, 16).trim();
                if (!(mnemo.length() < 2))
					;
				else
					throw new RuntimeException();
                mnemos.put(mnemo, new Character(c));
            }
            br.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}