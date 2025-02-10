/**
 * @author João Paulo Ferreira Alves
 * Analista de Sistemas
 * Data: 10/02/2025
 */

package com.industria.application.funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import com.industria.application.pessoa.Pessoa;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void aumentarSalario(BigDecimal percentual) {
        this.salario = this.salario.add(this.salario.multiply(percentual)).setScale(2, RoundingMode.HALF_UP);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getIdade() {
        return (int) ChronoUnit.YEARS.between(getDataNascimento(), LocalDate.now());
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nome: " + getNome() + ", Data de Nascimento: " + getDataNascimento().format(dtf) + ", Salário: "
                + String.format("%,.2f", salario).replace(",", "@").replace(".", ",").replace("@", ".")
                + ", Função: " + funcao;
    }
}
