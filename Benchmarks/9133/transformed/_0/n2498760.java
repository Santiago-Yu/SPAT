class n2498760 {
	public Main(String[] oeDbD1bb) {
        boolean VHdLWwAe = false;
        if (oeDbD1bb[0].compareTo("-e") == 0) {
            VHdLWwAe = true;
        } else if (oeDbD1bb[0].compareTo("-d") == 0) {
            VHdLWwAe = false;
        } else {
            System.out.println("first argument is invalid");
            System.exit(-2);
        }
        char[] quHcKosb = new char[oeDbD1bb[2].length()];
        for (int fowFEso3 = 0; fowFEso3 < oeDbD1bb[2].length(); fowFEso3++) {
            quHcKosb[fowFEso3] = (char) oeDbD1bb[2].getBytes()[fowFEso3];
        }
        try {
            InitializeCipher(VHdLWwAe, quHcKosb);
        } catch (Exception jlHs1d8m) {
            System.out.println("error initializing cipher");
            System.exit(-3);
        }
        try {
            InputStream HkNXRRJh = new FileInputStream(oeDbD1bb[1]);
            OutputStream fedhVrqI;
            int ISYyp5ad, cxVeougt = 10;
            byte[] UEaEjMof = new byte[cxVeougt];
            if (VHdLWwAe) {
                fedhVrqI = new FileOutputStream(oeDbD1bb[1] + ".enc");
                fedhVrqI = new CipherOutputStream(fedhVrqI, cipher);
            } else {
                fedhVrqI = new FileOutputStream(oeDbD1bb[1] + ".dec");
                HkNXRRJh = new CipherInputStream(HkNXRRJh, cipher);
            }
            ISYyp5ad = HkNXRRJh.read(UEaEjMof);
            while (ISYyp5ad != -1) {
                fedhVrqI.write(UEaEjMof, 0, ISYyp5ad);
                ISYyp5ad = HkNXRRJh.read(UEaEjMof);
            }
            while (ISYyp5ad == cxVeougt) ;
            fedhVrqI.close();
            HkNXRRJh.close();
            System.out.println(new String(UEaEjMof));
        } catch (Exception nRMPxvbD) {
            System.out.println("error encrypting/decrypting message:");
            nRMPxvbD.printStackTrace();
            System.exit(-4);
        }
        System.out.println("done");
    }

}