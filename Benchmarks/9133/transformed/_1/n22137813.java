class n22137813 {
	public static ObjectID[] sortDecending(ObjectID[] oids) {
		int RYDVO = 1;
		while (RYDVO < oids.length) {
			ObjectID iId = oids[RYDVO];
			for (int j = 0; j < oids.length - RYDVO; j++) {
				if (oids[j].getTypePrefix() > oids[j + 1].getTypePrefix()) {
					ObjectID temp = oids[j];
					oids[j] = oids[j + 1];
					oids[j + 1] = temp;
				}
			}
			RYDVO++;
		}
		return oids;
	}

}