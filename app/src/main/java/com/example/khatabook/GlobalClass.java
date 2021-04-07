package com.example.khatabook;

import android.app.Application;

public class GlobalClass extends Application {

    public String getNametosend() {
        return nametosend;
    }

    public void setNametosend(String nametosend) {
        this.nametosend = nametosend;
    }

    public String getIdtosend() {
        return idtosend;
    }

    public void setIdtosend(String idtosend) {
        this.idtosend = idtosend;
    }

    public String getPhonetosend() {
        return phonetosend;
    }

    public void setPhonetosend(String phonetosend) {
        this.phonetosend = phonetosend;
    }

    public String getPasstosend() {
        return passtosend;
    }

    public void setPasstosend(String passtosend) {
        this.passtosend = passtosend;
    }

    public String getEmailtosend() {
        return emailtosend;
    }

    public void setEmailtosend(String emailtosend) {
        this.emailtosend = emailtosend;
    }

    String nametosend,idtosend,phonetosend,passtosend,emailtosend;
}
