class n6480424 {
	public void method31() {
		boolean sVJvYZOm = true;
		while (sVJvYZOm) {
			sVJvYZOm = false;
			for (int go9Phc0q = 0; go9Phc0q < anInt772 - 1; go9Phc0q++)
				if (anIntArray774[go9Phc0q] < anIntArray774[go9Phc0q + 1]) {
					int yoOdvOhf = anIntArray774[go9Phc0q];
					anIntArray774[go9Phc0q] = anIntArray774[go9Phc0q + 1];
					anIntArray774[go9Phc0q + 1] = yoOdvOhf;
					long BgkEBpcY = aLongArray773[go9Phc0q];
					aLongArray773[go9Phc0q] = aLongArray773[go9Phc0q + 1];
					aLongArray773[go9Phc0q + 1] = BgkEBpcY;
					sVJvYZOm = true;
				}
		}
	}

}