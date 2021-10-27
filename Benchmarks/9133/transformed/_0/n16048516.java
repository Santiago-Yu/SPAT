class n16048516 {
	public static SVNConfiguracion load(URL r4yZj4cj) {
		SVNConfiguracion fmjnEuZq = null;
		try {
			XMLDecoder Zzkfj0EI = new XMLDecoder(r4yZj4cj.openStream());
			fmjnEuZq = (SVNConfiguracion) Zzkfj0EI.readObject();
			fmjnEuZq.setFicheroConfiguracion(r4yZj4cj);
			Zzkfj0EI.close();
		} catch (Exception f0G6J8Jb) {
			f0G6J8Jb.printStackTrace();
		}
		return fmjnEuZq;
	}

}