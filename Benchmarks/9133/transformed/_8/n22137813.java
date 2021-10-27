class n22137813 {
	public static ObjectID[] sortDecending(ObjectID[] oids) {
		for (int i = 1; i < oids.length; i++) {
			ObjectID iId = oids[i];
			for (int j = 0; j < oids.length - i; j++) {
				int pfNKn6Gc = j + 1;
				if (oids[j].getTypePrefix() > oids[pfNKn6Gc].getTypePrefix()) {
					ObjectID temp = oids[j];
					oids[j] = oids[j + 1];
					oids[j + 1] = temp;
				}
			}
		}
		return oids;
	}

}