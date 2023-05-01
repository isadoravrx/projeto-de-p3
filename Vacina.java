import java.util.List;

public class Vacina{

    static List<String> vacinas_crianca =  List.of("bcg", "hepatite b", "poliomielite", "vrh", "penta", "pcv 10", "meningocócica c", "febre amarela", "sarampo, caxumba e rubéola", "sarampo, caxumba, rubéola e varicela", "hepatite a", "difteria e tétano", "hpv", "ppv 23", "varicela");
    static List<String>vacinas_adolescente = List.of("hepatite b", "difteria e tétano", "febre amarela", "sarampo, caxumba e rubéola", "hpv", "ppv 23", "meningocócica");
    static List<String>vacinas_adulto = List.of("hepatite B", "difteria e tétano", "febre amarela", "sarampo, caxumba e rubéola", "ppv 23");
    static int[] numero_de_doses_crianca = {1,1,3,2,3,2,2,1,2,2,1,1,3,2,1,1} ;
    static int[] numero_de_doses_adolescentes = {3, 3, 1, 2, 2, 1, 1};
    static int[] numero_de_doses_adultos = {3, 3, 1, 3, 1};

    static int[] numero_de_doses_reforco_crianca = {0,0,2,0,2,1,1,1,0,0,0,2,1,8,0,0,0} ;
    static int[] numero_de_doses_reforco_adolescentes = {0, 8, 0, 0, 0 , 0, 0};
    static int[] numero_de_doses_reforco_adultos = {0, 8, 0, 0, 1};

    static int[] intervalo_entre_doses_crianca = {0,0,30,30,30,60,60,30,30,30,0,180,30,0,0,30};
    static int[] intervalo_entre_doses_adolescentes = {180, 60, 0, 30, 180, 0, 0};
    static int[] intervalo_entre_doses_adultos = {180, 60, 0, 30, 0};


    public static List<String> getVacinas_crianca() {
        return vacinas_crianca;
    }

    public static List<String> getVacinas_adulto() {
        return vacinas_adulto;
 
    }

    public static List<String> getVacinas_adolescente() {
        return vacinas_adolescente;
    }

    public static int[] getDosesCrianca(){
        int[] sumArray = new int[numero_de_doses_crianca.length];
        for(int i = 0; i != sumArray.length; i++){
            sumArray[i] = numero_de_doses_crianca[i] + numero_de_doses_reforco_crianca[i];
        }
        return sumArray;
    } 

    public static int[] getDosesAdolescentes(){
        int[] sumArray = new int[numero_de_doses_adolescentes.length];
        for(int i = 0; i != sumArray.length; i++){
            sumArray[i] = numero_de_doses_adolescentes[i] + numero_de_doses_reforco_adolescentes[i];
        }
        return sumArray;
    } 

    public static int[] getDosesAdutos(){
        int[] sumArray = new int[numero_de_doses_adultos.length];
        for(int i = 0; i != sumArray.length; i++){
            sumArray[i] = numero_de_doses_adultos[i] + numero_de_doses_reforco_adultos[i];
        }
        return sumArray;
    } 
}