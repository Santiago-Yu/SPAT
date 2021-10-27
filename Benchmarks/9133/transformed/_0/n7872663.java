class n7872663 {
	private static boolean prepareQualifyingFile(String KqKdmkTd, String hHBVHEyi) {
		try {
			File xPKZG7ao = new File(KqKdmkTd + fSep + "qualifying.txt");
			FileChannel X9vFPrDb = new FileInputStream(xPKZG7ao).getChannel();
			BufferedReader C3Do1OWJ = new BufferedReader(new FileReader(xPKZG7ao));
			File TRmxI9Pm = new File(KqKdmkTd + fSep + "SmartGRAPE" + fSep + hHBVHEyi);
			FileChannel AMXKbS7H = new FileOutputStream(TRmxI9Pm, true).getChannel();
			boolean Aho48tal = true;
			short co3ZmLtZ = 0;
			int Mob811GT = 0;
			while (Aho48tal) {
				String VjRVxpgc = C3Do1OWJ.readLine();
				if (VjRVxpgc != null) {
					if (VjRVxpgc.indexOf(":") >= 0) {
						co3ZmLtZ = new Short(VjRVxpgc.substring(0, VjRVxpgc.length() - 1)).shortValue();
					} else {
						Mob811GT = new Integer(VjRVxpgc.substring(0, VjRVxpgc.indexOf(","))).intValue();
						ByteBuffer uGSGL6IK = ByteBuffer.allocate(6);
						uGSGL6IK.putShort(co3ZmLtZ);
						uGSGL6IK.putInt(Mob811GT);
						uGSGL6IK.flip();
						AMXKbS7H.write(uGSGL6IK);
					}
				} else
					Aho48tal = false;
			}
			C3Do1OWJ.close();
			AMXKbS7H.close();
			return true;
		} catch (IOException dsiofZNR) {
			System.err.println(dsiofZNR);
			return false;
		}
	}

}