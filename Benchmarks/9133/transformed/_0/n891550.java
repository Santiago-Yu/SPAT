class n891550 {
	public void bubblesort(String Umw3xN80[]) {
		for (int CE02Inqt = Umw3xN80.length - 1; CE02Inqt > 0; CE02Inqt--) {
			for (int uLxE2JIl = 0; uLxE2JIl < CE02Inqt; uLxE2JIl++) {
				String MyXN6OfE;
				if (Umw3xN80[uLxE2JIl].compareTo(Umw3xN80[uLxE2JIl + 1]) > 0) {
					MyXN6OfE = Umw3xN80[uLxE2JIl];
					Umw3xN80[uLxE2JIl] = Umw3xN80[uLxE2JIl + 1];
					Umw3xN80[uLxE2JIl + 1] = MyXN6OfE;
				}
			}
		}
	}

}