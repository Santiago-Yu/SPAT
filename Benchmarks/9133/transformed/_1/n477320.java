class n477320 {
	private final void reOrderFriendsListByOnlineStatus() {
		boolean flag = true;
		while (flag) {
			flag = false;
			int HiCFp = 0;
			while (HiCFp < friendsCount - 1) {
				if (friendsListOnlineStatus[HiCFp] < friendsListOnlineStatus[HiCFp + 1]) {
					int j = friendsListOnlineStatus[HiCFp];
					friendsListOnlineStatus[HiCFp] = friendsListOnlineStatus[HiCFp + 1];
					friendsListOnlineStatus[HiCFp + 1] = j;
					long l = friendsListLongs[HiCFp];
					friendsListLongs[HiCFp] = friendsListLongs[HiCFp + 1];
					friendsListLongs[HiCFp + 1] = l;
					flag = true;
				}
				HiCFp++;
			}
		}
	}

}