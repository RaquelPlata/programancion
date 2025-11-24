public  class Main {
    public static void  main(String[] args){
        //Precarga de datos

        //Hospitales
        Direccion dir1 = new Direccion("Nogal",113, 11640,"Bornos", "Cádiz");
        Hospital h1 = new Hospital("Hospital Central" , "H001", dir1 );
        Hospital h2 = new Hospital("Hospital del Sur" , "H002", dir1 );

        //2.Areas

        Areas a1 = new Areas("Cardiología", " CAR1" , 2 , h1);
        Areas a2 = new Areas("Urgencias", " CAR1" , 1 , h1);
        Areas a3 = new Areas("Pediatría", " CAR1" , 0 , h2);

        h1.agregarAreas(a1);
        h1.agregarAreas(a2);
        h2.agregarAreas(a3);

        Medico m1= new Medico("jose",a1,"20607431Y",18,"Mujer",4000.400,24-8-2007);
        a1.aumentarMedicos();
        System.out.println(a1.getNumMedicos());

        Areas a = h1.getAreas().get(0);
        System.out.println(a.getNombre());

    }
}