package com.example.primeiroprojeto;

public class Pessoa {

    private String nome;
    private int idade;
    private float altura;
    private int sexo; //0 = FEMININO , 1 = MASCULINO , 2 = OUTRO

    public Pessoa(String nome, int idade, float altura, int sexo) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.sexo = sexo;
    }

    public String getSexo() {
        if(sexo == 0){
            return "Feminino";
        } else if(sexo == 1){
            return "Masculino";
        } else if(sexo == 2){
            return "Outro";
        } else {
            return "Não informado";
        }
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }



    @Override
    public String toString() {
        return nome + ": " +
                " idade = " + idade +
                ", altura = " + altura +
                'm' +
                " sexo = " + getSexo() ; //para retornar o sexo por escrito
    }
}
