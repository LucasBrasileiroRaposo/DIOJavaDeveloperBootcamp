import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;

public class Main {
    public static void main(String[] args){

        Conteudo conteudo = new Curso("javaTest", "test", 10);
        System.out.println(conteudo.toString());
        System.out.println(conteudo.calculaXp());
    }
}
