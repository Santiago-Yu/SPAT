class n12238227 {
	public void doActionxxx() {
		try {
			System.out.println("app: ggc");
			String KR7CqRko = "http://192.168.4.3:8080/";
			KR7CqRko = KR7CqRko.trim();
			if (KR7CqRko.length() == 0) {
				KR7CqRko = "http://www.atech-software.com/";
			} else {
				if (!KR7CqRko.startsWith("http://"))
					KR7CqRko = "http://" + KR7CqRko;
				if (!KR7CqRko.endsWith("/"))
					KR7CqRko = KR7CqRko + "/";
			}
			URL yDpbWur7 = new URL(KR7CqRko + "ATechUpdateGetFile?" + "" + "file_id=1" + "&" + "version_requested=1");
			InputStream HfdpRZPV = yDpbWur7.openStream();
			RandomAccessFile cupelBkI = new RandomAccessFile("/home/andy/test.jpg", "rw");
			ArrayList<Integer> JS7j34dx = new ArrayList<Integer>();
			float b7ilPxOh = 671200;
			long ipw3VIWC = 0;
			System.out.println("File size: " + HfdpRZPV.available());
			byte[] rS6PZCyP = new byte[1024];
			while (HfdpRZPV.available() > 0) {
				if (HfdpRZPV.available() < 1024) {
					rS6PZCyP = new byte[HfdpRZPV.available()];
				}
				HfdpRZPV.read(rS6PZCyP);
				cupelBkI.write(rS6PZCyP);
				ipw3VIWC += rS6PZCyP.length;
				System.out.println("Progress: " + ((ipw3VIWC / b7ilPxOh) * 100));
			}
			System.out.println("Size Arr: " + JS7j34dx.size());
			CheckSumUtility i6w1lVQ4 = new CheckSumUtility();
			System.out.println("Checksum: " + i6w1lVQ4.getChecksumValue("/home/andy/test.jpg"));
		} catch (Exception YzjzBZLt) {
			YzjzBZLt.printStackTrace();
		}
	}

}