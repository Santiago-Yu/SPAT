class n692680 {
	private static void main(String[] rhCrSMTd) {
		try {
			File NWeNs31P = new File("test.txt");
			if (NWeNs31P.exists()) {
				throw new IOException(NWeNs31P + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader ILeTvUWq;
			char[] RRLfgPf4 = new char[0x1000];
			int b1nTpdpZ;
			int XXHckzPe;
			FileOutputStream eyXU53hx = new FileOutputStream(NWeNs31P);
			for (int u16aaNpA = 0x00; u16aaNpA < 0x100; u16aaNpA++) {
				eyXU53hx.write(u16aaNpA);
			}
			eyXU53hx.close();
			ILeTvUWq = new StraightStreamReader(new FileInputStream(NWeNs31P));
			for (int ZkX036SF = 0x00; ZkX036SF < 0x100; ZkX036SF++) {
				b1nTpdpZ = ILeTvUWq.read();
				if (b1nTpdpZ != ZkX036SF) {
					System.err.println("Error: " + ZkX036SF + " read as " + b1nTpdpZ);
				}
			}
			ILeTvUWq.close();
			ILeTvUWq = new StraightStreamReader(new FileInputStream(NWeNs31P));
			XXHckzPe = ILeTvUWq.read(RRLfgPf4);
			if (XXHckzPe != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(XXHckzPe));
			}
			for (int WctH7q6x = 0x00; WctH7q6x < XXHckzPe; WctH7q6x++) {
				if (RRLfgPf4[WctH7q6x] != WctH7q6x) {
					System.err.println("Error: 0x" + WctH7q6x + " read as 0x" + RRLfgPf4[WctH7q6x]);
				}
			}
			ILeTvUWq.close();
			ILeTvUWq = new StraightStreamReader(new FileInputStream(NWeNs31P));
			XXHckzPe = 0;
			while (XXHckzPe <= 0x100 && (b1nTpdpZ = ILeTvUWq.read(RRLfgPf4, XXHckzPe, 0x100 - XXHckzPe)) > 0) {
				XXHckzPe += b1nTpdpZ;
			}
			if (XXHckzPe != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(XXHckzPe));
			}
			for (int e9SMEBqv = 0x00; e9SMEBqv < XXHckzPe; e9SMEBqv++) {
				if (RRLfgPf4[e9SMEBqv] != e9SMEBqv) {
					System.err.println("Error: 0x" + e9SMEBqv + " read as 0x" + RRLfgPf4[e9SMEBqv]);
				}
			}
			ILeTvUWq.close();
			ILeTvUWq = new StraightStreamReader(new FileInputStream(NWeNs31P));
			XXHckzPe = 0;
			while (XXHckzPe <= 0x100 && (b1nTpdpZ = ILeTvUWq.read(RRLfgPf4, XXHckzPe + 0x123, 0x100 - XXHckzPe)) > 0) {
				XXHckzPe += b1nTpdpZ;
			}
			if (XXHckzPe != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(XXHckzPe));
			}
			for (int Xkj3aNbG = 0x00; Xkj3aNbG < XXHckzPe; Xkj3aNbG++) {
				if (RRLfgPf4[Xkj3aNbG + 0x123] != Xkj3aNbG) {
					System.err.println("Error: 0x" + Xkj3aNbG + " read as 0x" + RRLfgPf4[Xkj3aNbG + 0x123]);
				}
			}
			ILeTvUWq.close();
			ILeTvUWq = new StraightStreamReader(new FileInputStream(NWeNs31P));
			XXHckzPe = 0;
			while (XXHckzPe <= 0x100 && (b1nTpdpZ = ILeTvUWq.read(RRLfgPf4, XXHckzPe + 0x123, 7)) > 0) {
				XXHckzPe += b1nTpdpZ;
			}
			if (XXHckzPe != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(XXHckzPe));
			}
			for (int O59tA4Jy = 0x00; O59tA4Jy < XXHckzPe; O59tA4Jy++) {
				if (RRLfgPf4[O59tA4Jy + 0x123] != O59tA4Jy) {
					System.err.println("Error: 0x" + O59tA4Jy + " read as 0x" + RRLfgPf4[O59tA4Jy + 0x123]);
				}
			}
			ILeTvUWq.close();
			NWeNs31P.delete();
		} catch (IOException pstAUjkE) {
			System.err.println(pstAUjkE.getMessage());
		}
	}

}