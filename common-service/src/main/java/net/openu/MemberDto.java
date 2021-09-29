package net.openu;

import lombok.Getter;

public class MemberDto {

    @Getter
    public static class Data {

        private String id;
        private String name;

        public Data(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }


    @Getter
    public static class Req {

        private String id;
        private String name;

        public Req(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
