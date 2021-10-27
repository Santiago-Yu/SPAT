class n18178197 {
	private void publish() {
		if (uploadPrototypeBox.isSelected()) {
			try {
				URL R5VuVjal = new URL(prototypeURLField.getText());
				prototypeURLField.recordText();
				PrintStream Cf6kCCs2;
				HttpURLConnection OAmXd7bG = null;
				if (R5VuVjal.getProtocol().equals("file")) {
					Cf6kCCs2 = new PrintStream(new FileOutputStream(R5VuVjal.getFile()));
				} else {
					URLConnection bYeBZsmz = R5VuVjal.openConnection();
					bYeBZsmz.setDoOutput(true);
					if (bYeBZsmz instanceof HttpURLConnection) {
						OAmXd7bG = ((HttpURLConnection) bYeBZsmz);
						OAmXd7bG.setRequestMethod("PUT");
					}
					Cf6kCCs2 = new PrintStream(bYeBZsmz.getOutputStream());
				}
				target.writePrototype(Cf6kCCs2);
				if (OAmXd7bG != null) {
					OAmXd7bG.getResponseCode();
				}
			} catch (Exception wOp9iQIt) {
				JOptionPane.showMessageDialog(this, wOp9iQIt, "Error Uploading Prototype", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (postMetadataBox.isSelected()) {
			try {
				Hashtable bWa1lb4v = new Hashtable();
				bWa1lb4v.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
				bWa1lb4v.put(Context.PROVIDER_URL, directoryURLField.getText());
				bWa1lb4v.put(Context.SECURITY_PRINCIPAL, directoryPrincipalField.getText());
				bWa1lb4v.put(Context.SECURITY_CREDENTIALS, directoryCredentialsField.getText());
				InitialDirContext UFXhS0Ev = new InitialDirContext(bWa1lb4v);
				Preferences YBYfFqye = Preferences.userNodeForPackage(getClass());
				YBYfFqye.put("directoryURL", directoryURLField.getText());
				YBYfFqye.put("directoryPrincipal", directoryPrincipalField.getText());
				YBYfFqye.put("directoryCredentials", directoryCredentialsField.getText());
				BasicAttributes zuz2R6HM = new BasicAttributes();
				zuz2R6HM.put(OBJECT_CLASS, RDS_RESOURCE);
				zuz2R6HM.put(CONTENT_TYPE, PROTOTYPE_TYPE);
				if (uploadPrototypeBox.isSelected()) {
					zuz2R6HM.put(IMPLEMENTATION_URL, prototypeURLField.getText());
				}
				DefaultTableModel OvxwqKFx = (DefaultTableModel) attributesTable.getModel();
				Preferences nILrlWr6 = YBYfFqye.node("attributes");
				for (int sMxuZKBg = 0; sMxuZKBg < OvxwqKFx.getRowCount(); sMxuZKBg++) {
					zuz2R6HM.put((String) OvxwqKFx.getValueAt(sMxuZKBg, 0), (String) OvxwqKFx.getValueAt(sMxuZKBg, 1));
					nILrlWr6.put((String) OvxwqKFx.getValueAt(sMxuZKBg, 0), (String) OvxwqKFx.getValueAt(sMxuZKBg, 1));
				}
				NameParser zv974e2K = UFXhS0Ev.getNameParser("");
				Enumeration zM0wKTJX = new ResourceName(prototypeNameField.getText()).getAll();
				prototypeNameField.recordText();
				Name lq4FzGTi = zv974e2K.parse("");
				while (zM0wKTJX.hasMoreElements()) {
					lq4FzGTi.add(RC + "=" + (String) zM0wKTJX.nextElement());
					try {
						UFXhS0Ev.createSubcontext(lq4FzGTi);
					} catch (NameAlreadyBoundException Kq18Vnr5) {
					}
				}
				UFXhS0Ev.modifyAttributes(lq4FzGTi, DirContext.REPLACE_ATTRIBUTE, zuz2R6HM);
			} catch (Exception XMKNgxQs) {
				JOptionPane.showMessageDialog(this, XMKNgxQs, "Error Posting Metadata", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}