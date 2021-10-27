class n15758921{
    public boolean Load_Clickable_Peaks_Source_File(String tam) {
        if (tam == null) return false;
        try {
            URL url = new URL(getDocumentBase(), tam);
            InputStream stream = url.openStream();
            DataInputStream fichier = new DataInputStream(stream);
            texte = new Vector();
            String s;
            while ((s = fichier.readLine()) != null) {
                texte.addElement(s);
            }
            My_ZoneVisu.Nb_Clickable_Peaks = texte.size();
        } catch (Exception e) {
            return false;
        }
        My_ZoneVisu.Peak_Start = new double[My_ZoneVisu.Nb_Clickable_Peaks];
        My_ZoneVisu.Peak_Stop = new double[My_ZoneVisu.Nb_Clickable_Peaks];
        My_ZoneVisu.Peak_Html = new String[My_ZoneVisu.Nb_Clickable_Peaks];
        int cpt_tokens = 0;
        int i = 0;
        StringTokenizer mon_token;
        while (cpt_tokens < My_ZoneVisu.Nb_Clickable_Peaks) {
            do {
                String mysub = (String) texte.elementAt(cpt_tokens);
                mon_token = new StringTokenizer(mysub, " ");
                cpt_tokens++;
            } while (cpt_tokens < My_ZoneVisu.Nb_Clickable_Peaks && mon_token.hasMoreTokens() == false);
            if (mon_token.hasMoreTokens() == true) {
                My_ZoneVisu.Peak_Start[i] = Double.valueOf(mon_token.nextToken()).doubleValue();
                My_ZoneVisu.Peak_Stop[i] = Double.valueOf(mon_token.nextToken()).doubleValue();
                if (My_ZoneVisu.Peak_Start[i] > My_ZoneVisu.Peak_Stop[i]) {
                    double temp = My_ZoneVisu.Peak_Start[i];
                    My_ZoneVisu.Peak_Start[i] = My_ZoneVisu.Peak_Stop[i];
                    My_ZoneVisu.Peak_Stop[i] = temp;
                }
                My_ZoneVisu.Peak_Html[i] = (String) mon_token.nextToken();
            }
            i++;
        }
        return true;
    }

}