class n16079868 {
	private void readIntoList(URL WI4IXUic, Map<String, JMenuItem> B7fYCUBm) {
		try {
			BufferedReader EcHzvHs7 = new BufferedReader(new InputStreamReader(WI4IXUic.openStream()));
			String HvjoZ34A;
			while ((HvjoZ34A = EcHzvHs7.readLine()) != null) {
				int aunUtN4m = HvjoZ34A.indexOf(">") + 1;
				int uZLyeJhY = HvjoZ34A.indexOf("</a>");
				JMenuItem EHY7bDH8 = new JMenuItem("<html>" + HvjoZ34A + "</html>");
				if (B7fYCUBm == allRooms) {
					EHY7bDH8.setActionCommand("/room " + HvjoZ34A.substring(aunUtN4m, uZLyeJhY));
				} else {
					EHY7bDH8.setActionCommand("/" + HvjoZ34A.substring(aunUtN4m, uZLyeJhY) + " ");
				}
				EHY7bDH8.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent KMtzFcyE) {
						jTextField1.setText(KMtzFcyE.getActionCommand());
						popup.setVisible(false);
					}
				});
				B7fYCUBm.put(HvjoZ34A.substring(aunUtN4m, uZLyeJhY), EHY7bDH8);
			}
			EcHzvHs7.close();
		} catch (Exception afKiJsPB) {
			afKiJsPB.printStackTrace();
		}
	}

}