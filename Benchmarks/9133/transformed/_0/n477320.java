class n477320 {
	private final void reOrderFriendsListByOnlineStatus() {
		boolean e5N9Ex36 = true;
		while (e5N9Ex36) {
			e5N9Ex36 = false;
			for (int Kr3GEDxF = 0; Kr3GEDxF < friendsCount - 1; Kr3GEDxF++)
				if (friendsListOnlineStatus[Kr3GEDxF] < friendsListOnlineStatus[Kr3GEDxF + 1]) {
					int zdbhxpM7 = friendsListOnlineStatus[Kr3GEDxF];
					friendsListOnlineStatus[Kr3GEDxF] = friendsListOnlineStatus[Kr3GEDxF + 1];
					friendsListOnlineStatus[Kr3GEDxF + 1] = zdbhxpM7;
					long BhuG9rZQ = friendsListLongs[Kr3GEDxF];
					friendsListLongs[Kr3GEDxF] = friendsListLongs[Kr3GEDxF + 1];
					friendsListLongs[Kr3GEDxF + 1] = BhuG9rZQ;
					e5N9Ex36 = true;
				}
		}
	}

}