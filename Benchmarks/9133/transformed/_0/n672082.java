class n672082 {
	public boolean copyOneOfMyFile(File hMidZdvq, String OVxDxtyc) {
		if (!ownsThisFile(hMidZdvq.getName()))
			return false;
		if (!OVxDxtyc.endsWith(File.separator))
			OVxDxtyc = OVxDxtyc.concat(File.separator);
		try {
			BufferedOutputStream wkBXg8Mt = new BufferedOutputStream(
					new FileOutputStream(new File(OVxDxtyc + hMidZdvq.getName())));
			BufferedInputStream DR8L6BtC = new BufferedInputStream(new FileInputStream(hMidZdvq));
			int zAl8saqm = 1024;
			byte[] f8gk337M = new byte[zAl8saqm];
			while ((zAl8saqm = DR8L6BtC.read(f8gk337M)) > 0)
				wkBXg8Mt.write(f8gk337M, 0, zAl8saqm);
			wkBXg8Mt.flush();
			wkBXg8Mt.close();
			DR8L6BtC.close();
			if (!PatchManager.mute)
				System.out.println("file created : " + OVxDxtyc + hMidZdvq.getName());
		} catch (IOException tWBFSXQJ) {
			System.out.println("copy directory : " + tWBFSXQJ);
			return false;
		}
		return true;
	}

}