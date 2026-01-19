
package com.juego.modelo;

// Clase que representa las estadísticas base de un personaje
public class Stats {

    private int f,i,d,vidaMax;

    public Stats(int f,int i,int d,int v){
        this.f=f;
        this.i=i;
        this.d=d;
        vidaMax=v;
    }

    public void aplicarBonus(int f,int i,int d){
        this.f+=f;
        this.i+=i;
        this.d+=d;
    }

    public int getVidaMax(){
        return vidaMax;
    }
    public void setVidaMax(int v){
        vidaMax=v;
    }
}
