class n581756 {
	private static void main(String[] uqsJlznp) {
		try {
			File iyKrEXYA = new File("test.txt");
			if (iyKrEXYA.exists()) {
				throw new IOException(iyKrEXYA + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader EQr6eZRY;
			char[] EZOsHdqp = new char[0x1000];
			int t0RMBSfS;
			int wGZd6KVw;
			FileOutputStream OoOguCsn = new FileOutputStream(iyKrEXYA);
			for (int eojd41J5 = 0x00; eojd41J5 < 0x100; eojd41J5++) {
				OoOguCsn.write(eojd41J5);
			}
			OoOguCsn.close();
			EQr6eZRY = new StraightStreamReader(new FileInputStream(iyKrEXYA));
			for (int b34BFBuZ = 0x00; b34BFBuZ < 0x100; b34BFBuZ++) {
				t0RMBSfS = EQr6eZRY.read();
				if (t0RMBSfS != b34BFBuZ) {
					System.err.println("Error: " + b34BFBuZ + " read as " + t0RMBSfS);
				}
			}
			EQr6eZRY.close();
			EQr6eZRY = new StraightStreamReader(new FileInputStream(iyKrEXYA));
			wGZd6KVw = EQr6eZRY.read(EZOsHdqp);
			if (wGZd6KVw != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(wGZd6KVw));
			}
			for (int iCpRC8iX = 0x00; iCpRC8iX < wGZd6KVw; iCpRC8iX++) {
				if (EZOsHdqp[iCpRC8iX] != iCpRC8iX) {
					System.err.println("Error: 0x" + iCpRC8iX + " read as 0x" + EZOsHdqp[iCpRC8iX]);
				}
			}
			EQr6eZRY.close();
			EQr6eZRY = new StraightStreamReader(new FileInputStream(iyKrEXYA));
			wGZd6KVw = 0;
			while (wGZd6KVw <= 0x100 && (t0RMBSfS = EQr6eZRY.read(EZOsHdqp, wGZd6KVw, 0x100 - wGZd6KVw)) > 0) {
				wGZd6KVw += t0RMBSfS;
			}
			if (wGZd6KVw != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(wGZd6KVw));
			}
			for (int VZ61TY8A = 0x00; VZ61TY8A < wGZd6KVw; VZ61TY8A++) {
				if (EZOsHdqp[VZ61TY8A] != VZ61TY8A) {
					System.err.println("Error: 0x" + VZ61TY8A + " read as 0x" + EZOsHdqp[VZ61TY8A]);
				}
			}
			EQr6eZRY.close();
			EQr6eZRY = new StraightStreamReader(new FileInputStream(iyKrEXYA));
			wGZd6KVw = 0;
			while (wGZd6KVw <= 0x100 && (t0RMBSfS = EQr6eZRY.read(EZOsHdqp, wGZd6KVw + 0x123, 0x100 - wGZd6KVw)) > 0) {
				wGZd6KVw += t0RMBSfS;
			}
			if (wGZd6KVw != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(wGZd6KVw));
			}
			for (int PSjva2D5 = 0x00; PSjva2D5 < wGZd6KVw; PSjva2D5++) {
				if (EZOsHdqp[PSjva2D5 + 0x123] != PSjva2D5) {
					System.err.println("Error: 0x" + PSjva2D5 + " read as 0x" + EZOsHdqp[PSjva2D5 + 0x123]);
				}
			}
			EQr6eZRY.close();
			EQr6eZRY = new StraightStreamReader(new FileInputStream(iyKrEXYA));
			wGZd6KVw = 0;
			while (wGZd6KVw <= 0x100 && (t0RMBSfS = EQr6eZRY.read(EZOsHdqp, wGZd6KVw + 0x123, 7)) > 0) {
				wGZd6KVw += t0RMBSfS;
			}
			if (wGZd6KVw != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(wGZd6KVw));
			}
			for (int GgZUR9Or = 0x00; GgZUR9Or < wGZd6KVw; GgZUR9Or++) {
				if (EZOsHdqp[GgZUR9Or + 0x123] != GgZUR9Or) {
					System.err.println("Error: 0x" + GgZUR9Or + " read as 0x" + EZOsHdqp[GgZUR9Or + 0x123]);
				}
			}
			EQr6eZRY.close();
			iyKrEXYA.delete();
		} catch (IOException UPPSFPJ8) {
			System.err.println(UPPSFPJ8.getMessage());
		}
	}

}