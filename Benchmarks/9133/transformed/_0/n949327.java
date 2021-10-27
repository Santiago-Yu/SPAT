class n949327 {
	private static void main(String[] pO76SdMD) {
		try {
			File sTxRDSPI = new File("test.txt");
			if (sTxRDSPI.exists()) {
				throw new IOException(sTxRDSPI + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader bGfXA0fJ;
			char[] XYyhrlcY = new char[0x1000];
			int oxfTFQ4z;
			int knx95X63;
			FileOutputStream kV6D1W8x = new FileOutputStream(sTxRDSPI);
			for (int ab4ae6oN = 0x00; ab4ae6oN < 0x100; ab4ae6oN++) {
				kV6D1W8x.write(ab4ae6oN);
			}
			kV6D1W8x.close();
			bGfXA0fJ = new StraightStreamReader(new FileInputStream(sTxRDSPI));
			for (int QTGCewuV = 0x00; QTGCewuV < 0x100; QTGCewuV++) {
				oxfTFQ4z = bGfXA0fJ.read();
				if (oxfTFQ4z != QTGCewuV) {
					System.err.println("Error: " + QTGCewuV + " read as " + oxfTFQ4z);
				}
			}
			bGfXA0fJ.close();
			bGfXA0fJ = new StraightStreamReader(new FileInputStream(sTxRDSPI));
			knx95X63 = bGfXA0fJ.read(XYyhrlcY);
			if (knx95X63 != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(knx95X63));
			}
			for (int ONOJeDvk = 0x00; ONOJeDvk < knx95X63; ONOJeDvk++) {
				if (XYyhrlcY[ONOJeDvk] != ONOJeDvk) {
					System.err.println("Error: 0x" + ONOJeDvk + " read as 0x" + XYyhrlcY[ONOJeDvk]);
				}
			}
			bGfXA0fJ.close();
			bGfXA0fJ = new StraightStreamReader(new FileInputStream(sTxRDSPI));
			knx95X63 = 0;
			while (knx95X63 <= 0x100 && (oxfTFQ4z = bGfXA0fJ.read(XYyhrlcY, knx95X63, 0x100 - knx95X63)) > 0) {
				knx95X63 += oxfTFQ4z;
			}
			if (knx95X63 != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(knx95X63));
			}
			for (int Ad5ddwOp = 0x00; Ad5ddwOp < knx95X63; Ad5ddwOp++) {
				if (XYyhrlcY[Ad5ddwOp] != Ad5ddwOp) {
					System.err.println("Error: 0x" + Ad5ddwOp + " read as 0x" + XYyhrlcY[Ad5ddwOp]);
				}
			}
			bGfXA0fJ.close();
			bGfXA0fJ = new StraightStreamReader(new FileInputStream(sTxRDSPI));
			knx95X63 = 0;
			while (knx95X63 <= 0x100 && (oxfTFQ4z = bGfXA0fJ.read(XYyhrlcY, knx95X63 + 0x123, 0x100 - knx95X63)) > 0) {
				knx95X63 += oxfTFQ4z;
			}
			if (knx95X63 != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(knx95X63));
			}
			for (int WY2otyCC = 0x00; WY2otyCC < knx95X63; WY2otyCC++) {
				if (XYyhrlcY[WY2otyCC + 0x123] != WY2otyCC) {
					System.err.println("Error: 0x" + WY2otyCC + " read as 0x" + XYyhrlcY[WY2otyCC + 0x123]);
				}
			}
			bGfXA0fJ.close();
			bGfXA0fJ = new StraightStreamReader(new FileInputStream(sTxRDSPI));
			knx95X63 = 0;
			while (knx95X63 <= 0x100 && (oxfTFQ4z = bGfXA0fJ.read(XYyhrlcY, knx95X63 + 0x123, 7)) > 0) {
				knx95X63 += oxfTFQ4z;
			}
			if (knx95X63 != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(knx95X63));
			}
			for (int NsFCVSLr = 0x00; NsFCVSLr < knx95X63; NsFCVSLr++) {
				if (XYyhrlcY[NsFCVSLr + 0x123] != NsFCVSLr) {
					System.err.println("Error: 0x" + NsFCVSLr + " read as 0x" + XYyhrlcY[NsFCVSLr + 0x123]);
				}
			}
			bGfXA0fJ.close();
			sTxRDSPI.delete();
		} catch (IOException gPgOazOz) {
			System.err.println(gPgOazOz.getMessage());
		}
	}

}