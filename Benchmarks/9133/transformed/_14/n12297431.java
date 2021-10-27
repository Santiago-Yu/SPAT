class n12297431 {
	public void actionPerformed(ActionEvent ae) {
		String actionCommand = ae.getActionCommand();
		if (null == actionCommand) {
			return;
		}
		if (DataManager.SHOW_DEBUG) {
			System.out.println("Action command : " + actionCommand);
		}
		DataManager dataManager = ClientDirector.getDataManager();
		PlayerImpl myPlayer = dataManager.getMyPlayer();
		if (!myPlayer.getLocation().isRoom() && actionCommand.equals("createChatRoom")) {
			JOptionPane.showMessageDialog(null,
					"Sorry, but you can not create/leave chat channels\n" + "on World/Town Maps.", "INFORMATION",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (actionCommand.equals("createChatRoom")) {
			WotlasLocation chatRoomLocation = myPlayer.getLocation();
			String chatRoomName = JOptionPane.showInputDialog("Please enter a Name:");
			if (null == chatRoomName || 0 == chatRoomName.length()) {
				return;
			}
			if (this.tabbedPane.getTabCount() >= ChatRoom.MAXIMUM_CHATROOMS_PER_ROOM - 1) {
				this.b_createChatRoom.setEnabled(false);
			} else {
				this.b_createChatRoom.setEnabled(true);
			}
			myPlayer.sendMessage(new ChatRoomCreationMessage(chatRoomName, myPlayer.getPrimaryKey()));
		} else if (actionCommand.equals("leaveChatRoom")) {
			if (!this.currentPrimaryKey.equals(ChatRoom.DEFAULT_CHAT)) {
				myPlayer.sendMessage(
						new RemPlayerFromChatRoomMessage(myPlayer.getPrimaryKey(), this.currentPrimaryKey));
			}
		} else if (actionCommand.equals("helpChat")) {
			DataManager dManager = ClientDirector.getDataManager();
			dManager.sendMessage(
					new SendTextMessage(dManager.getMyPlayer().getPrimaryKey(), dManager.getMyPlayer().getPlayerName(),
							getMyCurrentChatPrimaryKey(), "/help", ChatRoom.NORMAL_VOICE_LEVEL));
		} else if (actionCommand.equals("imageChat")) {
			String imageURL = JOptionPane
					.showInputDialog("Please enter your image's URL:\nExample: http://wotlas.sf.net/images/wotlas.gif");
			if (null == imageURL || 0 == imageURL.length()) {
				return;
			}
			try {
				URL url = new URL(imageURL);
				URLConnection urlC = url.openConnection();
				urlC.connect();
				String ctype = urlC.getContentType();
				if (!ctype.startsWith("image/")) {
					JOptionPane.showMessageDialog(null, "The specified URL does not refer to an image !", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (urlC.getContentLength() > 50 * 1024) {
					JOptionPane.showMessageDialog(null, "The specified image is too big (above 50kB).", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			} catch (Exception ex) {
				Debug.signal(Debug.ERROR, this, "Failed to get image: " + ex);
				JOptionPane.showMessageDialog(null, "Failed to get the specified image...\nCheck your URL.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			DataManager dManager = ClientDirector.getDataManager();
			dManager.sendMessage(
					new SendTextMessage(dManager.getMyPlayer().getPrimaryKey(), dManager.getMyPlayer().getPlayerName(),
							getMyCurrentChatPrimaryKey(), "<img src='" + imageURL + "'>", ChatRoom.NORMAL_VOICE_LEVEL));
		} else {
			if (DataManager.SHOW_DEBUG) {
				System.out.println("Err : unknown actionCommand");
				System.out.println("No action command found!");
			}
		}
	}

}