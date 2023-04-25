package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private long cargaHoraria;

    public Curso(String titulo, String descricao, long cargaHoraria) {
        super.titulo = titulo;
        super.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public double calculaXp(){
        return XP_PADRAO * this.cargaHoraria;
    }

    public long getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(long cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }


    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
