package com.chekan.ciklum;

public class GeneratorId {

    public int max;

    public GeneratorId(int max){
        this.max = max;
    }

    public int random(){
        return (int) (Math.random() * max);
    }
}
