package domain;

import domain.person.Client;

import java.util.Date;

public class Reservation {
    private long id;
    private Client client;
    private Date startData;
    private Date endData;

    public static class Builder {
        private long id;
        private Client client;
        private Date startData;
        private Date endData;

        public Builder(long id) {
            this.id = id;
        }
        public Builder ofClient(Client client){
            this.client = client;
            return this;
        }
        public Builder atStartDate(Date startData){
            this.startData = startData;
            return this;
        }
        public Builder atEndDate(Date endData){
            this.endData = endData;
            return this;
        }

        public Reservation build(){
            Reservation reservation = new Reservation();
            reservation.id = this.id;
            reservation.client = this.client;
            reservation.startData = this.startData;
            reservation.endData = this.endData;
            return reservation;
        }
    }

    private Reservation() { }
}