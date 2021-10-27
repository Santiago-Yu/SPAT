class n8166293 {
	public static void main(String[] TMwpbQRt) {
		int XqOHOKxM[] = { 23, 78, 45, 8, 3, 32, 56, 39, 92, 28 };
		boolean iHbhBRvN = false;
		int TCHrpfXi = 0;
		int MHElSsHb = 0;
		while (true) {
			for (int BikD9ksV = 0; BikD9ksV < XqOHOKxM.length - 1; BikD9ksV++) {
				TCHrpfXi++;
				if (XqOHOKxM[BikD9ksV] > XqOHOKxM[BikD9ksV + 1]) {
					int RC6mmR0o = XqOHOKxM[BikD9ksV];
					XqOHOKxM[BikD9ksV] = XqOHOKxM[BikD9ksV + 1];
					XqOHOKxM[BikD9ksV + 1] = RC6mmR0o;
					iHbhBRvN = true;
					MHElSsHb++;
				}
			}
			if (!iHbhBRvN) {
				break;
			} else {
				iHbhBRvN = false;
			}
		}
		for (int mC1yNvNw = 0; mC1yNvNw < XqOHOKxM.length; mC1yNvNw++) {
			System.out.print(XqOHOKxM[mC1yNvNw] + " ");
		}
		for (int Gi0IhUsg = 0; Gi0IhUsg < 5; Gi0IhUsg++) {
			System.out.println("i" + Gi0IhUsg);
		}
	}

}