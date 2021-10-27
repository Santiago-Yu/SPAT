class n14077808 {
	public Dbf(URL lLj3S692) throws java.io.IOException, DbfFileException {
        if (DEBUG) System.out.println("---->uk.ac.leeds.ccg.dbffile.Dbf constructed. Will identify itself as " + DBC);
        URLConnection KG6xWEKS = lLj3S692.openConnection();
        InputStream iEIcvKgz = KG6xWEKS.getInputStream();
        EndianDataInputStream Olu3A1s6 = new EndianDataInputStream(iEIcvKgz);
        init(Olu3A1s6);
    }

}