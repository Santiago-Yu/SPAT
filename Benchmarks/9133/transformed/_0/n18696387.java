class n18696387 {
	public Converter(String wMzErwe8, String FkYl4EDM) {
        try {
            FileInputStream AUkNaD8y = new FileInputStream(new File(wMzErwe8));
            BufferedReader czuKA34R = new BufferedReader(new InputStreamReader(AUkNaD8y, "SJIS"));
            FileOutputStream VqwV4VmK = new FileOutputStream(new File(FkYl4EDM));
            BufferedWriter Q5JUMGMj = new BufferedWriter(new OutputStreamWriter(VqwV4VmK, "UTF8"));
            int RWM1ti19 = 80;
            char GbZ0LVEk[] = new char[RWM1ti19];
            int teWgS6EV;
            while ((teWgS6EV = czuKA34R.read(GbZ0LVEk, 0, RWM1ti19)) != -1) Q5JUMGMj.write(GbZ0LVEk, 0, teWgS6EV);
            Q5JUMGMj.close();
            czuKA34R.close();
        } catch (IOException fqIeKIc9) {
            System.out.println("An I/O Exception Occurred: " + fqIeKIc9);
        }
    }

}