package com.example.projetopdmii;

import android.widget.TextView;

public class Pergunta {
public String pergunta,  opcaoA, opcaoB, opcaoC, opcaoD, opcaoE, gabarito;


public void setPergunta (String pergunta){
    this.pergunta = pergunta;

}
public String getPergunta(){
    return this.pergunta;
}

public void setOpcaoA(String opcaoA){
    this.opcaoA = opcaoA;
}

    public String getOpcaoA() {
        return opcaoA;
    }


    public void setOpcaoB(String opcaoB){
        this.opcaoB = opcaoB;
    }

    public String getOpcaoB() {
        return opcaoB;
    }


    public void setOpcaoC(String opcaoC){
        this.opcaoC = opcaoC;
    }

    public String getOpcaoC() {
        return opcaoC;
    }


    public void setOpcaoD(String opcaoD){
        this.opcaoD = opcaoD;
    }

    public String getOpcaoD() {
        return opcaoD;
    }


    public void setOpcaoE(String opcaoE){
        this.opcaoE = opcaoE;
    }

    public String getOpcaoE() {
        return opcaoE;
    }


    public void setgabarito(String gabarito){
        this.gabarito = gabarito;
    }

    public String getgabarito() {
        return gabarito;
    }

}
