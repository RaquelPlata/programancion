public  class Main {
    public static void  main(String[] args){
        //Precarga de datos

        //Hospitales
        Hospital h1 = new Hospital("Hospital Central" , "H001");
        Hospital h2 = new Hospital("Hospital del Sur" , "H002");

        //2.Areas

        Areas a1 = new Areas("Cardiología", " CAR1" , 2 , h1);
        Areas a2 = new Areas("Cardiología", " CAR1" , 1 , h1);
        Areas a3 = new Areas("Cardiología", " CAR1" , 0 , h2);

        h1.agregarAreas(a1);
        h1.agregarAreas(a2);
        h2.agregarAreas(a3);

        Medico m10 new Medico("jose",)

    }
}