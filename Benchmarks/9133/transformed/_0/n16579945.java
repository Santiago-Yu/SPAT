class n16579945 {
	public he3Decode(String HW5CEos8) {
        try {
            File F5TFJrCp = new File(HW5CEos8 + extension);
            File U3VooCcT = new File(HW5CEos8);
            int figO9ZsD = (int) U3VooCcT.length();
            FileInputStream IUewd42a = new FileInputStream(HW5CEos8);
            F5TFJrCp.createNewFile();
            FileOutputStream mjKC03q1 = new FileOutputStream(F5TFJrCp.getName());
            ByteArrayOutputStream YdHbL9vb = new ByteArrayOutputStream(figO9ZsD);
            byte OshO0CMI[] = new byte[8];
            int sGfZyoJG = OshO0CMI.length;
            int U7nqyE9z = 0;
            int SuKo9hUJ = 0;
            System.out.println(appname + ".\n" + "decoding: " + HW5CEos8 + "\n" + "decoding to: " + HW5CEos8 + extension + "\n" + "\nreading: ");
            while (U7nqyE9z < figO9ZsD) {
                SuKo9hUJ = IUewd42a.read(OshO0CMI, 0, sGfZyoJG);
                if (SuKo9hUJ == -1) break;
                YdHbL9vb.write(OshO0CMI, 0, SuKo9hUJ);
                U7nqyE9z += SuKo9hUJ;
                System.out.print("*");
            }
            System.out.print("\ndecoding: ");
            mjKC03q1.write(_decode((ByteArrayOutputStream) YdHbL9vb));
            System.out.print("complete\n\n");
        } catch (java.io.FileNotFoundException QoKmDese) {
            System.err.println("Exception: " + QoKmDese.getMessage());
        } catch (java.io.IOException A1SaCiR5) {
            System.err.println("Exception: " + A1SaCiR5.getMessage());
        }
    }

}