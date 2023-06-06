import com.sun.source.doctree.SeeTree;


import javax.swing.plaf.PanelUI;
import java.time.LocalDate;

public class Main {
    public  static void main (String[] args){
       LocalDate fechaCaducidad1 = LocalDate.of(2012,12,12);
       LocalDate fechadeEnvase = LocalDate.of(11,03,1);

ProducctosSupermercado P = new ProducctosSupermercado(12547, fechaCaducidad1);
P.getNumero_lote();
P.getFecha_de_caducidad();


System.out.println( " el numero de lote es " + P.getNumero_lote() + " " + "La fecha de caducidad " + P.getFecha_de_caducidad());

Productoscongelados C = new Productoscongelados(1254,fechaCaducidad1 , fechadeEnvase , "Perukistan", 15 );
C.Imprimir2();

CongeladosAgua A = new CongeladosAgua(1254,fechaCaducidad1 , fechadeEnvase , "Colombia" , 15,1,5);
A.Imprimir3();







    }
}
class ProducctosSupermercado {
    private LocalDate fecha_de_caducidad;
    private int numero_lote;

    public ProducctosSupermercado(int numero_lote, LocalDate fecha_de_caducidad) {

        this.numero_lote = numero_lote;
        this.fecha_de_caducidad = fecha_de_caducidad;
    }

    public LocalDate getFecha_de_caducidad() {
        return fecha_de_caducidad;
    }

    public int getNumero_lote() {
        return numero_lote;
    }


}

class ProductosFrescos extends ProducctosSupermercado{
    private LocalDate fechaEnvasado;
    private String  Paisorigen;


    public ProductosFrescos(int numero_lote, LocalDate fecha_de_caducidad , String Paisorigen , LocalDate fechaEnvasado) {
        super(numero_lote, fecha_de_caducidad);
        this.Paisorigen = Paisorigen;
        this.fechaEnvasado = fechaEnvasado;
    }

    public String getPaisorigen() {
        return Paisorigen;

    }

    public LocalDate getFechaEnvasado (){

        return  fechaEnvasado;
    }

    public  void Entre1(){
        System.out.println("el numero de lote es " + getNumero_lote() + " " + "la fecha de envase" + getFechaEnvasado() +
        " el pais de origen es " + getPaisorigen());
    }


}

class Productosrefrigerantes extends  ProducctosSupermercado{

    private  int Codigodesupervision;
    private  LocalDate Fechaenvasado;
    private  double Temperaturarecomendada;

    private  String Paisorigen;

    public Productosrefrigerantes(int numero_lote, LocalDate fecha_de_caducidad , int CodigoSuper , LocalDate fechaenvasado , double  temperaturarecomendada ,String paisorigen) {

        super(numero_lote, fecha_de_caducidad);
        this.Paisorigen = paisorigen;
        this.Codigodesupervision = CodigoSuper;
        this.Fechaenvasado = fechaenvasado;
        this.Temperaturarecomendada = temperaturarecomendada;


    }
    public String getPaisorigen (){

        return Paisorigen;
    }
    public  double getTemperaturarecomendada(){

        return  Temperaturarecomendada;
    }
    public int getCodigodesupervision(){
        return  Codigodesupervision;
    }

    public  LocalDate getFechaenvasado (){

        return Fechaenvasado;
    }
    public void Imprimir1(){

        System.out.println( " El codigo de supervision " + getCodigodesupervision() + "la fecha de envasado es " + getFechaenvasado() +
                "la temperatura recomendada es de " + getTemperaturarecomendada() + "C");
    }

}

class Productoscongelados extends ProducctosSupermercado{
    private   LocalDate fechaEnvase;
    private  String paiOrigen;
    private  int temperaturaRecomendada;


    public Productoscongelados(int numero_lote, LocalDate fecha_de_caducidad ,LocalDate FechaEnvase , String PaisOrigen , int TemRecom) {
        super(numero_lote, fecha_de_caducidad);

        this.fechaEnvase = FechaEnvase;
        this.paiOrigen = PaisOrigen;
        this.temperaturaRecomendada = TemRecom;
    }

    public LocalDate getFechaEnvase() {
        return fechaEnvase;
    }

    public String getPaiOrigen() {
        return paiOrigen;
    }

    public int getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public void Imprimir2 (){
        System.out.println("EL NUMERO DE LOTE ES  " + getNumero_lote() + " el pais de origen es " + getPaiOrigen() + " la fecha de envase es " + getFechaEnvase()
        + "temperatura recomenda es de "  + getTemperaturaRecomendada() + "C" );
    }
}

class CongeladosAire extends Productoscongelados{

    private Double cantidadNitrogeno;
    private Double cantidadOxigeno;
    private  Double cantidadC02;
    private  Double  cantidadVH2O;

    public CongeladosAire(int numero_lote, LocalDate fecha_de_caducidad, LocalDate FechaEnvase, String PaisOrigen, int TemRecom , double PorOxigeno , double porCO2 , double porVH20 , double PorN ) {

        super(numero_lote, fecha_de_caducidad, FechaEnvase, PaisOrigen, TemRecom);
        this.cantidadC02 = porCO2;
        this.cantidadNitrogeno = PorN;
        this.cantidadVH2O =  porVH20;
        this.cantidadOxigeno = PorOxigeno;
    }

    public Double getCantidadNitrogeno() {
        return cantidadNitrogeno;
    }

    public Double getCantidadOxigeno() {
        return cantidadOxigeno;
    }

    public Double getCantidadC02() {
        return cantidadC02;
    }

    public Double getCantidadVH2O() {
        return cantidadVH2O;
    }
}

class CongeladosAgua extends  Productoscongelados{

    private  double SalinidadAgua;
    private double Sal;
    private  double Agua;


    public CongeladosAgua(int numero_lote, LocalDate fecha_de_caducidad, LocalDate FechaEnvase, String PaisOrigen, int TemRecom  ,double Sal, double agua) {
        super(numero_lote, fecha_de_caducidad, FechaEnvase, PaisOrigen, TemRecom);

        this.Sal = Sal;
        this.Agua = agua;
        SalinidadCalcular();

    }
    public  void SalinidadCalcular(){
       if(Agua != 0){
           SalinidadAgua = (Sal / Agua)*1000;
       }else {
           throw new ArithmeticException("EL volumen no puede ser 0");
       }
    }

    private double getSalinidadAgua (){
        return  SalinidadAgua;
    }

    public  void Imprimir3 (){

        System.out.println(" el numero de lote es "  + getNumero_lote() + "la salinidad es de " + getSalinidadAgua());
    }

}
class CongeladosNitrogeno extends  Productoscongelados {

    private String metodoCongelacion;
    private  double TiempoExpoNitrogeno;

    public CongeladosNitrogeno(int numero_lote, LocalDate fecha_de_caducidad, LocalDate FechaEnvase, String PaisOrigen, int TemRecom , String MetCongelacion , double TempN) {

        super(numero_lote, fecha_de_caducidad, FechaEnvase, PaisOrigen, TemRecom);
        this.metodoCongelacion = MetCongelacion;
        this.TiempoExpoNitrogeno = TempN;
    }

    public String getMetodoCongelacion() {
        return metodoCongelacion;
    }

    public double getTiempoExpoNitrogeno() {
        return TiempoExpoNitrogeno;
    }
}










