class n5145801 {
	public void actionPerformed(ActionEvent OLWwxIMC) {
		JFileChooser HTBJ7ORM = new JFileChooser("");
		HTBJ7ORM.setMultiSelectionEnabled(false);
		HTBJ7ORM.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int OCHHR23X = 0;
		boolean xfWkAL9F = m_data != null;
		if (xfWkAL9F)
			OCHHR23X = HTBJ7ORM.showSaveDialog(this);
		else
			OCHHR23X = HTBJ7ORM.showOpenDialog(this);
		if (OCHHR23X != JFileChooser.APPROVE_OPTION)
			return;
		File MX8jJQVP = HTBJ7ORM.getSelectedFile();
		if (MX8jJQVP == null)
			return;
		log.info(MX8jJQVP.toString());
		try {
			if (xfWkAL9F) {
				FileOutputStream EObvKyJU = new FileOutputStream(MX8jJQVP);
				byte[] qb6sIpgu = (byte[]) m_data;
				EObvKyJU.write(qb6sIpgu);
				EObvKyJU.flush();
				EObvKyJU.close();
				log.config("Save to " + MX8jJQVP + " #" + qb6sIpgu.length);
			} else {
				FileInputStream luZQHNnN = new FileInputStream(MX8jJQVP);
				ByteArrayOutputStream bMiy0WUz = new ByteArrayOutputStream();
				byte[] HDojMqmR = new byte[1024 * 8];
				int DbaXrVDR = -1;
				while ((DbaXrVDR = luZQHNnN.read(HDojMqmR)) != -1)
					bMiy0WUz.write(HDojMqmR, 0, DbaXrVDR);
				luZQHNnN.close();
				byte[] jJ5DtJ8M = bMiy0WUz.toByteArray();
				m_data = jJ5DtJ8M;
				log.config("Load from " + MX8jJQVP + " #" + jJ5DtJ8M.length);
				bMiy0WUz.close();
			}
		} catch (Exception MrJAeNq9) {
			log.log(Level.WARNING, "Save=" + xfWkAL9F, MrJAeNq9);
		}
		try {
			fireVetoableChange(m_columnName, null, m_data);
		} catch (PropertyVetoException teMdd0dx) {
		}
	}

}