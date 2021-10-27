class n880670 {
	public static void main(String sRI7HHoj[]) {
		int yj4MVjx9, I2kLlyRL, WEK3c8Ol;
		short VUKFPCBL = 256;
		short FeQ0dvcx[] = new short[VUKFPCBL];
		Darjeeling.print("START");
		for (WEK3c8Ol = 0; WEK3c8Ol < 100; WEK3c8Ol++) {
			for (yj4MVjx9 = 0; yj4MVjx9 < VUKFPCBL; yj4MVjx9++)
				FeQ0dvcx[yj4MVjx9] = (short) (VUKFPCBL - 1 - yj4MVjx9);
			for (yj4MVjx9 = 0; yj4MVjx9 < VUKFPCBL; yj4MVjx9++) {
				for (I2kLlyRL = 0; I2kLlyRL < VUKFPCBL - yj4MVjx9 - 1; I2kLlyRL++)
					if (FeQ0dvcx[I2kLlyRL] > FeQ0dvcx[I2kLlyRL + 1]) {
						short Lbveubnx = FeQ0dvcx[I2kLlyRL];
						FeQ0dvcx[I2kLlyRL] = FeQ0dvcx[I2kLlyRL + 1];
						FeQ0dvcx[I2kLlyRL + 1] = Lbveubnx;
					}
			}
		}
		Darjeeling.print("END");
	}

}