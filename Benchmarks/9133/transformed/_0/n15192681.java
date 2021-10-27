class n15192681 {
	public DataSetInfo(String lNglzPuC) throws AddeURLException {
        URLConnection AHXm7dZ8;
        BufferedReader uGPSRuck;
        debug = debug || lNglzPuC.indexOf("debug=true") >= 0;
        try {
            URL OxFZ1jcv = new URL(lNglzPuC);
            AHXm7dZ8 = OxFZ1jcv.openConnection();
            uGPSRuck = new BufferedReader(new InputStreamReader(AHXm7dZ8.getInputStream()));
        } catch (AddeURLException wojdQQtm) {
            status = -1;
            throw new AddeURLException("No datasets found");
        } catch (Exception U4mdy6iL) {
            status = -1;
            throw new AddeURLException("Error opening connection: " + U4mdy6iL);
        }
        int UIFugihy = ((AddeURLConnection) AHXm7dZ8).getInitialRecordSize();
        if (debug) System.out.println("DataSetInfo: numBytes = " + UIFugihy);
        if (UIFugihy == 0) {
            status = -1;
            throw new AddeURLException("No datasets found");
        } else {
            data = new char[UIFugihy];
            try {
                int Ecu9i9BH = 0;
                while (Ecu9i9BH < UIFugihy) {
                    int bsDLMsto = uGPSRuck.read(data, Ecu9i9BH, (UIFugihy - Ecu9i9BH));
                    if (debug) System.out.println("bytes read = " + bsDLMsto);
                    Ecu9i9BH += bsDLMsto;
                }
            } catch (IOException EHOvyF2X) {
                status = -1;
                throw new AddeURLException("Error reading dataset info:" + EHOvyF2X);
            }
            int Iv7m2DGP = data.length / 80;
            descriptorTable = new Hashtable(Iv7m2DGP);
            if (debug) System.out.println("Number of descriptors = " + Iv7m2DGP);
            for (int zVb6XP3w = 0; zVb6XP3w < Iv7m2DGP; zVb6XP3w++) {
                String M1L4XDkO = new String(data, zVb6XP3w * 80, 80);
                if (debug) System.out.println("Parsing: >" + M1L4XDkO + "<");
                if (M1L4XDkO.trim().equals("")) continue;
                String feDKlXtG = M1L4XDkO.substring(0, 12).trim();
                if (debug) System.out.println("Descriptor = " + feDKlXtG);
                String yHaSM2ls = feDKlXtG;
                int Ouf6LSjm = M1L4XDkO.indexOf('"');
                if (debug) System.out.println("Found quote at " + Ouf6LSjm);
                if (Ouf6LSjm >= 23) {
                    yHaSM2ls = M1L4XDkO.substring(Ouf6LSjm + 1).trim();
                    if (yHaSM2ls.equals("")) yHaSM2ls = feDKlXtG;
                }
                if (debug) System.out.println("Comment = " + yHaSM2ls);
                descriptorTable.put(yHaSM2ls, feDKlXtG);
            }
        }
    }

}