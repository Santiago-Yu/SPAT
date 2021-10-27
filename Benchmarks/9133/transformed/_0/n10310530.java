class n10310530 {
	protected UnicodeList(URL x7ZQ6bIR) {
        try {
            BufferedReader JybJC3Ix = new BufferedReader(new InputStreamReader(new GZIPInputStream(x7ZQ6bIR.openStream())));
            String UbdAC7yP;
            UbdAC7yP = JybJC3Ix.readLine();
            chars = new ArrayList();
            while ((UbdAC7yP = JybJC3Ix.readLine()) != null) {
                String[] XN6EnSLm = GUIHelper.split(UbdAC7yP, ";");
                if (XN6EnSLm[0].length() >= 5) continue;
                if (XN6EnSLm.length < 2 || XN6EnSLm[0].length() != 4) {
                    System.out.println("Strange line: " + UbdAC7yP);
                } else {
                    if (XN6EnSLm.length > 10 && XN6EnSLm[1].equals("<control>")) {
                        XN6EnSLm[1] = XN6EnSLm[1] + ": " + XN6EnSLm[10];
                    }
                    try {
                        Integer.parseInt(XN6EnSLm[0], 16);
                        chars.add(XN6EnSLm[0] + XN6EnSLm[1]);
                    } catch (NumberFormatException eSAIzhZR) {
                        System.out.println("No number: " + UbdAC7yP);
                    }
                }
            }
            JybJC3Ix.close();
        } catch (FileNotFoundException OgLPqa23) {
        } catch (IOException TIDFT2Ic) {
            TIDFT2Ic.printStackTrace();
        }
    }

}