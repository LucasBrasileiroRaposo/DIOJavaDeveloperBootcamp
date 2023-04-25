import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        Conteudo conteudo = new Curso("javaTest", "test", 10);
        Bootcamp bootcamp1 = new Bootcamp("javaBootcamp", "bootcamp de java");
        bootcamp1.getConteudos().add(new Curso("introducao a java","aprendendo  java", 20));
        bootcamp1.getConteudos().add(new Curso("introducao a POO","aprendendo  POO", 15));
        bootcamp1.getConteudos().add(conteudo);
        bootcamp1.getConteudos().add(new Mentoria("introdução ao curso", "live de abertura do bootcamp", LocalDate.of(2023,05,01)));

        Dev devLucas = new Dev("Lucas");
        Dev devAbacate = new Dev("Abacate");
        devAbacate.inscreverBootcamp(bootcamp1);
        devLucas.inscreverBootcamp(bootcamp1);
        System.out.println("Conteúdos incritos Lucas: " + devLucas.getConteudosInscritos());
        System.out.println("XP Lucas: " + devLucas.calculaTotalXp());
        System.out.println("Conteúdos incritos Abacate: " + devAbacate.getConteudosInscritos());
        System.out.println("XP Abacate: " + devAbacate.calculaTotalXp());
        devAbacate.progredir();
        devAbacate.progredir();
        devLucas.progredir();
        System.out.println("\n \n Progredindo no bootcamp\n\n");
        System.out.println("Conteúdos concluidos Lucas: " + devLucas.getConteudosConcluidos());
        System.out.println("Conteúdos restantes Lucas: " + devLucas.getConteudosInscritos());
        System.out.println("XP Lucas: " + devLucas.calculaTotalXp());
        System.out.println("---------");
        System.out.println("Conteúdos concluidos Abacate: " + devAbacate.getConteudosConcluidos());
        System.out.println("Conteúdos restantes Abacate: " + devAbacate.getConteudosInscritos());
        System.out.println("XP Abacate: " + devAbacate.calculaTotalXp());

    }
}
