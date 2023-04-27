public class Vacina{

    String[] vacinas_crianca = {"bcg", "hepatite b", "poliomielite", "vrh", "penta", "pcv 10", "meningocócica c", "febre amarela", "sarampo, caxumba e rubéola", "sarampo, caxumba, rubéola e varicela", "hepatite a", "difteria e tétano", "hpv", "ppv 23", "varicela"};
    String[] vacinas_adolescente = {"hepatite b", "difteria e tétano", "febre amarela", "sarampo, caxumba e rubéola", "hpv", "ppv 23", "meningocócica"};
    String[] vacinas_adulto = {"hepatite B", "difteria e tétano", "febre amarela", "sarampo, caxumba e rubéola", "ppv 23"};
    int[] numero_de_doses_crianca = {1,1,3,2,3,2,2,1,2,2,1,1,3,2,1,1} ;
    int[] numero_de_doses_adolescentes = {3, 3, 1, 2, 2, 1, 1};
    int[] numero_de_doses_adultos = {3, 3, 1, 3, 1};

    int[] numero_de_doses_reforco_crianca = {0,0,2,0,2,1,1,1,0,0,0,2,1,8,0,0,0} ;
    int[] numero_de_doses_reforco_adolescentes = {0, 8, 0, 0, 0 , 0, 0};
    int[] numero_de_doses_reforco_adultos = {0, 8, 0, 0, 1};

    int[] intervalo_entre_doses_crianca = {0,0,30,30,30,60,60,30,30,30,0,180,30,0,0,30};
    int[] intervalo_entre_doses_adolescentes = {180, 60, 0, 30, 180, 0, 0};
    int[] intervalo_entre_doses_adultos = {180, 60, 0, 30, 0};
}