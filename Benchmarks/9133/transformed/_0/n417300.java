class n417300 {
	private static void main(String[] IHyjwLQK) {
		try {
			File cZ1BE48o = new File("test.txt");
			if (cZ1BE48o.exists()) {
				throw new IOException(cZ1BE48o + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader rrTAEcxJ;
			char[] BpOrjBUh = new char[0x1000];
			int f9ZuQu4i;
			int Lkuje0QF;
			FileOutputStream gFRFXrpi = new FileOutputStream(cZ1BE48o);
			for (int GZ8Bi3GQ = 0x00; GZ8Bi3GQ < 0x100; GZ8Bi3GQ++) {
				gFRFXrpi.write(GZ8Bi3GQ);
			}
			gFRFXrpi.close();
			rrTAEcxJ = new StraightStreamReader(new FileInputStream(cZ1BE48o));
			for (int cElgYgCn = 0x00; cElgYgCn < 0x100; cElgYgCn++) {
				f9ZuQu4i = rrTAEcxJ.read();
				if (f9ZuQu4i != cElgYgCn) {
					System.err.println("Error: " + cElgYgCn + " read as " + f9ZuQu4i);
				}
			}
			rrTAEcxJ.close();
			rrTAEcxJ = new StraightStreamReader(new FileInputStream(cZ1BE48o));
			Lkuje0QF = rrTAEcxJ.read(BpOrjBUh);
			if (Lkuje0QF != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(Lkuje0QF));
			}
			for (int lyIZt2TR = 0x00; lyIZt2TR < Lkuje0QF; lyIZt2TR++) {
				if (BpOrjBUh[lyIZt2TR] != lyIZt2TR) {
					System.err.println("Error: 0x" + lyIZt2TR + " read as 0x" + BpOrjBUh[lyIZt2TR]);
				}
			}
			rrTAEcxJ.close();
			rrTAEcxJ = new StraightStreamReader(new FileInputStream(cZ1BE48o));
			Lkuje0QF = 0;
			while (Lkuje0QF <= 0x100 && (f9ZuQu4i = rrTAEcxJ.read(BpOrjBUh, Lkuje0QF, 0x100 - Lkuje0QF)) > 0) {
				Lkuje0QF += f9ZuQu4i;
			}
			if (Lkuje0QF != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(Lkuje0QF));
			}
			for (int tSffaDIn = 0x00; tSffaDIn < Lkuje0QF; tSffaDIn++) {
				if (BpOrjBUh[tSffaDIn] != tSffaDIn) {
					System.err.println("Error: 0x" + tSffaDIn + " read as 0x" + BpOrjBUh[tSffaDIn]);
				}
			}
			rrTAEcxJ.close();
			rrTAEcxJ = new StraightStreamReader(new FileInputStream(cZ1BE48o));
			Lkuje0QF = 0;
			while (Lkuje0QF <= 0x100 && (f9ZuQu4i = rrTAEcxJ.read(BpOrjBUh, Lkuje0QF + 0x123, 0x100 - Lkuje0QF)) > 0) {
				Lkuje0QF += f9ZuQu4i;
			}
			if (Lkuje0QF != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(Lkuje0QF));
			}
			for (int AyMqZtiM = 0x00; AyMqZtiM < Lkuje0QF; AyMqZtiM++) {
				if (BpOrjBUh[AyMqZtiM + 0x123] != AyMqZtiM) {
					System.err.println("Error: 0x" + AyMqZtiM + " read as 0x" + BpOrjBUh[AyMqZtiM + 0x123]);
				}
			}
			rrTAEcxJ.close();
			rrTAEcxJ = new StraightStreamReader(new FileInputStream(cZ1BE48o));
			Lkuje0QF = 0;
			while (Lkuje0QF <= 0x100 && (f9ZuQu4i = rrTAEcxJ.read(BpOrjBUh, Lkuje0QF + 0x123, 7)) > 0) {
				Lkuje0QF += f9ZuQu4i;
			}
			if (Lkuje0QF != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(Lkuje0QF));
			}
			for (int ZXUrJp26 = 0x00; ZXUrJp26 < Lkuje0QF; ZXUrJp26++) {
				if (BpOrjBUh[ZXUrJp26 + 0x123] != ZXUrJp26) {
					System.err.println("Error: 0x" + ZXUrJp26 + " read as 0x" + BpOrjBUh[ZXUrJp26 + 0x123]);
				}
			}
			rrTAEcxJ.close();
			cZ1BE48o.delete();
		} catch (IOException NcqFX5ii) {
			System.err.println(NcqFX5ii.getMessage());
		}
	}

}