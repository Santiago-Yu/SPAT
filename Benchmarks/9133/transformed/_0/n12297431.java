class n12297431 {
	public void actionPerformed(ActionEvent kgaBgpqD) {
		String tUHguOFy = kgaBgpqD.getActionCommand();
		if (tUHguOFy == null) {
			return;
		}
		if (DataManager.SHOW_DEBUG) {
			System.out.println("Action command : " + tUHguOFy);
		}
		DataManager PSKyfR4o = ClientDirector.getDataManager();
		PlayerImpl z19G3vkk = PSKyfR4o.getMyPlayer();
		if (!z19G3vkk.getLocation().isRoom() && tUHguOFy.equals("createChatRoom")) {
			JOptionPane.showMessageDialog(null,
					"Sorry, but you can not create/leave chat channels\n" + "on World/Town Maps.", "INFORMATION",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (tUHguOFy.equals("createChatRoom")) {
			WotlasLocation k9u3ooZF = z19G3vkk.getLocation();
			String RIP1nEKc = JOptionPane.showInputDialog("Please enter a Name:");
			if (RIP1nEKc == null || RIP1nEKc.length() == 0) {
				return;
			}
			if (this.tabbedPane.getTabCount() >= ChatRoom.MAXIMUM_CHATROOMS_PER_ROOM - 1) {
				this.b_createChatRoom.setEnabled(false);
			} else {
				this.b_createChatRoom.setEnabled(true);
			}
			z19G3vkk.sendMessage(new ChatRoomCreationMessage(RIP1nEKc, z19G3vkk.getPrimaryKey()));
		} else if (tUHguOFy.equals("leaveChatRoom")) {
			if (!this.currentPrimaryKey.equals(ChatRoom.DEFAULT_CHAT)) {
				z19G3vkk.sendMessage(
						new RemPlayerFromChatRoomMessage(z19G3vkk.getPrimaryKey(), this.currentPrimaryKey));
			}
		} else if (tUHguOFy.equals("helpChat")) {
			DataManager QQYUI9Kw = ClientDirector.getDataManager();
			QQYUI9Kw.sendMessage(
					new SendTextMessage(QQYUI9Kw.getMyPlayer().getPrimaryKey(), QQYUI9Kw.getMyPlayer().getPlayerName(),
							getMyCurrentChatPrimaryKey(), "/help", ChatRoom.NORMAL_VOICE_LEVEL));
		} else if (tUHguOFy.equals("imageChat")) {
			String FrzMuBb7 = JOptionPane
					.showInputDialog("Please enter your image's URL:\nExample: http://wotlas.sf.net/images/wotlas.gif");
			if (FrzMuBb7 == null || FrzMuBb7.length() == 0) {
				return;
			}
			try {
				URL iD8Jfy7I = new URL(FrzMuBb7);
				URLConnection l872qO4P = iD8Jfy7I.openConnection();
				l872qO4P.connect();
				String gzWMX5Ei = l872qO4P.getContentType();
				if (!gzWMX5Ei.startsWith("image/")) {
					JOptionPane.showMessageDialog(null, "The specified URL does not refer to an image !", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (l872qO4P.getContentLength() > 50 * 1024) {
					JOptionPane.showMessageDialog(null, "The specified image is too big (above 50kB).", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			} catch (Exception nhofUW8f) {
				Debug.signal(Debug.ERROR, this, "Failed to get image: " + nhofUW8f);
				JOptionPane.showMessageDialog(null, "Failed to get the specified image...\nCheck your URL.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			DataManager wVEkC9Z2 = ClientDirector.getDataManager();
			wVEkC9Z2.sendMessage(
					new SendTextMessage(wVEkC9Z2.getMyPlayer().getPrimaryKey(), wVEkC9Z2.getMyPlayer().getPlayerName(),
							getMyCurrentChatPrimaryKey(), "<img src='" + FrzMuBb7 + "'>", ChatRoom.NORMAL_VOICE_LEVEL));
		} else {
			if (DataManager.SHOW_DEBUG) {
				System.out.println("Err : unknown actionCommand");
				System.out.println("No action command found!");
			}
		}
	}

}