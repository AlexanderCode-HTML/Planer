/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ausflugsplanner;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "ausflugBean")
@ApplicationScoped
public class AusflugBean implements Serializable {

    private String tag;
    private String wetter;
    private String schule;
    private String zeit;
    private String kinder;
//private String result = "";
    ArrayList<String> ausflug = new ArrayList<String>();

    /**
     * Creates a new instance of AusflugBean
     */

    public ArrayList<String> getAusflug() {
        return ausflug;
    }

    public void setAusflug(ArrayList<String> ausflug) {
        this.ausflug = ausflug;
    }

    public AusflugBean() {
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setWetter(String wetter) {
        this.wetter = wetter;
    }

    public void setSchule(String schule) {
        this.schule = schule;
    }

    public void setZeit(String zeit) {
        this.zeit = zeit;
    }

    public void setKinder(String kinder) {
        this.kinder = kinder;
    }

    public String getTag() {
        return tag;
    }

    public String getWetter() {
        return wetter;
    }

    public String getSchule() {
        return schule;
    }

    public String getZeit() {
        return zeit;
    }

    public String getKinder() {
        return kinder;
    }

    /* public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }*/
    //_______________________________________________________________________________________________________________________________________
    boolean kegeln, freibad, hallenbad, dunkelwald, musik, brotbackkurs, schieferbergwerk, gokurs, billard, rennauto, openair, korbflechten, wasserfall, zoobesuch;

    boolean wochentag, wetterschoen, ferien, tagsueber, mitKindern;

    public void chooseAuslug() {

        wochentag = (tag == "Wochentag");
        wetterschoen = (wetter == "schönes Wetter");
        ferien = (schule == "Schulferien");
        tagsueber = (zeit == "Tagsüber");
        mitKindern = (kinder == "Ausflug mit Kindern");
        calc();
        vorschlaegeAusgeben();

    }

    private void calc() {
        boolean wochenEnde = !wochentag;
        boolean schlechtWetter = !wetterschoen;
        boolean schulzeit = !ferien;
        boolean abends = !tagsueber;
        boolean nurErwachsene = !mitKindern;

        kegeln = abends || wochenEnde;
        freibad = wetterschoen && tagsueber;
        hallenbad = !(ferien && wochenEnde);
        dunkelwald = freibad;
        musik = abends && schulzeit;
        brotbackkurs = wochenEnde && schlechtWetter;
        schieferbergwerk = tagsueber || (wochenEnde && ferien);
        gokurs = (wochenEnde && schlechtWetter) || (wochentag && abends && wetterschoen);
        billard = nurErwachsene && (abends || wochenEnde);
        rennauto = nurErwachsene && tagsueber && ferien && wochenEnde;
        openair = wetterschoen && (abends || wochenEnde);
        korbflechten = ferien && schlechtWetter && wochentag;
        wasserfall = tagsueber;
        zoobesuch = true;
    }

    private void vorschlaegeAusgeben() {
        if (kegeln) {
            ausflug.add("Kegeln");
        }
        if (freibad) {
            ausflug.add("Freibad");
        }
        if (hallenbad) {
            ausflug.add("Hallenbad");
        }
        if (dunkelwald) {
            ausflug.add("Dunkelwald");
        }
        if (musik) {
            ausflug.add("Musikkurs");
        }
        if (brotbackkurs) {
            ausflug.add("Brotbackkurs");
        }
        if (schieferbergwerk) {
            ausflug.add("Schieferbergwerk");
        }
        if (gokurs) {
            ausflug.add("Go Kurs");
        }
        if (billard) {
            ausflug.add("Billard");
        }
        if (rennauto) {
            ausflug.add("Rennauto");
        }
        if (openair) {
            ausflug.add("Open Air Kino");
        }
        if (korbflechten) {
            ausflug.add("Korbflechten");
        }
        if (wasserfall) {
            ausflug.add("Wasserfall");
        }
        if (zoobesuch) {
            ausflug.add("Zoobesuch");
        }
    }

    public String nextPage() {
        return "result";
    }
}
