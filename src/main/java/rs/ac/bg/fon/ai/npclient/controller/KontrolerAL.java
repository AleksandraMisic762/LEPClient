package rs.ac.bg.fon.ai.npclient.controller;

import com.google.gson.JsonObject;
import rs.ac.bg.fon.ai.npcommon.communication.*;
import rs.ac.bg.fon.ai.npcommon.domain.*;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KontrolerAL {

    Socket socket;
    Sender sender;
    Receiver receiver;

    private static KontrolerAL instance;

    private KontrolerAL() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static KontrolerAL getInstance() throws Exception {
        if (instance == null) {
            instance = new KontrolerAL();
        }
        return instance;
    }

    public Korisnik login(String username, String password) throws Exception {
        Korisnik user = new Korisnik();
        user.setUsername(username);
        user.setPassword(password);
//        Request request = new Request(Operation.LOGIN, user);
        JsonObject request = new JsonObject();
        
        request.addProperty("operation", String.valueOf(Operation.LOGIN));
        request.addProperty("username", username);
        request.addProperty("password", password);
        
        sender.send(request);
        JsonObject response = (JsonObject) receiver.receive();
//        if (response.getException() == null) {
//            return (Korisnik) response.getResult();
//        } 
        if (response.get("exception") == null) {
            return new Korisnik(response.get("id").getAsLong(), response.get("username").getAsString(), response.get("password").getAsString());
        }
        else {
            return null;
        }
    }

    public boolean ucitajListuPredmeta(List<Predmet> listaPredmeta) throws Exception {
//        Request request = new Request(Operation.GET_ALL_PREDMET, null);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            listaPredmeta.addAll((List<Predmet>) response.getResult());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG1 

    public boolean kreirajStudenta(Student student) throws Exception {
//        Request request = new Request(Operation.KREIRAJ_STUDENTA, student);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            student.setSifra(((Student) response.getResult()).getSifra());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG2

    public boolean zapamtiStudenta(Student student) throws Exception {
//        Request request = new Request(Operation.ZAPAMTI_STUDENTA, student);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            Student res = (Student) response.getResult();
//            student.setSifra(res.getSifra());
//            student.setBrojIndeksa(res.getBrojIndeksa());
//            student.setIme(res.getIme());
//            student.setPrezime(res.getPrezime());
//            student.setPolozio(res.isPolozio());
//            student.setPredmet(res.getPredmet());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG3

    public boolean ucitajListuEksperimentatora(List<Eksperimentator> listaEksperimentatora) throws Exception {
//        Request request = new Request(Operation.GET_ALL_EKSPERIMENTATOR, null);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            listaEksperimentatora.addAll((List<Eksperimentator>) response.getResult());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }//UG4

    public boolean kreirajEksperiment(Eksperiment eksperiment) throws Exception {
//        Request request = new Request(Operation.KREIRAJ_EKSPERIMENT, eksperiment);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            eksperiment.setSifra(((Eksperiment) response.getResult()).getSifra());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG5

    public boolean zapamtiEksperiment(Eksperiment eksperiment) throws Exception {
//        Request request = new Request(Operation.ZAPAMTI_EKSPERIMENT, eksperiment);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            Eksperiment res = (Eksperiment) response.getResult();
//            eksperiment.setSifra(res.getSifra());
//            eksperiment.setNaziv(res.getNaziv());
//            eksperiment.setDatumOdrzavanja(res.getDatumOdrzavanja());
//            eksperiment.setBodovi(res.getBodovi());
//            eksperiment.setRaspored(res.getRaspored());
//            eksperiment.setEksperimenatator(res.getEksperimenatator());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG6

    public boolean ucitajListuEksperimenata(List<Eksperiment> listaEksperimenata) throws Exception {
//        Request request = new Request(Operation.GET_ALL_EKSPERIMENT, null);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            listaEksperimenata.addAll((List<Eksperiment>) response.getResult());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG7

    public boolean pretraziStudenta(Student student) throws Exception {
//        Request request = new Request(Operation.PRETRAZI_STUDENTA, student);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            Student res = (Student) response.getResult();
//            student.setSifra(res.getSifra());
//            student.setBrojIndeksa(res.getBrojIndeksa());
//            student.setIme(res.getIme());
//            student.setPrezime(res.getPrezime());
//            student.setPolozio(res.isPolozio());
//            student.setPredmet(res.getPredmet());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG8

    public boolean pretraziEksperiment(Eksperiment eksperiment) throws Exception {
//        Request request = new Request(Operation.PRETRAZI_EKSPERIMENT, eksperiment);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            Eksperiment res = (Eksperiment) response.getResult();
//            eksperiment.setSifra(res.getSifra());
//            eksperiment.setNaziv(res.getNaziv());
//            eksperiment.setDatumOdrzavanja(res.getDatumOdrzavanja());
//            eksperiment.setBodovi(res.getBodovi());
//            eksperiment.setRaspored(res.getRaspored());
//            eksperiment.setEksperimenatator(res.getEksperimenatator());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG9

    public boolean ucitajListuStudenataSaUslovom(ListaStudenata lista, List<Student> sviStudenti) throws Exception {
//        Request request = new Request(Operation.GET_ALL_STUDENT_USLOV, lista);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            sviStudenti.addAll((List<Student>) response.getResult());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG10

    public boolean zapamtiListuStudenata(Map mapa) throws Exception {
//        Request request = new Request(Operation.ZAPAMTI_LISTU_STUDENTA, mapa);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            mapa.replace("Lista", (ListaStudenata) response.getResult());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG11

    public boolean zapamtiUcesce(SE ucesce) throws Exception {
//        Request request = new Request(Operation.ZAPAMTI_UCESCE, ucesce);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            SE res = (SE) response.getResult();
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG 12

    public boolean zapamtiRasporedEksperimenata(RasporedEksperimenata raspored, List<Eksperiment> eksperimenti) throws Exception {
//        Request request = new Request(Operation.KREIRAJ_RASPORED_EKSPERIMENATA, raspored);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            eksperimenti.addAll((List<Eksperiment>) response.getResult());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }//UG13

    public boolean obrisiEksperiment(Eksperiment eksperiment) throws Exception {
//        Request request = new Request(Operation.OBRISI_EKSPERIMENT, eksperiment);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        return (boolean)response.getResult();
        return false;
    } //UG14

    public boolean kreirajEksperimentatora(Eksperimentator eksperimentator) throws Exception {
//        Request request = new Request(Operation.KREIRAJ_EKSPERIMENTATORA, eksperimentator);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            Eksperimentator res = (Eksperimentator) response.getResult();
//            eksperimentator.setSifra(res.getSifra());
//            return true;
//        } else {
//            return false;
//        }
        return false;
    } //UG15

    public boolean zapamtiEksperimentator(Eksperimentator eksperimentator) throws Exception {
//        Request request = new Request(Operation.ZAPAMTI_EKSPERIMENTATORA, eksperimentator);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            Eksperimentator res = (Eksperimentator) response.getResult();
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }//UG16

    public void closeSocket() {
        try {
            socket.close();
        } catch (IOException ex) {

        }
    }

    public boolean vratiSvaUcesca(Eksperiment eks, List<Student> sviS) throws Exception {
//        Map<String, Object> mapa = new HashMap();
//        mapa.put("E", eks);
//        mapa.put("LS", sviS);
//        Request request = new Request(Operation.GET_ALL_UCESCA_NA_EKSPERIMENTU, mapa);
//        sender.send(request);
//        Response response = (Response) receiver.receive();
//        if (response.getException() == null) {
//            HashMap res =(HashMap) response.getResult();
//            sviS.addAll((List<Student>) res.get("LS"));
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }
}
