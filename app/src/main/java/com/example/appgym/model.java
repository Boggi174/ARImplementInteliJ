package com.example.appgym;

public class model {
    String n_rutina, des_rutina,id_video;

    public model() {
    }

    public model(String n_rutina, String des_rutina, String id_video) {


        this.n_rutina = n_rutina;
        this.des_rutina = des_rutina;
        this.id_video = id_video;
    }

    public String getN_rutina() {
        return n_rutina;
    }

    public void setN_rutina(String n_rutina) {
        this.n_rutina = n_rutina;
    }

    public String getDes_rutina() {
        return des_rutina;
    }

    public void setDes_rutina(String des_rutina) {
        this.des_rutina = des_rutina;
    }

    public String getId_video() {
        return id_video;
    }

    public void setId_video(String id_video) {
        this.id_video = id_video;
    }
}
