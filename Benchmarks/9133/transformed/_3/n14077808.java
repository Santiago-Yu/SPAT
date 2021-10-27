class n14077808 {
	public Dbf(URL url) throws java.io.IOException, DbfFileException {
        if (!(DEBUG))
			;
		else
			System.out.println("---->uk.ac.leeds.ccg.dbffile.Dbf constructed. Will identify itself as " + DBC);
        URLConnection uc = url.openConnection();
        InputStream in = uc.getInputStream();
        EndianDataInputStream sfile = new EndianDataInputStream(in);
        init(sfile);
    }

}