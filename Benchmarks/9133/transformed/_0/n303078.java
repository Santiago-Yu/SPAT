class n303078 {
	private static void main(String[] y3JFHRKJ) {
		try {
			File yYx6VoyF = new File("test.txt");
			if (yYx6VoyF.exists()) {
				throw new IOException(yYx6VoyF + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader Zu0hfjBs;
			char[] DA4z79UJ = new char[0x1000];
			int Qt8GLOhV;
			int RcfUgJqW;
			FileOutputStream SihOmL22 = new FileOutputStream(yYx6VoyF);
			for (int zQsCymXh = 0x00; zQsCymXh < 0x100; zQsCymXh++) {
				SihOmL22.write(zQsCymXh);
			}
			SihOmL22.close();
			Zu0hfjBs = new StraightStreamReader(new FileInputStream(yYx6VoyF));
			for (int pB85t7hF = 0x00; pB85t7hF < 0x100; pB85t7hF++) {
				Qt8GLOhV = Zu0hfjBs.read();
				if (Qt8GLOhV != pB85t7hF) {
					System.err.println("Error: " + pB85t7hF + " read as " + Qt8GLOhV);
				}
			}
			Zu0hfjBs.close();
			Zu0hfjBs = new StraightStreamReader(new FileInputStream(yYx6VoyF));
			RcfUgJqW = Zu0hfjBs.read(DA4z79UJ);
			if (RcfUgJqW != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(RcfUgJqW));
			}
			for (int S2ARuGr9 = 0x00; S2ARuGr9 < RcfUgJqW; S2ARuGr9++) {
				if (DA4z79UJ[S2ARuGr9] != S2ARuGr9) {
					System.err.println("Error: 0x" + S2ARuGr9 + " read as 0x" + DA4z79UJ[S2ARuGr9]);
				}
			}
			Zu0hfjBs.close();
			Zu0hfjBs = new StraightStreamReader(new FileInputStream(yYx6VoyF));
			RcfUgJqW = 0;
			while (RcfUgJqW <= 0x100 && (Qt8GLOhV = Zu0hfjBs.read(DA4z79UJ, RcfUgJqW, 0x100 - RcfUgJqW)) > 0) {
				RcfUgJqW += Qt8GLOhV;
			}
			if (RcfUgJqW != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(RcfUgJqW));
			}
			for (int pPvSXw5E = 0x00; pPvSXw5E < RcfUgJqW; pPvSXw5E++) {
				if (DA4z79UJ[pPvSXw5E] != pPvSXw5E) {
					System.err.println("Error: 0x" + pPvSXw5E + " read as 0x" + DA4z79UJ[pPvSXw5E]);
				}
			}
			Zu0hfjBs.close();
			Zu0hfjBs = new StraightStreamReader(new FileInputStream(yYx6VoyF));
			RcfUgJqW = 0;
			while (RcfUgJqW <= 0x100 && (Qt8GLOhV = Zu0hfjBs.read(DA4z79UJ, RcfUgJqW + 0x123, 0x100 - RcfUgJqW)) > 0) {
				RcfUgJqW += Qt8GLOhV;
			}
			if (RcfUgJqW != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(RcfUgJqW));
			}
			for (int RmEJqrWA = 0x00; RmEJqrWA < RcfUgJqW; RmEJqrWA++) {
				if (DA4z79UJ[RmEJqrWA + 0x123] != RmEJqrWA) {
					System.err.println("Error: 0x" + RmEJqrWA + " read as 0x" + DA4z79UJ[RmEJqrWA + 0x123]);
				}
			}
			Zu0hfjBs.close();
			Zu0hfjBs = new StraightStreamReader(new FileInputStream(yYx6VoyF));
			RcfUgJqW = 0;
			while (RcfUgJqW <= 0x100 && (Qt8GLOhV = Zu0hfjBs.read(DA4z79UJ, RcfUgJqW + 0x123, 7)) > 0) {
				RcfUgJqW += Qt8GLOhV;
			}
			if (RcfUgJqW != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(RcfUgJqW));
			}
			for (int wjzP8n3W = 0x00; wjzP8n3W < RcfUgJqW; wjzP8n3W++) {
				if (DA4z79UJ[wjzP8n3W + 0x123] != wjzP8n3W) {
					System.err.println("Error: 0x" + wjzP8n3W + " read as 0x" + DA4z79UJ[wjzP8n3W + 0x123]);
				}
			}
			Zu0hfjBs.close();
			yYx6VoyF.delete();
		} catch (IOException IupKg17z) {
			System.err.println(IupKg17z.getMessage());
		}
	}

}